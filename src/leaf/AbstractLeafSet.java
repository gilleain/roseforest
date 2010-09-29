package leaf;

import java.util.HashSet;

import interfaces.TreeI;

public abstract class AbstractLeafSet extends AbstractLeafCollection {

    public AbstractLeafSet() {
        super(new HashSet<TreeI>());
    }

}
