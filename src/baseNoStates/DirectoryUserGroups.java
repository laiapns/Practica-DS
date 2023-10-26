package baseNoStates;

import baseNoStates.requests.RequestReader;
import baseNoStates.Area;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public final class DirectoryUserGroups {
  private static final ArrayList<User> users = new ArrayList<>();
  private static final ArrayList<UserGroup.GroupCharacteristics> userGroups = new ArrayList<>();
  RequestReader requestReader;
  private static final ArrayList<Area> accessibleAreasEmployees = new ArrayList<>();

  public static void makeUserGroups() {
    //TODO: make user groups according to the specifications in the comments, because
    // now all are the same

    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later

    users.add(new User("Bernat", "12345"));
    users.add(new User("Blai", "77532"));

    User ernestUser = new User("Ernest", "74984");
    User eulaliaUser = new User("Eulalia", "43295");
    UserGroup.EMPLOYEES_CHARACTERISTICS.addUser(ernestUser);
    UserGroup.EMPLOYEES_CHARACTERISTICS.addUser(eulaliaUser);

    users.add(ernestUser);
    users.add(eulaliaUser);

    userGroups.add(UserGroup.EMPLOYEES_CHARACTERISTICS);

    // employees :
    // Sep. 1 2023 to Mar. 1 2024
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking


    // managers :
    // Sep. 1 2023 to Mar. 1 2024
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    User manelUser = new User("Manel", "95783");
    User martaUser = new User("Marta", "05827");
    UserGroup.MANAGERS_CHARACTERISTICS.addUser(manelUser);
    UserGroup.MANAGERS_CHARACTERISTICS.addUser(martaUser);

    users.add(manelUser);
    users.add(martaUser);

    userGroups.add(UserGroup.MANAGERS_CHARACTERISTICS);


    // admin :
    // always=2023 to 2100
    // all days of the week
    // all actions
    // all spaces
    User anaUser = new User("Ana", "11343");

    UserGroup.ADMIN_CHARACTERISTICS.addUser(anaUser);

    users.add(anaUser);

    userGroups.add(UserGroup.ADMIN_CHARACTERISTICS);

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
