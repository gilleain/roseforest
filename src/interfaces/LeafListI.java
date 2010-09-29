package interfaces;


public interface LeafListI extends VisitableI {
    
    public String getTypeName();
    
    public void addLeaf(TreeI leaf);

}
