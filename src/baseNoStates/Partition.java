package baseNoStates;

import java.util.ArrayList;

public class Partition extends Area {
  protected ArrayList<Area> childPartitions = new ArrayList<>();
  public Partition (String id, String description, Partition parentPartition) {
    super(id, description, parentPartition);
  }

  public String getId(){
    return id;
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return null;
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
