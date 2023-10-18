package baseNoStates;

public class User {
  private final String name;
  private final String credential;
  private final String userRole;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
    this.userRole = "";
  }
  public User(String name, String credential, String role) {
    this.name = name;
    this.credential = credential;
    this.userRole = role;
  }

  public String getCredential() {
    return credential;
  }

  public String getUserRole() {
    return userRole;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
