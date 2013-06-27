package danyu.application;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame{

	private JPanel panel=null;
	private AppFrame appFrm=null;
	
	public  void initFrame(){
		appFrm=new AppFrame();
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
