package danyu.alg.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GraphicsHelper {

	
   public static  void drawLine(int x1, int y1, int x2, int y2,int radius, Color c, Graphics g){
		
		if (g == null)
			return;
		g.setColor(c);
		g.drawLine(x1, y1, x2, y2);
		
	}
	
	public static  void drawLink(int x1, int y1, int x2, int y2,int radius, Color c, Graphics g){
		
		if (g==null) return;
		g.setColor(c);
		int adjust=(int)(radius*0.8);
		if(x1<=x2)
		    g.drawLine(x1+adjust,y1+adjust,x2-adjust,y2-adjust);
		else
			g.drawLine(x1-adjust,y1+adjust,x2+adjust,y2-adjust);
	}
	public static void drawCircle(int center_x, int center_y, int radius, Color c, Graphics g){
		
		if (g==null) return;
		g.setColor(c);
		g.drawOval(center_x-radius,center_y-radius, 2*radius, 2*radius);
		
	}
	
	public static void fillCircle(int center_x, int center_y, int radius, Color c, Graphics g){
	    
		if (g==null) return;
		g.setColor(c);
		g.fillOval(center_x-radius,center_y-radius, 2*radius, 2*radius);
	}
	
	/**
	 * @param center_x
	 * @param center_y
	 * @param radius
	 * @param fill, the degree that string fills the out circle.
	 * @param str
	 * @param c
	 * @param g
	 */
	public static void drawKey(int center_x, int center_y,int radius, double fill,String str, Color c, Graphics g){
		g.setColor(c);
		int len=str.length();
		int size=(int)(radius*2*fill);
		g.setFont(new Font(Font.SANS_SERIF,0,size));
		//g.setColor(Color.GREEN);
		g.drawString(str, center_x-size*len/4,center_y+size/3);
	}
	
	public static void fillSquare(int x, int y, int l, Color c, Graphics g){
		if (g==null) return;
		g.setColor(c);
		g.fillRect(x,y, l, l);
	}
	
	public static void drawSquare(int x, int y, int l, Color c, Graphics g){
		if (g==null) return;
		g.setColor(c);
		g.drawRect(x,y, l, l);
	}
	
	public static void drawRect(int x, int y, int w, int h, Color c, Graphics g){
		if (g==null) return;
		g.setColor(c);
		g.drawRect(x,y, w, h);
	}
	
	public  static void drawStr(String str, int x, int y, Color c, Graphics offG) {

		//Graphics offG=drawPanel.getGraphics();
		if (offG == null)
			return;
		offG.setColor(c);
		offG.drawString(str, x, y);

	}
	
	
}
