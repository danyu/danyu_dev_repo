package danyu.alg.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import danyu.alg.ds.DS;
import danyu.alg.ds.DS.DSType;
import danyu.alg.ds.tree.BSTree;
import danyu.alg.ds.tree.RBTree;
import danyu.alg.util.ArrayHelper;

public class DSPanel 
		extends JPanel 
		implements MouseListener, 
		TreeSelectionListener{

	public static int DEFAULT_WIDTH=300;
	public static int DEFAULT_HEIGHT=400;
	public static int DEFAULT_INPUT_PANEL_HEIGHT=30;
	public static int DEFAULT_TXT_HEIGHT=30;
	/*colors
	 * -------------------------------------------*/
	public static Color DEFAULT_BACK_COLOR	=new Color(0x4b6c9e);
	
	
	/**
	 * It provides user interface with access to data structure
	 * related operations, such as insert, delete, pup, pop, min and max.
	 * It usually consist of buttons.
	 */
	protected OptionPanel optPanel;
	protected JPanel operationPanel;
	protected JPanel dataPanel;
	protected JPanel drawPanel;
	protected JPanel tracePanel;
	
	private DS ds;
	
	protected JSlider numOfKeysSlider;
	protected JSlider maxKeySlider;
	protected JComboBox worseCaseRBtn;
	protected JRadioButton shuffleBtn;
	
	protected JTextArea randomKTArea;
	protected JButton btnGenData;
	protected JButton btnDrawDS;
	
	/*For BSTree operation*/
	protected JTextField txtInsert;
	protected JTextField txtDelete;
	protected JButton btnInsert;
	protected JButton btnDelete;

	
	public DSPanel(){
		buildPanel();
	}
	
	public DSPanel(DS ds){
		setMinimumSize(new Dimension(600, 500));
		setDisplayedDS(ds);
		buildPanel();
		//draw.print(this);
	}
	
	public void setDisplayedDS(DS ds){
		this.ds=ds;
		repaint();
		if (drawPanel != null)
			((TitledBorder) drawPanel.getBorder()).setTitle(ds.toString());
	}
	
	public void buildPanel(){
		setMinimumSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
		
		LayoutManager lm=new BorderLayout();
		setLayout(lm);
		
		buildOptionPanel();
	    buildInputPanel();
	    buildDrawPanel();
		buildOperationPanel();
		//buildTracePanel();
		
		//add(optPanel,BorderLayout.LINE_START);
		add(dataPanel,BorderLayout.NORTH);
		add(operationPanel,BorderLayout.LINE_END);
		add(drawPanel,BorderLayout.CENTER);
		
	}
	
	public void buildOptionPanel(){

		optPanel=new OptionPanel();
		optPanel.addOptionListener(this);
			
	}
	public void buildInputPanel(){
		dataPanel=new JPanel();
		dataPanel.setPreferredSize(new Dimension(500,180));
		//dataPanel.setMinimumSize(new Dimension(400,DEFAULT_INPUT_PANEL_HEIGHT));
		dataPanel.setLayout(new GridLayout(1,2));
		dataPanel.setBorder(BorderFactory.createTitledBorder("Create Input Data"));
		
		JPanel dummyMid=new JPanel(new GridLayout(1,2));
		JPanel dummyTopLeft=new JPanel(new GridLayout(2,1));
		//dummyTop.setPreferredSize(new Dimension(400,60));
		
		Font sliderFont = new Font("Serif", Font.ITALIC, 10);
		
		numOfKeysSlider=new JSlider(JSlider.HORIZONTAL,5,80,DS.KEY_SIZE);
		numOfKeysSlider.setMinorTickSpacing(1);
		numOfKeysSlider.setMajorTickSpacing(25);
		numOfKeysSlider.setPaintLabels(true);
		numOfKeysSlider.setFont(sliderFont);
		numOfKeysSlider.setSnapToTicks(true);
		//txtNumOfKeys.setMinimumSize(new Dimension(100,DEFAULT_TXT_HEIGHT));
		numOfKeysSlider.setBorder(BorderFactory.createTitledBorder("Number of Keys"));	
		
		maxKeySlider=new JSlider(JSlider.HORIZONTAL,100,300,DS.MAX_KEY);
		maxKeySlider.setMinorTickSpacing(1);
		maxKeySlider.setMajorTickSpacing(50);
		maxKeySlider.setPaintLabels(true);
		
		//maxKeySlider.setPaintTicks(true);
		maxKeySlider.setFont(sliderFont);
		maxKeySlider.setBorder(BorderFactory.createTitledBorder("Maximum key"));
		//txtMaxKey.setMinimumSize(new Dimension(100, DEFAULT_TXT_HEIGHT));
		randomKTArea=new JTextArea();
		//randomKTArea.setText(ArrayHelper.arrayToString(DS.ks));
		randomKTArea.setEditable(false);
		randomKTArea.setMinimumSize(new Dimension(120, 80));
		randomKTArea.setLineWrap(true);
		randomKTArea.setBorder(BorderFactory.createTitledBorder("Randomly Generated Keys"));
				
		JPanel dummyRight=new JPanel(new BorderLayout());
		
		worseCaseRBtn=new JComboBox(new String[]{"WorseCase(Asending)","WorseCase(Desending)","Shuffle"});
		worseCaseRBtn.addMouseListener(this);
		
		btnGenData=new JButton();
		btnGenData.setText("Generate Data");
		btnGenData.setToolTipText("Generate another set of keys and redraw.");
		btnGenData.addMouseListener(this); 
		
		btnDrawDS=new JButton();
		btnDrawDS.setText("Draw");
		btnDrawDS.addMouseListener(this);
		
		dummyTopLeft.add(numOfKeysSlider);
		dummyTopLeft.add(maxKeySlider);
		dummyMid.add(dummyTopLeft);
		
		dummyRight.add(randomKTArea,BorderLayout.CENTER);
		JPanel dummyRightBottom=new JPanel(new GridLayout(1,2));
		dummyRightBottom.add(worseCaseRBtn);
		dummyRightBottom.add(btnGenData);
		dummyRight.add(dummyRightBottom,BorderLayout.SOUTH);
		//dummyRight.add(worseCaseRBtn);
		
		dataPanel.add(optPanel);
		dataPanel.add(dummyMid);
		dataPanel.add(dummyRight);
	}
	
	public void buildDrawPanel(){
		drawPanel=new DrawPanel();
		//drawPanel.
		drawPanel.setBorder(BorderFactory.createTitledBorder("Visualized Data Structure"));
		
	}
	
	public void buildOperationPanel(){
		
		GridLayout gl=new GridLayout(4,1);
		//gl.setRows
		operationPanel=new JPanel(new FlowLayout());
		operationPanel.setPreferredSize(new Dimension(150,400));
		operationPanel.setBorder(BorderFactory.createTitledBorder("Operations"));
	
		txtInsert=new EtxTextField();
		
		txtDelete=new EtxTextField();
		
		btnInsert =new JButton();
		btnInsert.setText("Insert");
		btnInsert.addMouseListener(this); 
		
		btnDelete=new JButton();
		btnDelete.setText("Delete");
		btnDelete.addMouseListener(this);
			
		operationPanel.add(txtInsert);
		operationPanel.add(btnInsert);
		operationPanel.add(txtDelete);
		operationPanel.add(btnDelete);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		   
		Component btn = e.getComponent();	
		
		if (btn.equals(btnGenData)) {
			int num = numOfKeysSlider.getValue();
			int max = maxKeySlider.getValue();
			
			DS.ks = BSTree.genExperimentalData(num, max);

			randomKTArea.setText(ArrayHelper.arrayToString(DS.ks));
			if (ds == null)
				return;
			ds.setKeys(DS.ks);
			drawPanel.repaint();
		} else if (btn.equals(btnDrawDS)) {
			if(ds==null) return;
			ds.setKeys(DS.ks);
			drawPanel.repaint();

		} else if (btn.equals(btnInsert)) {
			String keyToInsert=txtInsert.getText();
			if(keyToInsert.equals("")) return;
			int newNum = Integer.valueOf(keyToInsert);
			ds.insert(newNum, null);
			drawPanel.repaint();
		}else if (btn.equals(btnDelete)) {
			
			String keyToDelete=txtDelete.getText();
			if(keyToDelete.equals("")) return;
			int newNum = Integer.valueOf(keyToDelete);
			ds.delete(newNum);
			drawPanel.repaint();
		}else if (btn.equals(worseCaseRBtn)){
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void printAlg(){
		//ds.print(this);
	}
	
	private class DrawPanel extends JPanel{
		
		public DrawPanel(){
			//setMinimumSize(new Dimension());
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(ds ==null) return;
			((Graphics2D) g).setRenderingHint(
					RenderingHints.KEY_ANTIALIASING, // Anti-alias!
					RenderingHints.VALUE_ANTIALIAS_ON);
			DSPainter.paint(ds,g,getWidth(), getHeight());		
		}
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node =(DefaultMutableTreeNode)((JTree)e.getSource()).getLastSelectedPathComponent();

		if (node == null) return;

		if (node.isLeaf()) {
			DS selectedDs =(DS) node.getUserObject();
			selectedDs.setKeys(DS.ks);
			setDisplayedDS(selectedDs);
			drawPanel.repaint()	;
		} else {
			
		}
	}
	
	private void updateControl(){
		
	}
}
