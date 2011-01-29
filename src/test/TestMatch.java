package test;

import java.util.List;

import interfaces.LeafCollectionI;
import interfaces.TreeI;

import leaf.ResidueList;
import leaf.SSEList;
import matchers.LeafListMatcher;
import matchers.Match;
import matchers.TopLevelMatcher;

import org.junit.Test;

import tree.Chain;
import tree.Residue;
import tree.SSE;
import visitors.DFSNumberVisitor;

import description.DescriptionList;
import description.DescriptionNode;
import description.DescriptionSet;

public class TestMatch {
    
    public void addDescriptions(TreeI residueDescription, LeafCollectionI leaves, String... labels) {
        residueDescription.addLeaves(leaves);
        for (String label : labels) {
            TreeI description = new DescriptionNode();
            description.setLabel(label);
            leaves.addLeaf(description);
        }
    }
    
    public void addDescriptionList(TreeI residueDescription, String... labels) {
        addDescriptions(residueDescription, new DescriptionList(), labels);
    }
    
    public void addDescriptionSet(TreeI residueDescription, String... labels) {
        addDescriptions(residueDescription, new DescriptionSet(), labels);
    }
    
    @Test
    public void setMatch() {
        TreeI residueDescription = new DescriptionNode();
        addDescriptionSet(residueDescription, "N", "CA", "O");
    }
    
    @Test
    public void twoLevelListMatch() {
        DescriptionNode pattern = new DescriptionNode("*");
        addDescriptionList(pattern, "H", "E");
        String[][] residuePatternLabels = new String[2][];
        residuePatternLabels[0] = new String[] {"Y", "G"};
        residuePatternLabels[1] = new String[] {"A", "G"};
        int i = 0;
        for (TreeI node : pattern.getLeaves()) {
            addDescriptionList(node, residuePatternLabels[i]);
            i++;
        }
        pattern.accept(new DFSNumberVisitor());
//        pattern.accept(new visitors.PrintVisitor());
        
        Chain structure = new Chain();
        String[] sseLabels = new String[] { "H", "E", "H", "E"};
        LeafCollectionI sseList = new SSEList();
        for (String sseLabel : sseLabels) {
            sseList.addLeaf(new SSE(sseLabel));
        }
        structure.addLeaves(sseList);
        String[][] residueLabels = new String[4][];
        residueLabels[0] = new String[] {"Y", "G"};
        residueLabels[1] = new String[] {"A", "G"};
        residueLabels[2] = new String[] {"Y", "G"};
        residueLabels[3] = new String[] {"A", "G"};
        int j = 0;
        for (TreeI sse : structure.getLeaves()) {
            LeafCollectionI residueLeaves = new ResidueList(); 
            for (String residueLabel : residueLabels[j]) {
                residueLeaves.addLeaf(new Residue(residueLabel));
            }
            sse.addLeaves(residueLeaves);
            j++;
        }
        structure.accept(new DFSNumberVisitor());
//        structure.accept(new visitors.PrintVisitor());
        
        TopLevelMatcher topLevelMatcher = 
            new TopLevelMatcher(new LeafListMatcher(new LeafListMatcher(null)));
        List<Match> matches = topLevelMatcher.match(pattern, structure);
        for (Match match : matches) {
            System.out.println("match : " + match);
        }
    }

}
