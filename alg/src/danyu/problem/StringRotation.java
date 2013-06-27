package danyu.problem;


/*   Rotation of a string is defined as following:
 * ---------------------------------------
 * |  For str1 = "abcdef"
 * |  If  str2 = "defabc" 
 * |  Then str2 is a rotation of str1.
 * |  Also "bcdefa" is another rotation of str1.
 * ---------------------------------------
 * 
 *   (!) Assume strX.indexOf(strY) can only be used once to check if strX has substring 
 *       as strY, how to find out if one string is a rotation of another.
 * */
public class StringRotation {

	
	
	public static boolean isRotation(String str_original, String str_rotation){
		
		/*Tips:
		 * (1) concat str1 with itself get, "abc defabc def".
		 *                               -----> |defabc|
		 *                               | 
		 *                               |  
		 * (2) then it is easy to see str2 is there as shown in line above.
		 * 
		 * */
		return str_original.concat(str_original).indexOf(str_rotation)!=-1;
	}
	
	public static void main(String[] args){
		
		String str1="abcdef";
		String str2="defabc";
		String str3="defcab";
		
		System.out.println(isRotation(str1,str2));
		System.out.println(isRotation(str1,str3));
	}
	
	
}
