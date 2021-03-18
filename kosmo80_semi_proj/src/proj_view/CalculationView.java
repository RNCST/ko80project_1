package proj_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import proj_back.EventHandler;
import proj_back.MenuVO;
import proj_back.TransactionVO;

public class CalculationView extends JFrame {

	MainView       		mv 				= null;
	static EventHandler eh 				= null;
	JFrame         		jf 				= null;
	JPanel     			jpList 			= null;
	JPanel   			jpButton 		= null;
	public JTable       jtb_1 			= null;
	JTable        		jtb_2 			= null;
	JScrollPane   		jsp_1 			= null;
	JScrollPane   		jsp_2 			= null;
	public RButton     	jb_rf 			= null;
	public RButton     	jb_out 			= null;
	TitledBorder 		tb_south  		= null;
	DefaultTableModel 	detm_1			= null;
	DefaultTableModel 	detm_2			= null;
	String 				array_1[]       = {"주문번호", "주문일시", "주문금액"};
	String 				array_2[]    		= {"메뉴명", "가격"};
	String 				data_1[][]   	= new String[0][2];
	String 				data_2[][]   		= new String[0][1];
	Font 				ft1 			= null; 
	
	
	
 
	
	
	
	public CalculationView() {
		System.out.println("clv initdisplay호출 성공");
		detm_1        = new DefaultTableModel(data_1, array_1);
		jtb_1         = new JTable(detm_1);
		jsp_1         = new JScrollPane(jtb_1);
		detm_2        = new DefaultTableModel(data_2, array_2);
		jtb_2         = new JTable(detm_2);
		jsp_2         = new JScrollPane(jtb_2);
		jpList      = new JPanel();
		tb_south	= new TitledBorder(new LineBorder(Color.white));
		ft1 		= new Font("휴먼모음T", Font.PLAIN, 15);
		jb_rf       = new RButton("거래상세");
		jb_out      = new RButton("O L 모드 종료");
		jpButton    = new JPanel();
		
	}

	public CalculationView(MainView mv) {
		this();
		this.mv = mv;
		eh = mv.eh;
	}
	public void initDisplay() {
		jsp_1.setPreferredSize(new Dimension(610,760));
		jpList.add(jsp_1);
		jpList.setBackground(Color.LIGHT_GRAY);
		jsp_2.setPreferredSize(new Dimension(310,760));
		jpList.add(jsp_2);
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
		this.setSize(950,800);
		this.setMinimumSize(getSize());
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void setTransaction(Vector<TransactionVO> tVOS) {
		for(int i=0;i<tVOS.size();i++) {
		    Vector oneRow = new Vector();
		    oneRow.add(tVOS.elementAt(i).getT_num());
		    oneRow.add(tVOS.elementAt(i).getT_date());
		    oneRow.add(tVOS.elementAt(i).getT_total());
		    this.detm_1.addRow(oneRow);
		}
	}
	
	public void setDetail(Vector<MenuVO> mVOS) {
		for(int i=0;i<mVOS.size();i++) {
		    Vector oneRow = new Vector();
		    oneRow.add(mVOS.elementAt(i).getM_name());
		    oneRow.add(mVOS.elementAt(i).getM_price());
		    this.detm_2.addRow(oneRow);
		}
	}
	
	public void refresh() {
		   while(this.detm_2.getRowCount()>0) {
	            this.detm_2.removeRow(0);
	         }
	}


public static void main(String[] args) {
	 CalculationView ca = new CalculationView();
	 ca.initDisplay();
 }
}
