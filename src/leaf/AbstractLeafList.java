package leaf;

import java.util.ArrayList;

import interfaces.TreeI;

public abstract class AbstractLeafList extends AbstractLeafCollection {
    
    public AbstractLeafList() {
        super(new ArrayList<TreeI>());
    }

}
