package visitors;

import interfaces.LeafCollectionI;
import interfaces.TreeI;
import interfaces.VisitorI;

public class DFSNumberVisitor implements VisitorI {
    
    private int number;
    
    public DFSNumberVisitor() {
        number = 0;
    }

    @Override
    public void visit(TreeI tree) {
        tree.setID(number);
        number++;
//        System.out.println("TREE of type " + tree.getTypeName() + " = " + number);
    }

    @Override
    public void visit(LeafCollectionI leafList) {
//        System.out.println("LEAVES of type " + leafList.getTypeName());
    }

}
