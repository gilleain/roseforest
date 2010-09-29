package leaflist;

import interfaces.VisitorI;

public class AtomList extends AbstractLeafList {

    @Override
    public String getTypeName() {
        return "ATOMS";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting atom list");
    }

}
