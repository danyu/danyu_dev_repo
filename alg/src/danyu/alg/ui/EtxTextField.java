package danyu.alg.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import  javax.swing.JTextField;

public class EtxTextField extends JTextField {

	private final Color default_border_color=Color.white;
	public EtxTextField(){
		setPreferredSize(new Dimension(100,30));
		setForeground( Color.white);
		setBackground( DSPanel.DEFAULT_BACK_COLOR);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
	}
	
	@Override
	protected void processMouseEvent(MouseEvent e) {
		// TODO Auto-generated method stub
		super.processMouseEvent(e);
		/*if(e.getID()==MouseEvent.MOUSE_ENTERED)
			setBackground(Color.gray);
		if(e.getID()==FocusEvent.FOCUS_LOST)
			setBackground(Color.white);*/
	}
	
	@Override
	protected void processFocusEvent(FocusEvent e) {
		// TODO Auto-generated method stub
		super.processFocusEvent(e);
		
		/*if(e.getID()==FocusEvent.FOCUS_GAINED)
			setBackground(Color.lightGray);
		if(e.getID()==FocusEvent.FOCUS_LOST)
			setBackground(Color.white);*/
	}

}
