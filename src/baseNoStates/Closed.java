package baseNoStates;

public class Closed extends DoorState {
  public Closed(Door door, String name) {
    super(door, States.CLOSED);
  }

  @Override
  public void open() {
    System.out.println("Opening the door: " + name);
    door.setState(new Opened(door, States.OPENED), false);
  }

  @Override
  public void close() {
    System.out.println("Door " + name + " already close");
  }

  @Override
  public void unlock() {
    door.setState(new Unlocked(door, States.UNLOCKED), true);
  }

  @Override
  public void lock() {
    System.out.println("Locking the door: " + name);
    door.setState(new Locked(door, States.LOCKED), true);
  }

  @Override
  public void unlockshortly() {
    System.out.println("Door " + name + " is not locked");
  }

  @Override
  public void propper() {
    System.out.println("Door " + name + " can't be propper");
  }
  @Override
  public String toString() {
    return States.CLOSED;
  }
}
