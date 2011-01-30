package leaf;

import java.util.Collection;
import java.util.Iterator;

import interfaces.LeafCollectionI;
import interfaces.TreeI;
import interfaces.VisitorI;

public abstract class AbstractLeafCollection implements LeafCollectionI {
    
    private Collection<TreeI> leaves;
    
    public AbstractLeafCollection(Collection<TreeI> leaves) {
        this.leaves = leaves;
    }
    
    public void addLeaf(TreeI leaf) {
        leaves.add(leaf);
    }
    
    public Iterator<TreeI> iterator() {
        return leaves.iterator();
    }
    
    public int getTotalLeafCount() {
        int count = 0;
        for (TreeI leaf : leaves) {
            count += leaf.getTotalLeafCount();
        }
        return count;
    }
    
    public int size() {
        return leaves.size();
    }
    
    public abstract void visit(VisitorI visitor);

    @Override
    public void accept(VisitorI visitor) {
        visitor.visit(this);
        visit(visitor);
        for (TreeI tree : leaves) {
            tree.accept(visitor);
        }
    }

}
