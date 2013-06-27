package danyu.leetcode;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 * Analysis:
 * Methods(1)
 *  "abcdcbabc"  ---reverse-->   "cbabcdcba"
 *   sub strings are:
 *   abcdcbabc(a)                 cbabcdcba
 *    bcdcbabc                     babcdcba
 *     cdcbabc                      abcdcba(a)
 *      dcbabc                       bcdcba
 *       cbabc                        cdcba
 *        babc                         dcba
 *         abc                          cba
 *          bc                           ba
 *           c                            a
 *           
 *  Then sort all these sub strings to find the longest common prefix
 *  
 *  Methods(2)
 *  Palindromic string is symmetric.
 *  This method checks each char each time from head to tail.
 *  During checking a char, which is the shortest palindrom, 
 *  it expands by adding neibourgh (left and right) chars, 
 *  and checks if symmetry stays. If YES, keep going, if NO, stop right there.
 * 
 *  IMPORTANT, good handling of sub-string with repeated letters(e.g., "aaaaa","ffffffff") is critical.
 *    
 * */



public class LogstPalindrome {

	public String longestPalindrome(String s){
		String result ="";
		String temp;
		int start=s.length()/2;
		
		//start from center and check right half
		for( int i=start;i<s.length();i++){
			//straight to the end of single-letter sub-string
			while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)) i++;
			
			temp=checkChar(s, i);
			//update if longer palindrome is found
			if(temp.length()>result.length())result=temp;
			//Compare the length of existing palindrome
			//with possible largest length to see it is necessary to continue
			if(temp.length()>=(s.length()-i-1)*2+1) 
				break;
			if(temp.length()==s.length()) 
				return result;
		}
			
		for( int i=start-1;i>-1;i--){
			while(i>0 && s.charAt(i)==s.charAt(i-1)) i--;
			temp=checkChar(s, i);
			//update if longer palindrome is found
			if(temp.length()>result.length())result=temp;
			//Compare the length of existing palindrome
			//with possible largest length to see it is necessary to continue
			if(temp.length()>=(i*2+1)
					|| temp.length()==s.length()) 
				break;
		}
		
		return result;
	}
	
	//check each char and return longest palindrome
	//centered on this char
	public String checkChar(String s, int i){
		String result=""+s.charAt(i);
		int left=i-1, right =i+1;
		
		//if same chars
		while(left>-1)
			if(s.charAt(left)==s.charAt(i)) result=s.charAt(left--)+result;
			else break;
		while (right<s.length())
			if(s.charAt(right)==s.charAt(i)) result+=s.charAt(right++);
			else break;
		
		//check if symmetric
		while(left>-1 && right< s.length()){
			if(s.charAt(left)!=s.charAt(right)) break;
			else result=s.charAt(left--)+result+s.charAt(right++);
		}
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //System.out.println(new LogstPalindrome().longestPalindrome("aabcccdcccbaaaaaabccccccc"));
        System.out.println(new LogstPalindrome().longestPalindrome("FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}

}
