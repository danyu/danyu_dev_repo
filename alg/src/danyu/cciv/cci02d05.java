package danyu.cciv;

import java.util.LinkedList;


public class cci02d05 {

	public class ListNode{
		int value;
		ListNode next;
		
		public ListNode(int v){
			value=v;
			next=null;
		}
	}
	
	private ListNode head;
	public void createCircularList(){
		
		head=new ListNode(3);
		
		head.next=new ListNode(4);
		
		ListNode next=head.next ;
		
		ListNode loopPoint=next;//where the loop start
		
		next.next=new ListNode(5);
		next=next.next;
	  
		next.next=new ListNode(6);
		next=next.next;
			
		next.next=new ListNode(7);
		next=next.next;
		
		next.next=new ListNode(8);
		next=next.next;
		
		next.next=new ListNode(9);
		next=next.next;
		
		next.next=new ListNode(10);
		next=next.next;
		
		next.next=loopPoint;
		
	}
	
	public ListNode detectCircular(){
		ListNode slowP = head, // move one step a time
		fastP = head;// move two step(if >2, could miss circular the first time)
						// a time,
		boolean isCircular = false;
		ListNode circularStartPoint = null;
		int countSlow = 0, countFast = 0;

		//O(n)
		while ( fastP.next != null) {
			// move and check
			slowP = slowP.next;
			countSlow++;
			
			fastP = fastP.next.next ;
			countFast+=2;
		
			if(fastP==null) return null;
			if (slowP == fastP ) {
				System.out.println(countSlow+"="+countFast);
				isCircular = true;
				break;
			}
		}
			
		// O(n), get the start point of loop
		slowP = head;
		while (slowP != fastP) {
			slowP = slowP.next;
			fastP = fastP.next;
		}
		return slowP;
	}
	
	public ListNode detectCircularBetter(){
		ListNode slowP = head.next, // move one step a time
		//make first move right away		
		fastP = head.next ;// move two step(if >2, could miss circular the first time)
		if (fastP==null) return null;
		fastP=fastP.next ;
		
		boolean isCircular = false;
		ListNode circularStartPoint = null;
		int countSlow = 1, countFast = 2;

		
		//O(n)
		while ( fastP.next != null) {
			// move and check
			slowP = slowP.next;
			countSlow++;
			
			fastP = fastP.next;
			countFast++;
			
			if (slowP == fastP ) {
				System.out.println(countSlow + "=" + countFast);
				break;
			}
		
			fastP = fastP.next;
			countFast++;
			
			if (slowP == fastP ) {
				System.out.println(countSlow + "=" + countFast);
				break;
			}

		}
			
		// O(n), get the start point of loop
		slowP = head;
		while (slowP != fastP) {
			slowP = slowP.next;
			fastP = fastP.next;
		}
		return slowP;
	}
	
	public void printList(){
		ListNode cur = head;
		while (cur !=null){
			System.out.print(cur.value+",");
			cur=cur.next;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		cci02d05 c=new cci02d05();
		c.createCircularList();
		//c.printList();
		ListNode l= c.detectCircular();
		l=c.detectCircularBetter();
		if(l!=null) System.out.print(l.value );
		else System.out.print("No Circular" );
			
		//System.out.print(l.indexOf(i)+l.toString());
	}
}
