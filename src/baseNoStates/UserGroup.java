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

    private ArrayList<String> allowedActions;
    private ArrayList<Space> accessibleSpaces;

    public GroupCharacteristics(String groupName,LocalDate userStart,LocalDate userFinish,
                                LocalTime userStartHour,LocalTime userFinishHour,ArrayList<String> allowedActions,
                                ArrayList<Space> accessibleSpaces) {
      this.groupName = groupName;
      this.startDate = userStart;
      this.finishDate = userFinish;
      this.startHour = userStartHour;
      this.finishHour = userFinishHour;
      this.allowedActions = allowedActions;
      this.accessibleSpaces = accessibleSpaces;
    }
  }


  public static final GroupCharacteristics EMPLOYEES_CHARACTERISTICS = new GroupCharacteristics(
      EMPLOYEES_GROUP,
      LocalDate.of(2023, 9, 1), // Sep. 1, 2023
      LocalDate.of(2024, 3, 1), // Mar. 1, 2024
      LocalTime.of(9, 0), // 9:00 AM
      LocalTime.of(17, 0), // 5:00 PM
      Actions.EMPLOYEES_ACTIONS,
      new ArrayList<>(List.of(DirectoryAreas.findAreaById(groud)))

  );

  public static final GroupCharacteristics MANAGERS_CHARACTERISTICS = new GroupCharacteristics(
      MANAGERS_GROUP,

  );

  public static final GroupCharacteristics ADMIN_CHARACTERISTICS = new GroupCharacteristics(
      ADMIN_GROUP,

  );
}
