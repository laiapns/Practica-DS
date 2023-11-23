package baseNoStates;


import org.slf4j.Logger;

public class ProcessAVisitor implements AreaVisitor {
  private static final Logger LOGGER =
      org.slf4j.LoggerFactory.getLogger(Door.class);
  @Override
  public void visit(Partition partition) {
    LOGGER.debug("ProcessA for Partition: " + partition.getId());
  }

  @Override
  public void visit(Space space) {
    LOGGER.debug("ProcessA for Space: " + space.getId());
  }
}
