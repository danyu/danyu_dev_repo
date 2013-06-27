package danyu.application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;

public class AppDraw  {
	
	private static JFrame appFrm;
	private static JPanel panel;
	public static final int FRAME_W=420, FRAME_H=420;
	public static final int PANEL_W=400, PANEL_H=400;
	public  static final int gap=5;
	
	public static Graphics offScreen;
	private static Image mImage;
	
	private AppDraw() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void createPanel(){
		
		appFrm=new JFrame();
		appFrm.setMinimumSize(new Dimension(FRAME_W,FRAME_H));
		appFrm.setResizable(false);
		appFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel=new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setMinimumSize(new Dimension(PANEL_W, PANEL_H));
		
		appFrm.add(panel);
		
	}
	
	/**
	 * Set Size of AppDraw.
	 * @param w width of panel
	 * @param h height of panel
	 */
	public static void setSize(int width, int height){
		appFrm.setSize(width, height);
	}
	
	public static void show(){
		
		if (appFrm == null)
			createPanel();

		appFrm.pack();
		appFrm.setVisible(true);

	}
	
	public static void drawCircle(int center_x, int center_y, int radius, Color c){
		Dimension d = panel.getSize();
	    checkOffscreenImage();
		Graphics offG=panel.getGraphics();
		//offG.setColor(panel.getBackground());
	    //offG.fillRect(0, 0, d.width, d.height);
	    
		if (offG==null) return;
		offG.setColor(c);
		offG.drawOval(center_x-radius,center_y-radius, 2*radius, 2*radius);
		
	}
	
	public static void fillCircle(int center_x, int center_y, int radius, Color c){
		Dimension d = panel.getSize();
	    checkOffscreenImage();
		Graphics offG=panel.getGraphics();
		//offG.setColor(panel.getBackground());
	    //offG.fillRect(0, 0, d.width, d.height);
	    
		if (offG==null) return;
		offG.setColor(c);
		offG.fillOval(center_x-radius,center_y-radius, 2*radius, 2*radius);
		
	}
	
	public static void drawStr(String str, int x, int y,Color c){
		
	    checkOffscreenImage();
		Graphics offG=panel.getGraphics();
		if (offG==null) return;
		offG.setColor(c);
		offG.drawString(str,x,y);
	    
	}
	
	public static void drawLine(int x1, int y1, int x2, int y2, Color c){
		Graphics offG=panel.getGraphics();
		checkOffscreenImage();
		if (offG==null) return;
		offG.setColor(c);
		offG.drawLine(x1,y1,x2,y2);
	}
	
	public static void draw(){
		appFrm.repaint();
		//panel.repaint();
	}
	
	public static void clean(){
		panel.getGraphics().clearRect(0, 0, panel.getWidth() , panel.getHeight() );
	}
	
	public static Graphics getGraphics(){return panel.getGraphics();}
	
	public void paint(Graphics g) {
	    // Clear the offscreen image.
	    Dimension d = panel.getSize();
	    checkOffscreenImage();
	    Graphics offG = mImage.getGraphics();
	    offG.setColor(panel.getBackground());
	    offG.fillRect(0, 0, d.width, d.height);
	    // Draw into the offscreen image.
	    paintOffscreen(mImage.getGraphics());
	    // Put the offscreen image on the screen.
	    g.drawImage(mImage, 0, 0, null);
	  }

	public void paintOffscreen(Graphics g) {
	    int s = 100;
	    g.setColor(Color.blue);
	    //g.fillRect(mX - s / 2, mY - s / 2, s, s);
	  }

	private static void checkOffscreenImage() {
	    Dimension d = panel.getSize();
	    if (mImage == null || mImage.getWidth(null) != d.width
	        || mImage.getHeight(null) != d.height) {
	      mImage = panel.createImage(d.width, d.height);
	    }
	  }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AppDraw.show();

	}

}
