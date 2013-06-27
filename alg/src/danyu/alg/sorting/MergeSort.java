package danyu.alg.sorting;

import danyu.alg.util.ArrayHelper;


/* Divide And Conquer
 * 
 * Time:
 *     O(nlogn)
 *     
 * Tips:
 *     Good for linked list, bad for array.
 * 
*/

public class MergeSort extends Sort{
    
	private  Integer[] a;

	public MergeSort(Integer[] a){
		this.a=a;
	}
	
    public  void doIt(){
		
		sort(0,a.length/2);//sort left
		sort(a.length/2+1,a.length-1);//soft right
		
	}
	
    public void sort(){
    	sort(0,a.length-1);
    	ArrayHelper.printArray(a);
    }
    //sort by divide and conquer
	public void sort(int i, int j){
		if (j-i+1<2) return;// no need to sort
		else if (j - i + 1 == 2) {
			if (a[j] < a[i]) {
				int temp = 0;
				temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		else
		if(j-i+1>2){
			int middle=(i+j)/2;
			sort(i,middle);
			sort(middle+1,j);
			
			//merge based on insertion sort
			mergeWithInsertionSort(i, j);
			
		}
	}
	
	public void mergeWithInsertionSort(int start, int end){
		int sort=start;
		while (sort<end){
			int iToBePosed=a[sort+1];
			int j=sort;
			
			while(j>start-1 && iToBePosed<a[j]){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=iToBePosed;
			sort++;	
		//	ArrayPrinter.printArray(a);
		}
		//ArrayPrinter.printArray(a);
	}
	
	public static void main(String args[]){
		Integer [] a={3,1,4,12,5,66,8,1,22};
		MergeSort ms=new MergeSort(a);
		//ms.mergeWithInsertionSort(0, a.length-1);
		ms.sort();
	}
	
}
