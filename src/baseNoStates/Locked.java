package baseNoStates;

import java.util.Timer;
import java.util.TimerTask;

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
    door.setState(new Unlocked(this.door,this.name), false);
  }

  @Override
  public void lock() {
    System.out.println("Door " + name + " already locked");
  }

  @Override
  public void unlockshortly() {
    System.out.println("Unlocking shortly the door: " + name);
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      public void run() {
        if (door.isClosed()) {
          door.setState(new Locked(door,name), true); // Lock the door
        } else {
          door.setState(new Propped(door, name), false); // Set to another state
        }
        timer.cancel();
      }
    }, 1000);
  }

  public void propper() {
    System.out.println("Door " + name + " can't be propper");
  }
}

