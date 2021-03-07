package proj_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class CView extends JDialog implements ActionListener{
	//ORACLE 연동에 대한 선언부
	
	
	
	//선언부
	JScrollPane jsp         = null;
	JFrame      jf          = null;
	JPanel      jp_west     = new JPanel();
	//메뉴큰 분류
	JPanel      jp_south    = new JPanel();
	//장바구니 추가 
	JPanel      jp_center   = new JPanel();
	//메뉴 항목들 나오게
	JButton     jb_in     = new JButton("장바구니에 추가");
	//패널 테두리 따로 선언
	TitledBorder tb_south  =  new TitledBorder(new LineBorder(Color.white),"주문확인");
	TitledBorder tb_west   =  new TitledBorder(new LineBorder(Color.white),"분류");
	TitledBorder tb_center =  new TitledBorder(new LineBorder(Color.white),"세부메뉴");
	static MainView mv      = null;
	static CView    cv      = null;
	
//	public CView() {
//		  dbMgr = DBConnectionMgr.getInstance();
//	      try {
//	         con = dbMgr.getConnection();
//	         //자동커밋 모드를 켜둘때와 꺼둘때 - 디폴트 -true
//	         con.setAutoCommit(false);
//	      } catch (Exception e) {
//	         System.out.println(e.toString());
//	      }      
//	      initDisplay();
//	   }
	public void initDisplay() {
		this.add("West",jp_west);
		add(jp_west,BorderLayout.WEST);
		jp_west.setBorder(tb_west);
		jp_west.setBackground(Color.LIGHT_GRAY);
		jp_west.setPreferredSize(new Dimension(200,700));
		
		this.add("Center", jp_center);
		jp_center.setBorder(tb_center);
		jp_center.setBackground(Color.LIGHT_GRAY);
		jp_center.setPreferredSize(new Dimension(600,700));
		
		this.add("South",jp_south);
		add(jp_south,BorderLayout.SOUTH);
		jp_south.setBorder(tb_south);
		jp_south.setBackground(Color.LIGHT_GRAY);
		jp_south.setPreferredSize(new Dimension(800,100));
		
		jb_in.setBounds(350, 50, 300, 300);;
		jp_south.add(jb_in);
		jb_in.setPreferredSize(new Dimension(150,50));
		this.setSize(800,800);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		CView cv = new CView();
		cv.initDisplay();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
