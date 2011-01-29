package tree;

import interfaces.VisitorI;

public class SSE extends AbstractTree {
    
    public SSE(String label) {
        super(label);
    }

    @Override
    public String getTypeName() {
        return "SSE";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting SSE");
    }

}
