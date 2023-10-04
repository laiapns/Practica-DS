package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed; // physically
  private boolean locked;
  private DoorState state;

  public Door(String id) {
    this.id = id;
    this.state = new Closed(this,id);
    closed = true;
    locked = false;
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
        if(closed){
          locked = true;
        } else {
          System.out.println("Door " + id + " can't be locked because is open.");
        }
        // fall through
      case Actions.UNLOCK:
        if(locked){
          locked = false;
        } else {
          System.out.println("Door " + id + " already unlocked.");
        }
        // fall through
      case Actions.UNLOCK_SHORTLY:
        // TODO
        System.out.println("Action " + action + " not implemented yet");
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  //ADAPTAR
  public void setState(DoorState door){
    if (door != null) {
      if (door instanceof UnlockedShortly) {
        //iniciar temporitzador per entrar en l'estat  unlockshortly

      } else if (door instanceof UnlockedShortly) {
        //netejar temporitzador al sortir de l'estat unlockshortly
      }

      state = door;
      System.out.println("Door " + id + " is now in state: " + this.getStateName());
    } else {
      System.out.println("Invalid state provided.");
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
