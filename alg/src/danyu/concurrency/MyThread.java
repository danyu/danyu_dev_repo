package danyu.concurrency;



public class MyThread implements Runnable {
	

	private int myInt;
	private boolean isSynchronized;
	public MyThread (int i, boolean isSync){
		this.myInt=i;
		isSynchronized=isSync;
	}
	
	public void incre(){
		int j=0;
		while (j < 3) {
			myInt++;
			j++;
			System.out.println(myInt + " by Thread " +Thread.currentThread().getId());
		}
	}
	
	public void increUnsync(){
		incre();
	}
	
	public synchronized void increSync(){
		incre();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(isSynchronized)
			increSync();
		else
		increUnsync();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0;
		boolean isSync = false;
		MyThread dl1 = new MyThread(0, isSync);
		Thread t1 = new Thread(dl1);
		Thread t2 = new Thread(dl1);
		t1.start();
		t2.start();
		// Integer

		// dl1.increUnsync();

		System.out.println(" hello from Thread "
				+ Thread.currentThread().getId());
	}

	
}
