package baseNoStates;

import java.util.Observable;
import java.util.Observer;


public class UnlockedShortly extends DoorState implements Observer {
  private final Clock clock;


  public UnlockedShortly(Door door, String name, Clock clock) {
    super(door, States.UNLOCKED_SHORTLY);
    this.clock = clock;
    this.clock.start();
    door.addObserver(this); //door: Observable //UnlockedShortly: Observer
    System.out.println("Clock started with period: " + this.clock.getPeriod());
  }

  @Override
  public void open() {
    System.out.println("Opening the door: " + name);
    door.setClosed(false);
  }



  @Override
  public void close() {
    if (this.clock.getElapsedSeconds() >= 10) {
      System.out.println("Door : " + name + " may be propped");
      door.setState(new Propped(door, States.PROPPED), false);
    } else {
      System.out.println("Locking the door: " + name);
      door.setState(new Locked(door, States.LOCKED), true);
    }
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
    if (arg instanceof DoorState) {
      if ((this.clock.getElapsedSeconds() >= 10)
              && (door.isClosed())) {
        door.setState(new Locked(door, States.LOCKED), true);
        this.clock.stop();
      } else if ((this.clock.getElapsedSeconds() >= 10)
              && (!door.isClosed())) {
        System.out.println("Door : " + name + " may be propped");
        door.setState(new Propped(door, States.PROPPED), false);
        this.clock.stop();
      }
    }
  }
  @Override
  public String toString() {
    return States.UNLOCKED_SHORTLY;
  }
}