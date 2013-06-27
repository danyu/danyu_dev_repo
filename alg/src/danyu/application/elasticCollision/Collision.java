package danyu.application.elasticCollision;

import java.awt.Color;

import danyu.application.AppDraw;
import danyu.application.AppRandom;

public class Collision {

	private static final int NUM_BALL=3;
	private static final int RADIUS=3;
	private static final int SPEED_FACTOR=10;
	private static final int UP_SPEED=10;
	private static final int INTERVAL_OF_MOVE=30;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppDraw.createPanel();
		Ball[] balls=new Ball[NUM_BALL];
		for (int i=0;i<NUM_BALL;i++){
			balls[i]=new Ball(AppRandom.random(0.1,0.9)*AppDraw.PANEL_W,
					AppRandom.random(0.1,0.9)*AppDraw.PANEL_H,
					RADIUS);
		    balls[i].setSpeed(AppRandom.random(0.1,0.5)*SPEED_FACTOR, 
		    		AppRandom.random(0.1,0.5)*SPEED_FACTOR);
		}
		AppDraw.show();
		
		for (int i=0;i<NUM_BALL;i++)
		AppDraw.fillCircle((int)balls[i].center_x, 
				(int)balls[i].center_y, 
				(int)balls[i].r, 
				Color.BLUE);
		
		while(true){
			try {
				Thread.currentThread().sleep(INTERVAL_OF_MOVE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AppDraw.clean();
			for (int i=0;i<NUM_BALL;i++){
				balls[i].move();
				AppDraw.fillCircle((int)balls[i].center_x, 
						(int)balls[i].center_y, 
						(int)balls[i].r, 
						Color.BLUE);
			}
		}
		
	}

}
