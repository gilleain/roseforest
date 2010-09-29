package tree;

import interfaces.LeafListI;
import interfaces.TreeI;
import interfaces.VisitorI;

public abstract class AbstractTree implements TreeI {
    
    private LeafListI leafList;
    
    public void addLeafList(LeafListI leafList) {
        this.leafList = leafList;
    }
    
    public void accept(VisitorI visitor) {
        visitor.visit(this);
        this.visit(visitor);
        visitLeaves(visitor);
    }
    
    public abstract void visit(VisitorI visitor);

    public void visitLeaves(VisitorI visitor) {
        if (leafList != null) {
            leafList.accept(visitor);
        }
    }

}
