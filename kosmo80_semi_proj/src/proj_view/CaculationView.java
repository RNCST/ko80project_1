package proj_view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import proj_back.EventHandler;

public class CaculationView extends JFrame {

	MainView       mv = null;
	static EventHandler   eh = null;
	
	JFrame         jf = null;
	JPanel     jpList = null;
	JPanel   jpButton = null;
	JTable        jtb = null;
	JScrollPane   jsp = null;
	public JButton     jb_rf = null;
	TitledBorder tb_south  = new TitledBorder(new LineBorder(Color.white));
	DefaultTableModel detm = null;
	String array[]    = {"판매내역"};
	String data[][]   = new String[0][0];
	
	
 
	
	
	
	public CaculationView(MainView mv) {
		this.mv = mv;
	}
	public CaculationView() {
		
	}

	public void initDisplay() {
		eh = mv.eh;
		System.out.println("clv initdisplay호출 성공");
		detm        = new DefaultTableModel(data, array);
		jtb         = new JTable(detm);
		jsp         = new JScrollPane(jtb);
		jsp.setPreferredSize(new Dimension(810,760));
		
		
		jpList      = new JPanel();
		jpList.add(jsp);
		jpList.setBackground(Color.LIGHT_GRAY);
		
		jb_rf       = new JButton("새로 고침");
		
		jb_rf.setPreferredSize(new Dimension(150,50));
		
		jpButton    = new JPanel();
		jpButton.setBorder(tb_south);
		jpButton.setBackground(Color.LIGHT_GRAY);
		jpButton.add(jb_rf);
		
		
		this.add("Center",jpList);
		this.add("South",jpButton);
		this.setSize(800,800);
		this.setMinimumSize(getSize());
		this.setVisible(true);
	}


public static void main(String[] args) {
	 CaculationView ca = new CaculationView();
	 ca.initDisplay();
 }
}
