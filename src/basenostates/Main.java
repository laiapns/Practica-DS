package basenostates;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

import basenostates.firstmilestone.DirectoryAreas;
import basenostates.firstmilestone.DirectoryDoors;
import basenostates.firstmilestone.DirectoryUserGroups;
import basenostates.secondmilestone.Clock;

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
