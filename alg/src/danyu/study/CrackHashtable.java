package danyu.study;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class CrackHashtable {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		try {
			
			Hashtable t1 = new Hashtable();
			
			//System.out.println(t1.get(-1));
			for (int i=1;i<=58;i++){
				int temp=64+i;
				t1.put(i, (char)temp);
				System.out.print(t1.get(i).toString());
			}
		
			//System.out.println(t1.get(1).toString()+ (char)97);
			System.out.print("\n");
			String str="a";
			String str1="A";
			
			System.out.println(str.hashCode()+" "+str1.hashCode());
		} catch (Exception e) {
           
		}
		
	}

}
