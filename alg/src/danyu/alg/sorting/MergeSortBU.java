package danyu.alg.sorting;

//Botton-up mergesort

public class MergeSortBU extends MergeSort1{

	public static void sort( Comparable[] a){
		
		bk=new Comparable[a.length];

	    int N=a.length;   
	    //change size by double
		for (int SZ=1;SZ<N;SZ=SZ+SZ)
			for(int lo=0;lo<N-SZ;lo+=SZ+SZ)
				merge(bk,a,lo,lo+SZ-1,Math.min(lo+SZ+SZ-1, N-1));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character[] a = { 'a', 'v', 'f', 'd', 'a', 't' };
		Sort.printArray(a);
		MergeSortBU.sort(a);
		Sort.printArray(a);
		
		Integer[] b = { 22, 1, 3, 12, 5, 11,15,12,44,330,0 };
		Sort.printArray(b);
		MergeSort1.sort(b);
		Sort.printArray(b);

	}

}
