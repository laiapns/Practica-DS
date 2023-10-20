package baseNoStates;

public class UnlockedShortly extends DoorState {
  private long startTime;

  public UnlockedShortly(Door door, String name) {
    super(door, name);
    startTime = System.currentTimeMillis();

  }

  @Override
  public void open() {
    if (System.currentTimeMillis() - startTime >= 10000) {
      System.out.println("Door : " + name + " may be propped");
      door.setState(new Propped(door, name));
    }
  }

  @Override
  public void close() {
    System.out.println("Locking the door: " + name);
    door.setState(new Locked(door, name));
  }

  @Override
  public void unlock() {
    System.out.println("Door " + name + " already unlocked");
  }

  @Override
  public void lock() {
    System.out.println("Door " + name + " can't be locked while is unlocked shortly");
  }

  @Override
  public void unlockshortly() {
    System.out.println("Door " + name + " is already unlocked shortly");
  }

  @Override
  public void propper() {
    door.setState(new Propped(door, name));
  }
}
