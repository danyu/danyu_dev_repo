package danyu.alg.ui;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

import com.sun.xml.internal.fastinfoset.algorithm.HexadecimalEncodingAlgorithm;

public class ExtButton extends JButton {

	
	
	@Override
	protected void init(String text, Icon icon) {
		// TODO Auto-generated method stub
		super.init(text, icon);
		
		setBackground(DSPanel. DEFAULT_BACK_COLOR);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
