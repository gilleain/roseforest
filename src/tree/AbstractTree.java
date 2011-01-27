package tree;

import interfaces.LeafCollectionI;
import interfaces.TreeI;
import interfaces.VisitorI;

public abstract class AbstractTree implements TreeI {

    private String label;
    
    private LeafCollectionI leafCollection;
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public Integer getID() {
        return -1;  // TODO
    }
    
    public void addLeaves(LeafCollectionI leafList) {
        this.leafCollection = leafList;
    }
    
    public LeafCollectionI getLeaves() {
        return leafCollection;
    }
    
    public void accept(VisitorI visitor) {
        visitor.visit(this);
        this.visit(visitor);
        visitLeaves(visitor);
    }
    
    public abstract void visit(VisitorI visitor);

    public void visitLeaves(VisitorI visitor) {
        if (leafCollection != null) {
            leafCollection.accept(visitor);
        }
    }

}
