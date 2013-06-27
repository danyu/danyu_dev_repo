package danyu.alg.ds.tree;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import danyu.alg.ds.DS;
import danyu.alg.ds.Node;
import danyu.alg.ui.BSTreeUI;
import danyu.alg.ui.GraphicsHelper;
import danyu.application.AppDraw;

public class BSTree<Key extends Comparable<Key>, Value> extends DS {

	
	
	protected BSNode<Key, Value> root=null;
	
	public BSTree(){
		this((Key[])ks);
	}
	
	public BSTree(Key[] values){
		insert(values);
	}
	
	@Override
	public DSType getType(){return DSType.BinaryTree;}
	
	public void setKeys(Comparable[] ks){
		root=null;
		insert(ks);
	}
	
	public void insert(Comparable [] keys){
		for(int i=0;i<keys.length;i++) insert(keys[i],null);
	}
	
	public void insert(Comparable key, Object v){
		BSNode bstNode=new BSNode(key, null, 0);
		//if (root==null) {root=bstNode; return;}
		root=insert(root,bstNode);
		
	}
	
	public void insert(BSNode newP){insert(root,newP);}
	//insert node through a recursive logic
	
	protected BSNode insert(BSNode node, BSNode newP ){
		return insertNode(node,newP);
	}
	
	protected BSNode insertNode(BSNode node, BSNode newP ){
		if(node ==null){
			node=newP;
			System.out.println("[ "+newP.key+" ] is inserted."); 
			return node;
		}
		//replace if equal,
		if (node.equal(newP)) node.value=newP.value;	
		else if (node.less(newP)){
			node.numOfChildren++;
			newP.level++;
			if (node.rightChild == null) {
				node.rightChild = newP;//System.out.println("+ insert [ "+newP.key+" ].");
			}
			else node.rightChild=insert(node.rightChild, newP);
		}
		else{
			node.numOfChildren++;
			newP.level++;
			node.inOrderRank++;
			if (node.leftChild == null) node.leftChild = newP;//System.out.println("+ insert [ "+newP.key+" ]."); 
			else node.leftChild=insert(node.leftChild, newP);
		}
		
		return node;
	}
	
	/**
	 * T. Hibbard (1962) is applied to delete a node.
	 * From Algorithms 4th Edition
	 * 
	 * */
	public void delete(Comparable key){root=delete(root, key);	}	
	private BSNode delete(BSNode parent,Comparable key) {
		
		if (parent==null) return null;
		
		if (parent.key.compareTo(key)<0) parent.rightChild= delete(parent.rightChild,key);
		if (parent.key.compareTo(key)>0) parent.leftChild= delete(parent.leftChild,key);
		if (parent.key.compareTo(key)==0) {
			//if no left child, replace it with right child
			if(parent.leftChild==null) return parent.rightChild;
			//if no right child, similar.
			if(parent.rightChild==null) return parent.leftChild;
			//if no child at all, use the smallest larger node to replace it
			//(1) keep reference
			BSNode temp=parent;
			//(2) find the smallest child on the right subtree
			parent=min(parent.rightChild);
			//(3) connect with right child (without min)
			parent.rightChild=delMin(temp.rightChild);
			//(4) connect with left child
			parent.leftChild=temp.leftChild;
		}
		return parent;
	}

	public void min() {	System.out.println("min = [ " + min(root) + " ].");	}
	
	/**
	 * Find the minimum child under the node
	*/
	public BSNode min(BSNode node){
		if (node ==null) return null;
		if (node.leftChild!=null) return min(node.leftChild);
		return node;
	}
	
	public void max() {
		System.out.println("max = [ " + max(root) + " ].");
	};
	
	/**
	 * Find the max child under the node
	 * 
	 * */
	public Key max(BSNode node){
		if (node ==null) return null;
		if (node.rightChild!=null) return max(node.rightChild);
		return (Key)node.key ;		
	}
	
	public void delMin(){ root=delMin(root); }	
	public BSNode delMin(BSNode parent){
		if(parent.leftChild==null) return parent.rightChild ;
		parent.leftChild=delMin(parent.leftChild);
		return parent;
	}
	
	public BSNode lookup(Key key){ return lookup(root,key); }
	/**
	 * Find a node with @Param Key.
	 * If NO, return null;
	 *
	 * @param node
	 * @param key
	 * @return
	 */
	private BSNode lookup(BSNode node, Key key){
		if (node==null) return null;
		if (node.key==key) return node;
		else {
			BSNode temp=lookup(node.leftChild,key);
			if(temp!=null)return temp;
			else return lookup(node.rightChild,key);
		}
	}
	
	public void maxDepth(){
		System.out.println("MaxDepth = [ "+maxDepth(root)+" ]"); 
	}
	
	//get the deepest path 
	private int maxDepth(BSNode node){
		if (node==null) return 0;
		return 1+Math.max(maxDepth(node.leftChild),maxDepth(node.rightChild));
	}
	
	/**
	 * Return nodes in in-order sequence.
	 * */
	public ArrayList<BSNode<Key, Value>> inOrder(){
		ArrayList<BSNode<Key, Value>> result=new ArrayList<BSNode<Key, Value>>();
		inOrder(root,result);
		return result;
	}
	public void inOrder(BSNode<Key, Value> root, ArrayList<BSNode<Key, Value>> result){
		if (root==null) return;
		inOrder(root.leftChild,result);
		result.add(root);
		inOrder(root.rightChild,result);
	}
	
	public int inOrderRank(BSNode parent){
		return 1+numOfCh(parent.leftChild);
	}
	
	public int numOfCh(BSNode parent){
		if (parent == null) return 0;
		int temp=0;
		if (parent.leftChild!=null) temp=numOfCh(parent.leftChild)+1;
		if (parent.rightChild!=null) temp+=numOfCh(parent.rightChild)+1;
		return temp;
	}
	
	/**
	 * Calculate level of a node. The level of root is '0'.
	 * 
	 * */
	public int level(Key k){return level(root,k);}
	public int level(BSNode parent,Key k){
		int comp=parent.key.compareTo(k);
		if(comp==0) return 0;
		else if(comp<0) return level(parent.rightChild,k)+1;
		else return level(parent.leftChild,k)+1;
	}
	
	/* Rotate left works as:
	 *     B                          C                   
	 *    /  \                       / \
	 *   1    C     ---------->     B   3
	 *       / \                   / \
	 *      2   3                 1   2
	 * 
	 * */
	public BSNode rotateLeft(BSNode b){
		BSNode c=b.rightChild;
		b.rightChild=c.leftChild;
		c.leftChild=b;
		((RBNode)c).linkColor=((RBNode)b).linkColor;
		((RBNode)b).linkColor=Color.red;
		
		b.level++;
		adjustLevel(b.leftChild,b.level+1);
		c.level--;
		adjustLevel(c.rightChild,c.level+1);
		return c;
	}
	
	/* 
	 * Rotate right works as
	 *     B                          C                   
	 *    /  \                       / \
	 *   1    C     <----------     B   3
	 *       / \                   / \
	 *      2   3                 1   2
	 * 
	 * */
	public BSNode rotateRight(BSNode c){
		BSNode b=c.leftChild;
		c.leftChild=b.rightChild;
		b.rightChild=c;
		((RBNode)b).linkColor=((RBNode)c).linkColor;
		((RBNode)c).linkColor=Color.red;
		
		b.level--;
		adjustLevel(b.leftChild,b.level+1);
		c.level++;
		adjustLevel(c.rightChild,c.level+1);
		return b;
	}
	
	public void adjustLevel(BSNode n, int level){
		if(n==null) return;
		n.level=level;
		adjustLevel(n.leftChild,level+1);
		adjustLevel(n.rightChild,level+1);
	}
	
	public boolean isRed(BSNode n){
		if(n ==null) return false;
		return n.linkColor==Color.red;
	}
	
	public void print(){
		System.out.print("Pre-order:"); 
		print(root);
	}
	//print recursively with in-order
	private void print(BSNode node){
		if (node == null) return;
		
		print(node.leftChild);
		System.out.print(node.value+" ");
		print(node.rightChild);
	}
	
	/**
	 * Print tree in Console.
	 * 
	 * */
	public void printLikeTree(){
		int depth=maxDepth(root);
		//get dimension
		int row= depth;
		int col=(int) (Math.pow(2,depth)-1);
		Key[][] nodeLocs=(Key[][]) new Integer[row][col];
		
		//traversal tree in-order to mark location
		nodeLocs[0][(col-1)/2]=(Key)root.key;
		
		int rootRow=0;
		int rootCol=(col-1)/2;
		int rootBranchRadius=(rootCol+1)/2;
		markChildrenLocs(root, nodeLocs, rootRow, rootCol,rootBranchRadius);
		
		//print tree
		System.out.println();
		System.out.println("Print like in form of tree:");
		for (int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if (nodeLocs[i][j]==null) System.out.print("  ");
				else System.out.print(nodeLocs[i][j].toString()+" ");
				//change line
				if (j==col-1) System.out.println();
			}
		}
	}
	
	/**
	 * Print tree to user interface. 
	 * 
	 * */
	
	
	/**
	 * Time Complexity = O(n)	
	 * Breath-first traversal is applied here.
	 */
	public void printByLevel(){
		ArrayList<BSNode> levelQueue = new ArrayList<BSNode>();
		ArrayList<BSNode> temp = new ArrayList<BSNode>();
		int levelCount=0;
		//printByLevel(null, root);

		if (root == null)
			return;
		levelQueue.add(root);
		sysPrint("Print by levels:\n");
		while (levelQueue.size() > 0) {
		
			temp.clear();
			sysPrint("->Level "+levelCount+" = ");
			for(BSNode bn:levelQueue){
				sysPrint(bn.key.toString()+",");
				//levelQueue.remove(bn);
				if (bn.leftChild != null)
					temp.add(bn.leftChild);
				if (bn.rightChild != null)
					temp.add(bn.rightChild);
			}
			//new line for new level
			sysPrint("\n");
			levelCount++;
			levelQueue.clear();
			levelQueue.addAll(temp);
		}
	}
	
	public void sysPrint(String str){ 
		System.out.print(str);
	}
	
	public void printALevel(int level){
	  if (level> maxDepth(root)) return;
	}
	
	public void markChildrenLocs(BSNode<Key, Value> node,Key[][] nodeLocs,int parentRow, int cparentCol,int branchRadius){
		if (node==null) return;
		
		if (node.leftChild!=null){	
			nodeLocs[parentRow+1][cparentCol-branchRadius]=(Key)node.leftChild.key;
			markChildrenLocs(node.leftChild, nodeLocs, parentRow+1, cparentCol-branchRadius,branchRadius/2);
		}
		if (node.rightChild!=null){
			nodeLocs[parentRow+1][cparentCol+branchRadius]=(Key)node.rightChild.key;
			markChildrenLocs(node.rightChild, nodeLocs, parentRow+1, cparentCol+branchRadius,branchRadius/2);
		}
	}
	
	public void mirror(){	mirror(root);	}
	
	private void mirror(BSNode p){	
		if (p==null) return;
		BSNode temp= p.rightChild;
		p.rightChild=p.leftChild;
		p.leftChild=temp;
		
		mirror(p.leftChild);
		mirror(p.rightChild);
	}
	
	public void creatSampleTree(){

		this.insert(new Integer[]{13,33,15,6,9,8,2,1,18,16,12,31,14});
	}
	
	/*
	 * Create a tree with random Keys,
	 * where keys are unique for simplification.
	 * */
	
	public String toString(){
		return "Binary Search Tree";
	}
	
	public static void main(String[] argc){
		BSTree bst=new BSTree();
		bst.insert(new Integer[]{13,33,15,6,9,8,2,1,18,16,12,31,14});
		
		//bst.delete(22);
		//bst.min();
		//bst.max();
		//bst.maxDepth();
		bst.printLikeTree();
	    System.out.println(bst.level(6));
	    System.out.println(bst.level(1));
		//bst.delete(6);
		bst.printLikeTree();
		bst.printByLevel();
		System.out.println(bst.numOfCh(bst.lookup(6)));
		System.out.println(bst.lookup(6).numOfChildren);
		System.out.println(bst.lookup(6).level);
		System.out.println(bst.lookup(6).inOrderRank);
		System.out.println(bst.lookup(13).inOrderRank);
		//bst.mirror();
		//bst.printLikeTree();
		AppDraw.show();
		AppDraw.setSize(800, 400);
		//bst.printTree();
		
	}
	
}
