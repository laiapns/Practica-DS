package baseNoStates.first_milestone;

import baseNoStates.requests.RequestReader;
import org.slf4j.Logger;


import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The 'DirectoryUserGroups' class is responsible for
 * creating and managing user groups and users
 * in a building's security directory. It defines
 * different user groups, including employees, managers,
 * and administrators, and sets their characteristics,
 * such as access permissions, working hours,
 * and accessible areas. The class also includes methods
 * for finding users by their credentials.
 */

public final class DirectoryUserGroups {

  private static final Logger LOGGER =
      org.slf4j.LoggerFactory.getLogger(DirectoryUserGroups.class);
  private static final ArrayList<User> USERS = new ArrayList<>();
  private RequestReader requestReader;


  public static void makeUserGroups() {
    // users without any privilege, just to keep
    // temporally users instead of deleting them,
    // this is to withdraw all permissions but
    // still to keep user data to give back
    // permissions later

    //Array used to set the work days for employees.
    ArrayList<DayOfWeek> monToFri =
            new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
                    DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));

    UserGroup unknown = new UserGroup("Unknown",
            LocalDateTime.of(2000, 1, 1, 0, 0),
            LocalDateTime.of(2000, 12, 31, 23, 59),
            LocalTime.of(0, 0), LocalTime.of(0, 0),
            null, null, null);


    //this users won't be added to any group yet
    USERS.add(new User("Bernat", "12345", unknown));
    USERS.add(new User("Blai", "77532", unknown));

    // employees characteristics:
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground_floor, floor1, exterior, stairs (this, for all),
    // that is, everywhere but the parking

    ArrayList<Area> accessibleAreasEmployees = new ArrayList<>();
    //list of the spaces where employees can be.
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("hall"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("room1"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("room2"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("room3"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("corridor"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("IT"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("stairs"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("exterior"));


    UserGroup employees = new UserGroup("Employees",
            LocalDateTime.of(2023, 9, 1, 8, 8),
            LocalDateTime.of(2024, 3, 1, 8, 8),
            LocalTime.of(9, 0), LocalTime.of(17, 0),
            monToFri, Actions.EMPLOYEES_ACTIONS, accessibleAreasEmployees);

    User ernestUser = new User("Ernest", "74984", employees);
    User eulaliaUser = new User("Eulalia", "43295",  employees);

    //addUser is used to users to their specific group
    employees.addUser(ernestUser);
    employees.addUser(eulaliaUser);

    //addGroup is used to add a new group.
    employees.addGroup();

    //add is used to add the user into array of users
    USERS.add(ernestUser);
    USERS.add(eulaliaUser);

    // managers characteristics:
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces

    ArrayList<DayOfWeek> monToSat =
        new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY));
    UserGroup managers = new UserGroup("Managers",
        LocalDateTime.of(2023, 9, 1, 8, 8),
        LocalDateTime.of(2024, 3, 1, 8, 8),
        LocalTime.of(8, 0), LocalTime.of(20, 0),
        monToSat, Actions.OTHERS_ACTIONS, DirectoryAreas.getAllAreas());

    User manelUser = new User("Manel", "95783", managers);
    User martaUser = new User("Marta", "05827", managers);

    managers.addUser(manelUser);
    managers.addUser(martaUser);

    USERS.add(manelUser);
    USERS.add(martaUser);

    managers.addGroup();

    // admin characteristics :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    ArrayList<DayOfWeek> allDays =
        new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY, DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
    UserGroup admin =
        new UserGroup("admin", LocalDateTime.MIN, LocalDateTime.MAX,
        LocalTime.MIN, LocalTime.MAX, allDays,
            Actions.OTHERS_ACTIONS, DirectoryAreas.getAllAreas());
    User anaUser = new User("Ana", "11343", admin);

    USERS.add(anaUser);

    admin.addUser(anaUser);

    admin.addGroup();

  }

  public static User findUserByCredential(final String credential) {
    for (User user : USERS) {
      if (user.getCredential().equals(credential)) {
        return user;
      }
    }
    LOGGER.warn("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }


}