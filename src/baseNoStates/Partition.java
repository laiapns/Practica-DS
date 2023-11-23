package baseNoStates;

import java.util.ArrayList;

/**
 * The 'Partition' class represents a specific area within
 * a building that can contain other partitions or spaces.
 * It extends the 'Area' class to inherit common properties
 * and functionality for building areas.
 * This class can have child partitions and provides methods
 * to access doors, find areas by ID, and retrieve spaces within it.
 */

public class Partition extends Area {
  private ArrayList<Area> childPartitions = new ArrayList<>();

  public Partition(final String id, final String description) {
    super(id, description);
  }

  public String getId() {
    return getId();
  }

  @Override
  public void accept(AreaVisitor visitor) {
    visitor.visit(this);
    for (Area child : childPartitions) {
      child.accept(visitor);
    }
  }

  public void addChild(Area child) {
    childPartitions.add(child);
  }



}
