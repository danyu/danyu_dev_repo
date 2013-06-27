package danyu.leetcode;

public class ClimblingStairs {

	/*
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * Each time you can either climb 1 or 2 steps. 
	 * In how many distinct ways can you climb to the top?
	 * 
	 * */
	
	public static int solve(int n){
		
		int result=0;
		
		if (n==0) return result;
		
		int max=n;
		int min=n/2;
		
		for(int i=0;i<=min;i++)
		   result+=combination(max-i, i);
		
		return result;
	}
	
	//return (n-1)(n-2)...(n-i)/(1*2*3...*i)
	public static int combination(int n, int i){
		
		double p=1;
		double q=1;

		for (int m=0;m<i;m++){
			p*=(n-m);
			q*=	(m+1);
			
			//remove common factors to prevent overflow
			while (p % 2 == 0 && q % 2 == 0) {
				p = p / 2;
				q = q / 2;
			}
			
			while (p % 3 == 0 && q % 3 == 0) {
				p = p / 3;
				q = q / 3;
			}
				
		}
		
		return (int)(p/q);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         System.out.println(ClimblingStairs.combination(3,2));
//         System.out.println(ClimblingStairs.combination(4,1));
//         System.out.println(ClimblingStairs.combination(4,2));
//         System.out.println(ClimblingStairs.combination(4,3));
//         System.out.println(ClimblingStairs.solve(3));
//         System.out.println(ClimblingStairs.solve(4));
//         
         System.out.println(ClimblingStairs.solve(0));
         System.out.println(ClimblingStairs.solve(1));
         System.out.println(ClimblingStairs.solve(2));
         
         System.out.println(ClimblingStairs.solve(35));
         System.out.println(ClimblingStairs.solve(44));
         System.out.println("Integer.MAX_VALUE = "+Integer.MAX_VALUE);
         
         //1134903170
         //2147483647
         
	}

}
