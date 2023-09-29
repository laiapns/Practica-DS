package baseNoStates;

public class Unlocked extends DoorState {
  public Unlocked(Door door, String name) {
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
