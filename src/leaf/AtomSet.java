package leaf;

import interfaces.VisitorI;

public class AtomSet extends AbstractLeafSet {

    @Override
    public String getTypeName() {
        return "ATOM SET";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting atom set");
    }

}
