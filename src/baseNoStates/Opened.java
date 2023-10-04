package baseNoStates;

public class Opened extends DoorState{
  public Opened(Door door, String name) {
    super(door, name);
  }
  @Override
  public void open() {
    System.out.println("Door " + name + " already open");
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
    System.out.println("Door " + name + " can't be locked because it's open");
  }
}
