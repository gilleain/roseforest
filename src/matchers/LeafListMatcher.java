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
            System.out.println("structure " + childStructure + " current matches = " + matches);
            List<Match> extendedMatches = new ArrayList<Match>();
            for (Match match : matches) {
                TreeI childPattern = pattern.getChild(match);
                System.out.println("getting pattern " + childPattern + " for " + match);
                // extend the match
                if (nodeMatcher.match(childPattern, childStructure)) {
                    Match matchCopy = match.extend(childStructure);
                    extend(matchCopy, childPattern, childStructure, extendedMatches);
                } 
            }
            
            matches.addAll(extendedMatches);
            
            // create new matches
            TreeI childPattern = pattern.first();
            System.out.println("trying new match " + childPattern.getID());
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
        if (subMatcher == null) {
            matchList.add(match);
            System.out.println("submatcher null, returning");
            return;
        }
        List<Match> subMatches = subMatcher.match(
                childPattern.getLeaves(), childStructure.getLeaves());
        if (subMatches.size() == 0) {
            System.out.println("match not extended " + match);
            matchList.add(match);
        } else {
            for (Match extension : subMatches) {
                Match extended = match.extend(extension); 
                System.out.println("match extended " + extended);
                matchList.add(extended);
            }
        }
    }

}
