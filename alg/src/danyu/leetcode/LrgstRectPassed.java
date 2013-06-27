package danyu.leetcode;


/**
 * Find the biggest internal rectangle of a histogram
 * 
 * */
public class LrgstRectPassed {

	public int doIt(int[] height){
		int maxRect=0, start=0,end=0;
	    int tempStart=0,tempEnd=0,tempMax=0,tempMin=0;    
	    //O(n)
	    //For
		for(int i=0;i<height.length;i++){
			
			// looking for start point
			tempStart=i;
			tempEnd=i;
			tempMax=i;
			
			for (int m = i - 1; m >= 0; m--) {
				if (height[m] < height[i]) {
					tempStart = m+1;
					break;
				}
				else {
					tempStart=m;
					if(height[tempMax]< height[m]) tempMax=m ;
				}
			}
			// looking for end point
			// O(n)
			for (int m = i + 1; m < height.length; m++) {
				if (height[m] < height[i]) {
					// min=hist[i];
					tempEnd = m-1;
					break;
				}else	{
					tempEnd=m;
					if(height[tempMax]< height[m]) tempMax=m ;
				}
			}
					
			//new bigger rectangle found, then update
			int s=height[i]*(tempEnd-tempStart+1);
			if(s>maxRect){		
				maxRect=s;
				start=tempStart;
				end=tempEnd;
			}
			//***Important improvement: check if it is a same-height area
			//If YES, jump to end.
			if(i==tempMax) i=tempEnd;			
		}
		
		return maxRect;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         new BiggestHistogram().doIt(new int[]{5,4,4,
//        		 4,4,4,
//        		 4,4,4,
//        		 4,4,4,
//        		 4,4,4});
       System.out.println( new LrgstRectPassed().doIt(new int[]{2,1,2}));
         
	}

}
