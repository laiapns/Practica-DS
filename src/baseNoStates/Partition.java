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
  //private ArrayList<Door> doorsArea = new ArrayList<>();
  public Partition(String id, final String description,
                   final Partition parentPartition) {
    super(id, description, parentPartition);
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> doorsArea = new ArrayList<>();
    getDoorsRecursively(childPartitions, doorsArea);
    return doorsArea;
  }

  private void getDoorsRecursively(ArrayList<Area> partitions, ArrayList<Door> doorsArea) {
    for (Area area : partitions) {
      if (area instanceof Space) {
        doorsArea.addAll(area.getDoorsGivingAccess());
      } else if (area instanceof Partition) {
        getDoorsRecursively(((Partition) area).childPartitions, doorsArea);
      }
    }
  }

  @Override
  public Area findAreaById(String areaId) {
    if (this.getId().equals(areaId)) {
      return this;
    }
    for (Area area : childPartitions) {
      Area foundArea = area.findAreaById(areaId);
      if (foundArea != null) {
        return foundArea;
      }
    }
    return null;
  }


  public void addChild(Area child) {
    childPartitions.add(child);
  }

  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    for (Area child : childPartitions) {
      if (child instanceof Space) {
        spaces.add((Space) child);
      } else if (child instanceof Partition) {
        spaces.addAll(((Partition) child).getSpaces());
      }
    }
    return spaces;
  }

}
