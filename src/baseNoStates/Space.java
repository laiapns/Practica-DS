package baseNoStates;

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
  public Space(String id, final String description, final Partition partition) {
    super(id, description, partition);
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doorsGivingAccess;
  }
  public void setDoorsGivingAccess(final Door door) {
    doorsGivingAccess.add(door);
  }

  @Override
  public Area findAreaById(final String areaId) {
    if (this.getId().equals(areaId)) {
      return this;
    }
    return null;
  }

  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    spaces.add(this);
    return spaces;
  }

}