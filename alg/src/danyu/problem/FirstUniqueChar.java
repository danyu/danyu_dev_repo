package danyu.problem;

//find the first unique char in O(n)
public class FirstUniqueChar {

	public void locateFirstUniqueChar(String str){
		
		System.out.println("Input = ( "+str+" )");
		int UNUSED=-2,DUPLICATED=-1;
		int[] locas=new int[26];
		for (int i=0; i<locas.length;i++) locas[i]=UNUSED;
		
		for (int i=0;i<str.length();i++){
			int idx=str.charAt(i)-'a';
			if (locas[idx]==UNUSED)
				//save location of current char on its first appearance
				locas[idx]=i;
			else
				locas[idx]=DUPLICATED;
		}
		
		//go through locations to find out the first one
		int min=DUPLICATED;
		for (int i=0;i<locas.length;i++){
			//save the first valid location
			if (min == DUPLICATED && locas[i] > 0)
				min = locas[i];
			//then save earlier location based on comparison
			if (locas[i] != DUPLICATED && locas[i] != UNUSED && locas[i] < min)
				min = locas[i];
		}
		
		// print result
		String result = min != DUPLICATED ? "Output = "
				+ str.charAt(min) : "Output = No result.";
		System.out.println(result);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
              (new FirstUniqueChar()).locateFirstUniqueChar("abcdefbacfed");
	}

}
