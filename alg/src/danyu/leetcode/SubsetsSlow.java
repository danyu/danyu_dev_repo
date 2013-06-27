package danyu.leetcode;


import java.util.*;
public class SubsetsSlow {

	public ArrayList<ArrayList<Integer>> subsets(int[] S){
		
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		
		if (S!=null) 
			if (S.length!=0) 
				result=subsets(result,S, 0, S.length-1);
		result.add(null);
		return result;
	}
	
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<ArrayList<Integer>> result,
    		int[] S, int start, int end){

    	 	
    	if(start==end){
    		ArrayList<ArrayList<Integer>> sets=new ArrayList<ArrayList<Integer>>();
    		addSet(sets, S, start,start);
    		return sets;
    	}
		if(start==end-1){
			//If there are only two elements,
			//stop recursive.
			ArrayList<ArrayList<Integer>> sets=new ArrayList<ArrayList<Integer>>();
			addSet(sets, S, start, start);
			addSet(sets, S, end, end);
			addSet(sets, S, start, end);
			return sets;
		}else{
			//Split Set(from start to end) into A and B, 
			//where B = Last element, that is the element with index end
			//Add B, the last elements
			addSet(result, S, end, end);
			
			//Find subset inside A recursively
			ArrayList<ArrayList<Integer>> sets=new ArrayList<ArrayList<Integer>>();
			sets=subsets(sets,S,start,end-1);
			
			//Add subset of A into result
			addSets(result, sets);
			
			//Figure out combination of A and B
			ArrayList<ArrayList<Integer>> com=combine(sets,S[end]);
			
			//Add combination into result 
			addSets(result,com);
			
			return result;
		}
	}
    
    public void addSet(ArrayList<ArrayList<Integer>> result, int[] S, int start, int end){
    	ArrayList<Integer> temp=new ArrayList<Integer>();
    	for (int i = start; i <= end; i++) {
			temp.add(S[i]);
		}
		result.add(temp);
    }
    
    //add b into a
    public void addSets(ArrayList<ArrayList<Integer>> a,
    		ArrayList<ArrayList<Integer>> b){
    	for(int i=0;i<b.size();i++)
    		a.add((ArrayList<Integer>)b.get(i).clone());
    
    }
	
	//append B to the end of each A.get(i)
	public ArrayList<ArrayList<Integer>> combine(ArrayList<ArrayList<Integer>> A, int B){

		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		for (int i=0;i<A.size();i++){
			result.add((ArrayList<Integer>)A.get(i).clone());
			result.get(i).add(B);
		}
		return result;

	}
	
	public void printResult(ArrayList<ArrayList<Integer>> result) {
		for (int i = 0; i < result.size(); i++) {
			System.out.print("[");
			ArrayList<Integer> temp = result.get(i);
			if (temp==null) System.out.print("");
			else
				for (int j = 0; j < temp.size(); j++)
					System.out.print(temp.get(j));
			System.out.print("]\n");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SubsetsSlow ss=new SubsetsSlow();

		ss.printResult(ss.subsets(new int[]{1,2,3}));

	}

}
