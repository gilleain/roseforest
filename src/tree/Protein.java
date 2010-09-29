package tree;

import interfaces.VisitorI;

public class Protein extends AbstractTree {
    
    @Override
    public String getTypeName() {
        return "PROTEIN";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting protein");
    }

}
