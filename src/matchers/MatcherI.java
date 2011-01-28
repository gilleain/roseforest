package matchers;

import java.util.List;

public interface MatcherI<T>{
    
    public List<Match> match(T pattern, T structure);

}
