package leaf;

import interfaces.VisitorI;

public class AtomList extends AbstractLeafList {

    @Override
    public String getTypeName() {
        return "ATOMLIST";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting atom list");
    }

}
