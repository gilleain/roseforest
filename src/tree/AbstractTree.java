package tree;

import interfaces.LeafCollectionI;
import interfaces.TreeI;
import interfaces.VisitorI;

public abstract class AbstractTree implements TreeI {
    
    private LeafCollectionI leafCollection;
    
    public void addLeaves(LeafCollectionI leafList) {
        this.leafCollection = leafList;
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
