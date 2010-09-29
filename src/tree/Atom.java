package tree;

import interfaces.VisitorI;

public class Atom extends AbstractTree {

    @Override
    public String getTypeName() {
        return "ATOM";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting atom");
    }

}
