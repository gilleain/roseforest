package matchers;

import interfaces.TreeI;

public class NodeMatcher {

    public boolean match(TreeI childPattern, TreeI childStructure) {
        if (childPattern == null || childStructure == null) return false;
        System.out.println("Node matching " + childPattern.getLabel() 
                                   + " to " + childStructure.getLabel());
        return childPattern.getLabel().equals(childStructure.getLabel());
    }

}
