package danyu.problem;

import java.util.ArrayList;

public class AllPermutations {
	// static ArrayList<String> result;

	static void doIt(String str) {
		permutation(str);
	}

	static ArrayList<String> permutation(String str) {
		if (str == null)
			return null;
		ArrayList<String> result = new ArrayList<String>();
		if (str.length() <= 1) {
			result.add(str);
		} else if (str.length() == 2) {
			result.add(str.substring(0, 1) + str.substring(1));
			result.add(str.substring(1) + str.substring(0, 1));
		} else if (str.length() > 2) {
			ArrayList<String> perSub = permutation(str.substring(1));
			for (int l = 0; l < perSub.size(); l++) {
				String temp = perSub.get(l);
				result.add( str.substring(0, 1)+temp );
				for (int i = 0; i < temp.length(); i++) {
					result.add(temp.substring(0, i + 1) + str.substring(0, 1)
							+ temp.substring(i + 1));
				}
				//result.add(temp + str.substring(0, 1));
			}
		}
		return result;
	}
	
	static String level="";
	static void permutationV2(Character[] str, int k, int m){
		printTrace(str);
		level+="=>";
		if (k==m) {
			printChars(str);		
		}
		else{
			for(int i=k;i<=m;i++){
				swap(str,k,i);				
				permutationV2(str, k+1, m);
				swap(str,k,i);
				printTrace(str);
			}
		}
		level=level.replaceFirst("=>", "");
	}
	
	static void printChars(Character[] str){
		for(int i=0;i<str.length;i++)
			System.out.print(str[i]);
		System.out.print("\n");
	}
	
	static void printTrace(Character[] str){
		System.out.print(level);
		printChars(str);
	}
	
	public static void swap(Character[] ch, int i, int j){
		char temp=ch[i];
		ch[i]=ch[j];
		ch[j]=temp;
		System.out.print("*Swap "+ch[j]+"<->"+ch[i]+" \n");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String str = "1234";
		//ArrayList<String> result = AllPermutations.permutation(str);
		//System.out.println(result);
		Character [] str={'a','b','c'};
		//AllPermutations.swap(str,1,3);
		AllPermutations.permutationV2(str, 0,2);
	}

}
