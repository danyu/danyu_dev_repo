package danyu.alg.sorting;

import java.util.Random;

import danyu.alg.util.ArrayHelper;


/**
 * @author danyu_you
 * Description:
 *		Quick Sort is doing following three steps recursively:
 *      (1)chose a "pivot", which could be any element of a array.
 *      (2)divide array into two parts:
 *         one part consists of elements bigger than pivot;
 *         another part consists of elements smaller than pivot;
 *      (3)do (1) and (2) to those two parts .
 *
 * Example:
 * 
 * 
 *
 * Time:
 *		Log(n)		
 *
 * Tips:
 *     Divided and conquer 
 *      
 */
public class QuickSort extends Sort {

	// do sort recursively
	public static void sort(Comparable[] a) {	
		sort(a, 0, a.length - 1);
	}

	public static void sort(Comparable[] a, int left, int right) {	
		if (left >= right)	return;
        int pivot= partition(a,left, right);
		sort(a, left, pivot-1);
		sort(a, pivot+1, right);
	}

	// do in place partition
	public static int partition(Comparable[] a,int left, int right) {
		int pivot = right;
		right--;	//leave pivot
		while (true) {//find place for pivot
			while (less(a[left],a[pivot])) left++;
			while (greater(a[right],a[pivot]) )	right--;
			if (left >= right) break;
			else swap(a, left, right);	
		}
		swap(a, pivot, left);//move pivot in place
		return left;
	}
	
	public void printElements() {
		ArrayHelper.printArray(a);
	}

	public static void main(String[] arg) {
		Comparable[] a=new Integer[] { 3, 7, 14, 12, 7, 6, 9, 10,12,21,8 };
		
		Sort.printArray(a);	
		QuickSort.partition(a, 0, a.length-1);
		Sort.printArray(a);	
		QuickSort.sort(a);
		Sort.printArray(a);
	}
}
