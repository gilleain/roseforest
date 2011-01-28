package matchers;

import java.util.List;

import leaf.AbstractLeafSet;

import interfaces.LeafCollectionI;
import interfaces.TreeI;

public class LeafSetMatcher implements MatcherI<AbstractLeafSet> {
    
 private NodeMatcher nodeMatcher;
    
    private MatcherI subMatcher;
    
    public LeafSetMatcher(NodeMatcher nodeMatcher, MatcherI subMatcher) {
        this.nodeMatcher = nodeMatcher;
        this.subMatcher = subMatcher;
    }

    public List<Match> match(AbstractLeafSet pattern, AbstractLeafSet structure) {
        // TODO Auto-generated method stub
        return null;
    }

}
