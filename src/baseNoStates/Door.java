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

  public Door(String id, Space spaceFrom, Space spaceTo) {
    this.id = id;
    this.state = new Closed(this, id);

    closed = true;
    locked = false;
    door = this;
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
        if (closed) {
          closed = false;
        } else {
          System.out.println("Can't open door " + id + " because it's already open");
        }
        break;
      case Actions.CLOSE:
        if (closed) {
          System.out.println("Can't close door " + id + " because it's already closed");
        } else {
          closed = true;
        }
        break;
      case Actions.LOCK:
        if (closed) {
          locked = true;
        } else {
          System.out.println("Door " + id + " can't be locked because is open.");
        }
        // fall through
      case Actions.UNLOCK:
        if (locked) {
          locked = false;
        } else {
          System.out.println("Door " + id + " already unlocked.");
        }
        // fall through
      case Actions.UNLOCK_SHORTLY:
        if (locked) {
          locked = false;
        } else {
          System.out.println("Door " + id + " already unlocked.");
        }
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public void setState(DoorState doorState) {
    if (doorState != null) {
        if (doorState instanceof UnlockedShortly) {
          Timer timer = new Timer();
          timer.schedule(new TimerTask() {
            @Override
            public void run() {
              if (isClosed()) {
                doAction(Actions.LOCK); // Lock the door
              } else {
                setState(new Propped(door, id)); // Set to another state
              }
              timer.cancel();
            }
          }, 1000);
        }
        state = doorState;
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
