package baseNoStates;

import java.util.ArrayList;
import baseNoStates.UserGroup;

public class User {
  private final String name;
  private final String credential;
  private final String userRole;

  private ArrayList<Area> accessibleSpaces;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
    this.userRole = "";
    this.accessibleSpaces=new ArrayList<>();
  }

  public String getCredential() {
    return credential;
  }

  private ArrayList<Area> getSpaces(){
    return accessibleSpaces;
  }
  public void addSpace(UserGroup.GroupCharacteristics group){
    accessibleSpaces=group.getAccessibleSpaces();
  }
  public boolean canBeInSpace(UserGroup.GroupCharacteristics group,Area area){
    for(Area a: group.getAccessibleSpaces()){
      if(a==area){
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
