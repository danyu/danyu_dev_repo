package danyu.concurrency;

public class OneAfterAnother implements Runnable {

	private String thName;
	private Thread th=null;
	public OneAfterAnother(String theName){
		this.thName=theName;
	}
	
	
	public void setThread(Thread th){
		this.th=th;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneAfterAnother r1=new OneAfterAnother("t1");
		Thread t1=new Thread(r1);
		//r1.setThread(t1);
		
		OneAfterAnother r2=new OneAfterAnother("t2");
		Thread t2=new Thread(r2);
		r2.setThread(t1);
		
		OneAfterAnother r3=new OneAfterAnother("t3");
		Thread t3=new Thread(r3);
		r3.setThread(t2);
		
		OneAfterAnother r4=new OneAfterAnother("t4");
		Thread t4=new Thread(r4);
		r4.setThread(t3);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			//Thread.sleep(1000);
			
			if(th!=null)
				th.join();
			System.out.println("->"+thName);
			//System.out.println("-<"+thName);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
