package basenostates.firstmilestone;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


/**
 * The 'UserGroup' class represents a group of users with common access rules
 * and permissions within a building's security system. It defines attributes
 * such as group name, start and finish dates,
 * allowed actions, and accessible spaces.
 */

public class UserGroup {
  private final String groupName;

  private final LocalDateTime startDate;
  private final LocalDateTime finishDate;

  private final LocalTime startHour;
  private final LocalTime finishHour;
  private final ArrayList<DayOfWeek> weekPlan;

  private final List<String> allowedActions;
  private final ArrayList<Area> accessibleSpaces;
  private final List<User> users = new ArrayList<>();
  private final List<UserGroup> userGroups = new ArrayList<>();


  /**
   * Constructor for the 'UserGroup' class.
   *
   * @param group          The name of the user group.
   * @param userStart      The start date for user access.
   * @param userFinish     The finish date for user access.
   * @param userStartHour  The start hour for user access.
   * @param userFinishHour The finish hour for user access.
   * @param plan           The week plan specifying days of the week for access.
   * @param actions        The list of allowed actions for the user group.
   * @param spaces         The list of accessible spaces for the user group.
   */
  public UserGroup(final String group, final LocalDateTime userStart,
                   final LocalDateTime userFinish,
                   final LocalTime userStartHour,
                   final LocalTime userFinishHour,
                   final ArrayList<DayOfWeek> plan,
                   final List<String> actions,
                   final ArrayList<Area> spaces) {
    this.groupName = group;
    this.startDate = userStart;
    this.finishDate = userFinish;
    this.startHour = userStartHour;
    this.finishHour = userFinishHour;
    this.weekPlan = plan;
    this.allowedActions = actions;
    this.accessibleSpaces = spaces;

  }

  public final void addUser(final User user) {
    users.add(user);
  }

  public final void addGroup() {
    userGroups.add((UserGroup) this);
  }

  public final List<User> getUsers() {
    return users;
  }

  public final List<UserGroup> getGroups() {
    return userGroups;
  }

  public final String getGroupName() {
    return groupName;
  }

  public final LocalDateTime getStartDate() {
    return startDate;
  }

  public final LocalDateTime getFinishDate() {
    return finishDate;
  }

  public final LocalTime getStartHour() {
    return startHour;
  }

  public final LocalTime getFinishHour() {
    return finishHour;
  }

  public final ArrayList<DayOfWeek> getWeekPlan() {
    return weekPlan;
  }

  public final List<String> getAllowedActions() {
    return allowedActions;
  }

  public final List<UserGroup> getUserGroups() {
    return userGroups;
  }

  public final ArrayList<Area> getAccessibleSpaces() {
    return this.accessibleSpaces;
  }
}
