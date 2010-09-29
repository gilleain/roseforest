package leaflist;

import java.util.ArrayList;
import java.util.List;

import interfaces.LeafListI;
import interfaces.TreeI;
import interfaces.VisitorI;

public abstract class AbstractLeafList implements LeafListI {
    
    private List<TreeI> trees;
    
    public AbstractLeafList() {
        trees = new ArrayList<TreeI>();
    }

    public void addLeaf(TreeI tree) {
        trees.add(tree);
    }
    
    public abstract void visit(VisitorI visitor);

    @Override
    public void accept(VisitorI visitor) {
        visitor.visit(this);
        visit(visitor);
        for (TreeI tree : trees) {
            tree.accept(visitor);
        }
    }

}
