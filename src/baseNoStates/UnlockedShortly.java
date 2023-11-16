package baseNoStates;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;


public class UnlockedShortly extends DoorState implements Observer {
  private final Clock clock = Clock.getInstance();
  private LocalDateTime subscriptionTime;

  public UnlockedShortly(Door door, String name) {
    super(door, States.UNLOCKED_SHORTLY);
    clock.addObserver(this);
    subscriptionTime = LocalDateTime.now();
    System.out.println("Clock update with period: " + this.clock.getPeriod());
  }

  @Override
  public void open() {
    System.out.println("Opening the door: " + name);
    door.setClosed(false);
  }

  @Override
  public void close() {
    /*if (this.clock.getElapsedSeconds() >= 10) {
      System.out.println("Door : " + name + " may be propped");
      door.setState(new Propped(door, States.PROPPED), false);
    } else {
      System.out.println("Locking the door: " + name);
      door.setState(new Locked(door, States.LOCKED), true);
    }*/
    System.out.println("Closing the door: " + name);
    door.setClosed(true);
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
    door.setState(new Propped(door, States.PROPPED), false);
  }

  //in order to be aware of the state of the door, we implement the Observer Patron
  //if the door is set to UnlockedShortly the observer while set a clock that will wait 10 seconds.
  //after this 10 seconds if the door is closed it will
  // change the door to Locked, otherwise will set the door Propped
  @Override
  public void update(Observable o, Object arg) {
    long seconds = clock.getElapsedSecondsFrom(subscriptionTime);
    System.out.println("Update con el segundo: "+ seconds);
    if (seconds >= 10) {
      if (door.isClosed()) {
        door.setState(new Locked(this.door, States.LOCKED), true);
      } else {
        door.setState(new Propped(this.door, States.PROPPED), false);
      }
      clock.deleteObserver(this);
    }
  }
  @Override
  public String toString() {
    return States.UNLOCKED_SHORTLY;
  }
}