package baseNoStates;

public class Closed extends DoorState{
  public Closed(Door door, String name) {
    super(door, name);
  }
  @Override
  public void open() {
    System.out.println("Opening the door: " + name );
    door.setState(new Opened(door, name));
  }
  @Override
  public void close() {
    System.out.println("Door " + name + " already close");
  }
  @Override
  public void unlock() {
    System.out.println("Unlocking the door: " + name );
    door.setState(new Unlocked(door, name));
  }
  @Override
  public void lock() {
    System.out.println("Locking the door: " + name );
    door.setState(new Locked(door, name));
  }
  public void unlockshortly(){
    System.out.println("Unocking shortly the door: " + name );
    door.setState(new UnlockedShortly(door, name));
  }
}
