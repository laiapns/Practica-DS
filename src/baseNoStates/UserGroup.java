package baseNoStates;


import java.util.ArrayList;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class UserGroup {
    private final String groupName;

    private final LocalDateTime startDate;
    private final LocalDateTime finishDate;

    private final LocalTime startHour;
    private final LocalTime finishHour;
    private final ArrayList<DayOfWeek> weekPlan;

    private final List<String> allowedActions;
    private final ArrayList<Area> accessibleSpaces;
    private final  List<User> users = new ArrayList<>();
  private final List<UserGroup> userGroups = new ArrayList<>();



  public UserGroup(String groupName,LocalDateTime userStart,LocalDateTime userFinish,
                   LocalTime userStartHour,LocalTime userFinishHour,ArrayList<DayOfWeek> weekPlan,
                   List<String> allowedActions,ArrayList<Area> accessibleSpaces) {
      this.groupName = groupName;
      this.startDate = userStart;
      this.finishDate = userFinish;
      this.startHour = userStartHour;
      this.finishHour = userFinishHour;
      this.weekPlan = weekPlan;
      this.allowedActions = allowedActions;
      this.accessibleSpaces = accessibleSpaces;

    }
    public void addUser(User user) {
      users.add(user);
    }
    public void addGroup(){userGroups.add((UserGroup)this);}
    public List<User> getUsers() {
      return users;
    }
    public List<UserGroup> getGroups() {
      return userGroups;
    }
  public String getGroupName() {
    return groupName;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public LocalDateTime getFinishDate() {
    return finishDate;
  }

  public LocalTime getStartHour() {
    return startHour;
  }

  public LocalTime getFinishHour() {
    return finishHour;
  }

  public ArrayList<DayOfWeek> getWeekPlan() {
    return weekPlan;
  }

  public List<String> getAllowedActions() {
    return allowedActions;
  }

  public List<UserGroup> getUserGroups() {
    return userGroups;
  }


}
