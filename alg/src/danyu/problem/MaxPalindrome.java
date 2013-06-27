package danyu.problem;

/* find the longest palindrome in a string
 i.e., abcba, efe are a palindrome
 Input = abbad, Output= abba
 input = cfcddcfg Output = fcddcf 
*/ 
public class MaxPalindrome {

	public static void doIt(String str) {

		// String stores max palindrome
		String maxP = "";

		// start from the center point
		int center, left, right;
		
		// change position
		for (center = 1; center < str.length()-1; center++) {
			left = center;
			right = center;
			
			while ( left > -1 && right < str.length()) {
				
				char cCh=str.charAt(center);
				//char lCh=str.charAt(left);
				//char rCh=str.charAt(right);
				
				//handle duplicated letters
				while (cCh==str.charAt(left)) left--;
				while (str.charAt(right)==cCh) right++;
				
				// check if out of boundary
				/*if (right > str.length() - 1 || left < 0) {
					left++;
					right--;
					break;
				}
*/
				if (str.charAt(left) != str.charAt(right) ||(right > str.length() - 1 || left < 0) ){ 
					// if not symmetric, this try ends
					//go back to previous position
					left++;
					right--;
					break;
				}
				
				// check if on the boundary
				if(right>=str.length()-1 ||left<=0) break;
				left--;
				right++;
			}
			// update only if longer palindrome is found.
			if (right - left + 1 > maxP.length())
				if(right==left) maxP=Character.toString(str.charAt(right));
				else maxP = str.substring(left, right+1);

		}

		System.out.println("Result="+maxP);
	}

	public static void main(String[] args) {

		MaxPalindrome.doIt("abccbad");
		MaxPalindrome.doIt("cfcddcfg");
		MaxPalindrome.doIt("cfcdcfg");
		
	}

}
