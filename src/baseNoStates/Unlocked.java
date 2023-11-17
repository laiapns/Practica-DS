package baseNoStates;

import org.slf4j.Logger;

public class Unlocked extends DoorState {

  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Unlocked.class);
  public Unlocked(Door door, String name) {
    super(door, States.UNLOCKED);
  }

  @Override
  public void open() {
    LOGGER.info("Opening the door: " + name);
    door.setClosed(false);
  }

  @Override
  public void close() {
    LOGGER.info("Closing the door: " + name);
    door.setClosed(true);
  }

  @Override
  public void unlock() {
    LOGGER.warn("Door " + name + " already unlocked");
  }

  @Override
  public void lock() {
    if(door.isClosed()){
      door.setState(new Locked(door, States.LOCKED), true);
    }else{
      LOGGER.warn("Door " + name + " can't be locked, is open");
    }
  }

  @Override
  public void unlockshortly() {
    LOGGER.warn("Door " + name + " already unlocked");
  }

  @Override
  public void propper() {
    LOGGER.warn("Door " + name + " can't be propper");
  }
  @Override
  public String toString() {
    return States.UNLOCKED;
  }
}
