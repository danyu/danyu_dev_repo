package danyu.leetcode;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * 
 * */
public class GenerateParenthesis {

	//^_^ Passed
	public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result=new ArrayList<String>();
        result=genRecursive(n);
        return result;
    }
	public ArrayList<String> genRecursive(int n){
		ArrayList<String> result=new ArrayList<String>();
		if(n==1) result.add(new String("()"));
		else if(n==2){ result.add(new String("(())"));result.add(new String("()()"));}
		else {
			ArrayList<String> temp=genRecursive(n-1);
			 for (int i=0;i<temp.size();i++) {			 
				 //make a valid one
				 String newComb="()"+temp.get(i);//put () at begining
				 char[] chars=newComb.toCharArray();
				 result.add(newComb);				 
				 for(int k=2;k<chars.length-1;k++)//then shift ')' to right to get new combinations	 
					 if (chars[k]=='('){
				    	chars[k-1]='(';
				    	chars[k]=')';
				    	newComb=new String(chars);
				    	if(!result.contains(newComb)) result.add(newComb);
				    }	 
			 }
		}
		return result;
	}
	
	///_\,Not Passed, it is not correct at all.
	public ArrayList<String> generateParenthesis1(int n){
		ArrayList<String> result=new ArrayList<String>();
		int N=2*n;
		char[] basic=new char[N];
		
		for(int i=0;i<n;i++) basic[i]='(';
		for(int i=n;i<2*n;i++) basic[i]=')';
		
		String newComb="";
		String revr="";
		for(int i=1;i<n;i++){
			basic[i]=')';
			for(int j=n;j<N-1;j++){
				basic[j]='(';
				newComb=new String(basic);
			    if (!result.contains(newComb)) result.add(newComb);
				basic[j]=')';
			}
			basic[i]='(';
		}	     
		
		return result;
	}
	
	public String reverse(char[] old){
		String r=new String();
		for(int i=old.length-1;i>=0;i--)
		     r+=old[i]=='('?')':'(';
		return r;
	}
	
	//Not Pass because of taking too long
	//***Permutation based methods, which works, but takes too long.
	public ArrayList<String> generateParenthesis2(int n){
		
		ArrayList<String> result=new ArrayList<String>();	
        Character[] a=new Character[2*n];	
		for(int i=0;i<n;i++) a[i]='(';
		for(int i=n;i<2*n;i++) a[i]=')';
		permutate(result, a, 0, a.length-1);
		return result;
	}	
	public void permutate(ArrayList<String> result,Character[]a, int start, int end ){
		
		if(start==end){
			if(isValid(a)){
		    String newComb=charToString(a);
		    if(!result.contains(newComb))result.add(newComb);
			}
		}
		else{
			for( int i=start;i<=end;i++){
				swap(a,start,i);//
				permutate(result,a,start+1,end);//swap rest
				swap(a,start,i);
			}		
		}
	}
	
	public String charToString(Character[] a ){
		String str="";
		for(int i=0;i<a.length;i++)
			str+=a[i];
		return str;
	}
	
	public boolean isValid(Character[] a){
		int l=0;
		int r=0;
		for(int i=0;i<a.length;i++){
			if(a[i]=='(') l++;
			else r++;
			if(r>l) return false;
		}
		return true;
	}
	
	public void swap(Character[] a, int i, int j){
		char temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	public void printResult(ArrayList<String> result){
		for(int i=0;i<result.size();i++) System.out.print(result.get(i)+',');
		System.out.print("\n");
		
	}
	
	public ArrayList<String> sub(int n){
		
		return null;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis gp=new GenerateParenthesis();
		gp.printResult(gp.generateParenthesis(4));
         
         //(((()))), ((()())), ((())()), ((()))(), (()(())) ,(()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()   
         //[(((()))), ((()())), ((())()), (()(())), (()()()), ((()))(), ()((())), (()())(), ()(()()), (())()(), ()(())(), ()()(()), ()()()()]
//		 int [] is=new int[]{99,1,2,3,4,5,6};
//		   for (int i=1;i<is.length;i++){
//			   is[i-1]=is[i];
//		       is[i]=99;
//		   }
	}
	
}
