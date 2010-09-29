package leaflist;

import interfaces.VisitorI;

public class SSEList extends AbstractLeafList {

    @Override
    public String getTypeName() {
        return "SSES";
    }

    @Override
    public void visit(VisitorI visitor) {
        System.out.println("visiting SSE list");
    }

}
