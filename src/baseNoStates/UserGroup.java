package baseNoStates;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UserGroup {
  public static final String EMPLOYEES_GROUP = "employees";
  public static final String MANAGERS_GROUP = "managers";
  public static final String ADMIN_GROUP = "admin";



  public static class GroupCharacteristics {
    private String groupName;

    LocalDate startDate;
    LocalDate finishDate;

    LocalTime startHour;
    LocalTime finishHour;

    private List<String> allowedActions;
    private ArrayList<Area> accessibleSpaces;

    private List<User> users = new ArrayList<>();


    public GroupCharacteristics(String groupName,LocalDate userStart,LocalDate userFinish,
                                LocalTime userStartHour,LocalTime userFinishHour,List<String> allowedActions,
                                ArrayList<Area> accessibleSpaces) {
      this.groupName = groupName;
      this.startDate = userStart;
      this.finishDate = userFinish;
      this.startHour = userStartHour;
      this.finishHour = userFinishHour;
      this.allowedActions = allowedActions;
      this.accessibleSpaces = accessibleSpaces;

    }
    public ArrayList<Area> getAccessibleSpaces() {
      return accessibleSpaces;
    }
    public void addUser(User user) {
      users.add(user);
    }

    public List<User> getUsers() {
      return users;
    }


  }

  public static final GroupCharacteristics EMPLOYEES_CHARACTERISTICS;

  static {
    ArrayList<Area> accessibleAreasEmployees = new ArrayList<>();
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("hall"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("room1"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("room2"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("room3"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("corridor"));
    accessibleAreasEmployees.add(DirectoryAreas.findAreaById("IT"));

    EMPLOYEES_CHARACTERISTICS = new GroupCharacteristics(
            EMPLOYEES_GROUP,
            LocalDate.of(2023, 9, 1), // Sep. 1, 2023
            LocalDate.of(2024, 3, 1), // Mar. 1, 2024
            LocalTime.of(9, 0), // 9:00 AM
            LocalTime.of(17, 0), // 5:00 PM
            Actions.EMPLOYEES_ACTIONS,
            accessibleAreasEmployees
    );

  }
  public static final GroupCharacteristics MANAGERS_CHARACTERISTICS;

  static {
    MANAGERS_CHARACTERISTICS = new GroupCharacteristics(
        MANAGERS_GROUP,
        LocalDate.of(2023, 9, 1), // Sep. 1, 2023
        LocalDate.of(2024, 3, 1), // Mar. 1, 2024
        LocalTime.of(8, 0), // 9:00 AM
        LocalTime.of(20, 0), // 5:00 PM
        Actions.OTHERS_ACTIONS,
        DirectoryAreas.getAllAreas()
    );
  }
  public static final GroupCharacteristics ADMIN_CHARACTERISTICS;

  static {
    ADMIN_CHARACTERISTICS = new GroupCharacteristics(
        ADMIN_GROUP,
        LocalDate.of(2023, 9, 1), // Sep. 1, 2023
        LocalDate.of(2024, 3, 1), // Mar. 1, 2024
        LocalTime.of(00, 0), // 9:00 AM
        LocalTime.of(00, 0), // 5:00 PM
        Actions.OTHERS_ACTIONS,
        DirectoryAreas.getAllAreas()
    );
  }

}
