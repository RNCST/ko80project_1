package proj_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CartView extends JDialog implements ActionListener {
	//ORACLE 연동에 대한 선언부
	
	
	
	//선언부
	JPanel    jp_center     = new JPanel();
	JPanel    jp_southB     = new JPanel();
	JPanel    jp_south1     = new JPanel();
	JPanel    jp_south2     = new JPanel();
	
	TitledBorder tb_south   = new TitledBorder(new LineBorder(Color.lightGray),"주문확인");
	TitledBorder tb_south1  = new TitledBorder(new LineBorder(Color.white),"총액확인");
	TitledBorder tb_south2  = new TitledBorder(new LineBorder(Color.white));
	TitledBorder tb_center  = new TitledBorder(new LineBorder(Color.white),"목록확인");
	
	
	public JButton   jb_buy        = new JButton("결제하기");
	public JButton   jb_cancel     = new JButton("취소하기");
	
	
	
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
		
		
		
		this.setSize(500, 650);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		CartView cv = new CartView();
		cv.initDisplay();
		
	}
}
