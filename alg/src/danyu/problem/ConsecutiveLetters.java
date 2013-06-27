package danyu.problem;

import java.util.ArrayList;

//????unfinished

/* Problem description:
 * Say there is a string 
 *                'hllsacefgdbdfdfdffd'
 * You need to find the biggest string that has all consecutive characters.
 * Consecutive string might have jungled words, 
 * i.e 'acb' is also continuous or 
 *     'bcad' is also continuous
 * 
 * Solution:
 * (1) check letters one by one from left to right
 * (2) put letters that can be connected IMMEDIATELY into the same string 
 * (3) check existing strings, and connect those that are consecutive.
 * 
 * */



public class ConsecutiveLetters {

	private ArrayList<ArrayList<Character>> consecutives;
	private String targetStr;

	public ConsecutiveLetters(String targetStr) {
		consecutives = new ArrayList<ArrayList<Character>>();
		this.targetStr = targetStr;
	}

	public String findBiggestConsecutiveString() {
		String rsltStr = new String();

		for (int i = 0; i < targetStr.length(); i++) {
			connChars(targetStr.charAt(i));
		}

		return rsltStr;
	}

	// if can be connected, connect.
	// if NOT, create a new string.
	public void connChars(Character currChar) {
		// only check the last string
		if (consecutives.size() == 0) {
			createNewStr(currChar);
		} else {
			ArrayList<Character> temp = consecutives
					.get(consecutives.size() - 1);
			// check if can be connected

			// check if can be put before first character
			if (temp.get(0) - currChar == 1){
				temp.add(0, currChar);
				connStrs();
			}// check if can be put after last character
			else if (currChar - temp.get(temp.size() - 1) == 1){
				temp.add(currChar);
				connStrs();
			}
			else
				createNewStr(currChar);
		}
	}

	public void createNewStr(Character currChar) {
		ArrayList<Character> newStr = new ArrayList<Character>();
		newStr.add(currChar);
		consecutives.add(newStr);
	}

	// check and adjust existing consecutive strings
	// only check neighbor strings
	public void connStrs() {
		if (consecutives.size() <= 1)
			return;

		ArrayList<Character> str1 = consecutives.get(consecutives.size() - 2);
		ArrayList<Character> str2 = consecutives.get(consecutives.size() - 1);
		if (str1.get(str1.size() - 1) - str2.get(0) == -1) {
			// then str1 + str2
			consecutives.remove(consecutives.size() - 1);
			consecutives.remove(consecutives.size() - 1);
			str1.addAll(str2);
			consecutives.add(str1);
			connStrs();
		} else if (str2.get(str2.size() - 1) - str1.get(0) == -1) {
			// then str2 + str1
			consecutives.remove(consecutives.size() - 1);
			consecutives.remove(consecutives.size() - 1);
			str2.addAll(str1);
			consecutives.add(str2);
			connStrs();
		}
	}

	public void printAllStrs(){
		for (ArrayList<Character> s:consecutives){
			System.out.println(s);
		}
	}
	
	public ArrayList<Character> getLargestString() {
		int maxIndx=-1;
		
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] cases={"hllsacefgdbdfdfdffd","adbec","abcdcaboq"};
		ConsecutiveLetters cl = new ConsecutiveLetters(cases[1]);
		cl.findBiggestConsecutiveString();
		cl.printAllStrs();

	}

}
