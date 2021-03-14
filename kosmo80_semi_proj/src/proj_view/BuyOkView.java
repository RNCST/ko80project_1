package proj_view;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import proj_back.EventHandler;

public class BuyOkView extends JDialog{

	MainView 		mv       	= null;
	EventHandler   	eh 			= null;
	
	JLabel  		jl        	= new JLabel("결제를 하시려면 결제버튼을 눌러주세요");
	JPanel  		jp_south  	= new JPanel();
	JPanel  		jp_center 	= new JPanel();
	public RButton 	jb_buy    	= new RButton("결제");
	public RButton 	jb_no     	= new RButton("취소");
	
	
	
	public BuyOkView(MainView mv) {
		this.mv=mv;
	}
	public BuyOkView() {
	}
	
		
	public String getTimer() {
		Calendar cal = Calendar.getInstance();
		
		int year     = cal.get(Calendar.YEAR);
		int month    = cal.get(Calendar.MONTH);
		int day      = cal.get(Calendar.DATE);
		int hour     = cal.get(Calendar.HOUR_OF_DAY);
		int min      = cal.get(Calendar.MINUTE);
		int sec      = cal.get(Calendar.SECOND);
//		String str1   = Integer.toString(hour);
//		if(str1.length()==1) {
//			str1 = "0"+str1;
//		}
//		String str2   = Integer.toString(min);
//		if(str2.length()==1) {
//			str2 = "0"+str2;
//		}
//		String str3   = Integer.toString(sec);
//		if(str3.length()==1) {
//			str3 = "0"+str3;
//		}
		return year+"년"+month+"월"+day+"일 "+hour+":"+min+":"+sec;
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
		jp_south.add(jb_buy);
		jp_south.add(jb_no);
		jl.setHorizontalAlignment(JLabel.CENTER);
		
		jb_buy.setFont(ft1);
		jb_no.setFont(ft1);
		jl.setFont(ft3);
		
		this.setSize(300, 150);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		BuyOkView ok = new BuyOkView();
		System.out.println(ok.getTimer());
		ok.initDiplayOkView();
	}
}
