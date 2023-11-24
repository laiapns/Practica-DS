package basenostates.firstmilestone;

import java.util.ArrayList;

/**
 * The 'User' class represents a user in a building's
 * security system. Users have a name, a credential
 * for identification, and belong to a specific 'UserGroup'
 * that defines their access permissions.
 * Users can access areas within the building based on
 * their group's accessible spaces.
 */


public class User {
  private final String userName;
  private final String userCredential;

  private final UserGroup userGroup;

  private ArrayList<Area> accessibleSpaces;

  /**
   * Constructs a user with the specified name, credential, and user group.
   *
   * @param name       The name of the user.
   * @param credential The credential for user identification.
   * @param group      The user group to which the user belongs.
   */
  public User(final String name, final String credential, final UserGroup group) {
    this.userName = name;
    this.userCredential = credential;
    this.accessibleSpaces = new ArrayList<>();
    this.userGroup = group;

  }

  public String getName() {
    return userName;
  }

  public UserGroup getGroup() {
    return userGroup;
  }

  public String getCredential() {
    return userCredential;
  }


  private ArrayList<Area> getSpaces() {
    return accessibleSpaces;
  }

  /**
   * Checks if the user can be in a specific area based on the user group's accessible spaces.
   *
   * @param group The user group.
   * @param area  The area to check.
   * @return True if the user can be in the specified area, false otherwise.
   */
  public boolean canBeInSpace(final UserGroup group, final Area area) {
    for (Area a : group.getAccessibleSpaces()) {
      if (a == area) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "User{name=" + userName + ", credential=" + userCredential + "}";
  }
}
