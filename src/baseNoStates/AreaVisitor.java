package baseNoStates;

public interface AreaVisitor {
  void visit(Partition partition);
  void visit(Space space);
}

