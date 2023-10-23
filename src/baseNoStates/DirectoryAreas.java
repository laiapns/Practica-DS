package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryAreas {
  private static Area restArea;
  private static ArrayList<Door> allDoors;
  private static ArrayList<Area> allAreas;

  public static void makeAreas() {
    Partition building = new Partition("building","two floors and parking",null);

    Partition basement = new Partition("basement","parking for employees",building);
    Partition floor1 = new Partition("floor1","first floor",building);
    Partition ground_floor = new Partition("ground_floor","basement",building);

    Space exterior = new Space("exterior","outside",building);
    Space stairs = new Space("stairs","stairs to basement and plant 1",building);

    Space parking = new Space("parking","parking",basement);

    Space hall = new Space("hall","hall",ground_floor);
    Space room1 = new Space("room1","room1",ground_floor);
    Space room2 = new Space("room2","room2",ground_floor);

    Space room3 = new Space("room3","room3",floor1);
    Space corridor = new Space("corridor","corridor",floor1);
    Space IT = new Space("IT","IT",floor1);

    allAreas=new ArrayList<>(Arrays.asList(building, basement, floor1, ground_floor, exterior, stairs, parking, hall, room1, room2, room3, corridor, IT));

  }

  public static Area findAreaById (String areaId) {
    for (Area area : allAreas) {
      if (area.getId().equals(areaId)) {
        return area;
      }
    }
    System.out.println("door with id " + areaId + " not found");
    return null;
  }
  public static ArrayList<Area> getAllAreas() {
    System.out.println(allAreas);
    return allAreas;
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
  public static Door findDoorById(String doorId) {
    ArrayList<Door> allDoors = getAllDoors();

    for (Door door : allDoors) {
      if (door.getId().equals(doorId)) {
        return door;
      }
    }

    System.out.println("Door with id " + doorId + " not found");
    return null;
  }

}
