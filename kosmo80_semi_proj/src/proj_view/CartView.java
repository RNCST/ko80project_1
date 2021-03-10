package proj_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import proj_back.EventHandler;
import proj_back.MenuVO;

public class CartView extends JDialog {
	//선언부
	JPanel    				jp_center     	= null;
	JPanel    				jp_southB     	= null;
	JPanel    				jp_south1     	= null;
	JPanel    				jp_south2     	= null;
	static EventHandler   	eh       		= null;
	MainView     			mv         		= null;
	
	JScrollPane			    jsp             = null;
	MenuVO				    mVOS[]          = null;
	DefaultTableModel	    detm 		    = null;
	public JTable           jtb 		    = null;
	String 				    array[]    	    = {};
	String 				    data[][]   	    = new String[0][2];
	
	TitledBorder 			tb_south   		= null;
	TitledBorder 			tb_south1  		= null;
	TitledBorder 			tb_south2  		= null;
	TitledBorder 			tb_center  		= null;
	
	public JButton   		jb_buy        	= null;
	public JButton   		jb_cancel     	= null;
	
	Font 					ft1 			= null;
	Font 					ft2 			= null;
	private MenuVO[]		cartList		= null;
	
	//생성자
	public CartView() {
		jp_center     	= new JPanel();
		jp_southB     	= new JPanel();
		jp_south1     	= new JPanel();
		jp_south2     	= new JPanel();
		
		tb_south   		= new TitledBorder(new LineBorder(Color.lightGray),"주문확인");
		tb_south1  		= new TitledBorder(new LineBorder(Color.white),"총액확인");
		tb_south2  		= new TitledBorder(new LineBorder(Color.white));
		tb_center  		= new TitledBorder(new LineBorder(Color.white),"목록확인");
		
		detm            = new DefaultTableModel(data, array);
		jtb             = new JTable(detm);
		jsp             = new JScrollPane(jtb);
		
		jb_buy        	= new JButton("결제하기");
		jb_cancel     	= new JButton("취소하기");
		
		ft1 			= new Font("휴먼모음T", Font.PLAIN, 15);
		ft2 			= new Font("Ariel", Font.BOLD, 15);
	}
	public CartView(MainView mv) {
		this();
		this.mv = mv;
		eh = mv.eh;
	}

	//화면처리
	public void initDisplay() {
		//총액 구매 취소 패널들을 담는 패널
		this.add("South", jp_southB);
		jp_southB.setBorder(tb_south);
		jp_southB.setBackground(Color.LIGHT_GRAY);
		jp_southB.setPreferredSize(new Dimension(300,130));
		
		//총액 테이블이 보여지는 곳
		jp_southB.add("Center",jp_south1);
		jp_south1.setBorder(tb_south1);
		jp_south1.setBackground(Color.WHITE);
		jp_south1.setPreferredSize(new Dimension(400,40));
		
		
		
		//버튼부
		jp_southB.add("Center",jp_south2);
		jp_south2.setBorder(tb_south2);
		jp_south2.setBackground(Color.LIGHT_GRAY);
		jp_south2.setPreferredSize(new Dimension(400,40));
		
		jb_buy.setFont(ft1);
		jb_cancel.setFont(ft1);
		
		//구매버튼
		jp_south2.add(jb_buy);
		jb_buy.setBounds(0, 0, 100, 100);
		jb_buy.setPreferredSize(new Dimension(100,30));
		
		//취소버튼
		jp_south2.add(jb_cancel);
		jb_cancel.setBounds(120, 10, 100, 100);
		jb_cancel.setPreferredSize(new Dimension(100,30));
		
		//장바쿠니 테이블에 추가된 항목들이 보여야하는 곳
		this.add("Center", jp_center);
		jp_center.setBorder(tb_center);
		jp_center.setBackground(Color.LIGHT_GRAY);
		jp_center.setPreferredSize(new Dimension(300,30));
		
		//장바구니 테이블속 데이터를 내보내는 테이블.
		jtb.setRowHeight(35);
		jtb.setFont(ft1);
		jp_center.add(jsp);
		
		
		
		
		
		this.setSize(500, 650);
		this.setVisible(true);
		System.out.println("Cav initdisplay호출 성공");
	}
	
	public void setCartList() {
		
	}
	
	public MenuVO[] getCartList() {
		return cartList;
	}
	
	public void refresh() {
		   while(detm.getRowCount()>0) {
	            detm.removeRow(0);
	         }
	}
	
	public static void main(String[] args) {
		CartView cav = new CartView();
		cav.initDisplay();
		
	}
}
