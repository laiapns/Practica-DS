package baseNoStates;

import java.util.ArrayList;

/**
 * The 'Space' and 'Partition' classes inherit from the 'Area' class to create a tree-like
 * structure representing the building. 'Area' serves as the base class providing common
 * properties and functionality for all building areas, while 'Space' and 'Partition' can
 * extend it with specific attributes for their respective roles in the building's hierarchy.
 */

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
