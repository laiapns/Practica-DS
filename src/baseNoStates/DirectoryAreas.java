package baseNoStates;

import java.util.ArrayList;

public class DirectoryAreas {
  private static Area restArea;
  private static ArrayList<Door> allDoors;
  private static Partition p;

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


  }

  //public static findAreaById (String areaId) {}
}
