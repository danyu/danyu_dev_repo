package danyu.application;

public class AppRandom {

	/**
	 * @param l lower bound
	 * @param h upper bound
	 * @return a random double value locates between l and h.
	 */
	public  static double random(double l, double h){
		double result=Math.random();
		while(result<l || result >h){
			result=Math.random();
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
