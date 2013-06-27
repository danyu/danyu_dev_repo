package danyu.problem;

public class OddTimeNumber {

	public static int solve(int[] a){
		
		int result=0;
		result=a[0];
		for (int i =1;i< a.length;i++){
			result=result^a[i];
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.out.println(	OddTimeNumber.solve(new int[]{1,2,2,5,7,2,2,1,5}));
		
	}

	
}
