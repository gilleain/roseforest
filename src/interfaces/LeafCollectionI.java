package interfaces;


public interface LeafCollectionI extends VisitableI {
    
    public String getTypeName();
    
    public void addLeaf(TreeI leaf);

}
