package danyu.cciv;

/*
 * You are given two 32-bit numbers, N and M, and two bit positions, 
 * i and j. Write a method to set all bits between i and
 *  j in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
 *  EXAMPLE:
 *  Input: N = 10000000000, M = 10101, i = 2, j = 6
 *  Output: N = 10001010100
 *  
 *  */

public class cci05d01 {

	public static void solve(int m, int n, int start, int end) {

		String result = "";
		// int temp=m;
		int count = 0;
		while (m != 0) {
			// before start point, take m's bit value
			if (count < start || count > end) {
				result = m % 2 + result;

			} else {
				result = n % 2 + result;
				n = n >> 1;
			}
			m = m >> 1;
			count++;
		}

		System.out.println(result);

	}
	
	public static String toBinary(int m){
		String bStr="";
		//calculate length
		
		int temp=m;
		
		while (temp != 0) {
			//lenInBinary += 1;
			bStr = temp % 2+bStr;
			temp = temp >> 1;
		}
		
		return bStr;
	}
	
	public static void main(String[] args){
		cci05d01.solve(32, 8, 1, 4);
	}
	
}
