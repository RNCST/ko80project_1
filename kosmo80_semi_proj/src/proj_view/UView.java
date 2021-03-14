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


public class UView extends JDialog implements InterView {
	//선언부
	JScrollPane			jsp         = null;
	static EventHandler eh         	= null;
	Vector<MenuVO>		mVOS	    = null;
	DefaultTableModel	detm 		= null;
	public JTable       jtb 		= null;
	String 				array[]    	= {"메뉴","가격", "출시일"};
	String 				data[][]   	= new String[0][2];
	JPanel      		jp_west     = null;
	//메뉴큰 분류
	JPanel      		jp_south    = null;
	//장바구니 추가
	JPanel      		jp_center   = null;
	//메뉴 항목들 나오게
	public RButton     	jb_ins     	= null;
	public RButton     	jb_upd     	= null;
	public RButton      jb_del      = null;
	public RButton      jb_out      = null;
	
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
    UView          		uv      	= null;
    DBLogic		   		db	   		= null;
    
	Font 				ft1 		= null;
	Font 				ft2 		= null;
	
    //생성자
    public UView() {
    	jp_west     = new JPanel();
    	jp_south    = new JPanel();
    	jp_center   = new JPanel();
    	
    	jb_ins    	= new RButton("항목 추가");
    	jb_upd     	= new RButton("항목 수정");
    	jb_del      = new RButton("항목 삭제");
    	jb_out      = new RButton("U L 모드 종료");
    	jb_new     	= new RButton("N E W");
    	jb_hot     	= new RButton("H O T");
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
	public UView(UView uv) { 
		this();
		this.uv = uv;
		eh = uv.eh;
	}
	@Override
	public void setrow(Vector<MenuVO> mVOS) {
		this.mVOS = mVOS;
		for(int i=0;i<this.mVOS.size();i++) {
		    Vector oneRow = new Vector();
		    oneRow.add(this.mVOS.elementAt(i).getM_name());
		    oneRow.add(this.mVOS.elementAt(i).getM_price());
		    oneRow.add(this.mVOS.elementAt(i).getM_lunch_date());
		    this.detm.addRow(oneRow);
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
		jp_west.add(jb_main);
		jp_west.add(jb_drink);
		jp_west.add(jb_side);
		
		jb_new.setPreferredSize(new Dimension(150,120));
		jb_hot.setPreferredSize(new Dimension(150,120));
		jb_main.setPreferredSize(new Dimension(150,120));
		jb_drink.setPreferredSize(new Dimension(150,120));
		jb_side.setPreferredSize(new Dimension(150,120));
		
		jb_new.setFont(ft2);
		jb_hot.setFont(ft2);
		jb_main.setFont(ft2);
		jb_drink.setFont(ft2);
		jb_side.setFont(ft2);
		jb_ins.setFont(ft1);
		jb_upd.setFont(ft1);
		jb_del.setFont(ft1);
		jb_out.setFont(ft1);
		
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
		
		jb_ins.setBounds(350, 50, 300, 300);
		jp_south.add(jb_ins);
		jb_ins.setPreferredSize(new Dimension(150,50));
		jb_upd.setBounds(350, 50, 300, 300);
		jp_south.add(jb_upd);
		jb_upd.setPreferredSize(new Dimension(150,50));
		jb_del.setBounds(350, 50, 300, 300);
		jp_south.add(jb_del);
		jb_del.setPreferredSize(new Dimension(150,50));
		jb_out.setBounds(350, 50, 300, 300);
		jp_south.add(jb_out);
		jb_out.setPreferredSize(new Dimension(150,50));
		this.setSize(800,800);
		this.setVisible(false);
	}
	@Override
	public void refresh() {
		   while(detm.getRowCount()>0) {
	            detm.removeRow(0);
	         }
	}
	
	public static void main(String[] args) {
		UView uv = new UView();
		uv.initDisplay();
		uv.setVisible(true);
	}
}