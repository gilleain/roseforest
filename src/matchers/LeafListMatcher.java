package matchers;

import interfaces.TreeI;

import java.util.ArrayList;
import java.util.List;

import leaf.AbstractLeafList;

public class LeafListMatcher implements MatcherI<AbstractLeafList> {
    
    private NodeMatcher nodeMatcher;
    
    private MatcherI subMatcher;
    
    public LeafListMatcher(MatcherI subMatcher) {
        this(new NodeMatcher(), subMatcher);
    }
    
    public LeafListMatcher(NodeMatcher nodeMatcher, MatcherI subMatcher) {
        this.nodeMatcher = nodeMatcher;
        this.subMatcher = subMatcher;
    }
    
    public List<Match> match(AbstractLeafList pattern, AbstractLeafList structure) {
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
                } else {
                    // if it can't be extended, carry it over unchanged
                    extendedMatches.add(match);
                }
            }
            
            // only those matches that have been extended are saved
            matches = extendedMatches;
            
            // create new matches
            TreeI childPattern = pattern.first();
            if (nodeMatcher.match(childPattern, childStructure)) {
                Match match = new Match(childStructure);
                System.out.println("new match " + match);
                extend(match, childPattern, childStructure, matches);
            }
        }
        System.out.println(matches);
        return matches;
    }

    public void extend(Match match, TreeI childPattern, 
                       TreeI childStructure, List<Match> matchList) {
        if (subMatcher == null) return;
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
