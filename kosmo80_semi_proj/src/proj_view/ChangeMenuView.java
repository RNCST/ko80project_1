package proj_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import proj_back.EventHandler;

public class ChangeMenuView extends JDialog{
	
	
	//선언부
	ChangeMenuView cmv           =  null;
	MainView       mv            =  null;
	EventHandler   eh            =  null;
	
	JPanel         jp_center     =  null;
	JPanel         jp_south      =  null;
	TitledBorder   tb_center     =  null;
	TitledBorder   tb_south   	 =  null;
	public RButton        jbrun         =  null;
	public RButton        jbno          =  null;
	
	JLabel         jl_mname      =  null;
	JTextField     jtf_mname     =  null;
	JLabel         jl_mprice     =  null;
	JTextField     jtf_mprice    =  null;
	JLabel         jl_mtype      =  null;
	JTextField     jtf_mtype     =  null;
	JLabel         jl_mldate     =  null;
	JTextField     jtf_mldate    =  null;
	
	JLabel         jl_jl1        =  null;
	
	Font           ft1           =  null;
	Font           ft2           =  null;
	
	public ChangeMenuView(MainView mv) {
		this();
		this.mv = mv;
		eh = mv.eh;
	}
	
	public ChangeMenuView() {
		
		
     jp_center     =  new JPanel();
     jp_south      =  new JPanel();
     jbrun         =  new RButton("처리");
     jbno          =  new RButton("취소");
     
     tb_center     =  new TitledBorder(new LineBorder(Color.white));
     tb_south      =  new TitledBorder(new LineBorder(Color.white));

     jl_mname      =  new JLabel("상품이름");
     jtf_mname     =  new JTextField();
     jl_mprice     =  new JLabel("상품가격");
     jtf_mprice    =  new JTextField();
     jl_mtype      =  new JLabel("상품종류");
     jtf_mtype     =  new JTextField();
     jl_mldate     =  new JLabel("상품등록일");
     jtf_mldate    =  new JTextField();
     
     jl_jl1        =  new JLabel("빈칸을 채운후 처리버튼을 눌러주세요");
	
	 ft1           =  new Font("휴먼모음T", Font.PLAIN, 15);
	 ft2           =  new Font("휴먼모음T", Font.BOLD, 20);
	}
	
	
	//화면처리부
	public void initDisplay() {
		
		this.add("Center",jp_center);
		this.add("South",jp_south);
		
		jp_center.setBorder(tb_center);
		jp_center.setPreferredSize(new Dimension(150,120));
		jp_center.setLayout(null);
		
		jl_mname.setBounds(40, 50, 100, 30);
		jl_mprice.setBounds(150, 50, 100, 30);
		jl_mtype.setBounds(260, 50, 100, 30);
		jl_mldate.setBounds(370, 50, 100, 30);
		
		jl_jl1.setHorizontalAlignment(JLabel.CENTER);
		jl_jl1.setBounds(0, 5, 500, 50);
		jl_mname.setFont(ft1);
		jl_mprice.setFont(ft1);
		jl_mtype.setFont(ft1);
		jl_mldate.setFont(ft1);
		jl_jl1.setFont(ft2);
		
		jtf_mname.setBounds(20, 80, 100, 30);
		jtf_mprice.setBounds(130, 80, 100, 30);
		jtf_mtype.setBounds(240, 80, 100, 30);
		jtf_mldate.setBounds(350, 80, 100, 30);
		
		jp_center.add(jl_jl1);
		jp_center.add(jl_mname);
		jp_center.add(jtf_mname);
		jp_center.add(jl_mprice);
		jp_center.add(jtf_mprice);
		jp_center.add(jl_mtype);
		jp_center.add(jtf_mtype);
		jp_center.add(jl_mldate);
		jp_center.add(jtf_mldate);
		
		
		jp_south.setBorder(tb_south);
		jp_south.setPreferredSize(new Dimension(150,50));
		
		jbrun.setBounds(40, 40, 40,20);
		jbno.setBounds(40, 40, 40, 20);
		jbrun.setFont(ft1);
		jbno.setFont(ft1);
		
		jp_south.add(jbrun);
		jp_south.add(jbno);
		
		
		this.setSize(500, 230);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		ChangeMenuView cmv = new ChangeMenuView();
				cmv.initDisplay();
	}
			
		
	
	
	
	
	
	
	
	
}
