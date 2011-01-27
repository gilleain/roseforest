package description;

import leaf.AbstractLeafList;
import interfaces.VisitorI;

public class DescriptionSet extends AbstractLeafList {

    @Override
    public String getTypeName() {
        return "DESCRIPTION SET";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visited description");
    }

}
