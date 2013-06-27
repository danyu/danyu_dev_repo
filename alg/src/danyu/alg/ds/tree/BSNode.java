package danyu.alg.ds.tree;

import danyu.alg.ds.Node;
import danyu.alg.ds.*;

public class BSNode<Key extends Comparable<Key>, Value> extends Node{

		public BSNode leftChild, 
		               rightChild;
		public int numOfChildren=0;
		
		/**
		 * Following two variables for printing tree
		 * */
		public int inOrderRank=0,
				   level=0;
		
		public BSNode(){}
		public BSNode(Key k){
			key=k;
		}
		public BSNode(Key k, Value v, int N){
			key=k;value=v;numOfChildren=N;
		}
		
		//shorthand functions
		public boolean less(BSNode<Key,Value> p1){	return this.key.compareTo(p1.key)<0;}
		public boolean greater(BSNode<Key,Value> p1){return this.key.compareTo(p1.key)>0;}
		public boolean equal(BSNode<Key,Value> p1){return this.key.compareTo(p1.key)==0;}
		
		public boolean isLeaf(){return leftChild==null && rightChild==null;}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
