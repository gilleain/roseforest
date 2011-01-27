package leaf;

import java.util.Collection;
import java.util.Iterator;

import matchers.Match;

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
    
    public TreeI getChild(Match match) {
        int last = match.getLast();
        return null;    // TODO
    }
    
    public TreeI first() {
        return null;    // TODO
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
