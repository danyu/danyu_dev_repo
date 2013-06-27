package danyu.concurrency;

import java.io.IOException;

public class CakeMakerEater {

	private static Oven oven=new Oven();
	private static int quantityOfCake=5;
	
	public void run(){
		CakeMaker cakeMaker=new CakeMaker();
		CakeEater cakeEater=new CakeEater();
		Thread makerThd=new Thread(cakeMaker);
		Thread eaterThd=new Thread(cakeEater);
		
		makerThd.start();
		eaterThd.start();
		
		try {
			makerThd.join();
			eaterThd.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		CakeMakerEater sample=new CakeMakerEater();
		sample.run();
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public class CakeMaker implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<quantityOfCake;i++)
				oven.bake(i);
		}
	}
	
	public class CakeEater implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<quantityOfCake;i++)
				oven.take();
		}
		
	}
	
	public static class Oven{
		int quantityOfCake=0;
		boolean isTimeToBaking=true;
		public synchronized void bake(int q){
			synchronized(this){
				if(!isTimeToBaking){
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				isTimeToBaking=false;
				quantityOfCake=q;
				System.out.println("Make cake # "+quantityOfCake);
				notifyAll();
			}
		}
		
		public synchronized int take(){
			
				if(isTimeToBaking){
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				isTimeToBaking=true;
				System.out.println("Eat cake # "+quantityOfCake);
				notifyAll();
				return quantityOfCake;
			}
		}

}
