package baseNoStates;

import java.util.ArrayList;

public class User {
  private final String name;
  private final String credential;
  private final String userRole;

  private ArrayList<Space> accessibleSpaces;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
    this.userRole = "";
    this.accessibleSpaces=new ArrayList<>();

  }

  public User(String name, String credential, String role) {
    this.name = name;
    this.credential = credential;
    this.userRole = role;
    this.accessibleSpaces=new ArrayList<>();
  }

  public String getCredential() {
    return credential;
  }

  public String getUserRole() {
    return userRole;
  }

  private ArrayList<Space> getSpaces(){
    return accessibleSpaces;
  }
  public void addSpace(Space space){
    accessibleSpaces.add(space);
  }
  public boolean canBeInSpace(Space space){
    for(Space s: accessibleSpaces){
      if(s==space){
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
