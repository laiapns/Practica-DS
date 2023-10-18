package baseNoStates;

public class Locked extends DoorState {
  public Locked(Door door, String name) {
    super(door, name);
  }

  @Override
  public void open() {
    System.out.println("Door " + name + " can't be open");
  }

  @Override
  public void close() {
    System.out.println("Door " + name + " already closed");
  }

  @Override
  public void unlock() {
    System.out.println("Unlocking the door: " + name);
    door.setState(new Unlocked(door, name), requestReader);
  }

  @Override
  public void lock() {
    System.out.println("Door " + name + " already locked");
  }

  @Override
  public void unlockshortly() {
    System.out.println("Unlocking shortly the door: " + name);
    door.setState(new UnlockedShortly(door, name), requestReader);
  }

  public void propper() {
    System.out.println("Door " + name + " can't be propper");
  }
}

