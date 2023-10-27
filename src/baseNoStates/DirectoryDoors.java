package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The 'DirectoryDoors' class is responsible for creating and managing doors within a building's security system.
 * It defines various doors and their connections, such as which spaces they connect. The class also includes methods
 * for finding doors by their identifiers and obtaining a list of all doors in the building.
 */

public final class DirectoryDoors {
  private static ArrayList<Door> allDoors;

  public static void makeDoors() {
    // basement
    Space parking = (Space)DirectoryAreas.findAreaById("parking");
    Space exterior = (Space)DirectoryAreas.findAreaById("exterior");
    Space stairs = (Space)DirectoryAreas.findAreaById("stairs");

    Door d1 = new Door("D1", exterior, parking); // exterior, parking
    Door d2 = new Door("D2", stairs, parking); // stairs, parking

    // ground floor
    Space hall = (Space)DirectoryAreas.findAreaById("hall");
    Space room1 = (Space)DirectoryAreas.findAreaById("room1");
    Space room2 = (Space)DirectoryAreas.findAreaById("room2");

    Door d3 = new Door("D3", exterior, hall); // exterior, hall
    Door d4 = new Door("D4", stairs, hall); // stairs, hall
    Door d5 = new Door("D5", hall, room1); // hall, room1
    Door d6 = new Door("D6", hall, room2); // hall, room2

    Space room3 = (Space)DirectoryAreas.findAreaById("room3");
    Space corridor = (Space)DirectoryAreas.findAreaById("corridor");
    Space IT = (Space)DirectoryAreas.findAreaById("IT");
    // first floor
    Door d7 = new Door("D7", stairs, corridor); // stairs, corridor
    Door d8 = new Door("D8", corridor, room3); // corridor, room3
    Door d9 = new Door("D9", corridor, IT); // corridor, IT

    allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
  }

  public static Door findDoorById(String id) {
    for (Door door : allDoors) {
      if (door.getId().equals(id)) {
        return door;
      }
    }
    System.out.println("door with id " + id + " not found");
    return null; // otherwise we get a Java error
  }

  // this is needed by RequestRefresh
  public static ArrayList<Door> getAllDoors() {
    System.out.println(allDoors);
    return allDoors;
  }

}
