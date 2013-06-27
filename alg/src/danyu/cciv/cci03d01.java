package danyu.cciv;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Describe how you could use a single array to implement three stacks
 * 
 * Solution:
 * Space is allocated to each stack dynamically.
 * 
 * 
*/
public class cci03d01 {

	public class ThreeStacks{
		int SIZE=10;
		Node[] ary=new Node[SIZE];
		int[] tops={-1,-1,-1};//index of top of stacks
		int[] sizes={0,0,0};
		List<Integer> freeLocs=new ArrayList<Integer>();
		
		ThreeStacks(){
			for(int i=0;i<SIZE;i++)	freeLocs.add(i);
		}
		
		public void push(int stackIndex, int v){
		
		  if(freeLocs.size()<=0) {
			  
			  return;
		  }
		  
		  Node n=new Node(tops[stackIndex],v);
		  n.next=tops[stackIndex];
		  n.value=v;
		  
		  tops[stackIndex]=freeLocs.remove(0);// update top index
		  ary[tops[stackIndex]]=n;// store new node into array
		  
		}
		
		public void pop(int stackIndex){
			if(tops[stackIndex]==-1) return;//nothing to pop
			Node top=ary[tops[stackIndex]];
			freeLocs.add(tops[stackIndex]);//restore space
			ary[tops[stackIndex]]=null;
			tops[stackIndex]=top.next;//update top pointer
		}
		
		public int size(int statckIndex){		
			return 0;
		}
		
		public boolean isEmpty(int statckIndex){
			return false;
		}
		
		public void print(int stackIndex){
			if(tops[stackIndex]==-1){
				System.out.println("Stack "+stackIndex+" is empty.");
				return;
			}		
			Node x=ary[tops[stackIndex]];
		
			System.out.print("Stack "+stackIndex+" = ");
			while(true){
				System.out.print(x.value+"--");
			    if(x.next==-1) break;
			    else x=ary[x.next];
			}
			System.out.print("null \n");
					
		}
		
		public void print(){
			System.out.println("Stacks info at "+new Date(System.currentTimeMillis()).toString());
			for(int i=0;i<3;i++)  print(i);
		}
	}
	
	private class Node{
		int next=-1;
		int value;
		Node(int nx,int v){
			next=nx;value=v;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreeStacks ts=(new cci03d01()).new ThreeStacks();
		ts.push(1, 5);
		ts.push(2, 7);
		ts.push(1, 7);
		ts.push(2, 99);
		ts.push(0, 3);
		ts.print();	
		ts.pop(0);
		ts.pop(1);
		ts.print();
		
	}

}
