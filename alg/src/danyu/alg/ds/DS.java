package danyu.alg.ds;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


/**
 * @author danyu_you
 *
 * Super class of all data structures.
 * 
 */
public abstract class DS<Key extends Comparable<Key> , Value> {

	public static int KEY_SIZE=20;
	public static int MAX_KEY=150;
	public static Integer[] ks=null;
	protected int size=0;
	public static Boolean DRAW_DATA=true;
	
	static{
		ks=DS.genExperimentalData(KEY_SIZE, MAX_KEY);
	}
	
	public enum DSType{
		Unkown,Stack, Queue, List,BinaryTree
	}
	public DSType getType(){
		return DSType.Unkown;
	}
	
	public void insert(Comparable k, Value v){	}
	
	public void delete(Key k){}
	
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public static void exch(Comparable[] a, int i, int j) {
       Comparable temp=a[i];
       a[i]=a[j];
       a[j]=temp;
	}
	
	public static void printElements(Comparable[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i].toString()+"  ");
		}
		System.out.print("\n");
	}
	
	public void setKeys(Comparable[] ks){
		
	}
	
	public static Integer[] genExperimentalData(int num, int max){
		Integer[] ks=new Integer[num];
		List<Integer> l=new ArrayList<Integer>();
		for( int i=0;i<num;i++){
			ks[i]=new Integer((int)(Math.random()*max));
			while(l.contains(ks[i]))
			  ks[i]=new Integer((int)(Math.random()*max));
		    l.add(ks[i]);
		}
		return ks;
	}
	
	public String toString(){
		return "Un-named";
	}
	
	public String description(){
		return "blar blar ... ";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//generate a color for node based on key and size
	public static Color calColor(Comparable key){
		int i=(Integer)key;
		int r=i%255;
		int g=(i*2)%255;
		int b=(i*3)%255;
		
		return new Color(r,g,b);
	}

}
