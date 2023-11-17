package baseNoStates;

import org.slf4j.Logger;

public class Locked extends DoorState {

  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Locked.class);
  public Locked(Door door, String name) {
    super(door, States.LOCKED);
  }

  @Override
  public void open() {
    LOGGER.warn("Door " + name + " can't be open");
  }

  @Override
  public void close() {
    LOGGER.warn("Door " + name + " already closed");
  }

  @Override
  public void unlock() {
    LOGGER.info("Unlocking the door: " + name);
    door.setState(new Unlocked(this.door,States.UNLOCKED), true);
  }

  @Override
  public void lock() {
    LOGGER.warn("Door " + name + " already locked");
  }

  @Override
  public void unlockshortly() {
    LOGGER.info("Unlocking shortly the door: " + name);
    door.setState(new UnlockedShortly(door, name), true);
  }

  public void propper() {
    LOGGER.warn("Door " + name + " can't be propper");
  }

  @Override
  public String toString() {
    return States.LOCKED;
  }
}

