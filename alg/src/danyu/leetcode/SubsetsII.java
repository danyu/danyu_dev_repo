package danyu.leetcode;

import java.util.*;

/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class SubsetsII {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {

		S = sort(S);

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int size = S.length;
		int NUM_OF_SETS = 1 << size; // 2 to size sets

		for (int i = 0; i < NUM_OF_SETS; i++) {
			ArrayList<Integer> newSet = new ArrayList<Integer>();
			int setInt = i;
			int index = 0;
			// check bit by bit
			while (setInt > 0) {
				if ((setInt & 1) > 0)
					newSet.add(S[index]);
				setInt = setInt >> 1;
				index++;
			}
			if (!result.contains(newSet))
				result.add(newSet);
		}
		return result;
	}

	// following is merge sort to keep array in ascending order
	private static Comparable[] bk;

	public static int[] sort(int[] b) {
		Integer[] a = new Integer[b.length];
		for (int i = 0; i < b.length; i++)
			a[i] = b[i];
		bk = new Comparable[a.length];
		sort(bk, a, 0, a.length - 1);
		for (int i = 0; i < b.length; i++)
			b[i] = a[i];

		return b;// return sorted array
	}

	public static void sort(Comparable[] bk, Comparable[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		sort(bk, a, lo, mid); // System.out.println("Sort ("+lo+","+(mid)+")");
		sort(bk, a, mid + 1, hi); // System.out.println("Sort ("+(mid+1)+","+hi+")");
		merge(bk, a, lo, mid, hi); // System.out.println("merge ("+lo+","+mid+","+hi+")");
	}

	public static void merge(Comparable[] bk, Comparable[] a, int lo, int mid,
			int hi) {
		// create a backup(bk) for a
		for (int i = 0; i < a.length; i++)
			bk[i] = a[i];

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = bk[j++]; // left part is handled
			else if (j > hi)
				a[k] = bk[i++]; // right part is handled
			else if (bk[i].compareTo(bk[j]) < 0)
				a[k] = bk[i++];
			else
				a[k] = bk[j++];
		}
	}

	public void printResult(ArrayList<ArrayList<Integer>> result) {
		for (int i = 0; i < result.size(); i++) {
			System.out.print("[");
			ArrayList<Integer> subset = result.get(i);
			for (int j = 0; j < subset.size(); j++)
				System.out.print(subset.get(j).toString());
			System.out.print("]\n");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetsII ss = new SubsetsII();
		// ArrayList<ArrayList<Integer>> result= ss.solve(new int[]{1,2,3,4});
		ss.printResult(ss.subsetsWithDup(new int[] { 1, 2, 2 }));

	}

}
