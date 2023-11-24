package baseNoStates;

import java.util.ArrayList;

/**
 * The 'Space' and 'Partition' classes inherit from
 * the 'Area' class to create a tree-like structure
 * representing the building. 'Area' serves as the
 * base class providing common properties and
 * functionality for all building areas, while
 * 'Space' and 'Partition' can extend it with
 * specific attributes for their respective roles
 * in the building's hierarchy.
 */

public abstract class Area {
  private String areaId;
  private String areaDescription;
  private static ArrayList<Area> allAreas = new ArrayList<>();

  public Area(String id, final String description,
               final Partition parentPartition) {
    this.areaId = id;
    this.areaDescription = description;
    if (parentPartition != null) {
      parentPartition.addChild((Area) this);
    }
    allAreas.add((Area) this);
  }
  public abstract ArrayList<Space> getSpaces();

  public static ArrayList<Area> getAllAreas() {
    return allAreas;
  }

  /**
   * Gets the unique identifier of this area.
   *
   * @return The unique identifier of this area.
   */
  public String getId() {
    return areaId;
  }


  public abstract ArrayList<Door> getDoorsGivingAccess();

  public abstract Area findAreaById(String id);
}
