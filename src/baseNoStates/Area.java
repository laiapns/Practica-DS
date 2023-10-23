package baseNoStates;

import java.util.ArrayList;

public abstract class Area {
  protected String id;
  protected String description;

  public Area (String id, String description, Partition parentPartition) {
    this.id = id;
    this.description = description;
    if(parentPartition!=null) {
      parentPartition.addChild((Area)this);
    }
  }
  public abstract ArrayList<Space> getSpaces();
}
