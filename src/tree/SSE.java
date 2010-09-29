package tree;

import interfaces.VisitorI;

public class SSE extends AbstractTree {

    @Override
    public String getTypeName() {
        return "SSE";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting SSE");
    }

}
