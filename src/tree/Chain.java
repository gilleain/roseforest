package tree;

import interfaces.VisitorI;

public class Chain extends AbstractTree {

    @Override
    public String getTypeName() {
        return "CHAIN";
    }
    
    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting chain");        
    }

}
