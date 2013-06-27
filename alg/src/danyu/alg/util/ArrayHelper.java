package danyu.alg.util;

public class ArrayHelper {

	private static String separator="============================";
	
	public static void printArray(Object[] array) {
		System.out.print("[");
		for (Object x : array) {
			System.out.print(x.toString() + " ");
		}
		System.out.print("]\n");
	}
	
	public static String arrayToString(Object[] array) {
		String str="";
		str+="[-";
		for (Object x : array) {
			str+=x.toString() + "-";
		}
		str+="]\n";
		return str;
	}

	public static void printMatrix(Object[][] mx) {
		int rows = mx.length;
		int cols = mx[0].length;

		for (int r = 0; r < rows; r++) {

			for (int c = 0; c < cols; c++) {
				System.out.print(mx[r][c].toString() + " ");
			}
			System.out.println(" ");
		}
		System.out.println(separator);
	}
}
