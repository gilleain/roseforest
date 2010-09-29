package leaf;

import interfaces.VisitorI;

public class ResidueList extends AbstractLeafList {

    @Override
    public String getTypeName() {
        return "RESIDUE LIST";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting residue list");
    }

}
