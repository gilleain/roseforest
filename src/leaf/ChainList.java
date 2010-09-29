package leaf;

import interfaces.VisitorI;

public class ChainList extends AbstractLeafList {

    @Override
    public String getTypeName() {
        return "CHAIN LIST";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting chain list");
    }

}
