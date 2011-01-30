package interfaces;


public interface LeafCollectionI extends VisitableI, Iterable<TreeI> {
    
    public String getTypeName();
    
    public void addLeaf(TreeI leaf);

    public int getTotalLeafCount();
    
    /**
     * The number of children directly in this collection, not the total leaf
     * count.
     * 
     * @return the number of children in the collection
     */
    public int size();

}
