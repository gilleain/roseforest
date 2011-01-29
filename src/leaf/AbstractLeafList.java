package leaf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import matchers.Match;

import interfaces.LeafCollectionI;
import interfaces.TreeI;
import interfaces.VisitorI;

public abstract class AbstractLeafList implements LeafCollectionI {
    
    private List<TreeI> leaves;
    
    public AbstractLeafList() {
        leaves = new ArrayList<TreeI>();
    }
    
    public void addLeaf(TreeI leaf) {
        leaves.add(leaf);
    }
    
    public Iterator<TreeI> iterator() {
        return leaves.iterator();
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
    
    public int getTotalLeafCount() {
        int count = 0;
        for (TreeI leaf : leaves) {
            count += leaf.getTotalLeafCount();
        }
        return count;
    }
    
    public TreeI first() {
        return leaves.get(0);
    }
    
    public TreeI getChild(Match match) {
        int size = match.getSize();
        // faster lookup if leaves were a linked list
        int targetIndex = leaves.get(0).getID() + size;
        for (TreeI leaf : leaves) {
            if (leaf.getID() == targetIndex) {
                return leaf;
            }
        }
        return null;
    }

}
