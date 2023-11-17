package baseNoStates;

import org.slf4j.Logger;

public class Propped extends DoorState {

  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Propped.class);
  public Propped(Door door, String name) {
    super(door, States.PROPPED);
  }

  @Override
  public void open() {
    LOGGER.warn("Door " + name + " already open");
  }

  @Override
  public void close() {
    LOGGER.warn("Door " + name + " can't be closed while it's propped");
  }

  //if the door is propped we can change the state to unlocked in order
  //to quit the propped state
  @Override
  public void unlock() {
    door.setState(new Unlocked(door, States.UNLOCKED), false);
  }

  @Override
  public void lock() {
    LOGGER.warn("Door " + name + " can't be locked while it's propped");
  }

  @Override
  public void unlockshortly() {
    LOGGER.warn("Door " + name + " can't be unlocked while it's propped");
  }

  @Override
  public void propper() {
    LOGGER.warn("Door " + name + " already propped");
  }
  @Override
  public String toString() {
    return States.PROPPED;
  }
}
