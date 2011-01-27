package matchers;

import java.util.List;

import interfaces.LeafCollectionI;
import interfaces.TreeI;

public class LeafSetMatcher implements LeafMatcherI {
    
 private NodeMatcher nodeMatcher;
    
    private LeafMatcherI subMatcher;
    
    public LeafSetMatcher(NodeMatcher nodeMatcher, LeafMatcherI subMatcher) {
        this.nodeMatcher = nodeMatcher;
        this.subMatcher = subMatcher;
    }

    @Override
    public List<Match> match(LeafCollectionI pattern, LeafCollectionI structure) {
        // TODO Auto-generated method stub
        return null;
    }

}
