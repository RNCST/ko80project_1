package proj_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import proj_back.EventHandler;

public class CalculationView extends JFrame {

	MainView       		mv 				= null;
	static EventHandler eh 				= null;
	JFrame         		jf 				= null;
	JPanel     			jpList 			= null;
	JPanel   			jpButton 		= null;
	JTable        		jtb 			= null;
	JScrollPane   		jsp 			= null;
	public RButton     	jb_rf 			= null;
	public RButton     	jb_out 			= null;
	TitledBorder 		tb_south  		= null;
	DefaultTableModel 	detm 			= null;
	String 				array[]    		= {"판매내역"};
	String 				data[][]   		= new String[0][0];
	Font 				ft1 			= null; 
 
	
	
	
	public CalculationView() {
		System.out.println("clv initdisplay호출 성공");
		detm        = new DefaultTableModel(data, array);
		jtb         = new JTable(detm);
		jsp         = new JScrollPane(jtb);
		jpList      = new JPanel();
		tb_south	= new TitledBorder(new LineBorder(Color.white));
		ft1 		= new Font("휴먼모음T", Font.PLAIN, 15);
		jb_rf       = new RButton("새로 고침");
		jb_out      = new RButton("O L 모드 종료");
		jpButton    = new JPanel();
		
	}

	public CalculationView(MainView mv) {
		this();
		this.mv = mv;
		eh = mv.eh;
	}
	public void initDisplay() {
		jsp.setPreferredSize(new Dimension(810,760));
		jpList.add(jsp);
		jpList.setBackground(Color.LIGHT_GRAY);
		
		jb_out.setFont(ft1);
		jb_rf.setFont(ft1);
		
		jb_rf.setPreferredSize(new Dimension(150,50));
		jb_out.setPreferredSize(new Dimension(150,50));
		
		jpButton.setBorder(tb_south);
		jpButton.setBackground(Color.LIGHT_GRAY);
		jpButton.add(jb_rf);
		jpButton.add(jb_out);
		
		
		this.add("Center",jpList);
		this.add("South",jpButton);
		this.setSize(800,800);
		this.setMinimumSize(getSize());
		this.setVisible(true);
	}


public static void main(String[] args) {
	 CalculationView ca = new CalculationView();
	 ca.initDisplay();
 }
}
