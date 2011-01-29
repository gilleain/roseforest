package test;

import interfaces.LeafCollectionI;
import interfaces.TreeI;
import leaf.AtomList;
import leaf.AtomSet;
import leaf.ResidueList;
import leaf.SSEList;

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
        LeafCollectionI residueList = new ResidueList();
        chain.addLeaves(residueList);
        
        printVisit(chain);
    }
    
    @Test
    public void makeAtomChain() {
        TreeI chain = new Chain();
        LeafCollectionI atomList = new AtomList();
        chain.addLeaves(atomList);
        
        printVisit(chain);
    }
    
    @Test
    public void makeAtomResidueSSEChain() {
        TreeI atom = new Atom();
        LeafCollectionI atomSet = new AtomSet();
        atomSet.addLeaf(atom);
        
        TreeI residue = new Residue("Y");
        residue.addLeaves(atomSet);
        LeafCollectionI residueList = new ResidueList();
        residueList.addLeaf(residue);
        
        TreeI sse = new SSE("H");
        sse.addLeaves(residueList);
        LeafCollectionI sseList = new SSEList();
        sseList.addLeaf(sse);
        
        TreeI chain = new Chain();
        chain.addLeaves(sseList);
        
        printVisit(chain);
    }

}
