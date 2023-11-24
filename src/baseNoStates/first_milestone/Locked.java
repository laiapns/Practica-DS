package baseNoStates.first_milestone;

import org.slf4j.Logger;

public class Locked extends DoorState {

  private static final Logger LOGGER =
      org.slf4j.LoggerFactory.getLogger(Locked.class);
  public Locked(final Door door, final String name) {
    super(door, States.LOCKED);
  }

  @Override
  public void open() {
    LOGGER.warn("Door " + getName() + " can't be open");
  }

  @Override
  public void close() {
    LOGGER.warn("Door " + getName() + " already closed");
  }

  @Override
  public void unlock() {
    LOGGER.info("Unlocking the door: " + getName());
    getDoor().setState(new Unlocked(this.getDoor(), States.UNLOCKED), true);
  }

  @Override
  public void lock() {
    LOGGER.warn("Door " + getName() + " already locked");
  }

  @Override
  public void unlockshortly() {
    LOGGER.info("Unlocking shortly the door: " + getName());
    getDoor().setState(new UnlockedShortly(getDoor(), getName()), true);
  }

  public void propper() {
    LOGGER.warn("Door " + getName() + " can't be propper");
  }

  @Override
  public String toString() {
    return States.LOCKED;
  }
}

