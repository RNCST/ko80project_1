package proj_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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


public class CView extends JDialog implements InterView {
	//선언부
	JScrollPane			jsp         = null;
	static EventHandler eh         	= null;
	Vector<MenuVO>		mVOS	    = null;
	DefaultTableModel	detm 		= null;
	public JTable       jtb 		= null;
	String 				array[]    	= {"메뉴","가격"};
	String 				data[][]   	= new String[0][2];
	JPanel      		jp_west     = null;
	//메뉴큰 분류
	JPanel      		jp_south    = null;
	//장바구니 추가
	JPanel      		jp_center   = null;
	//메뉴 항목들 나오게
	public RButton     	jb_see     	= null;
	public RButton     	jb_in      	= null;
	public RButton   	jb_new     	= null;
	public RButton   	jb_hot     	= null;
	public RButton   	jb_main    	= null;
	public RButton   	jb_drink   	= null;
	public RButton    	jb_side    	= null;
	//패널 테두리 따로 선언
	TitledBorder 		tb_south  	= null;
	TitledBorder 		tb_west   	= null;
//	TitledBorder 		tb_center	= null;
	MainView       		mv      	= null;
    CView          		cv      	= null;
    DBLogic		   		db	   		= null;
    
	Font 				ft1 		= null;
	Font 				ft2 		= null;
	
    //생성자
    public CView() {
    	jp_west     = new JPanel();
    	jp_south    = new JPanel();
    	jp_center   = new JPanel();
    	
    	jb_see     	= new RButton("장바구니 확인");
    	jb_in      	= new RButton("장바구니에 담기");
    	jb_new     	= new RButton("N E W");
    	jb_hot     	= new RButton("H O T");
//    	jb_set     	= new RButton("S E T");
    	jb_main    	= new RButton("M A I N");
    	jb_drink   	= new RButton("DRINK");
    	jb_side    	= new RButton("S I D E");

    	tb_south  	= new TitledBorder(new LineBorder(Color.white),"장바구니추가");
    	tb_west   	= new TitledBorder(new LineBorder(Color.white),"분류");
    	//tb_center = new TitledBorder(new LineBorder(Color.white),"세부메뉴");
    	
    	detm        = new DefaultTableModel(data, array);
		jtb         = new JTable(detm);
		jsp         = new JScrollPane(jtb);
		
		ft1 		= new Font("휴먼모음T", Font.PLAIN, 15);
		ft2 		= new Font("Ariel", Font.BOLD, 25);
    	
    	
	}
	public CView(MainView mv) {
		this();
		this.mv = mv;
		eh = mv.eh;
	}
	@Override
	public void setrow(Vector<MenuVO> mVOS) {
		this.mVOS = mVOS;
		for(int i=0;i<this.mVOS.size();i++) {
		    Vector oneRow = new Vector();
		    oneRow.add(this.mVOS.elementAt(i).getM_name());
		    System.out.println("getM_name 성공");
		    oneRow.add(this.mVOS.elementAt(i).getM_price());
		    System.out.println("getM_price 성공");
		    this.detm.addRow(oneRow);
		    System.out.println("추가 실행");
		}
	}

	@Override
	public void initDisplay() {
		
		jsp.setPreferredSize(new Dimension(560,650));
		jtb.setRowHeight(40);
		jtb.setFont(ft1);

		//jtb.setRowHeight(int row_index, int row_height);
		
		add("West",jp_west);
		add(jp_west,BorderLayout.WEST);
		jp_west.setBorder(tb_west);
		jp_west.setBackground(Color.LIGHT_GRAY);
		jp_west.setPreferredSize(new Dimension(200,700));
		
		jp_west.add(jb_new);
		jp_west.add(jb_hot);
//		jp_west.add(jb_set);
		jp_west.add(jb_main);
		jp_west.add(jb_drink);
		jp_west.add(jb_side);
		
		jb_new.setPreferredSize(new Dimension(150,120));
		jb_hot.setPreferredSize(new Dimension(150,120));
//		jb_set.setPreferredSize(new Dimension(150,100));
		jb_main.setPreferredSize(new Dimension(150,120));
		jb_drink.setPreferredSize(new Dimension(150,120));
		jb_side.setPreferredSize(new Dimension(150,120));
		
		jb_new.setFont(ft2);
		jb_hot.setFont(ft2);
//		jb_set.setFont(ft2);
		jb_main.setFont(ft2);
		jb_drink.setFont(ft2);
		jb_side.setFont(ft2);
		jb_in.setFont(ft1);
		jb_see.setFont(ft1);
		
		add("Center", jp_center);
		//jp_center.setBorder(tb_center);
		jp_center.setBackground(Color.LIGHT_GRAY);
		jp_center.setPreferredSize(new Dimension(600,700));
		jp_center.add(jsp);
		
		add("South",jp_south);
		add(jp_south,BorderLayout.SOUTH);
		jp_south.setBorder(tb_south);
		jp_south.setBackground(Color.LIGHT_GRAY);
		jp_south.setPreferredSize(new Dimension(800,100));
		
		jb_in.setBounds(350, 50, 300, 300);
		jp_south.add(jb_in);
		jb_in.setPreferredSize(new Dimension(150,50));
		jb_see.setBounds(350, 50, 300, 300);
		jp_south.add(jb_see);
		jb_see.setPreferredSize(new Dimension(150,50));
		this.setSize(800,800);
		this.setVisible(false);
	}
	@Override
	public void refresh() {
		   while(this.detm.getRowCount()>0) {
	            this.detm.removeRow(0);
	         }
	}
	
	public static void main(String[] args) {
		CView cv = new CView();
		cv.initDisplay();
		cv.setVisible(true);
	}
}
