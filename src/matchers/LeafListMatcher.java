package matchers;

import interfaces.LeafCollectionI;
import interfaces.TreeI;

import java.util.ArrayList;
import java.util.List;

public class LeafListMatcher implements LeafMatcherI {
    
    private NodeMatcher nodeMatcher;
    
    private LeafMatcherI subMatcher;
    
    public LeafListMatcher(NodeMatcher nodeMatcher, LeafMatcherI subMatcher) {
        this.nodeMatcher = nodeMatcher;
        this.subMatcher = subMatcher;
    }
    
    public List<Match> match(LeafCollectionI pattern, LeafCollectionI structure) {
        List<Match> matches = new ArrayList<Match>();
        if (pattern == null || structure == null) return matches;
        
        for (TreeI childStructure : structure) {
            List<Match> extendedMatches = new ArrayList<Match>();
            for (Match match : matches) {
                TreeI childPattern = pattern.getChild(match);
                // extend the match
                if (nodeMatcher.match(childPattern, childStructure)) {
                    match.add(childStructure);
                    extend(match, childPattern, childStructure, extendedMatches);
                }
            }
            
            // only those matches that have been extended are saved
            matches = extendedMatches;
            
            // create new matches
            TreeI childPattern = pattern.first();
            if (nodeMatcher.match(childPattern, childStructure)) {
                Match match = new Match(childStructure);
                extend(match, childPattern, childStructure, matches);
            }
        }
        return matches;
    }

    public void extend(Match match, TreeI childPattern, 
                       TreeI childStructure, List<Match> matchList) {
        List<Match> subMatches = subMatcher.match(
                childPattern.getLeaves(), childStructure.getLeaves());
        if (subMatches.size() == 0) {
            matchList.add(match);
        } else {
            for (Match extension : subMatches) {
                matchList.add(match.extend(extension));
            }
        }
    }

}