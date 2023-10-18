package baseNoStates;

public class Propped extends DoorState{
  public Propped(Door door, String name) {
    super(door, name);
  }
  @Override
  public void open() {
    System.out.println("Door " + name + " already open");
  }
  @Override
  public void close() {
    System.out.println("Locking the door: " + name );
    door.setState(new Locked(door,name));
  }
  @Override
  public void unlock() {
    System.out.println("Door " + name + " can't be unlocked while it's propped");
  }
  @Override
  public void lock() {
    System.out.println("Door " + name + " can't be locked while it's propped");
  }
  @Override
  public void unlockshortly(){
    System.out.println("Door " + name + " can't be unlocked while it's propped");
  }
  public void propper(){
    System.out.println("Door " + name + " already propped");
  }
}
