package danyu.problem;

import sun.awt.datatransfer.DataTransferer.IndexOrderComparator;

/*Given An Array with N integer with values ranging from 1 to N. 
 * there is only one duplicate in the Array.
	Find out Duplicate value.
	i.e. 
	A = { 10,6,3,4,7,5,2,4,9,1}

	values from 1 to 10.
	in this example, Duplicate element is 4.

	N could be quite large.*/

public class TheDuplicatedNumber {

	//The basic idea is to putting number onto the position where it should be.
	//It means that a[0]=1, a[1]=2,...a[N-1]=N
	//To do that, visit every unit in loop, 
	//if a number a[i]=x is not in position, put it to correct position a[x-1]=x,
	//and move the number at a[x] to its position.
	//During this process, if a number is put to a position that is set already,
	//that number will be the
	//duplicated one.
	public static int solve(int[] a){
		
		int index2Set = 0;
		int indexOfDup = -1;
		for (int i = 0; i < a.length; i++) {
			
			if(indexOfDup!=-1) return indexOfDup;
			if(a[i]==i+1) continue;//in place
			
			while (a[i]!=i+1) {
				index2Set = a[i]-1;
				if(a[index2Set] == index2Set+1) {
					indexOfDup=(index2Set+1);
					break;
				}
				a[i]=a[index2Set];//keep value of number to be handled
				a[index2Set]=index2Set+1;//set right value for that unit	
			}
		}
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(TheDuplicatedNumber.solve(new int[]{1,6,3,4,7,5,2,8,10,9,11}));
	}

}
