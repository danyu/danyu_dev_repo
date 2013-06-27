package danyu.alg.sorting;

public class HeapSort1 extends Sort{
	
	//for consistency with binary tree,
	//array index is from 1 to N
    
    public HeapSort1(Comparable[] a )
    {
    	this.a=a;
    }
    
    //adjust element from ith to Nth(last one)
	public void siftUp( int i, int N){
		
		//check a pair each time
		for(int j= 2*i;j<=N;j*=2){
			//figure out which child is larger
			if(j<N && less(a[j],a[j+1])) j++;
			
			//compare with larger child
			if(!less(a[j/2],a[j])) break;//in right position
			swap(j/2,j);//move up
		}
	}
	
    
    public void sort(){
    	int N=a.length-1;
    	//start from layer (= total # of layer - 1)
    	//check parent node one by one
    	
    	//construct a heap
    	//by checking a pair of elements each time, in order of bottom up
    	for( int i=N/2;i>-1;i-- ){
    		siftUp(i, N);
    		printElements();
    	}
    	printElements();
    	
    	//sort based on the heap
    	while(N>=0){
    		swap(0,N--);//put the largest number to the end
    		siftUp(0, N);// adjust rest element to a new heap
    	}
    	printElements();
    }
    
//    public void swap(int i, int j){
//        int temp=a[i];
//        a[i]=a[j];
//        a[j]=temp;
//               
//}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = { 2, 31, 4, 5, 5, 11, 1, 55, 6 };
		HeapSort1 hs1 = new HeapSort1(a);
		hs1.sort();

	}

}
