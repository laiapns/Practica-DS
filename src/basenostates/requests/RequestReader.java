package basenostates.requests;

import basenostates.firstmilestone.DirectoryDoors;
import basenostates.firstmilestone.DirectoryUserGroups;
import basenostates.firstmilestone.Door;
import basenostates.firstmilestone.User;
import basenostates.firstmilestone.UserGroup;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The 'RequestReader' class represents a reader for
 * processing requests related to doors within a building.
 */
public class RequestReader implements Request {
  private final String credential; // who
  private final String action;     // what
  private final LocalDateTime now; // when
  private final String doorId;     // where
  private String userName;
  private boolean authorized;
  private final ArrayList<String> reasons; // why not authorized
  private String doorStateName;
  private boolean doorClosed;

  /**
   * Constructor for the 'RequestReader' class.
   *
   * @param credential The credential for user identification.
   * @param action     The action to be performed (e.g., open, close, lock, unlock).
   * @param now        The current date and time.
   * @param doorId     The identifier of the door for the request.
   */
  public RequestReader(String credential, String action, LocalDateTime now, String doorId) {
    this.credential = credential;
    this.action = action;
    this.doorId = doorId;
    reasons = new ArrayList<>();
    this.now = now;
  }

  public void setDoorStateName(String name) {
    doorStateName = name;
  }

  public String getAction() {
    return action;
  }

  public boolean isAuthorized() {
    return authorized;
  }

  public void addReason(String reason) {
    reasons.add(reason);
  }


  @Override
  public String toString() {
    if (userName == null) {
      userName = "unknown";
    }
    return "Request{"
        + "credential=" + credential
        + ", userName=" + userName
        + ", action=" + action
        + ", now=" + now
        + ", doorID=" + doorId
        + ", closed=" + doorClosed
        + ", authorized=" + authorized
        + ", reasons=" + reasons
        + "}";
  }

  public JSONObject answerToJson() {
    JSONObject json = new JSONObject();
    json.put("authorized", authorized);
    json.put("action", action);
    json.put("doorId", doorId);
    json.put("closed", doorClosed);
    json.put("state", doorStateName);
    json.put("reasons", new JSONArray(reasons));
    return json;
  }

  // see if the request is authorized and put this into the request, then send it to the door.
  // if authorized, perform the action.
  public void process() {
    User user = DirectoryUserGroups.findUserByCredential(credential);
    Door door = DirectoryDoors.findDoorById(doorId);
    assert door != null : "door " + doorId + " not found";
    authorize(user, door);
    // this sets the boolean authorize attribute of the request
    door.processRequest(this);
    // even if not authorized we process the request, so that if desired we could log all
    // the requests made to the server as part of processing the request
    doorClosed = door.isClosed();
  }

  // the result is put into the request object plus, if not authorized, why not,
  // only for testing
  public void authorize(User user, Door door) {
    if (user == null) {
      authorized = false;
      addReason("user doesn't exists");
    } else {
      userName = user.getName();
      UserGroup group = user.getGroup();
      LocalTime currentTime = now.toLocalTime();
      setDoorStateName(door.getState().toString());

      if (now.isAfter(group.getStartDate()) && now.isBefore(group.getFinishDate())
          && currentTime.isAfter(group.getStartHour())
          && currentTime.isBefore(group.getFinishHour())
          && (group.getWeekPlan().contains(now.getDayOfWeek()))
          && (group.getAllowedActions().contains(action))
          && (user.canBeInSpace(group, door.getSpaceTo()))) {
        authorized = true;

      }
    }
  }
}

