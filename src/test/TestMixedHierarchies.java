package test;

import interfaces.LeafListI;
import interfaces.TreeI;
import leaflist.AtomList;
import leaflist.ResidueList;
import leaflist.SSEList;

import org.junit.Test;

import tree.Atom;
import tree.Chain;
import tree.Residue;
import tree.SSE;
import visitors.PrintVisitor;

public class TestMixedHierarchies {
    
    public void printVisit(TreeI tree) {
        PrintVisitor visitor = new PrintVisitor();
        tree.accept(visitor);
    }
    
    @Test
    public void makeResidueChain() {
        TreeI chain = new Chain();
        LeafListI residueList = new ResidueList();
        chain.addLeafList(residueList);
        
        printVisit(chain);
    }
    
    @Test
    public void makeAtomChain() {
        TreeI chain = new Chain();
        LeafListI atomList = new AtomList();
        chain.addLeafList(atomList);
        
        printVisit(chain);
    }
    
    @Test
    public void makeAtomResidueSSEChain() {
        TreeI atom = new Atom();
        LeafListI atomList = new AtomList();
        atomList.addLeaf(atom);
        
        TreeI residue = new Residue();
        residue.addLeafList(atomList);
        LeafListI residueList = new ResidueList();
        residueList.addLeaf(residue);
        
        TreeI sse = new SSE();
        sse.addLeafList(residueList);
        LeafListI sseList = new SSEList();
        sseList.addLeaf(sse);
        
        TreeI chain = new Chain();
        chain.addLeafList(sseList);
        
        printVisit(chain);
    }

}
