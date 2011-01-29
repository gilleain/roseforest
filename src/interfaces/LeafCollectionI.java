package interfaces;


public interface LeafCollectionI extends VisitableI, Iterable<TreeI> {
    
    public String getTypeName();
    
    public void addLeaf(TreeI leaf);

    public int getTotalLeafCount();

}
