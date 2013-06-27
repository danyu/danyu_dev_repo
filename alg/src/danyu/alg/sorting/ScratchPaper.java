package danyu.alg.sorting;

public class ScratchPaper {

	private int [] a;
	
	//must-have functions
	public void swap(int i, int j){
		//swap without extra variable
		a[i]=a[i]+a[j];
		a[j]=a[i]-a[j];
		a[i]=a[i]-a[j];
	}
	
	public void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println(" ");
	}
	
	public  void quickSort(int[] a){
		this.a=a;
		printArray(this.a);
		quickSort(0,a.length-1);
		printArray(this.a);
	}
	
	public  void quickSort(int start, int end){
		if(start>end) return;
		
		//one element
		if(start-end==0) return;
		
		//two elements
		if(start-end==1) {
			//compare and swap
		    if(a[start]>a[end]) swap(start,end);
		    return;
		}
		
		// 2+ elements,
		// it's getting serious
		int pivot=end, l=start, r=end-1;
		
		// loop 
		while(true){
		    while(a[l]<a[pivot] && l<r) l++;
		    
		    while(a[r]>=a[pivot] && r>l) r--;
		    
		      //avoid situation that elements are partitioned
			if (l < r)	swap(l, r);
			else break;
		}
		
		// put pivot to right position
		if(a[r]>a[pivot]) {
			swap(r,pivot);
		    pivot=r;
		}
		
		printArray(a);
		//sort sub-array recursively
		quickSort(start,pivot-1);
		quickSort(pivot+1, end);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ScratchPaper sp=new ScratchPaper();
       sp.quickSort(new int[]{20,4,1,3,2,3,1,3,1,6,10});
       
	}

}
