package interfaces;


public interface TreeI extends VisitableI {
    
    public void setLabel(String label);
    
    public String getLabel();
    
    public void addLeaves(LeafCollectionI leafList);
    
    public String getTypeName();

    public LeafCollectionI getLeaves();

    public Integer getID();
    
}
