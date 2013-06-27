package danyu.problem;

import java.util.ArrayList;
import java.util.List;

//find median in O(n)
//use two pointers/cursors
public class FindMedian {

	//assume that array is
	public static int median(Integer[] a){
		int pt1=0,pt2=0;
		int last_pt2=pt2;
		while(a[pt2]!=null){
			last_pt2=pt2;
			
			pt1+=1;
			pt2+=2;
		}
		
		return 0;
	}
	
	
}
