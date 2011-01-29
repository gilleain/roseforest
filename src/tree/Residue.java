package tree;

import interfaces.VisitorI;

public class Residue extends AbstractTree {

    public Residue(String label) {
        super(label);
    }

    @Override
    public String getTypeName() {
        return "RESIDUE";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting residue");
    }

}
