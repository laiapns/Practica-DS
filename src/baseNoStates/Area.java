package baseNoStates;

import java.util.ArrayList;

/**
 * The 'Space' and 'Partition' classes inherit from
 * the 'Area' class to create a tree-like structure
 * representing the building. 'Area' serves as the
 * base class providing common properties and
 * functionality for all building areas, while
 * 'Space' and 'Partition' can extend it with
 * specific attributes for their respective roles
 * in the building's hierarchy.
 */

public abstract class Area {
  private String areaId;
  private String areaDescription;


  public Area(final String id, final String description,) {
    this.areaId = id;
    this.areaDescription = description;
  }

  public abstract void accept(AreaVisitor visitor);

  public String getId() {
    return areaId;
  }

}
