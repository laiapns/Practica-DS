package baseNoStates.first_milestone;

import org.slf4j.Logger;

public class Unlocked extends DoorState {

  private static final Logger LOGGER =
      org.slf4j.LoggerFactory.getLogger(Unlocked.class);
  public Unlocked(final Door door, final String name) {
    super(door, States.UNLOCKED);
  }

  @Override
  public void open() {
    LOGGER.info("Opening the door: " + getName());
    getDoor().setClosed(false);
  }

  @Override
  public void close() {
    LOGGER.info("Closing the door: " + getName());
    getDoor().setClosed(true);
  }

  @Override
  public void unlock() {
    LOGGER.warn("Door " + getName() + " already unlocked");
  }

  @Override
  public void lock() {
    if (getDoor().isClosed()) {
      getDoor().setState(new Locked(getDoor(), States.LOCKED), true);
    } else {
      LOGGER.warn("Door " + getName() + " can't be locked, is open");
    }
  }

  @Override
  public void unlockshortly() {
    LOGGER.warn("Door " + getName() + " already unlocked");
  }

  @Override
  public void propper() {
    LOGGER.warn("Door " + getName() + " can't be propper");
  }
  @Override
  public String toString() {
    return States.UNLOCKED;
  }
}
