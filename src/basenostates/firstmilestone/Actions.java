package basenostates.firstmilestone;

import java.util.Arrays;
import java.util.List;

public final class Actions {
  // Constants for different actions
  public static final String LOCK = "lock";
  public static final String UNLOCK = "unlock";
  public static final String UNLOCK_SHORTLY = "unlock_shortly";
  public static final String OPEN = "open";
  public static final String CLOSE = "close";

  //array of actions for group employees
  public static final List<String> EMPLOYEES_ACTIONS =
      Arrays.asList(OPEN, CLOSE,
      UNLOCK_SHORTLY);

  //array of actions for group managers and group admin
  public static final List<String> OTHERS_ACTIONS = Arrays.asList(
      LOCK, UNLOCK, UNLOCK_SHORTLY, OPEN, CLOSE);

  // Private constructor to prevent instantiation
  private Actions() {
    throw new AssertionError("No instanciar una clase de utilidad");
  }
}
