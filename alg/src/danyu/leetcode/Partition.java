package danyu.leetcode;

import java.util.ArrayList;

/*Given a linked list and a value x, 
 * partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.*/

public class Partition {
	
	 //Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (head==null) return null;
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> r=new ArrayList<Integer>();
        ListNode next=head;
        while(next!=null){
        	if(next.val<x) l.add(next.val);
        	else r.add(next.val);
        	next=next.next;
        }
        head=null;
        int i=0;
        if (l.size()!=0){
        	head=new ListNode(l.get(0));
        	next=head;
        	i++;
        	for(;i<l.size();i++) {
        		next.next=new ListNode(l.get(i));
        		next=next.next;
        	} 
        }
        i=0;
        if (r.size()!=0){
        	if (head==null) {
        		head=new ListNode(r.get(0));
        		next=head;
        		i++;
        		}
        	for(;i<r.size();i++) {
        		next.next=new ListNode(r.get(i));
        		next=next.next;
        	}  
        }
        
        return head;
        
    }
	
	public void print(ListNode head){
		ListNode next=head;
		while(next!=null) {
			System.out.print("->"+next.val);
			next=next.next;}
		System.out.print("\n");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 5, 2, 3, 4, 5 };

		Partition p = new Partition();
		ListNode head = p.new ListNode(a[0]);
		ListNode next = head;
		for(int i=1;i<a.length;i++){
			next.next  = p.new ListNode(a[i]);
		    next = next.next;
		}
          
		p.print(head);
		
		p.print(p.partition(head, 3));
	}

}
