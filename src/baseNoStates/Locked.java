package baseNoStates;

public class Locked extends DoorState{
  public Locked(Door door, String name) {
    super(door, name);
  }
  @Override
  public void open() {}
  @Override
  public void close() {}
  @Override
  public void unlock() {}
  @Override
  public void lock() {}
}

