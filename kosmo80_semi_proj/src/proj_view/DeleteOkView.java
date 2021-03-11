package proj_view;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import proj_back.EventHandler;

public class DeleteOkView extends JDialog {

	MainView 		mv       	= null;
	EventHandler   	eh 			= null;
	
	JLabel  		jl        	= new JLabel("정말로 항목을 삭제할까요?");
	JPanel  		jp_south  	= new JPanel();
	JPanel  		jp_center 	= new JPanel();
	public RButton 	jb_delete    	= new RButton("삭제");
	public RButton 	jb_no     	= new RButton("아니요");
	
	
	
	public DeleteOkView(MainView mv) {
		this.mv=mv;
	}
	public DeleteOkView() {
	}
	public void initDiplayOkView() {
		Font ft1 = new Font("휴먼모음T", Font.PLAIN, 15);
		Font ft3 = new Font("휴먼모음T", Font.PLAIN, 17);
		Font ft2 = new Font("Ariel", Font.BOLD, 15);
		eh = mv.eh;
		System.out.println("okv initdisplay호출 성공");
		this.add("Center",jp_center);
		this.add("South",jp_south);
		
		jp_center.add(jl);
		jp_south.add(jb_delete);
		jp_south.add(jb_no);
		jl.setHorizontalAlignment(JLabel.CENTER);
		
		jb_delete.setFont(ft1);
		jb_no.setFont(ft1);
		jl.setFont(ft3);
		
		this.setSize(300, 150);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		BuyOkView ok = new BuyOkView();
		ok.initDiplayOkView();
	}
}

	

