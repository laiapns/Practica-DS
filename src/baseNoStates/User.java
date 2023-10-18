package baseNoStates;

public class User {
  private final String name;
  private final String credential;
  String accessPermission;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
  }
  public User(String name, String credential, String access) {
    this.name = name;
    this.credential = credential;
    this.accessPermission=access;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
