package baseNoStates;

public abstract class Area {
  protected String id;
  protected String description;

  public Area (String id, String description, Partition parentPartition) {
    this.id = id;
    this.description = description;
    parentPartition.addChild(this);
  }
}
