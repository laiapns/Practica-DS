package baseNoStates;

import java.util.ArrayList;

/**
 * The 'Space' class represents a specific area within
 * a building. It extends the 'Area' class
 * to inherit common properties and functionality for
 * building areas. A space is typically a part
 * of a larger partition and may have doors providing access.
 * This class provides methods to manage
 * doors, find the space by ID (though this is not practical
 * for spaces), and retrieve itself as a space.
 */

public class Space extends Area {
  public Space(final String id, final String description) {
    super(id, description);
  }

  public String getId() {
    return getId();
  }

  @Override
  public void accept(AreaVisitor visitor) {
    visitor.visit(this);
  }

}
