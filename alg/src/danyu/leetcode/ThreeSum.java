package danyu.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.Position;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import danyu.alg.sorting.QuickSort;
import danyu.problem.Sum2;

public class ThreeSum {

	/**
	 * @param num
	 *            , has at least three elements
	 * @param sum
	 */
	public static ArrayList<ArrayList<Integer>> solve(int[] num, int sum) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (num.length < 3)
			return null;

		num = Sum2.sort(num);

		int head = 0, mid = 0, tail = 0;
		int curSum;
		

		while (head <= num.length - 3) {

			mid = head + 1;
			tail = num.length - 1;

			// find a pair with sum of sum-p1
			while (mid < tail) {
				curSum = num[head] + num[mid] + num[tail];
				if (sum == curSum) {
					ArrayList<Integer> oneSolution = new ArrayList<Integer>();
					oneSolution.add(num[head]);
					oneSolution.add(num[mid]);
					oneSolution.add(num[tail]);
					
					if (result.size() > 0) {
						ArrayList<Integer> last = result.get(result.size() - 1);
						if (last.get(0) != oneSolution.get(0)
								|| last.get(1) != oneSolution.get(1)
								|| last.get(2) != oneSolution.get(2)) {
							result.add(oneSolution);

						}
					} else {
						result.add(oneSolution);
						
					}
					//System.out.print("{" + oneSolution.get(0) + ", " + oneSolution.get(1)
					//		+ ", " + oneSolution.get(2) + "} ");

					// look for other solution
					mid++;

				} else if (curSum > sum) {
					tail--;
					while (num[tail] == num[tail + 1] && tail > mid)
						tail--;
				} else {
					mid++;
					while (num[mid] == num[mid - 1] && mid < tail)
						mid++;
				}

			}
			//avoid duplication
			head++;
			while (head>0 && num[head] == num[head - 1] && head < tail)
				head++;
		}

		//System.out.println("Done");
		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //try cases
		ThreeSum.solve(new int[] { -1, -1, 0, 0, 0, 0, 0, 1, -1, -2, 3 }, 0);
		ThreeSum.solve(new int[] { -1, -1,-1, 0, 0,0, 1,1, 2,4 }, 0);
		ThreeSum.solve(new int[] { -4, -2,-1, 0, 0,0, 1,1,1,1 }, 0);
		ThreeSum.solve(new int[] { -1, 0, 1, 2, -1, -4 }, 0);
		ThreeSum.solve(new int[] { 1,1,-2}, 0);
		ThreeSum.solve(new int[] { -4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}, 0);
		
	}

}
