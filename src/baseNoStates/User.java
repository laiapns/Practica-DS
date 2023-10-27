package baseNoStates;

import java.util.ArrayList;
import baseNoStates.UserGroup;

public class User {
  private final String name;
  private final String credential;

  private final UserGroup group;


  private ArrayList<Area> accessibleSpaces;



  public User(String name,String credential,UserGroup group) {
    this.name = name;
    this.credential = credential;
    this.accessibleSpaces=new ArrayList<>();
    this.group = group;

  }
  public String getName() {
    return name;
  }
  public UserGroup getGroup() {
    return group;
  }
  public String getCredential() {
    return credential;
  }

  private ArrayList<Area> getSpaces(){
    return accessibleSpaces;
  }
  /*public void addSpace(UserGroup group){
    accessibleSpaces = group.getAccessibleSpaces();
  }*/
  public boolean canBeInSpace(UserGroup group,Area area){
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