package baseNoStates;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

import baseNoStates.first_milestone.DirectoryAreas;
import baseNoStates.first_milestone.DirectoryDoors;
import baseNoStates.first_milestone.DirectoryUserGroups;
import baseNoStates.second_milestone.Clock;

public class Main {
  public static void main(String[] args) {
    Clock.getInstance().start();
    DirectoryAreas.makeAreas();
    DirectoryUserGroups.makeUserGroups();
    DirectoryDoors.makeDoors();
    new WebServer();
    Clock.getInstance().stop();
  }
}
