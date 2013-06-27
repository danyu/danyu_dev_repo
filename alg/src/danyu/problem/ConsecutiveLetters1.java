package danyu.problem;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveLetters1 {

	public static void doIt(String str){
		ArrayList<String> segs=getSegs(str);
		printSegs(segs);
		
		String maxConsec="";
		
		
	}
	
	public static ArrayList<String> getSegs(String str){
		
		char[] chs=str.toCharArray();
		//separated
		ArrayList<String> segs=new ArrayList<String>();
		
		for (int i = 0; i < chs.length; i++) {
			if (segs.size() == 0) {
				segs.add(String.valueOf(chs[i]));
				continue;
			}
            String lastSeg=segs.get(segs.size() - 1);
            int indxOfCurrCh=lastSeg.indexOf(chs[i]);
			if (indxOfCurrCh>-1) {
				// a repeated letter, create a new segment
				String temp = lastSeg.substring(indxOfCurrCh+1);
				segs.add(temp + String.valueOf(chs[i]));

			} else {
				// if nor repeated, add to the last string in segs
				//segs.get(segs.size() - 1).concat(lastSeg+String.valueOf( chs[i]));
				lastSeg+=chs[i];
				//update segs
				segs.set(segs.size() - 1, lastSeg);
			}
		}

		return segs;
	}
	
	public static boolean isContained(String str, char ch){
		if(str==null)return false;
		else return str.indexOf(ch)!=-1;
	}
	
	public static void printSegs(ArrayList<String>  strs){
		
		for(String str: strs)
			System.out.println(str);
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(ConsecutiveLetters1.isContained("abcd", 'a'));
		String[] cases={"hllsacefgdbdfdfdffd","adbec","abcdcaboq"};
		int caseNum=1;
		for(String str:cases){
			System.out.println("---Case#"+(caseNum++));
			ConsecutiveLetters1.doIt(str);
		}
		
	}

}
