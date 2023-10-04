package baseNoStates;

public class Unlocked extends DoorState {
  public Unlocked(Door door, String name) {
    super(door, name);
  }

  @Override
  public void open() {}
  @Override
  public void close() {}
  @Override
  public void unlock() {
    System.out.println("Door " + name + " already unlocked");
  }
  @Override
  public void lock() {
    System.out.println("Locking the door: " + name );
    door.setState(new Locked(door, name));
  }
}
