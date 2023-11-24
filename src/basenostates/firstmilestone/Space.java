package basenostates.firstmilestone;

import java.util.ArrayList;

/**
 * The 'Space' class represents a specific area within
 * a building. It extends the 'Area' class
 * to inherit common properties and functionality for
 * building areas. A space is typically a part
 * of a larger partition and may have doors providing access.
 * This class provides methods to manage
 * doors, find the space by ID (though this is not practical
 * for spaces), and retrieve itself as a space.
 */

public class Space extends Area {
  private Partition parentPartition;
  private final ArrayList<Door> doorsGivingAccess = new ArrayList<>();

  /**
   * Constructor for the 'Space' class.
   *
   * @param id          The unique identifier for the space.
   * @param description The description of the space.
   * @param partition   The partition to which this space belongs.
   */
  public Space(String id, final String description, final Partition partition) {
    super(id, description, partition);
  }

  /**
   * Get all doors providing access to this space.
   *
   * @return ArrayList of doors providing access to this space.
   */
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doorsGivingAccess;
  }

  /**
   * Set a door to provide access to this space.
   *
   * @param door The door to set for providing access to this space.
   */
  public void setDoorsGivingAccess(final Door door) {
    doorsGivingAccess.add(door);
  }

  /**
   * Find an area within this space based on its ID.
   * Note: For spaces, finding by ID always returns itself.
   *
   * @param areaId The ID of the area to find.
   * @return The found area (itself) or null if not found.
   */
  @Override
  public Area findAreaById(final String areaId) {
    if (this.getId().equals(areaId)) {
      return this;
    }
    return null;
  }

  /**
   * Get all spaces within this space.
   * Note: For spaces, it returns a list containing itself.
   *
   * @return ArrayList containing this space.
   */
  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    spaces.add(this);
    return spaces;
  }

}