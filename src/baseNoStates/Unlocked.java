package baseNoStates;

public class Unlocked extends DoorState {
  public Unlocked(Door door, String name) {
    super(door, States.UNLOCKED);
  }

  @Override
  public void open() {

    System.out.println("Opening the door: " + name);
    door.setState(new Opened(door, States.OPENED), false);
  }

  @Override
  public void close() {
    System.out.println("Closing the door: " + name);
    door.setState(new Closed(door, States.CLOSED), true);
  }

  @Override
  public void unlock() {
    System.out.println("Door " + name + " already unlocked");
  }

  @Override
  public void lock() {
    if(door.isClosed()){
      door.setState(new Locked(door, States.LOCKED), true);
    }else{
      System.out.println("Door " + name + " can't be locked, is open");
    }
  }

  @Override
  public void unlockshortly() {
    System.out.println("Door " + name + " already unlocked");
  }

  @Override
  public void propper() {
    System.out.println("Door " + name + " can't be propper");
  }
  @Override
  public String toString() {
    return States.UNLOCKED;
  }
}
