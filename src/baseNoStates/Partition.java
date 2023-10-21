package baseNoStates;

import java.util.ArrayList;

public class Partition extends Area {
  private ArrayList childPartitions = new ArrayList<>();
  public Partition (String id, String description, Partition parentPartition) {
    super(id, description, parentPartition);
  }

  public String getId(){
    return id;
  }
  public void addChild(Area child) {
    childPartitions.add(child);
  }

}
