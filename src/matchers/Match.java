package matchers;

import java.util.ArrayList;
import java.util.List;

import interfaces.TreeI;

public class Match {
    
    private List<Integer> ids;

    public Match(TreeI structure) {
        ids = new ArrayList<Integer>();
        add(structure);
    }
    
    public Match(Match other) {
        ids = new ArrayList<Integer>();
        ids.addAll(other.ids);
    }

    public void add(TreeI structure) {
        ids.add(structure.getID());
    }

    public Match extend(Match extension) {
        Match copy = new Match(this);
        copy.ids.addAll(extension.ids);
        return copy;
    }
    
    public Integer getLast() {
        return ids.get(ids.size() - 1);
    }
    
    public String toString() {
        return ids.toString();
    }

    public Match extend(TreeI structure) {
        Match copy = new Match(this);
        copy.add(structure);
        return copy;
    }

}
