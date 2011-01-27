package interfaces;


public interface LeafCollectionI extends VisitableI, Iterable<TreeI> {
    
    public String getTypeName();
    
    public void addLeaf(TreeI leaf);

    public TreeI getChild(int dfsIndex);

    // XXX : problematic for LeafSet...
    public TreeI first();

}
