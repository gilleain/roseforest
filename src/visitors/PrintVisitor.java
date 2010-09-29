package visitors;

import interfaces.LeafListI;
import interfaces.TreeI;
import interfaces.VisitorI;

public class PrintVisitor implements VisitorI {

    @Override
    public void visit(TreeI tree) {
        System.out.println("TREE of type " + tree.getTypeName());
    }

    @Override
    public void visit(LeafListI leafList) {
        System.out.println("LEAVES of type " + leafList.getTypeName());
    }

}
