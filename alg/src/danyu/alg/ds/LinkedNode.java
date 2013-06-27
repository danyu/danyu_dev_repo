package danyu.alg.ds;

import danyu.alg.ds.linkedlist.ExtLinkedList;


/**
 * @author danyu
 * It provides possibilities of connecting to previous or next node.
 * @param <Key>
 * @param <Value>
 */
public class LinkedNode<Key extends Comparable<Key>, Value> extends Node {
	
	public LinkedNode<Key, Value> previous;
	public LinkedNode<Key, Value> next;
	public Value value;
	public Key key;

	//Allow node without value
	public LinkedNode(Key k) {
			this(k,null);
	}

	public LinkedNode(Key k, Value v){
		key=k;
		value=v;
		next=null;
	}

}
