package proj_view;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.BoundDocument;

public class SignUpView extends JDialog {

	MainView mv     = null;
	
	
	public RButton jb_chpw  = null;
	public RButton jb_out    = null;

	public RTextField     jtf_pw    = null;

	JPanel         jp_south  = null;
	JPanel         jp_center = null;

	JLabel         jlb = null;

	Font           ft1 = null;
	Font           ft2 = null;
	Font           ft3 = null;

	public SignUpView() {
		jb_chpw  = new RButton("change pw");
		jb_out    = new RButton("Cancel");

		jtf_pw    = new RTextField(4);
		jp_south  = new JPanel();
		jp_center = new JPanel();
		
		jlb      = new JLabel(); 

		ft1      = new Font("휴먼모음T", Font.PLAIN, 15);
		ft2      = new Font("Ariel", Font.BOLD, 15);
		ft3      = new Font("Ariel", Font.BOLD, 50);

	}
	public SignUpView(MainView mv) {
		this();
		this.mv = mv;
	}
	public void initDisplay() {
		this.setLayout(null);
		
		jb_chpw.setFont(ft2);
		jb_out.setFont(ft2);
		jlb.setFont(ft1);
		
		
		jlb.setBounds(0, 20, 400, 100);
		jlb.setHorizontalAlignment(JLabel.CENTER);
		jlb.setText(" 사용하고자 하는 pw를 입력해 주세요 ");
		
		jtf_pw.setBounds(116, 80, 140, 60);
		jtf_pw.setHorizontalAlignment(JLabel.CENTER);
		jtf_pw.setDocument(new BoundDocument(4, jtf_pw));
		jtf_pw.setFont(ft3);
		jtf_pw.setEnabled(false);
		
		this.add(jlb);
		this.add(jtf_pw);
		
		jb_chpw.setBounds( 40, 170, 112, 30);
	    jb_out.setBounds(220, 170, 112, 30);
		
		this.add(jb_chpw);
		this.add(jb_out);
		
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

		SignUpView suv = new SignUpView();
		suv.initDisplay();
	}

}















