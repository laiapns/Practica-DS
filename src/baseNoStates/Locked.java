package baseNoStates;

import java.time.Clock;
import java.util.Timer;
import java.util.TimerTask;

public class Locked extends DoorState {
  public Locked(Door door, String name) {
    super(door, States.LOCKED);
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
    door.setState(new Unlocked(this.door,States.UNLOCKED), true);
  }

  @Override
  public void lock() {
    System.out.println("Door " + name + " already locked");
  }

  @Override
  public void unlockshortly() {
    System.out.println("Unlocking shortly the door: " + name);
    Clock clock = Clock.systemDefaultZone();
    UnlockedShortly unlockedShortly = new UnlockedShortly(door, States.UNLOCKED_SHORTLY, clock);
    door.setState(unlockedShortly, false);
  }

  public void propper() {
    System.out.println("Door " + name + " can't be propper");
  }

  @Override
  public String toString() {
    return States.LOCKED;
  }
}

