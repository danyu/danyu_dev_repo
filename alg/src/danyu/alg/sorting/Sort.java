package danyu.alg.sorting;

import danyu.alg.util.ArrayHelper;

public class Sort<T> {
    protected Comparable<T>[] a ; 
    
    public void swap(int i, int j) {
		Comparable<T> temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
    
    public static void swap(Comparable[] a, int i, int j){
    	Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
    }

	public void printElements() {
		printArray(a);
	}
	
	public static void printArray(Object[] array) {
		System.out.print("[");
		for (Object x : array) {
			System.out.print(x.toString() + " ");
		}
		System.out.print("]\n");
	}
	
	public Comparable<T>[] getResult(){
		return a;
	}
	
	public static boolean less(Comparable val1, Comparable val2){
		return val1.compareTo(val2)<0;
	}
	
	public static boolean equal(Comparable val1, Comparable val2){
		return val1.compareTo(val2)==0;
	}
	
	public static boolean greater(Comparable val1, Comparable val2){
		return val1.compareTo(val2)>0;
	}
	
	public static Integer[] convertToIntegerArray(int [] a){
		Integer[] temp = new Integer[a.length];

		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}
		return temp;

	}
	
}
