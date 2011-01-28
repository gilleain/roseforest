package matchers;

import interfaces.TreeI;

public class NodeMatcher {

    public boolean match(TreeI childPattern, TreeI childStructure) {
        System.out.println("Node matching " + childPattern.getLabel() 
                                   + " to " + childStructure.getLabel());
        return childPattern.getLabel().equals(childStructure.getLabel());
    }

}
