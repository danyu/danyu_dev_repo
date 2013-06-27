package danyu.leetcode;

import java.util.ArrayList;

import danyu.problem.Sum2;

public class FourSum {

	public static ArrayList<ArrayList<Integer>> solve(int[] num, int target) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3)
			return result;

		num = Sum2.sort(num);

		int head = 0, mid1, mid2, tail = num.length - 1, tempSum;

		while (head <= num.length - 4) {
			mid1 = head + 1;
			while (mid1 < tail - 1) {
				mid2 = mid1 + 1;
				// reset tail
				tail = num.length - 1;
				while (mid2 < tail) {
					tempSum = num[head] + num[mid1] + num[mid2] + num[tail];

					if (tempSum == target) {
						// get a solution
						ArrayList<Integer> oneSolution = new ArrayList<Integer>();
						oneSolution.add(num[head]);
						oneSolution.add(num[mid1]);
						oneSolution.add(num[mid2]);
						oneSolution.add(num[tail]);

						if (result.size() == 0) {
							result.add(oneSolution);

						} else {
							// avoid duplication
							ArrayList<Integer> lastSolution = result.get(result
									.size() - 1);
							if (lastSolution.get(0) != num[head]
									|| lastSolution.get(1) != num[mid1]
									|| lastSolution.get(2) != num[mid2]
									|| lastSolution.get(3) != num[tail]) {
								result.add(oneSolution);
								System.out.print(" {" + num[head] + ", "
										+ num[mid1] + ", " + num[mid2] + ", "
										+ num[tail] + "} ");
							}
						}
						mid2++;
					} else if (tempSum < target) {
						mid2++;
						// avoid duplication
						while (mid2 < tail && num[mid2] == num[mid2 - 1])
							mid2++;
					} else {
						tail--;
						// avoid duplication
						while (mid2 < tail && num[tail] == num[tail + 1])
							tail--;
					}

				}
				mid1++;
				// avoid duplication
				while (mid1 > head && mid1 < tail && num[mid1] == num[mid1 - 1])
					mid1++;
			}
			head++;
			// avoid duplication
			while (head > 0 && head < tail && num[head] == num[head - 1])
				head++;
		}
		System.out.println(", Done");
		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum.solve(new int[] { 12, 2, 3, -2, -4, 6, -1, -1, -1, 4 }, 1);
		FourSum.solve(new int[] { -4, -4, -3, -2, -1, 0, 1, 1, 2, 3, 4 }, 0);

	}

}
