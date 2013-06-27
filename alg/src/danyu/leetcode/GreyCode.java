package danyu.leetcode;

import java.util.ArrayList;

/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2*/

//^_^ Passed
public class GreyCode {
	
	
	 public ArrayList<Integer> grayCode(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<Integer> result=new ArrayList<Integer>();
	        grayCode(n, result);
	        return result;
	}
	//recursive  
	public void grayCode(int n,ArrayList<Integer> result) {
	 
		 if(n==0) result.add(0) ;
		 else{
			ArrayList<Integer> temp= new ArrayList<Integer>();
			grayCode(n-1,temp); 
			int max=1<<(n-1);
			result.addAll(temp);//add half solutions
			for(int i=temp.size()-1;i>-1; i--) result.add(temp.get(i)|max);
		 }
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(0|1);
        new GreyCode().grayCode(3);
	}

}
