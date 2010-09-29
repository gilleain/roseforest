package leaflist;

import interfaces.VisitorI;

public class ChainList extends AbstractLeafList {

    @Override
    public String getTypeName() {
        return "CHAINS";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting chain list");
    }

}
