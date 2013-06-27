package danyu.alg.ds.stack;

import java.awt.Graphics;

import danyu.alg.ds.*;
import danyu.alg.ds.DS.DSType;
import danyu.alg.ds.linkedlist.ExtLinkedList;
import danyu.alg.ui.GraphicsHelper;

/**
 * @author danyu
 * Data structure - stack.
 * Implemented based on linked-list
 */
public class ExtStack<Key extends Comparable<Key>, Value> extends ExtLinkedList{

	//private ExtLinkedList<Key, Value> data;
	
	public DSType getType(){
		return DSType.Stack;
	}
	
	public ExtStack(){
		this((Key[]) ks);
	}
	
	public ExtStack(Key[] keys){
		super(keys);
	}
	
	@Override
	public void insert(Comparable key, Object v){
		push(key,v);
	}
	
	@Override
	public void delete(Comparable key){
		//Deletion only works for top one		
		if(key.equals(head.key)) pop();
	}
	
	public void push(Comparable key, Object v){
		super.insert(key,v);
	}
	
	public Node pop(){
		head=head.next;
		return head;
	}
	
	public LinkedNode top(){
	 return	head;
	}
	

	public String toString(){
		return "Stack";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
