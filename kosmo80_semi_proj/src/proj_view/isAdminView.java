package proj_view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import proj_back.EventHandler;
import proj_back.BoundDocument;

public class isAdminView extends JFrame {
	
	isAdminView iav = null;
	MainView mv     = null;
	EventHandler eh = null;

	public RButton jb_login = null;
	public RButton jb_chpw = null;
	public RButton jb_out = null;
	
	public RButton jb_input = null;


	public RTextField jtf_pw = null;

	JPanel jp_south = null;
	JPanel jp_center= null;
	JPanel jp_east  = null;

	JLabel jlb = null;

	Font ft1 = null;
	Font ft2 = null;
	Font ft3 = null;

	public isAdminView() {
		jb_login  = new RButton("login");
		jb_chpw   = new RButton("change pw");
		jb_out    = new RButton("Cancel");
		jb_input  = new RButton("패스워드 입력");

		jtf_pw    = new RTextField(4);
		jp_south  = new JPanel();
		jp_center = new JPanel();
		jp_east   = new JPanel();
		
		jlb      = new JLabel();

		ft1      = new Font("휴먼모음T", Font.PLAIN, 15);
		ft2      = new Font("Ariel", Font.BOLD, 15);
		ft3      = new Font("Ariel", Font.BOLD, 50);

	}
	public isAdminView(MainView mv) {
		this();
		this.mv = mv;
		eh = mv.eh;
	}
	public void initDisplay() {
		this.getContentPane().setLayout(null);
		
		jb_login.setFont(ft2);
		jb_chpw.setFont(ft2);
		jb_out.setFont(ft2);
		jb_input.setFont(ft2);
		jlb.setFont(ft2);
		
		
		jlb.setBounds(0, 0, 400, 100);
		jlb.setHorizontalAlignment(JLabel.CENTER);
		jlb.setText("<html>로그인을 위해 <br>"
				+ "패스워드를 입력해주십시오.</html>");
		
		jtf_pw.setBounds(116, 80, 140, 60);
		jtf_pw.setDocument(new BoundDocument(4, jtf_pw));
		jtf_pw.setHorizontalAlignment(JLabel.CENTER);
		jtf_pw.setFont(ft3);
		jtf_pw.setEnabled(false);
		
		
		this.getContentPane().add(jlb);
		this.getContentPane().add(jtf_pw);
		
		jb_login.setBounds( 10, 170, 112, 30);
	    jb_chpw.setBounds(130, 170, 112, 30);
	    jb_out.setBounds(250, 170, 112, 30);
	    jb_input.setBounds(130, 100, 112, 25);
	    
	    this.getContentPane().add("East", jp_east);
		
		this.getContentPane().add(jb_login);
		this.getContentPane().add(jb_chpw);
		this.getContentPane().add(jb_out);
		this.getContentPane().add(jb_input);
		
		this.setTitle("관리자 진입확인");
		this.setSize(400,300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
	}
	public String get_text() { return jtf_pw.getText();}
	public void set_text(String text) {
		jtf_pw.setText(text);
	}
	public static void main(String[] args) {

		isAdminView iav = new isAdminView();
		iav.initDisplay();
	}

}
















