package interfaces;


public interface TreeI extends VisitableI {
    
    public void setLabel(String label);
    
    public String getLabel();
    
    public void addLeaves(LeafCollectionI leafList);
    
    public int getTotalLeafCount();
    
    public String getTypeName();

    public LeafCollectionI getLeaves();

    public int getID();

    public void setID(int number);
    
}
