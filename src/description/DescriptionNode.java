package description;

import tree.AbstractTree;
import interfaces.VisitorI;

public class DescriptionNode extends AbstractTree {
    
    private String label;
    
    public DescriptionNode() {
        label = null;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }

    @Override
    public String getTypeName() {
        return "DESCRIPTION";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting description");
    }

}
