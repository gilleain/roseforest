package tree;

import interfaces.VisitorI;

public class Residue extends AbstractTree {

    @Override
    public String getTypeName() {
        return "RESIDUE";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting residue");
    }

}
