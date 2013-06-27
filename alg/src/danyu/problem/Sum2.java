package danyu.problem;

import java.util.ArrayList;

/**
 * @author danyu_you Find pairs with certain summation.
 */
public class Sum2 {

	public static void solve(int[] a, int sum) {

		int[] sa = sort(a);

		int head = 0;
		int tail = sa.length - 1;
		System.out.print("Answers are: ");
		while (head < tail) {
			int tempSum = sa[head] + sa[tail];
			if (tempSum == sum) {
				System.out.print("{" + sa[head] + ", " + sa[tail] + "} ");
				// look for other solution
				head++;
			} 
			else if (tempSum > sum) tail--;
			else 				head++;
		}
		System.out.println(" ");
	}

	// external sort
	public static int[] sort(int[] num) {

		int c = 0;
		ArrayList<Integer> l = new ArrayList<Integer>();
		int v;
		while (c < num.length) {
			v = num[c];

			if (l.size() == 0) {
				l.add(v);

			} else {

				int i = 0;
				//if larger, than compare to the next
				while (v > l.get(i) && i <= l.size() - 1) {
					i++;
					if(i>l.size()-1) break;
				}
				
				// if (i >= l.size() - 1) l.add(v);
				// else
				l.add(i, v);
			}
			c++;
		}

		// copy back to a
		c = 0;
		while (c < num.length) {
			num[c] = l.get(c);
			c++;
		}
		return num;

	}

	public static void main(String[] args) {
		Sum2.solve(new int[] { 7, 5, 2, 3, 4, 1, 6, -1 }, 5);
		Sum2.solve(new int[] { -1, 0, -1, 4, -2, 6, 0, 0, 3 }, 0);
		Sum2.solve(new int[]{1,1,1,1,1,1}, 2);
	}

}
