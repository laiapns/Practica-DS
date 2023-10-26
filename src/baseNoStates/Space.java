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

    @Override
    public ArrayList<Door> getDoorsGivingAccess() {
      return null;
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
