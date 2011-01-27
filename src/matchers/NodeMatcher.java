package matchers;

import interfaces.TreeI;

public class NodeMatcher {

    public boolean match(TreeI childPattern, TreeI childStructure) {
        return childPattern.getLabel().equals(childStructure.getLabel());
    }

}
