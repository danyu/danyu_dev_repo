package danyu.math;

public class RootFinding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bisection();
	}

	public static double f(double x) {
		return x * x * x;
	}

	public static void bisection() {
		// set a proper set of initial values
		double tol = 1e-3, a = 0, b = 3, x = 0, dx = b - a;
		int k = 0;
		while (dx > tol) {
			x = (b + a) / 2;
			if (f(x) * f(a) < 0) {// means f(a)<0
				b = x;
			} else {
				a = x;
			}
			dx = b - a;
			k++;
		}
		// print out result
		System.out.println("X = " + x);
		System.out.println("Iteration number = " + k);
	}

	public static void newton() {

	}

	public static void secant() {

	}

}
