package baseNoStates;

import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;


public class UnlockedShortly extends DoorState implements Observer {

  private static final Logger LOGGER =
      org.slf4j.LoggerFactory.getLogger(UnlockedShortly.class);
  private final Clock clock = Clock.getInstance();
  private LocalDateTime subscriptionTime;

  public UnlockedShortly(final Door door, final String name) {
    super(door, States.UNLOCKED_SHORTLY);
    clock.addObserver(this);
    subscriptionTime = LocalDateTime.now();
    LOGGER.debug("Clock update with period: " + this.clock.getPeriod());
  }

  @Override
  public void open() {
    LOGGER.info("Opening the door: " + getName());
    getDoor().setClosed(false);
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
    LOGGER.info("Closing the door: " + getName());
    getDoor().setClosed(true);
  }

  @Override
  public void unlock() {
    LOGGER.warn("Door " + getName() + " already unlocked");
  }

  @Override
  public void lock() {
    LOGGER.warn("Door " + getName()
        + " can't be locked while is unlocked shortly");
  }

  @Override
  public void unlockshortly() {
    LOGGER.warn("Door " + getName() + " is already unlocked shortly");
  }

  @Override
  public void propper() {
    getDoor().setState(new Propped(getDoor(), States.PROPPED), false);
  }

  // in order to be aware of the state of the door,
  // we implement the Observer Patron
  // if the door is set to UnlockedShortly the observer
  // while set a clock that will wait 10 seconds.
  // after this 10 seconds if the door is closed it will
  // change the door to Locked, otherwise will set the door Propped
  @Override
  public void update(final Observable o, final Object arg) {
    long seconds = clock.getElapsedSecondsFrom(subscriptionTime);
    LOGGER.debug("Update con el segundo: " + seconds);
    if (seconds >= 10) {
      if (getDoor().isClosed()) {
        getDoor().setState(new Locked(this.getDoor(), States.LOCKED), true);
      } else {
        getDoor().setState(new Propped(this.getDoor(), States.PROPPED), false);
      }
      clock.deleteObserver(this);
    }
  }
  @Override
  public String toString() {
    return States.UNLOCKED_SHORTLY;
  }
}