package danyu.alg.sorting;


/*Refer to Algorithms*/
public class MergeSort1 extends Sort {

	protected static Comparable[] bk;

	public static void sort(Comparable[] a) {
		bk = new Comparable[a.length];
		sort(bk, a, 0, a.length - 1);
	}

	public static void sort(Comparable[] bk, Comparable[] a, int lo, int hi) {
		// stop condition
		
		if (lo >= hi)
			return;

		int mid = (lo + hi) / 2;  
		sort(bk, a, lo, mid);     // System.out.println("Sort ("+lo+","+(mid)+")");
		sort(bk, a, mid+1, hi);	  // System.out.println("Sort ("+(mid+1)+","+hi+")");
		merge(bk, a, lo, mid, hi); // System.out.println("merge ("+lo+","+mid+","+hi+")");
	}

	public static void merge(Comparable[] bk, Comparable[] a, int lo, int mid,int hi) {
		// create a backup(bk) for a
		for (int i = 0; i < a.length; i++)	bk[i] = a[i];

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)                 a[k] = bk[j++]; // left part is handled
			else if (j > hi)             a[k] = bk[i++]; // right part is handled
			else if (less(bk[i], bk[j])) a[k] = bk[i++];
			else           			     a[k] = bk[j++];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character[] a = { 'a', 'v', 'f', 'd', 'a', 't' };
		Sort.printArray(a);
		MergeSort1.sort(a);
		Sort.printArray(a);
		
		Integer[] b = { 22, 1, 3, 12, 5, 11,15,12,44,330,0 };
		Sort.printArray(b);
		MergeSort1.sort(b);
		Sort.printArray(b);

	}

}
