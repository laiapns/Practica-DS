package baseNoStates;

import baseNoStates.requests.RequestReader;

/**
 * The 'DoorState' class represents the state of a door, providing methods to interact with the door,
 * such as opening, closing, unlocking, locking, unlocking shortly, and performing proper actions.
 */

public abstract class DoorState extends States {
  protected Door door;
  protected String name;
  protected RequestReader requestReader;

  public DoorState(Door door, String n) {
    this.door = door;
    this.name = n;
    if (requestReader != null) {
      this.requestReader.setDoorStateName(n);
    }
  }

  public abstract void open();

  public abstract void close();

  public abstract void unlock();

  public abstract void lock();

  public abstract void unlockshortly();

  public abstract void propper();


}
