package danyu.alg.sorting;


/**
 * @author danyu_you
 * Algorithm:
 *		Divide array into two parts: sorted part and unsorted part.
 *      Every time pick one number from unsorted part, find a
 *      position in sorted part and put it onto that position, until
 *      no element is in the unsorted part.
 *       
 * Time:
 * 		n^2
 * 
 * Application: 
 * 		locally sorted array.
 * 
 * Tips:
 *		Keep scanned part sorted.
 *
 */
public class InsertionSort extends Sort {

	InsertionSort(Comparable[] a) {
		this.a = a;
	}

	public void sort() {
		int s = 0; // mark of the end of sorted part
		int u = a.length - 1; // mark of the start point of u sorted

		while (s < a.length - 1) {
			    Comparable temp=a[s+1];// the element next to the sorted part
			    //int i = s + 1; 
				int j = s; // the largest element in the sorted part
				//shift elements while comparing
			while (j > -1 && temp.compareTo( a[j])==-1) {
				a[j + 1] = a[j];
				j--;
			}
				a[j+1] = temp;
				s++;
				printElements();
			}

	}

	public static void main(String[] arg) {
		InsertionSort is = new InsertionSort(new Integer[] { 3, 1,7, 14, 12, 7, 6, 9,
				10, 12, 21, 8 });
		is.printElements();
		is.sort();
		is.printElements();
	}
}
