package danyu.problem;


/**mark the first appearance of 
 * each letter of a string in another string
 * 
 * e.g., input:      
 *              str1='abc'
 *              str2='abcc'
 *       Output:
 *              0 1 2 2
 * Following
 * */
public class FirstOccurOfStr {

	/**
	 * Assume the string only consists of letters 
	 * from the alphabetic table,
     * which means there are only 26 possible letters
	 * */
	
	public int[] firstPoses;
	public static void doIt(String str1, String str2){
		
		int SIZE_OF_ALPHABETIC = 26;
		int[] firstPoses = new int[SIZE_OF_ALPHABETIC];

		// initialize positions
		for (int i = 0; i < SIZE_OF_ALPHABETIC; i++)
			firstPoses[i] = -1;

		// check str1, takes O(n), n = length of str1
		for (int i = 0; i < str1.length(); i++) {
			int tempPos = str1.charAt(i) - 'a';
			// update position if current letter appear first
			if (firstPoses[tempPos] == -1)
				firstPoses[str1.charAt(i) - 'a'] = i;
		}

		// check str2, takes O(n), n = length of str2
		for (int i = 0; i < str2.length(); i++) {
			int tempPos = str2.charAt(i) - 'a';
			System.out.print(firstPoses[tempPos] + " ");
		}
		
	}
	
	//test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstOccurOfStr.doIt("mmabcbedfa", "axbfa");
	}

}
