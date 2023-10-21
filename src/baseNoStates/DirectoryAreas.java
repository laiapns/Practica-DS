package baseNoStates;

import java.awt.geom.Area;
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

  }

  public static findAreaById (String areaId) {
    while (true) {
      if  (areaId.equals(p.getId())) {
      }
    }
    }
  }
}
