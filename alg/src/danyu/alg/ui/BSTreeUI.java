package danyu.alg.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import danyu.alg.ds.tree.BSTree;
import danyu.alg.ds.tree.RBTree;
import danyu.alg.ds.tree.BSNode;
import danyu.alg.util.ArrayHelper;

public class BSTreeUI extends JFrame
        implements MouseListener
        {

	BSTree bst;//basic binary search tree
	RBTree rbt;//red-black binary search tree
	
	JTextArea data;
	public JPanel controlPanel,
	                dataPanel,
					graphPanel,//contain other graphic panels
					bsTreePanel,
					rbTreePanel;
	Graphics currentG;
	JButton btnGenData, btnGenBSTrees, btnGen234Tree;
	JComboBox btnTreeType;
	Integer[] ks={0,1,2,3,4,5};//default
	
	public BSTreeUI(BSTree bst){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800,400));
		this.bst=bst;
		buildPanel();
	}
	
	public void buildPanel(){
		LayoutManager lm=new BorderLayout();
		setLayout(lm);
		
		data=new JTextArea();
		data.setText("----");
		
		dataPanel=new JPanel();
		dataPanel.setMinimumSize(new Dimension(100,50));
		dataPanel.setLayout(new BorderLayout());
		dataPanel.setBorder(BorderFactory.createTitledBorder("Current keys:"));
		dataPanel.add(data,BorderLayout.CENTER);
		
		bsTreePanel=new JPanel();
		bsTreePanel.setBorder(BorderFactory.createTitledBorder("Basic Binary Search Tree"));
	
		rbTreePanel=new JPanel();
		rbTreePanel.setBorder(BorderFactory.createTitledBorder("Red-Black/2-3 Tree"));
		
		graphPanel=new JPanel();
		LayoutManager gd=new GridLayout(1,2);
		graphPanel.setLayout(gd);
		graphPanel.add(bsTreePanel);
		graphPanel.add(rbTreePanel);
		
		controlPanel=new JPanel();
		controlPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
	
		btnGenData=new JButton();
		btnGenData.setText("Generate Keys");
		btnGenData.addMouseListener(this); 
		
		btnGenBSTrees=new JButton();
		btnGenBSTrees.setText("Generate Trees");
		btnGenBSTrees.addMouseListener(this);
			
		controlPanel.add(btnGenData);
		controlPanel.add(btnGenBSTrees);
		
		add(dataPanel,BorderLayout.NORTH);
		add(controlPanel,BorderLayout.SOUTH);
		add(graphPanel,BorderLayout.CENTER);
		//add(rbTreePanel);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		updateDrawing();
		
	}

	public void  updateDrawing(){
		
		
		
		//bsTreePanel.getGraphics().clearRect(0, 0, bsTreePanel.WIDTH, bsTreePanel.HEIGHT);
		//rbTreePanel.getGraphics().clearRect(0, 0, rbTreePanel.WIDTH, rbTreePanel.HEIGHT);
		bsTreePanel.paint(bsTreePanel.getGraphics());	
		rbTreePanel.paint(rbTreePanel.getGraphics());
		dataPanel.paint(dataPanel.getGraphics());
		controlPanel.paint(controlPanel.getGraphics());
		
		if (bst==null || rbt == null) return;
		currentG=bsTreePanel.getGraphics();
		((Graphics2D) currentG).setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, // Anti-alias!
				RenderingHints.VALUE_ANTIALIAS_ON);
		//bst.print(this);
		currentG=rbTreePanel.getGraphics();
		((Graphics2D) currentG).setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, // Anti-alias!
				RenderingHints.VALUE_ANTIALIAS_ON);
		//rbt.print(this);
	}
	
	public  void drawLine(int x1, int y1, int x2, int y2, Color c){
		 
		Graphics offG=currentG;
		if (offG==null) return;
		offG.setColor(c);
		offG.drawLine(x1,y1,x2,y2);
	}
	public void drawCircle(int center_x, int center_y, int radius, Color c){
		Dimension d = getSize();
	    
		Graphics offG=currentG;
		//offG.setColor(panel.getBackground());
	    //offG.fillRect(0, 0, d.width, d.height);
	    
		if (offG==null) return;
		offG.setColor(c);
		offG.drawOval(center_x-radius,center_y-radius, 2*radius, 2*radius);
		
	}
	
	public  void fillCircle(int center_x, int center_y, int radius, Color c){
		Dimension d = getSize();
	    
		Graphics offG=currentG;
		//offG.setColor(panel.getBackground());
	    //offG.fillRect(0, 0, d.width, d.height);
	    
		if (offG==null) return;
		offG.setColor(c);
		offG.fillOval(center_x-radius,center_y-radius, 2*radius, 2*radius);
		
	}
	
	public void drawStr(String str, int x, int y, Color c) {

		Graphics offG = currentG;
		if (offG == null)
			return;
		offG.setColor(c);
		offG.drawString(str, x, y);

	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BSTree bst=new BSTree();
		 //bst.creatSampleTree();
		 //bst.experiment(100, 1000);
         BSTreeUI btui=new BSTreeUI(bst);
         btui.pack();
         btui.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
           
		 JButton btn=(JButton)e.getComponent();
         if(btn.equals(btnGenData)){
        	 ks=BSTree.genExperimentalData(20,100);
        	 
        	 data.setText(ArrayHelper.arrayToString(ks));
         }
         else if(btn.equals(btnGenBSTrees)){
        	bst = new BSTree();
			bst.insert(ks);
			rbt=new RBTree();
			rbt.insert(ks);
			updateDrawing();
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

}
