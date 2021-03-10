package proj_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.util.Vector;

import proj_back.EventHandler;
import proj_back.MenuVO;

public class CartView extends JDialog {
	//선언부
	static EventHandler   		eh       		= null;
	MainView     				mv         		= null;
	CView          				cv     			= null;
	
	JPanel    					jp_center     	= null;
	JPanel    					jp_southB     	= null;
	JPanel    					jp_south1     	= null;
	JPanel    					jp_south2     	= null;

	JScrollPane			   		jsp             = null;
	MenuVO				    	mVOS[]          = null;
	DefaultTableModel	    	detm 		    = null;
	public JTable           	jtb 		    = null;
	String 				    	array[]    	    = {"메뉴","가격"};
	String 				    	data[][]   	    = new String[0][2];
	
	TitledBorder 				tb_south   		= null;
	TitledBorder 				tb_south1  		= null;
	TitledBorder 				tb_south2  		= null;
	TitledBorder 				tb_center  		= null;
	
	public JButton   			jb_buy        	= null;
	public JButton   			jb_cancel     	= null;
	
	private Vector<MenuVO>		cartList		= null;
	private int					total			= 0;
	JLabel                  	jlb             = null;
	JLabel                  	jlb2            = null;
	
	Font 						ft1 			= null;
	Font 						ft2 			= null;
	Font 						ft3 			= null;
	
	//생성자
	public CartView() {
		jp_center     	= new JPanel();
		jp_southB     	= new JPanel();
		jp_south1     	= new JPanel();
		jp_south2     	= new JPanel();
		
		tb_south   		= new TitledBorder(new LineBorder(Color.lightGray),"주문확인");
		tb_south1  		= new TitledBorder(new LineBorder(Color.white),"");
		tb_south2  		= new TitledBorder(new LineBorder(Color.white));
		tb_center  		= new TitledBorder(new LineBorder(Color.white),"목록확인");
		
		detm            = new DefaultTableModel(data, array);
		jtb             = new JTable(detm);
		jsp             = new JScrollPane(jtb);
		
		jlb             = new JLabel("");
		jlb2            = new JLabel("");
		
		
		jb_buy        	= new JButton("결제하기");
		jb_cancel     	= new JButton("취소하기");
		
		ft1 			= new Font("휴먼모음T", Font.PLAIN, 15);
		ft2 			= new Font("Ariel", Font.BOLD, 15);
		ft3             = new Font("휴먼모음T",Font.PLAIN,14);
		
		cartList		= new Vector<MenuVO>();

	}

	public CartView(MainView mv) {
		this();
		this.mv = mv;
		eh = mv.eh;
		cv = mv.cv;
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
		
		jp_south1.setLayout(new GridLayout(2,0));           

		jp_south1.add(jlb);
		jlb.setOpaque(true);
		jlb.setBackground(Color.LIGHT_GRAY);
		jlb.setHorizontalAlignment(JLabel.RIGHT);
		jp_south1.add(jlb2);
		jlb2.setOpaque(true);
		jlb2.setBackground(Color.LIGHT_GRAY);
		jlb2.setHorizontalAlignment(JLabel.RIGHT);
		jlb.setFont(ft3);
		jlb2.setFont(ft3);
		
//		jlb.setText("지불하실 금액은 ");
//		totalPrice=Integer.toString(price);
//		jlb2.setText("총 "+totalPrice+"원 입니다.");
		
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
	
	public void addCartList(MenuVO selectedMenu) {
		MenuVO mVO = new MenuVO();
		mVO.setM_name(selectedMenu.getM_name());
		mVO.setM_price(selectedMenu.getM_price());
		mVO.setM_type(selectedMenu.getM_type());
		mVO.setM_type(selectedMenu.getM_lunch_date());
		total += selectedMenu.getM_price();
		cartList.addElement(mVO);
	}
	
	public void showCartList() {
		for(int i=0;i<this.cartList.size();i++) {
			Vector oneRow = new Vector();
			oneRow.add(cartList.elementAt(i).getM_name());
			oneRow.add(cartList.elementAt(i).getM_price());
			this.detm.addRow(oneRow);
		}
		tb_south1.setTitle("지불하실 총 금액은 " +this.getTotal()+"원 입니다.\n");
		
	}
	
	public MenuVO[] getCartList() {
		MenuVO[] cl = null;
		cartList.copyInto(cl);
		return cl;
	}
	
	public int getTotal() {
		return this.total;
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
