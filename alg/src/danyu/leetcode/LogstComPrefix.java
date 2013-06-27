package danyu.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class LogstComPrefix {
     
	//sort and find
	 public String longestCommonPrefix(String[] strs) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 
		 if (strs.length==0) return "";
		 if (strs.length==1) return strs[0];
		 
	     ArrayList<String> s=new ArrayList<String>();
	     for (String str:strs) s.add(str);   
		 Collections.sort(s);
		 String LCP=null, tempLCP="";
		 for(int i=0;i<s.size()-1;i++){
			 tempLCP=commonPrefix(s.get(i), s.get(i+1));
			 if(LCP==null) LCP=tempLCP;
			 else LCP=commonPrefix(LCP,tempLCP);
			 if(LCP.length()==0) break;//the dead end
		 }
		 
		 return LCP;
	    }
	
	 private String commonPrefix(String str1, String str2){
		 int l=Math.min(str1.length(), str2.length());
		 String comPrefix="";
		 for(int i=0;i<l;i++){
			 if(str1.charAt(i)==str2.charAt(i))
				 comPrefix=comPrefix+str1.charAt(i);
			 else
				 break;
		 }
		 return comPrefix;
	 }
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String[] strs=new String[]{""};//{"fdsafdsafs","asdff","abb","zzzz","xxxxx","xxa","abc","zzza"};
         new LogstComPrefix().longestCommonPrefix(strs);
	}

}
