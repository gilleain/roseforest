package description;

import interfaces.VisitorI;
import leaf.AbstractLeafList;

public class DescriptionList extends AbstractLeafList {

    @Override
    public String getTypeName() {
        return "DESCRIPTION LIST";
    }

    @Override
    public void visit(VisitorI visitor) {
//        System.out.println("visiting description list");
    }

}
