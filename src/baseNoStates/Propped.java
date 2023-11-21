package baseNoStates;

import org.slf4j.Logger;

public class Propped extends DoorState {

  private static final Logger LOGGER =
      org.slf4j.LoggerFactory.getLogger(Propped.class);
  public Propped(final Door door, final String name) {
    super(door, States.PROPPED);
  }

  @Override
  public void open() {
    LOGGER.warn("Door " + getName() + " already open");
  }

  @Override
  public void close() {
    LOGGER.warn("Door " + getName() + " can't be closed while it's propped");
  }

  //if the door is propped we can change the state to unlocked in order
  //to quit the propped state
  @Override
  public void unlock() {
    getDoor().setState(new Unlocked(getDoor(), States.UNLOCKED), false);
  }

  @Override
  public void lock() {
    LOGGER.warn("Door " + getName() + " can't be locked while it's propped");
  }

  @Override
  public void unlockshortly() {
    LOGGER.warn("Door " + getName() + " can't be unlocked while it's propped");
  }

  @Override
  public void propper() {
    LOGGER.warn("Door " + getName() + " already propped");
  }
  @Override
  public String toString() {
    return States.PROPPED;
  }
}
