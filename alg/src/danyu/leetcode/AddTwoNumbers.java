package danyu.leetcode;

public class AddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			next = null;
			val = x;
		}
	}

	// Trap: the number can be long, so int can cause problem.
	public ListNode solve(ListNode l1, ListNode l2) {

		ListNode head = null;
		ListNode cur = null;

		long i1 = 0;
		long i2 = 0;
		int digits = 0;
		int temp;

		// O(n)
		while (l1 != null) {
			i1 += l1.val * Math.pow(10, digits);
			l1 = l1.next;
			digits++;

		}
		// reset digits
		digits = 0;
		while (l2 != null) {
			i2 += l2.val * Math.pow(10, digits);
			l2 = l2.next;
			digits++;
		}

		long i3 = i1 + i2;

		if (i3 == 0)
			return new ListNode((int)i3);

		// turn result into a linklist
		while (i3 > 0) {

			if (head == null) {
				head = new ListNode((int) (i3 % 10));
				cur = head;
			} else {
				cur.next = new ListNode((int) (i3 % 10));
				cur = cur.next;
			}
			i3 = i3 / 10;// move to the next digit
		}

		return head;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//(new AddTwoNumbers()).solve(l1, l2);
	}

}
