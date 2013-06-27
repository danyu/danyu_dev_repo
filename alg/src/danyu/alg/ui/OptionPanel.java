package danyu.alg.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.MouseListener;
import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import danyu.alg.ds.DS;
import danyu.alg.ds.linkedlist.ExtLinkedList;
import danyu.alg.ds.stack.ExtStack;
import danyu.alg.ds.tree.B234Tree;
import danyu.alg.ds.tree.BSTree;
import danyu.alg.ds.tree.RBTree;

public class OptionPanel extends JPanel {

	JScrollPane optionPane;
	JTree optionTree;
	
	public OptionPanel(){
		setOptions();
		setSize(new Dimension(350,100));
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Select:"));
		
		optionPane=new JScrollPane(optionTree);
		optionPane.setMinimumSize(new Dimension(250,100));
		add(optionPane,BorderLayout.CENTER);
	}
	
	private void setOptions(){
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("Data Structures");
		optionTree=new JTree(root);
		//optionTree.setMinimumSize(new Dimension(200,100));
		optionTree.getSelectionModel().setSelectionMode
        (TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		//Integer[] initData=DS.genExperimentalData(20, 100);
		root.add(new DefaultMutableTreeNode(new ExtLinkedList()));
		root.add(new DefaultMutableTreeNode(new ExtStack()));
		
		//Build node for trees
		DefaultMutableTreeNode treeSelection=new DefaultMutableTreeNode("Tree");
		treeSelection.add(new DefaultMutableTreeNode(new BSTree()));
		treeSelection.add(new DefaultMutableTreeNode(new RBTree()));
		treeSelection.add(new DefaultMutableTreeNode(new B234Tree()));
		
	    root.add(treeSelection);
		//Expand the root so that all data structure are visible
		optionTree.expandRow(0);
		optionTree.expandRow(3);	
	}
	
	public void addOptionListener(TreeSelectionListener tls){
		optionTree.addTreeSelectionListener(tls);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
