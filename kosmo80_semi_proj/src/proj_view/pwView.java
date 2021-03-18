package proj_view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import proj_back.EventHandler;

public class pwView extends JDialog {

	MainView mv  = null;
	EventHandler   eh  = null;
	
	public RButton jb_1 = null;
	public RButton jb_2 = null;
	public RButton jb_3 = null;
	public RButton jb_4 = null;
	public RButton jb_5 = null;
	public RButton jb_6 = null;
	public RButton jb_7 = null;
	public RButton jb_8 = null;
	public RButton jb_9 = null;
	public RButton jb_0 = null;
	public RButton jb_b1 = null;
	public RButton jb_b2 = null;
	
	Font        ft1      = null;
	Font        ft2      = null;
	

	public pwView() {

		jb_1 = new RButton("1");
		jb_2 = new RButton("2");
		jb_3 = new RButton("3");
		jb_4 = new RButton("4");
		jb_5 = new RButton("5");
		jb_6 = new RButton("6");
		jb_7 = new RButton("7");
		jb_8 = new RButton("8");
		jb_9 = new RButton("9"); 
		jb_0 = new RButton("0");
		jb_b1= new RButton("지우기");
		jb_b2= new RButton("입  력");


		ft1 = new Font("휴먼모음T", Font.PLAIN, 15);
		ft2 = new Font("Ariel", Font.BOLD, 30);

	}
	public pwView(MainView mv) {
		this();
		this.mv = mv;
		eh = mv.eh;
	}
	public void initDisplay() {
		
		
//		this.setContentPane(jb_0);
//		this.setContentPane(jb_1);
		this.setLayout(new GridLayout(4,3,10,10));
		this.add(jb_7);
		this.add(jb_8);
		this.add(jb_9);
		this.add(jb_4);
		this.add(jb_5);
		this.add(jb_6);
		this.add(jb_1);
		this.add(jb_2);
		this.add(jb_3);
		this.add(jb_b1);
		this.add(jb_0);
		this.add(jb_b2);
		
//		jb_9.setPreferredSize(new Dimension(10,40));
//		jb_8.setPreferredSize(new Dimension(40,40));
//		jb_7.setPreferredSize(new Dimension(40,40));
//		jb_6.setPreferredSize(new Dimension(40,40));
//		jb_5.setPreferredSize(new Dimension(40,40));
//		jb_4.setPreferredSize(new Dimension(40,40));
//		jb_3.setPreferredSize(new Dimension(40,40));
//		jb_2.setPreferredSize(new Dimension(40,40));
//		jb_1.setPreferredSize(new Dimension(40,40));
//		jb_0.setPreferredSize(new Dimension(40,40));
//		jb_b1.setPreferredSize(new Dimension(40,40));
//		jb_b2.setPreferredSize(new Dimension(40,40));
		jb_9.setFont(ft2);
		jb_8.setFont(ft2);
		jb_7.setFont(ft2);
		jb_6.setFont(ft2);
		jb_5.setFont(ft2);
		jb_4.setFont(ft2);
		jb_3.setFont(ft2);
		jb_2.setFont(ft2);
		jb_1.setFont(ft2);
		jb_0.setFont(ft2);
		jb_b1.setFont(ft2);
		jb_b2.setFont(ft2);
		
		this.setSize(300,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLocation(1180, 390);
		this.setResizable(false);
		
		
		
	}
	

	public static void main(String[] args) {
		pwView pv = new pwView();
		pv.initDisplay();
	}

}
