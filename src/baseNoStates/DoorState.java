package baseNoStates;

import baseNoStates.requests.RequestReader;

public abstract class DoorState {
  protected Door door;
  protected String name;
  RequestReader requestReader;

  public DoorState(Door door, String n) {
    this.door = door;
    this.name = n;
  }

  public abstract void open();
  public abstract void close();
  public abstract void unlock();
  public abstract void lock();
  public abstract void unlockshortly();
  public abstract void propper();


}
