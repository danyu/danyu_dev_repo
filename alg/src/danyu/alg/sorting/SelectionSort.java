package danyu.alg.sorting;


/**
 * @author danyu_you
 * Algorithm:
 * 		Similar to bubble sort but with fewer swapping.
 *		Scan array to find the smallest element in the unsorted
 *		part and put it to the end of the sorted part.
 * 
 * Time: 
 * 		n^2
 * 
 * Tips:
 * 		Find the smallest / largest.		
 * 
 */
public class SelectionSort extends Sort{

	SelectionSort(Integer[] a) {
          this.a=a;
	}
	
	public void sort(){
		int bigger=0;
		
		for (int i=a.length-1;i>0;i--){
			bigger=0;
			for(int ptr=0;ptr<=i;ptr++){
				if ( a[ptr].compareTo( a[bigger])==1)
					// record the position of bigger number after every
					// comparison
					bigger = ptr;
			}
			swap(bigger,i);
			printElements();
		}
	}
	
	public static void main(String[] args){
		SelectionSort ss= new SelectionSort(new Integer[]{3,4,5,12,4,6,2,77,63,99,16,3});
		ss.printElements();
		ss.sort();
		ss.printElements();
		
		//System.out.println(Math.pow(-32, 0.2));
	}
	
	

}
