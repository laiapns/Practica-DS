package baseNoStates;

public class Propped extends DoorState {
  public Propped(Door door, String name) {
    super(door, States.PROPPED);
  }

  @Override
  public void open() {
    System.out.println("Door " + name + " already open");
  }

  @Override
  public void close() {
    System.out.println("Door " + name + " can't be closed while it's propped");
  }

  //if the door is propped we can change the state to unlocked in order
  //to quit the propped state
  @Override
  public void unlock() {
    door.setState(new Unlocked(door, States.UNLOCKED), false);
  }

  @Override
  public void lock() {
    System.out.println("Door " + name + " can't be locked while it's propped");
  }

  @Override
  public void unlockshortly() {
    System.out.println("Door " + name + " can't be unlocked while it's propped");
  }

  @Override
  public void propper() {
    System.out.println("Door " + name + " already propped");
  }
  @Override
  public String toString() {
    return States.PROPPED;
  }
}
