package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The 'DirectoryAreas' class is responsible for defining and
 * managing areas and doors within a building's layout.
 * It defines various areas, such as partitions and spaces,
 * and their relationships. The class also includes methods
 * for finding areas and doors by their identifiers and obtaining
 * lists of all areas and doors in the building.
 */

public class DirectoryAreas {
  private static Area restArea;
  private static ArrayList<Door> allDoors;
  private static ArrayList<Area> allAreas;

  public static void makeAreas() {
    Partition building = new Partition("building",
        "two floors and parking", null);

    Partition basement = new Partition("basement",
        "parking for employees", building);
    Partition floor1 = new Partition("floor1",
        "first floor", building);
    Partition groundFloor = new Partition("ground_floor",
        "basement", building);

    Space exterior = new Space("exterior",
        "outside", building);
    Space stairs = new Space("stairs",
        "stairs to basement and floor 1", building);

    Space parking = new Space("parking", "parking", basement);

    Space hall = new Space("hall", "hall", groundFloor);
    Space room1 = new Space("room1", "room1", groundFloor);
    Space room2 = new Space("room2", "room2", groundFloor);

    Space room3 = new Space("room3", "room3", floor1);
    Space corridor = new Space("corridor", "corridor", floor1);
    Space iT = new Space("IT", "IT", floor1);

    allAreas = new ArrayList<>(Arrays.asList(building, basement,
        floor1, groundFloor, exterior, stairs, parking, hall,
        room1, room2, room3, corridor, iT));
    restArea = building;
  }

  public static Area findAreaById(final String areaId) {
    return restArea.findAreaById(areaId);
  }
  public static ArrayList<Area> getAllAreas() {
    return Area.getAllAreas();
  }
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
  public static Door findDoorById(final String doorId) {
    allDoors = getAllDoors();

    for (Door door : allDoors) {
      if (door.getId().equals(doorId)) {
        return door;
      }
    }

    System.out.println("Door with id " + doorId + " not found");
    return null;
  }

}
