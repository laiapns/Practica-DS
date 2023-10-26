  package baseNoStates;


  import java.util.ArrayList;

  public class Space extends Area {
    private Partition parentPartition;
    private final ArrayList<Door> doorsGivingAccess = new ArrayList<>();
    public Space (String id, String description, Partition parentPartition) {
      super(id,description, parentPartition);
    }

    public String getId(){
      return id;
    }

    @Override
    public ArrayList<Door> getDoorsGivingAccess() {
      return doorsGivingAccess;
    }
    public void setDoorsGivingAccess(Door door) {
      doorsGivingAccess.add(door);
    }

    @Override
    public Area findAreaById(String areaId) {
      if (this.getId().equals(areaId)) {
        return this;
      }
      return null;
    }

    @Override
    public ArrayList<Space> getSpaces() {
      ArrayList<Space> spaces = new ArrayList<>();
      spaces.add(this);
      return spaces;
    }

  }
