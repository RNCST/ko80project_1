package proj_view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import proj_back.EventHandler;

public class OkView extends JDialog{

	MainView mv       = null;
	EventHandler   eh = null;
	
	JLabel  jl        = new JLabel("결제를 하시려면 결제버튼을 눌러주세요");
	JPanel  jp_south  = new JPanel();
	JPanel  jp_center = new JPanel();
	public JButton jb_buy    = new JButton("결제");
	public JButton jb_no     = new JButton("취소");
	
	
	
	public OkView(MainView mv) {
		this.mv=mv;
	}
	public OkView() {
		
	}
	public void initDiplayOkView() {
		eh = mv.eh;
		System.out.println("okv initdisplay호출 성공");
		this.add("Center",jp_center);
		this.add("South",jp_south);
		
		jp_center.add(jl);
		jp_south.add(jb_buy);
		jp_south.add(jb_no);
		jl.setHorizontalAlignment(JLabel.CENTER);
		
		this.setSize(300, 150);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		OkView ok = new OkView();
		ok.initDiplayOkView();
	}
}
