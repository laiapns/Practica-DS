package baseNoStates;

public class Tree {
    public static void main(String[] args) {
      Partition root = new Partition("Root", "Root Partition");
      Space space1 = new Space("S1", "Space 1");
      Space space2 = new Space("S2", "Space 2");
      root.addChild(space1);
      root.addChild(space2);


      AreaVisitor processA = new ProcessAVisitor();
      AreaVisitor processB = new ProcessBVisitor();


      root.accept(processA);
      root.accept(processB);
    }
}


