package danyu.alg.ds;

import danyu.alg.sorting.HeapSort;
import danyu.alg.sorting.Sort;

//implement a maximum heap
public class MaxHeap {

	private Comparable[] a;
    private static int ROOT=-9999;
	public MaxHeap(Comparable[] a) {
		this.a = a;

	}

	public void insert(Comparable n) {

	}
	
	public void sinkDown(int n) {

		while (n * 2 <= a.length-1) {
			int j = n * 2;
			if (DS.less(a[j], a[j + 1]))
				j++;
			if (DS.less(a[j], a[n]))
				break;
			DS.exch(a, n, j);
            n=j;
		}
	}

	public void swimUp(int n) {
        while(n>1 &&  DS.less(a[n/2], a[n])){
        	DS.exch(a, n, n/2);
        	n=n/2;
        }
	}

	public static void main(String[] args) {
		Integer[] a={ROOT,1222,2,31,4,5,5,11,1,55};
		MaxHeap hs=new MaxHeap(a);
		hs.sinkDown(2);
		hs.swimUp(9);
		DS.printElements(a);
		
	}

}
