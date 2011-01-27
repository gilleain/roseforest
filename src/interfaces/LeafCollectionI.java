package interfaces;

import matchers.Match;


public interface LeafCollectionI extends VisitableI, Iterable<TreeI> {
    
    public String getTypeName();
    
    public void addLeaf(TreeI leaf);

    public TreeI getChild(Match match);

    // XXX : problematic for LeafSet...
    public TreeI first();

}
