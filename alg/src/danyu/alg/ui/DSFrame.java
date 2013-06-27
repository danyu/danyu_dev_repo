package danyu.alg.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import danyu.alg.ds.tree.BSTree;

//Program entry.
public class DSFrame extends JFrame {

	private DSPanel dsPanel;
	public final static int PANEL_H=100;
	
	public DSFrame(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800,500));
		dsPanel=new DSPanel();
		add(dsPanel);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

         DSFrame ui=new DSFrame();
         ui.pack();
         ui.setVisible(true);	
	}
	
}
