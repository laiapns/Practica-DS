package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import java.util.Timer;
import java.util.TimerTask;


public class Door {
  private final String id;
  private boolean closed; // physically
  private boolean locked;
  private DoorState state;
  private Door door;
  private RequestReader requestReader;
  private Space spaceFrom;
  private Space spaceTo;

  public Door(String id, Space from, Space to) {
    this.id = id;
    this.state = new Closed(this, id);
    closed = true;
    this.door = door;
    spaceFrom = from;
    spaceTo = to;
    spaceTo.setDoorsGivingAccess((Door)this);

  }

  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        state.open();
        break;
      case Actions.CLOSE:
        state.close();
        break;
      case Actions.LOCK:
        state.lock();
        break;
      case Actions.UNLOCK:
        state.unlock();
        break;
      case Actions.UNLOCK_SHORTLY:
        state.unlockshortly();
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public void setState(DoorState state, boolean isClosed) {
    if (state != null) {
        this.state = state;
        closed=isClosed;
        System.out.println("Door " + id + " is now in state: " + this.getStateName());
      } else {
        System.out.println("Not authorized to change the state of door " + id);
      }
  }


  public boolean isClosed() {
    return closed;
  }


  public String getId() {
    return id;
  }

  public String getStateName() {
    return state.toString();
  }

  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }
}
