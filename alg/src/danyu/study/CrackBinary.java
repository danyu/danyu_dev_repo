package danyu.study;

public class CrackBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int positive =123;
		int negative=-1, negative1=-2;
		int base=0x7FFFFFFF;
		System.out.println(Integer.toBinaryString(base));
		
		//int non_negative=-234;
		
		positive=positive & 0x7FFFFFFF;
		System.out.println(Integer.toBinaryString(positive));
		System.out.println(Integer.toBinaryString(negative));
		negative=negative & 0x7FFFFFFF;
		System.out.println(Integer.toBinaryString(negative));
		negative1=negative1 & 0x7FFFFFFF;
		System.out.println(positive+", "+negative);
		
		System.out.println("2|1 = "+ (2|1));
		System.out.println("2&1 = "+ (2&1));
	}

}
