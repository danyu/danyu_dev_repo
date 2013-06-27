package danyu.leetcode;

import danyu.problem.Sum2;

/*
 * Given an array S of n integers, find three integers in S 
 * such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * */

public class ThreeSumClosest {

	public static int solve(int[] num, int target){
		
		num=Sum2.sort(num);
		
		int tempSum = 0;
		int closerSum = num[num.length - 1] + num[num.length - 2]
				+ num[num.length - 3];
		int diff = closerSum - target;
		int newDiff;
		int head = 0, mid = 0, tail = num.length - 1;

		while(head<tail){
			mid=head+1;
			tail=num.length-1;
			
			while(mid<tail){
				
				tempSum = num[head] + num[mid] + num[tail];
				newDiff = tempSum - target;
				
				if (Math.abs(diff) > Math.abs(newDiff)) {
					diff = newDiff;
					closerSum = tempSum;
				}
				if (diff == 0) {
					// ideal solution
					System.out.println("Closest = " + target);
					return target;

				} else if (tempSum > target) {
					tail--;
					while(tail>mid && num[tail]==num[tail+1])
					tail--;

				} else {
					mid++;
					while(tail>mid && num[mid]==num[mid-1])
					 mid++;
				}
			}
			head++;
			while(head>0 && head <tail && num[head]==num[head-1])
				head++;
			
		}
		
		System.out.println("Closest = "+ closerSum);
		return closerSum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           ThreeSumClosest.solve(new int[]{1,1,1,-1,2,-4}, 1);
           ThreeSumClosest.solve(new int[]{1,1,1,-1,2,-4,10}, 100);
           ThreeSumClosest.solve(new int[]{0,0,0}, 1);
           ThreeSumClosest.solve(new int[]{-77,-33,0,29,30,31,31,31,99,100}, 1);
           
	}

}
