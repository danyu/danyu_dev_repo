package danyu.problem;

public class TowersOfHanoi {

	static int NUM_PEGS=3;
	
	/*
	 * From Algorithms in Java, Third Edition, Parts 1-4: Fundamentals, Data
	 * Structures, Sorting, Searching 
	 * 
	 * We shift the tower of disks to the right
	 * by (recursively) shifting all but the bottom disk to the left, then
	 * shifting the bottom disk to the right, then (recursively) shifting the
	 * tower back onto the bottom disk.
	 */
	static void hanoi(int disk, int direction){
		if(disk==0) return;
		//move away the one on the top of disk
		hanoi(disk-1, -direction);
		//move diskX to destination
		shift(disk,direction);
		//finish rest disks
		hanoi(disk-1,-direction);
	}
	
	static void shift(int N,int direc){
		System.out.printf("hanoi(%d, %d)\n",N,direc);
		
	}
	
	static void solve(int numOfDisks) {
		//hanoi(numOfDisk, -1)
		hanoi(numOfDisks, -1);
	}

	public static void main(String[] args){
		TowersOfHanoi.solve(3);
	}
	
}
