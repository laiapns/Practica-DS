package baseNoStates;

public class Locked extends DoorState{
  public Locked(Door door, String name) {
    super(door, name);
  }
  @Override
  public void open() {}
  @Override
  public void close() {}
  @Override
  public void unlock() {
    System.out.println("Unlocking the door: " + name );
    door.setState(new Unlocked(door, name));
  }
  @Override
  public void lock() {
    System.out.println("Door " + name + " already locked");
  }
}

