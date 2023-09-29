package baseNoStates;

public abstract class DoorState {
  protected Door door;
  protected String name;

  public DoorState (Door door){
    door = this.door;
  }
  public boolean open() {
    return true;
  }
  public boolean close() {
    return true;
  }
  public boolean lock() { return true; }
  public boolean unlock() { return true; }

}
