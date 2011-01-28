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
    
    public TreeI first() {
        return leaves.get(0);
    }
    
    public TreeI getChild(Match match) {
        int last = match.getLast();
        if (last < leaves.size()) {
            return leaves.get(last + 1);
        } else {
            return null;
        }
    }

}
