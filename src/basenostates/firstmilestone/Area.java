package basenostates.firstmilestone;

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

  /**
   * Constructor for the 'Area' class.
   *
   * @param id               The unique identifier of the area.
   * @param description      The description of the area.
   * @param parentPartition  The parent partition of the area (can be null).
   */
  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Area(String id, final String description,
              final Partition parentPartition) {
    this.areaId = id;
    this.areaDescription = description;
    if (parentPartition != null) {
      parentPartition.addChild((Area) this);
    }
    allAreas.add((Area) this);
  }
  @SuppressWarnings("checkstyle:EmptyLineSeparator")
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

  /**
   * Abstract method to be implemented by subclasses to get
   * a list of doors providing access to this area.
   *
   * @return An ArrayList of Door objects providing access to this area.
   */
  public abstract ArrayList<Door> getDoorsGivingAccess();

  /**
   * Abstract method to be implemented by subclasses to find
   * an area within this area hierarchy by its unique identifier.
   *
   * @param id The unique identifier of the area to find.
   * @return The found Area object or null if not found.
   */
  public abstract Area findAreaById(String id);
}
