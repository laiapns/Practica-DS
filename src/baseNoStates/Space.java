package baseNoStates;


import java.util.ArrayList;

public class Space extends Area {
  private Partition parentPartition;
  private ArrayList doorsGivingAccess = new ArrayList<Door>();
  public Space (String id, String description, Partition parentPartition) {
    super(id,description, parentPartition);

  }

  public String getId(){
    return id;
  }

  //adddoorgivingacces(), seran les portes que entran al space
}
