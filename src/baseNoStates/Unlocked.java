package baseNoStates;

public class Unlocked extends DoorState {
  public Unlocked(Door door, String name) {
    super(door, name);
  }

  @Override
  public void open() {
    System.out.println("Opening the door: " + name);
    door.setState(new Opened(door, name), false);
  }

  @Override
  public void close() {
    System.out.println("Closing the door: " + name);
    door.setState(new Closed(door, name), true);
  }

  @Override
  public void unlock() {
    System.out.println("Door " + name + " already unlocked");
  }

  @Override
  public void lock() {
    if(door.isClosed()){
      door.setState(new Locked(door, name), true);
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
}
