package test;

import interfaces.LeafCollectionI;
import interfaces.TreeI;

import org.junit.Test;

import description.DescriptionNode;
import description.DescriptionSet;

public class TestMatch {
    
    public void addAtomDescriptions(TreeI residueDescription, String... atomSymbols) {
        LeafCollectionI atomSet = new DescriptionSet();
        residueDescription.addLeaves(atomSet);
        for (String atomSymbol : atomSymbols) {
            TreeI atomDescription = new DescriptionNode();
            atomDescription.setLabel(atomSymbol);
            atomSet.addLeaf(atomDescription);
        }
    }
    
    @Test
    public void setMatch() {
        TreeI residueDescription = new DescriptionNode();
        addAtomDescriptions(residueDescription, "N", "CA", "O");
    }

}
