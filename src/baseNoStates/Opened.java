package baseNoStates;

public class Opened extends DoorState {
  public Opened(Door door, String name) {

    super(door, States.OPENED);

  }
  @Override
  public void open() {
    System.out.println("Door " + name + " already open");
  }

  @Override
  public void close() {
    System.out.println("Closing the door: " + name);
    door.setState(new Closed(this.door,this.name), true);
  }

  @Override
  public void unlock() {
    door.setState(new Unlocked(this.door,this.name),false);
  }

  @Override
  public void lock() {
    System.out.println("Door " + name + " can't be locked because it's open");
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
    return States.OPENED;
  }
}
