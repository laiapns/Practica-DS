package baseNoStates;

import baseNoStates.requests.RequestReader;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;


public final class DirectoryUserGroups {
  private static final ArrayList<User> users = new ArrayList<>();
  RequestReader requestReader;


  public static void makeUserGroups() {
    //TODO: make user groups according to the specifications in the comments, because
    // now all are the same

    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later

    //this users won't be added to any group yet
    users.add(new User("Bernat", "12345", null));
    users.add(new User("Blai", "77532", null));

    // employees characteristics:
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground_floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking

    ArrayList<Area> accessibleAreasEmployees = new ArrayList<>(); //list of the spaces where employees can be.
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("hall"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("room1"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("room2"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("room3"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("corridor"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("IT"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("stairs"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("exterior"));

    //Array used to set the work days for employees.
    ArrayList<DayOfWeek> monToFri = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY,DayOfWeek.TUESDAY,DayOfWeek.WEDNESDAY,DayOfWeek.THURSDAY,DayOfWeek.FRIDAY));

    UserGroup employees = new UserGroup("Employees",LocalDateTime.of(2023,9,1,8,8),
        LocalDateTime.of(2024,3,1,8,8),LocalTime.of(9, 0),LocalTime.of(17, 0),
        monToFri, Actions.EMPLOYEES_ACTIONS,accessibleAreasEmployees);

    User ernestUser = new User("Ernest", "74984", employees);
    User eulaliaUser = new User("Eulalia", "43295",  employees);

    //addUser is used to users to their specific group
    employees.addUser(ernestUser);
    employees.addUser(eulaliaUser);

    //addGroup is used to add a new group.
    employees.addGroup();

    //add is used to add the user into array of users
    users.add(ernestUser);
    users.add(eulaliaUser);

    // managers characteristics:
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces

    ArrayList<DayOfWeek> monToSat = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY,DayOfWeek.TUESDAY,DayOfWeek.WEDNESDAY,DayOfWeek.THURSDAY,DayOfWeek.FRIDAY,DayOfWeek.SATURDAY));
    UserGroup managers = new UserGroup("Managers",LocalDateTime.of(2023,9,1,8,8),
        LocalDateTime.of(2024,3,1,8,8), LocalTime.of(8, 0), LocalTime.of(20, 0),
        monToSat, Actions.OTHERS_ACTIONS, DirectoryAreas.getAllAreas());

    User manelUser = new User("Manel", "95783", managers);
    User martaUser = new User("Marta", "05827", managers );

    managers.addUser(manelUser);
    managers.addUser(martaUser);

    users.add(manelUser);
    users.add(martaUser);

    managers.addGroup();

    // admin characteristics :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    ArrayList<DayOfWeek> allDays = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY,DayOfWeek.TUESDAY,DayOfWeek.WEDNESDAY,DayOfWeek.THURSDAY,DayOfWeek.FRIDAY,DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
    UserGroup admin = new UserGroup("admin", LocalDateTime.MIN, LocalDateTime.MAX,
        LocalTime.MIN, LocalTime.MAX, allDays, Actions.OTHERS_ACTIONS, DirectoryAreas.getAllAreas());
    User anaUser = new User("Ana", "11343", admin);

    users.add(anaUser);

    admin.addUser(anaUser);

    admin.addGroup();

  }

  public static User findUserByCredential(String credential) {
    for (User user : users) {
      if (user.getCredential().equals(credential)) {
        return user;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }


}