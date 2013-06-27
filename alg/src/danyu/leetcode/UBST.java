package danyu.leetcode;


/*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   */

public class UBST {

	public int numTrees(int n) {
        return t(n); 
    }
    
	//recursive
	//t(n)=2*(t(n-1)+t(n-2)*t(1)+t(n-3)*t(2)......
    public int t(int n){
        if (n==0 || n==1) return 1; //stopping condition
        else if(n==2) return 2;//stopping condition
        else {
	        
        	boolean isEven=(n%2==0);
	        int mid=n/2;
	        if(!isEven) mid++;
	        int sum=0;
	        for (int i=1;i<mid;i++) sum+= 2*t(i-1)*t(n-i);
	        if (isEven) sum+=2*t(mid-1)*t(n-mid);
	        else sum+=t(mid-1)*t(n-mid);
	        
	        return sum;
        
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
