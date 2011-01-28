package tree;

import interfaces.LeafCollectionI;
import interfaces.TreeI;
import interfaces.VisitorI;

public abstract class AbstractTree implements TreeI {

    private String label;
    
    private int id;
    
    private LeafCollectionI leafCollection;
    
    public AbstractTree() {
        setLabel(null);
    }
    
    public AbstractTree(String label) {
        setLabel(label);
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public int getID() {
        return id;
    }
    
    public void setID(int id) {
        this.id = id;
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
