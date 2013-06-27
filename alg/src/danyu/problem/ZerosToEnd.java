package danyu.problem;

import danyu.alg.util.ArrayHelper;

/* Given an unsorted integer array, place all zeros 
 * to the end of the array 
 * WITHOUT changing the sequence of non-zero elements. 
 * 
 * Input 
 *       [1,3,0,8,12,0,4,0,7] 
 * Output
 *       [1,3,8,12,4,7,0,0,0]
 *       
 */
public class ZerosToEnd {

	public static void move(Integer[] a){
	    System.out.println("Before move:");
		ArrayHelper.printArray(a);
			
		//shift non-zeros to the head
		int curNonZeros=0;
		for (int i=0;i<a.length;i++){
			if (a[i]!=0){
				a[curNonZeros]=a[i];
			    curNonZeros++;
			}
		}
		//put zeros to the end
		for(;curNonZeros<a.length;curNonZeros++)
			a[curNonZeros]=0;
		
		System.out.println("After move:");
		ArrayHelper.printArray(a);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    ZerosToEnd.move(new Integer[]{1,0,3,4,0,11,9});

	}

}
