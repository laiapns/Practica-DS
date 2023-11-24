package baseNoStates.first_milestone;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import org.slf4j.Logger;


/**
 * The 'Door' class represents a physical door within
 * a building. It manages the door's state, open or closed,
 * and processes requests for actions such as opening,
 * closing, locking, and unlocking. The class also interacts
 * with a 'DoorState' to change the door's state based
*/

public class Door {

  private static final Logger LOGGER =
      org.slf4j.LoggerFactory.getLogger(Door.class);
  private final String doorId;
  private boolean closed; // physically
  private DoorState doorState;
  private RequestReader requestReader;
  private final Space spaceFrom;
  private final Space spaceTo;

  /**
   * Constructor for the 'Door' class.
   *
   * @param id   The unique identifier for the door.
   * @param from The space from which the door opens.
   * @param to   The space to which the door leads.
   */
  public Door(final String id, final Space from, final Space to) {
    this.doorId = id;
    this.doorState = new Unlocked(this, id);
    this.closed = true;
    this.spaceFrom = from;
    this.spaceTo = to;
    if(spaceTo != null){
      this.spaceTo.setDoorsGivingAccess(this);
    }
  }

  public void processRequest(final RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      LOGGER.warn("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

//switch to the request action in order to change the state throw its class
  private void doAction(final String action) {
    switch (action) {
      case Actions.OPEN:
        doorState.open();
        break;
      case Actions.CLOSE:
        doorState.close();
        break;
      case Actions.LOCK:
        doorState.lock();
        break;
      case Actions.UNLOCK:
        doorState.unlock();
        break;
      case Actions.UNLOCK_SHORTLY:
        doorState.unlockshortly();
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  //used to set the next state and set if the door is closed
  public void setState(final DoorState state, final boolean isClosed) {
    if (state != null) {
      this.doorState = state;
      closed = isClosed;
      LOGGER.debug("Door " + doorId + " is now in state: "
          + this.getStateName());
    } else {
        LOGGER.warn("Not authorized to change the state of door "
            + doorId);
    }
  }



  public void setClosed(final boolean close) {
    closed = close;
  }
//getters
  public String getId() {
    return doorId;
  }

  public String getStateName() {
    return doorState.toString();
  }

  public States getState() {
    return this.doorState;
  }

  public Space getSpaceTo() {
    return spaceTo;
  }

  public boolean isClosed() {
    return closed;
  }

  @Override
  public String toString() {
    return "Door{"
        + ", id='" + doorId + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", doorId);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }
}