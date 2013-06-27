package danyu.problem;

import danyu.alg.util.ArrayHelper;

/*Rotate a N by N matrix clockwise by 90 degree.
 * 
 *  E.g.
 *       a                      a'
 *  --------------       ---------------     
 *    1  2  3  4          10  11  12  1
 *   12  1  2  5   to      9   4   1  2        
 *   11  4  3  6   =>      8   3   2  3
 *   10  9  8  7           7   6   5  4
 *  --------------       ---------------    
 *   
 *   that is: a[0][0]=a'[0][3]=1
 *            a[2][0]=a'[0][1]=11
 *            a[3][1]=a'[1][0]=9
 *            a[2][2]=a'[2][1]=3
 * */



public class MatrixRotation {

	
	public static Integer[][] Rotate90Clock(Integer[][] mx){
	    
		int rows=mx.length;
		int cols=mx[0].length;
		Integer[][] result_mx=new Integer[rows][cols];
		
		for(int r=0;r<rows;r++)
			for(int c=0;c<cols;c++)
			result_mx[c][rows-r-1]=mx[r][c];		
		
		System.out.println("After rotation 90 clock");
		return result_mx;
	}
	
	public static void main (String[] args){
		
		Integer[][] mx={{1,2,3,4},{12, 1,2,5},{11,4,3,6},{10,9,8,7}};
		ArrayHelper.printMatrix(mx);
		mx=MatrixRotation.Rotate90Clock(mx);
		ArrayHelper.printMatrix(mx);
		mx=MatrixRotation.Rotate90Clock(mx);
		ArrayHelper.printMatrix(mx);
		mx=MatrixRotation.Rotate90Clock(mx);
		ArrayHelper.printMatrix(mx);
		mx=MatrixRotation.Rotate90Clock(mx);
		ArrayHelper.printMatrix(mx);
		
	}
	
}
