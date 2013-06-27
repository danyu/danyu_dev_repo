package danyu.leetcode;

public class AddBinary {

	// O(n)
	public static String solve(String b1, String b2) {
		int i1 = 0;
		for (int i = 0; i < b1.length(); i++)
			i1 = b1.charAt(i) == '0' ? (i1 * 2) : (i1 * 2 + 1);
		int i2 = 0;
		for (int i = 0; i < b2.length(); i++)
			i2 = b2.charAt(i) == '0' ? (i2 * 2) : (i2 * 2 + 1);

		int sum = i1 + i2;
		String result = "";
		while (sum != 0) {
			result = (sum % 2) + result;
			sum = sum >> 1;
		}

		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          System.out.println( AddBinary.solve("1011", "111"));
	}

}
