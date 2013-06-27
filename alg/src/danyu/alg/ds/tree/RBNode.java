package danyu.alg.ds.tree;

import java.awt.Color;

public class RBNode<Key extends Comparable<Key>, Value>  extends BSNode {
	
	
	public RBNode(){}
	public RBNode(Key k){
		super(k);
		linkColor=Color.black;
	}
	public RBNode(Key k, Value v, int N){
		key=k;value=v;
	}
}