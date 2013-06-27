package danyu.alg.sorting;

/**
 * @author danyu_you
 * 
 *         Based on Quick Sort, to find the kth largest element in a array.
 * 
 */
public class QuickSelect {

	public static Comparable select(Comparable[] a, int kth) {

		return select(a, 0, a.length - 1, kth);
	}

	public static Comparable select(Comparable[] a, int left, int right, int k) {

		int x = QuickSort.partition(a, left, right);

		while (x != k) {
			if (x > k)
				right = x - 1;
			if (x < k)
				left = x + 1;

			x = QuickSort.partition(a, left, right);
		}
		return a[x];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kth = 5;
		Comparable[] a = new Integer[] { 3, 7, 14, 12, 7, 6, 9, 10, 12, 21, 8 };

		// Sort.printArray(a);
		System.out.println(kth + "th of a = "
				+ QuickSelect.select(a, kth).toString());
		// Sort.printArray(a);
	}

}
