package baseNoStates;

import java.util.ArrayList;

public abstract class Area {
  protected String id;
  protected String description;
  protected static ArrayList<Area>allAreas = new ArrayList<>();

  public Area (String id, String description, Partition parentPartition) {
    this.id = id;
    this.description = description;
    if(parentPartition!=null) {
      parentPartition.addChild((Area)this);
    }
    allAreas.add((Area)this);
  }
  public abstract ArrayList<Space> getSpaces();

  public static ArrayList<Area> getAllAreas() {
    return allAreas;
  }

  public String getId() {
    return id;
  }

  public abstract ArrayList<Door> getDoorsGivingAccess();

  public abstract Area findAreaById(String areaId);
}
