package danyu.application.elasticCollision;

import danyu.application.AppDraw;

public class Ball {

	
	public double center_x, center_y;
	public double r;
	private double hSpeed=0, vSpeed=0;

	public Ball(double x, double y, double radius) {
		center_x = x;
		center_y = y;
		r = radius;
	}

	public void setSpeed(double hSpeed, double vSpeed){
		this.hSpeed=hSpeed;
		this.vSpeed=vSpeed;
	}
	
	public void move(){
		
		if(center_x-r<0 || center_x+r>AppDraw.PANEL_W )hSpeed=-hSpeed;
		if(center_y-r<0 || center_y+r>AppDraw.PANEL_H )vSpeed=-vSpeed;
		center_x+=hSpeed;
		center_y+=vSpeed;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
