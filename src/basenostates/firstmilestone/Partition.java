package basenostates.firstmilestone;

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

  /**
   * Constructor for the 'Partition' class.
   *
   * @param id                The unique identifier for the partition.
   * @param description       The description of the partition.
   * @param parentPartition   The parent partition, if any.
   */
  public Partition(String id, final String description,
                   final Partition parentPartition) {
    super(id, description, parentPartition);
  }

  /**
   * Get all the doors giving access within this partition.
   *
   * @return ArrayList of doors giving access within this partition.
   */
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> doorsArea = new ArrayList<>();
    getDoorsRecursively(childPartitions, doorsArea);
    return doorsArea;
  }

  // Helper method to recursively get doors from child partitions
  private void getDoorsRecursively(ArrayList<Area> partitions, ArrayList<Door> doorsArea) {
    for (Area area : partitions) {
      if (area instanceof Space) {
        doorsArea.addAll(area.getDoorsGivingAccess());
      } else if (area instanceof Partition) {
        getDoorsRecursively(((Partition) area).childPartitions, doorsArea);
      }
    }
  }

  /**
   * Find an area within this partition based on its ID.
   *
   * @param areaId The ID of the area to find.
   * @return The found area or null if not found.
   */
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

  /**
   * Add a child area (partition or space) to this partition.
   *
   * @param child The child area to add.
   */
  public void addChild(Area child) {
    childPartitions.add(child);
  }

  /**
   * Get all spaces within this partition.
   *
   * @return ArrayList of spaces within this partition.
   */
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
