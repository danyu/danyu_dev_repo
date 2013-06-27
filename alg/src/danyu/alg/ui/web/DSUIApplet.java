package danyu.alg.ui.web;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.SwingUtilities;
import danyu.alg.ui.DSPanel;


public class DSUIApplet extends Applet {

	 public void init() {
		 setSize(700, 600);
		 setLayout(new BorderLayout());
	        //Execute a job on the event-dispatching thread; creating this applet's GUI.
	        try {
	            SwingUtilities.invokeAndWait(new Runnable() {
	                public void run() {
	                 DSPanel dsPanel=new DSPanel();
	                 dsPanel.setSize(800,600);
	            	 add(dsPanel,BorderLayout.CENTER);
	            	  
	                }
	            });
	        } catch (Exception e) {
	            System.err.println("createGUI didn't complete successfully");
	        }
	    }
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "DS Study Room - Danyu You";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
