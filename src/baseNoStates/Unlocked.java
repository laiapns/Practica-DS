package baseNoStates;

public class Unlocked extends DoorState {
  public Unlocked(Door door, String name) {
    super(door, name);
  }

  @Override
  public void open() {
    System.out.println("Opening the door: " + name );
    door.setState(new Opened(door, name));
  }
  @Override
  public void close() {
    System.out.println("Closing the door: " + name );
    door.setState(new Closed(door, name));
  }
  @Override
  public void unlock() {
    System.out.println("Door " + name + " already unlocked");
  }
  @Override
  public void lock() {
    System.out.println("Locking the door: " + name );
    door.setState(new Locked(door, name));
  }
  @Override
  public void unlockshortly(){
    System.out.println("Door " + name + " already unlocked");
  }
}
