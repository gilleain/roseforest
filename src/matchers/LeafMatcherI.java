package matchers;

import interfaces.LeafCollectionI;

import java.util.List;

public interface LeafMatcherI {
    
    public List<Match> match(LeafCollectionI pattern, LeafCollectionI structure);

}
