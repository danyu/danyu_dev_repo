package danyu.alg.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import danyu.alg.ds.DS;
import danyu.alg.ds.LinkedNode;
import danyu.alg.ds.DS.DSType;
import danyu.alg.ds.Node;
import danyu.alg.ds.linkedlist.ExtLinkedList;
import danyu.alg.ds.stack.ExtStack;
import danyu.alg.ds.tree.BSNode;
import danyu.alg.ds.tree.BSTree;

/**
 * @author danyu
 * Expert knows how to visualize all kinds of data structures.
 * 
 */
public class DSPainter  {

	public static int view_top=60;
	public static int view_left=100;
	//intervals for tree nodes
	public static int DEFAULT_NODE_RADIUS=20;
	public static int NODE_RADIUS=DEFAULT_NODE_RADIUS;
	public static int HORIZONTAL_INTERVAL=(int)(NODE_RADIUS*2.8);
	public static int VERTICAL_INTERVAL=(int)(NODE_RADIUS*2.8);
	//The smallest R that allows drawing key. 
	public static int MIN_R_DRAW_KEY=5;
	public Color keyForeColor=Color.black;
	public Color keyBkColor=Color.magenta;
	public Color valueForeColor=Color.black ;
	public Color valueBkColor=Color.black ;
	
	public static int NUMBER_IN_LINE=20;
	
	
	public static void paint(DS ds, Graphics g, int w, int h){
		updateLocParams(ds.ks.length,w,h);
		switch (ds.getType()){
		case BinaryTree:
			paint((BSTree)ds, g,w,h);
			break;
		case List:
			paint((ExtLinkedList)ds, g,w,h);
			break;
		case Stack:
			paint((ExtStack)ds,g,w,h);
			break;
		case Unkown:
			break;
		default:
				break;
		}
	}
	
	public static void paint(BSTree bsTree, Graphics g,int w, int h){
		
		ArrayList<BSNode> in=bsTree.inOrder();
		BSNode itr=null;//iterator
		int tempX=0,tempY=0;
		for(int i=0;i<in.size();i++){
			itr=in.get(i);
			tempX=view_left+i*HORIZONTAL_INTERVAL;
			tempY=view_top+itr.level*VERTICAL_INTERVAL;			
			
			if(itr.leftChild !=null) {
				int indexOfLeftChd=in.indexOf(itr.leftChild);
				//AppDraw.drawLine(tempX, tempY, left+indexOfLeftChd*step, top+temp.leftChild.level*step, Color.BLUE);
				GraphicsHelper.drawLink(tempX, tempY, 
						view_left+indexOfLeftChd*HORIZONTAL_INTERVAL, 
						view_top+itr.leftChild.level*VERTICAL_INTERVAL, 
						NODE_RADIUS,
						itr.leftChild.linkColor ,g);
			};
			if(itr.rightChild !=null) {
				int indexOfRightChd=in.indexOf(itr.rightChild);
				GraphicsHelper.drawLink(tempX, tempY, 
						view_left+indexOfRightChd*HORIZONTAL_INTERVAL, 
						view_top+itr.rightChild.level*VERTICAL_INTERVAL,
						NODE_RADIUS,
						itr.rightChild.linkColor,g);
			};
			//System.out.println(temp.key.toString()+"["+	i+", "+temp.level+"]");
			GraphicsHelper.drawCircle(tempX, tempY, NODE_RADIUS,Color.black,g);
			if(NODE_RADIUS>MIN_R_DRAW_KEY)
				GraphicsHelper.drawKey(
					tempX, 
					tempY,
					NODE_RADIUS, 
					0.5,
					itr.key.toString(), 
					Color.BLACK,g);
		}
	}

	/*
	 * Draw as a horizontal link
	 *  |1|--|2|--|3|--|4|--|5|--|null| 
	 * 
	 * */
	public static void paint(ExtLinkedList ll, Graphics g, int w, int h){
		LinkedNode itr=ll.head;
		//int visited=0;
		int tempX=view_left, linkY=view_top+NODE_RADIUS;
		int length=2*NODE_RADIUS;
		while(itr!=null){
			
			//left edge of this node
			//tempX=left+visited*(temp.nodeWidth+temp.linkLength);
			GraphicsHelper.drawSquare(tempX, view_top, length,
					DS.calColor(itr.key), g);
			GraphicsHelper.drawKey(tempX + NODE_RADIUS, linkY, NODE_RADIUS,
					0.6, itr.key.toString(), Color.black, g);
			//shift and draw link 
			tempX+=length;
			GraphicsHelper.drawLine(tempX, linkY, tempX + itr.linkLength,
					linkY, length, Color.black, g);
			tempX+=itr.linkLength;
			itr=itr.next;
			
		}
		GraphicsHelper.drawSquare(tempX,view_top,length,Color.black,g);
		
	}
	
	/*
	 * Draw something like this.
	 * 
	 *      |________|      ->  top
	 *      |________|
	 *      |________|
	 *      |________|
	 * _____|________|_____ ->  dead end
	 *   /////////////////
	 * 
	 * */
	public static void paint1(ExtStack s, Graphics g, int w, int h){
		LinkedNode itr=s.top();
		int hInterval=NODE_RADIUS;
		int tempX=view_left,linkY=view_top;
		
		while(itr!=null){
			//left edge of this node
			//tempX=left+visited*(temp.nodeWidth+temp.linkLength);
			GraphicsHelper.drawRect(tempX, linkY, NODE_RADIUS*4,NODE_RADIUS,
					DS.calColor(itr.key), g);
			GraphicsHelper.drawKey(tempX+NODE_RADIUS*2, linkY+(int)NODE_RADIUS/2, NODE_RADIUS,
					0.5, itr.key.toString(), Color.black, g);
			//shift and draw link 
			linkY+=hInterval;
//			GraphicsHelper.drawLine(tempX, linkY, tempX ,
//					linkY+ itr.linkLength, hInterval, Color.black, g);
			linkY+=itr.linkLength;
			itr=itr.next;
			
		}
		GraphicsHelper.drawRect(tempX-NODE_RADIUS*2, linkY, NODE_RADIUS * 8, 3,
				Color.black, g);
		GraphicsHelper.drawKey(tempX+NODE_RADIUS*2, linkY+NODE_RADIUS, NODE_RADIUS,
				0.5, "Bottom", Color.black, g);

	}

	public static void updateLocParams(int size, int w, int h){
		view_left=(int)(w*0.05);
		HORIZONTAL_INTERVAL=(int)((w*0.9)/((size-1)));
		NODE_RADIUS=Math.min(DEFAULT_NODE_RADIUS, (int)(HORIZONTAL_INTERVAL/2.5));
		VERTICAL_INTERVAL=(int)(NODE_RADIUS*3);
	}
	
	public static void paint(Graphics g){
		GraphicsHelper.drawSquare(view_left,view_top,NODE_RADIUS,Color.black,g);
	}
	
}
