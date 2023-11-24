package basenostates.firstmilestone;

import java.util.ArrayList;
import java.util.Arrays;
import org.slf4j.Logger;


/**
 * The 'DirectoryAreas' class is responsible for defining and managing areas and doors
 * within a building's layout.
 * It defines various areas, such as partitions and spaces, and their relationships.
 * The class also includes methods
 * for finding areas and doors by their identifiers and obtaining lists
 * of all areas and doors in the building.
 */

public class DirectoryAreas {
  private static final Logger LOGGER =
          org.slf4j.LoggerFactory.getLogger(Unlocked.class);
  private static Area restArea;
  private static ArrayList<Door> allDoors;
  private static ArrayList<Area> allAreas;

  /**
   * Method to create the initial areas and spaces in the building layout.
   */
  public static void makeAreas() {
    Partition building = new Partition("building", "two floors and parking", null);

    Partition basement = new Partition("basement", "parking for employees", building);
    Partition floor1 = new Partition("floor1", "first floor", building);
    Partition groundFloor = new Partition("groundFloor", "basement", building);

    Space exterior = new Space("exterior", "outside", building);
    Space stairs = new Space("stairs", "stairs to basement and floor 1", building);

    Space parking = new Space("parking", "parking", basement);

    Space hall = new Space("hall", "hall", groundFloor);
    Space room1 = new Space("room1", "room1", groundFloor);
    Space room2 = new Space("room2", "room2", groundFloor);

    Space room3 = new Space("room3", "room3", floor1);
    Space corridor = new Space("corridor", "corridor", floor1);
    Space it = new Space("it", "it", floor1);

    allAreas = new ArrayList<>(Arrays.asList(building, basement, floor1, groundFloor,
        exterior, stairs, parking, hall, room1, room2, room3, corridor, it));
    restArea = building;
  }

  public static Area findAreaById(String areaId) {
    return restArea.findAreaById(areaId);
  }

  /**
   * Get a list of all areas within the building.
   *
   * @return An ArrayList containing all areas within the building.
   */
  public static ArrayList<Area> getAllAreas() {
    return Area.getAllAreas();
  }

  /**
   * Get a list of all doors within the building.
   *
   * @return An ArrayList containing all doors within the building.
   */
  public static ArrayList<Door> getAllDoors() {
    ArrayList<Door> doors = new ArrayList<>();
    for (Area area : allAreas) {
      if (area instanceof Space) {
        Space space = (Space) area;
        doors.addAll(space.getDoorsGivingAccess());
      }
    }
    return doors;
  }

  /**
   * Find a door within the building by its unique identifier.
   *
   * @param doorId The unique identifier of the door to find.
   * @return The found Door object or null if not found.
   */
  public static Door findDoorById(String doorId) {
    ArrayList<Door> allDoors = getAllDoors();

    for (Door door : allDoors) {
      if (door.getId().equals(doorId)) {
        return door;
      }
    }

    LOGGER.warn("Door with id " + doorId + " not found");
    return null;
  }

}
