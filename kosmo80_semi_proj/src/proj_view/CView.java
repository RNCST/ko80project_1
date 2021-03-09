package proj_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import proj_back.DBLogic;
import proj_back.EventHandler;
import proj_back.MenuVO;


public class CView extends JDialog {
	//ORACLE 연동에 대한 선언부
	
	
	
	//선언부
	JScrollPane jsp         = null;
	static EventHandler eh         = null;
	MenuVO      mVOS[]      = null;
	DefaultTableModel detm = null;
	JTable        jtb = null;
	String array[]    = {"메뉴","가격"};
	String data[][]   = new String[0][2];
	JPanel      jp_west     = new JPanel();
	//메뉴큰 분류
	JPanel      jp_south    = new JPanel();
	//장바구니 추가 
	JPanel      jp_center   = new JPanel();
	//메뉴 항목들 나오게
	public JButton     jb_in     = new JButton("장바구니에 추가");
	public JButton     jb_new     = new JButton("N E W");
	public JButton     jb_hot     = new JButton("H O T");
	public JButton     jb_main     = new JButton("M A I N");
	public JButton     jb_drink    = new JButton("DRINK");
	public JButton     jb_side    = new JButton("S I D E ");
	//패널 테두리 따로 선언
	TitledBorder tb_south  =  new TitledBorder(new LineBorder(Color.white),"장바구니추가");
	TitledBorder tb_west   =  new TitledBorder(new LineBorder(Color.white),"분류");
//	TitledBorder tb_center =  new TitledBorder(new LineBorder(Color.white),"세부메뉴");
	MainView       mv      = null;
    CView          cv      = null;
    DBLogic		   db	   = null;
	


	public CView(MainView mv) {
		this.mv = mv;
	}
	public CView() {
		
	}
	public void setrow(MenuVO[] mVOS) {
		this.mVOS = mVOS;
		try {
		  for(int i=0;i<this.mVOS.length;i++) {
	            Vector oneRow = new Vector();
	            //oneRow.add(this.mVOS[i].getM_num());
	            //System.out.println("getM_num 성공");
	            oneRow.add(this.mVOS[i].getM_name());
	            System.out.println("getM_name 성공");
	            oneRow.add(this.mVOS[i].getM_price());
	            System.out.println("getM_price 성공");
	            //oneRow.add(this.mVOS[i].getM_type());
	            //System.out.println("getM_type 성공");
	            this.detm.addRow(oneRow);
	            System.out.println("추가 실행");
		  }
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	public void initDisplay() {
		eh = mv.eh;
		System.out.println(eh+"cv위");
		System.out.println("CV initdisplay호출 성공");
		
		detm        = new DefaultTableModel(data, array);
		jtb         = new JTable(detm);
		jsp         = new JScrollPane(jtb);
		jsp.setPreferredSize(new Dimension(600,700));
		
		this.add("West",jp_west);
		add(jp_west,BorderLayout.WEST);
		jp_west.setBorder(tb_west);
		jp_west.setBackground(Color.LIGHT_GRAY);
		jp_west.setPreferredSize(new Dimension(200,700));
		jp_west.add(jb_new);
		jp_west.add(jb_hot);
		jp_west.add(jb_main);
		jp_west.add(jb_drink);
		jp_west.add(jb_side);
		jb_new.setPreferredSize(new Dimension(150,120));
		jb_hot.setPreferredSize(new Dimension(150,120));
		jb_main.setPreferredSize(new Dimension(150,120));
		jb_drink.setPreferredSize(new Dimension(150,120));
		jb_side.setPreferredSize(new Dimension(150,120));
		
		this.add("Center", jp_center);
//		jp_center.setBorder(tb_center);
		jp_center.setBackground(Color.LIGHT_GRAY);
		jp_center.setPreferredSize(new Dimension(600,700));
		jp_center.add(jsp);
		
		this.add("South",jp_south);
		add(jp_south,BorderLayout.SOUTH);
		jp_south.setBorder(tb_south);
		jp_south.setBackground(Color.LIGHT_GRAY);
		jp_south.setPreferredSize(new Dimension(800,100));
		
		jb_in.setBounds(350, 50, 300, 300);
		jp_south.add(jb_in);
		jb_in.setPreferredSize(new Dimension(150,50));
		this.setSize(800,800);
		this.setVisible(true);
		
		
		System.out.println(eh+"cv아래");
		
	}
	
	
//	public static void main(String[] args) {
//		CView cv = new CView();
//		cv.initDisplay();
//	}
	
	public static void main(String[] args) {
		CView cv = new CView();
		cv.initDisplay();
	}
}
