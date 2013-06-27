package danyu.alg.ds.linkedlist;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import danyu.alg.ds.DS;
import danyu.alg.ds.LinkedNode;
import danyu.alg.ds.Node;
import danyu.alg.ds.DS.DSType;
import danyu.alg.ds.tree.BSNode;
import danyu.alg.ui.GraphicsHelper;

public class ExtLinkedList<Key extends Comparable<Key>, Value> extends DS{

	public LinkedNode<Key, Value> head=null;
	
	public ExtLinkedList(){
		this((Key[])ks);
	}
	
	public ExtLinkedList(Key[] ks) {
          //head=new LinkedNode();
		setKeys(ks);
	}
	
	@Override
	public DSType getType(){return DSType.List;}
	
	@Override
	public void setKeys(Comparable[] ks) {
		// TODO Auto-generated method stub
		head=null;
		size=0;
		insert((Key[])ks);
	}

	@Override
	public void insert(Comparable k, Object v){
		//insert to the begin
		LinkedNode ln=new LinkedNode(k);
		ln.next=head;
		head=ln;
		size++;
	}
	
	public void insert(Comparable[] ks){
		for (int i = 1; i < ks.length; i++)	insert(ks[i],null);
	}
	
	/*public void print(Graphics g){
		int left=20;
		int top=40;
		LinkedNode temp=head;
		//int visited=0;
		int tempX=left, linkY=top+Node.RADIUS/2;

		while(temp!=null){
			
			//left edge of this node
			//tempX=left+visited*(temp.nodeWidth+temp.linkLength);
			GraphicsHelper.fillSquare(tempX,top,temp.RADIUS,calColor(temp.key),g);
			//right edge of this node
			tempX+=temp.RADIUS;
			GraphicsHelper.drawHLine(
					tempX,
					linkY,
					tempX+temp.linkLength,
					linkY,
					Node.RADIUS,
					Color.black,g);
			tempX+=temp.linkLength;
			temp=temp.next;
			//visited++;
		}
		//
		GraphicsHelper.drawSquare(tempX,top,Node.RADIUS,Color.black,g);
		
	}
	*/
	@Override
	public void delete(Comparable k) {
		// TODO Auto-generated method stub
		if(head==null) return;
		LinkedNode n=head;
		//if(n.key.compareTo(k)==0) {head=head.next;return;}
		LinkedNode next=n.next;
		while(next!=null && next.key.compareTo(k)!=0){
			n=next;
			next=next.next;
		}
		if(next==null)return;
		n.next=next.next;
	}

	public String toString(){
		return "Linked List";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
