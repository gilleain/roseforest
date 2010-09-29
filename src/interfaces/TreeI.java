package interfaces;


public interface TreeI extends VisitableI {
    
    public void addLeaves(LeafCollectionI leafList);
    
    public String getTypeName();
    
}
