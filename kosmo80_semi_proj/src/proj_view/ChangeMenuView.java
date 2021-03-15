package proj_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import proj_back.EventHandler;
import proj_back.MenuVO;

public class ChangeMenuView extends JDialog{
	
	
	//선언부
	ChangeMenuView 		cmv           =  null;
	MainView       		mv            =  null;
	EventHandler   		eh            =  null;
	
	JPanel         		jp_center     =  null;
	JPanel         		jp_south      =  null;
	TitledBorder   		tb_center     =  null;
	TitledBorder   		tb_south	  =  null;
	public RButton 		jbrun         =  null;
	public RButton 		jbno          =  null;
	public JComboBox 	jcb1          =  null;      
	
	JLabel         		jl_mname      =  null;
	public JTextField   jtf_mname     =  null;
	JLabel         		jl_mprice     =  null;
	JTextField     		jtf_mprice    =  null;
	JLabel         		jl_mtype      =  null;
	JTextField     		jtf_mtype     =  null;
//	JLabel         		jl_mldate     =  null;
//	JTextField     		jtf_mldate    =  null;
	
	JLabel        		jl_jl1        =  null;
	
	Font           		ft1           =  null;
	Font           		ft2           =  null;
	private String[]    type          =  {"Main","Drink","Side"};
	private boolean		add		 	  ;
	private MenuVO		mVO			  = null;
	
	public ChangeMenuView() {
		
		
     jp_center     =  new JPanel();
     jp_south      =  new JPanel();
     jbrun         =  new RButton("처리");
     jbno          =  new RButton("취소");
     jcb1          =  new JComboBox(type);
     
     tb_center     =  new TitledBorder(new LineBorder(Color.white));
     tb_south      =  new TitledBorder(new LineBorder(Color.white));

     jl_mname      =  new JLabel("상품이름");
     jtf_mname     =  new JTextField();
     jl_mprice     =  new JLabel("상품가격");
     jtf_mprice    =  new JTextField();
     jl_mtype      =  new JLabel("상품종류");
//     jtf_mtype     =  new JTextField();
//     jl_mldate     =  new JLabel("상품등록일");
//     jtf_mldate    =  new JTextField();
     
     jl_jl1        =  new JLabel("빈칸을 채운후 처리버튼을 눌러주세요");
     
	 ft1           =  new Font("휴먼모음T", Font.PLAIN, 15);
	 ft2           =  new Font("휴먼모음T", Font.BOLD, 20);
	}
	
	public ChangeMenuView(MainView mv) {
		this();
		this.mv = mv;
		eh = mv.eh;
	}
	
	public String getJtf_mname() { return jtf_mname.getText(); }
	public void setJtf_mname(String mname) {
		jtf_mprice.setText(mname);
	}
	public int getJtf_mprice() { return Integer.parseInt(jtf_mprice.getText()); }
	public void setJtf_mprice(String mprice) {
		jtf_mprice.setText(mprice);
	}
	public String getJtf_mtype() { return jcb1.getSelectedItem().toString(); }
	public void setJtf_mtype(String mtype) {
		mtype = jcb1.getSelectedItem().toString();
	}

	//화면처리부
	public void initDisplay() {
		
		this.add("Center",jp_center);
		this.add("South",jp_south);
		
		jp_center.setBorder(tb_center);
		jp_center.setPreferredSize(new Dimension(150,120));
		jp_center.setLayout(null);
		
		jl_mtype.setBounds(40, 50, 100, 30);
		jl_mname.setBounds(150, 50, 100, 30);
		jl_mprice.setBounds(260, 50, 100, 30);
//		jl_mldate.setBounds(370, 50, 100, 30);
		
		jl_jl1.setHorizontalAlignment(JLabel.CENTER);
		jl_jl1.setBounds(0, 5, 375, 50);
		jl_mname.setFont(ft1);
		jl_mprice.setFont(ft1);
		jl_mtype.setFont(ft1);
		jcb1.setFont(ft1);
//		jl_mldate.setFont(ft1);
		jl_jl1.setFont(ft2);
		
		jcb1.setBounds(20, 80, 100, 30);
		jtf_mname.setBounds(130, 80, 100, 30);
		jtf_mprice.setBounds(240, 80, 100, 30);
//		jtf_mtype.setBounds(240, 80, 100, 30);
//		jtf_mldate.setBounds(350, 80, 100, 30);
		
		jp_center.add(jl_jl1);
		jp_center.add(jl_mname);
		jp_center.add(jtf_mname);
		jp_center.add(jl_mprice);
		jp_center.add(jtf_mprice);
		jp_center.add(jcb1);
		jp_center.add(jl_mtype);
//		jp_center.add(jtf_mtype);
//		jp_center.add(jl_mldate);
//		jp_center.add(jtf_mldate);
		
		
		jp_south.setBorder(tb_south);
		jp_south.setPreferredSize(new Dimension(150,50));
		
		jbrun.setBounds(40, 40, 40,20);
		jbno.setBounds(40, 40, 40, 20);
		jbrun.setFont(ft1);
		jbno.setFont(ft1);
		
		jp_south.add(jbrun);
		jp_south.add(jbno);
		
		this.setSize(375, 230);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	private int getIndexOfType(MenuVO mVO) {
		int idx = 0;
		for(int i = 0; i < type.length; i++) {
			if(type[i].toLowerCase().equals(mVO.getM_type().toLowerCase()))
				idx = i;
		}
		return idx;
	}
	public boolean checkToAdd() {
		return add;
	}
	public void setAdd(boolean add) {
		this.add = add;
	}
	
	public void reset() {
		jtf_mname.setText("");
		jtf_mprice.setText("");
		jcb1.setSelectedIndex(0);
		
	}
	public void setMVO(MenuVO mVO) {
		this.mVO = mVO;
	} 
	public MenuVO getDisplay() {
		this.mVO.setM_name(jtf_mname.getText());
		this.mVO.setM_price(Integer.parseInt(jtf_mprice.getText()));
		this.mVO.setM_type(jcb1.getSelectedItem().toString());
		return mVO;
	}
	public void setDisplay() {
		jtf_mname.setText(mVO.getM_name()); 
		jtf_mprice.setText(mVO.getM_price()+"");
		jcb1.setSelectedIndex(getIndexOfType(mVO));
	}

	public static void main(String[] args) {
		ChangeMenuView cmv = new ChangeMenuView();
		cmv.jcb1.setSelectedIndex(1);
				cmv.initDisplay();

	}
			
}