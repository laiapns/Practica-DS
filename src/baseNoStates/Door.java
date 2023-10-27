package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import java.util.Observable;

/**
 * The 'Door' class represents a physical door within a building. It manages the door's state, open or closed,
 * and processes requests for actions such as opening, closing, locking, and unlocking. The class also interacts
 * with a 'DoorState' to change the door's state based
*/

public class Door extends Observable {
  private final String id;
  private boolean closed; // physically
  private DoorState state;
  private RequestReader requestReader;
  private final Space spaceFrom;
  private final Space spaceTo;

  public Door(String id, Space from, Space to) {
    this.id = id;
    this.state = new Unlocked(this, id);
    this.closed = true;
    this.spaceFrom = from;
    this.spaceTo = to;
    this.spaceTo.setDoorsGivingAccess((Door)this);
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

//switch to the request action in order to change the state throw its class
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

  //used to set the next state and set if the door is closed
  public void setState(DoorState state, boolean isClosed) {
    if (state != null) {
      this.state = state;
      closed = isClosed;
      setChanged();
      notifyObservers();
      System.out.println("Door " + id + " is now in state: " + this.getStateName());
    }
    else {
        System.out.println("Not authorized to change the state of door " + id);
    }

  }



  public void setClosed(boolean close) { closed = close; }

//getters
  public String getId() {
    return id;
  }

  public String getStateName() {
    return state.toString();
  }

  public States getState() {
    return this.state;
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