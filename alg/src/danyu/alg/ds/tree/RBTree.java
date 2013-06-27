package danyu.alg.ds.tree;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import danyu.alg.ds.Node;
import danyu.alg.ds.tree.BSNode;
import danyu.alg.ui.BSTreeUI;
import danyu.alg.ui.GraphicsHelper;

public class RBTree<Key extends Comparable<Key>, Value> extends BSTree{
	
	public RBTree(){
		super(ks);
	}
	
	/*public RBTree(Key[] keys){
		super(ks);
	}*/
	
	
	

	@Override
	public void insert(Comparable key,Object value) {
		// TODO Auto-generated method stub
		RBNode newNode=new RBNode((Key)key);
		newNode.linkColor=Color.red;
		
		root=insert(root,newNode);
		((RBNode)root).linkColor=Color.black;
	}
	
	@Override
	protected BSNode insert(BSNode node, BSNode newP) {
		// TODO Auto-generated method stub
		if (node==null) {
			node=newP;
			return node;
		}
		
		super.insert(node,newP);
		
		if(isRed(node.rightChild) && ! isRed(node.leftChild))	
			node=rotateLeft(node);
		
		if(isRed(node.leftChild) && isRed(node.leftChild.leftChild))
			node=rotateRight(node);	
		
		if(isRed(node.leftChild) && isRed(node.rightChild))
			swapColor(node);
		
		return node;
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
	
	public void swapColor(BSNode n){
		((RBNode)n).linkColor=Color.red;
		((RBNode)n.leftChild).linkColor= Color.black;
		((RBNode)n.rightChild).linkColor= Color.black;
	}
	
	

	@Override
	public void delete(Comparable key){
		super.delete(key);
	}
	
	public String toString(){
		return "Red-Black Tree";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
