package matchers;

import java.util.List;

import interfaces.TreeI;

public class TopLevelMatcher implements MatcherI<TreeI> {
    
    private MatcherI subMatcher;
    
    public TopLevelMatcher(MatcherI subMatcher) {
        this.subMatcher = subMatcher;
    }

    @Override
    public List<Match> match(TreeI pattern, TreeI structure) {
        return subMatcher.match(pattern.getLeaves(), structure.getLeaves());
    }

}
