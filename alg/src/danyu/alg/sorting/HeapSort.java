package danyu.alg.sorting;

/**
 * @author danyu_you
 *	Algorithm:
 *			
 *	
 *
 *
 */
public class HeapSort<T> extends Sort{
	
	static final int ROOT=-999999;
	
	public HeapSort(Comparable<T>[] a){
		this.a=a;
	}
	
	public  void sink( int k, int N){
		
		while (2 * k < N) {
			int j = 2 * k;
			if (less(a[j], a[j + 1]))j++;  // right child is greater
			if (!less(a[k], a[j]))break; // right position
			swap(k,j);//swap if not in place
			k=j;
		}
	}
	
	public void swim(int n){
		while(n>1 && Sort.less(a[n/2], a[n])){
			swap(a, n, n/2);
			n=n/2;
		}
	}
	
	public void sort(){
		int N=a.length-1;
		System.out.println("Construct a heap:");
		for(int i=N/2;i>0;i--){//last parent
			sink(i, N);
			printElements();
		}	
		
		System.out.println("Generate a sorte array:");
		while(N>0){
			swap(1,N--);
			sink(1,N);
		}
		printElements();	
	}
	
	public void swap(int i, int j){
	        Comparable<T> temp=a[i];
	        a[i]=a[j];
	        a[j]=temp;
	               
	}
	
	public void printElements(){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"  ");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args){
		Integer[] a={ROOT,2,31,4,5,5,11,1,55};
		HeapSort<Integer> hs=new HeapSort<Integer>(a);
		//hs.swim(7);
		hs.printElements();
		hs.sort();
		Sort.printArray(a);
			
	}
	
}
