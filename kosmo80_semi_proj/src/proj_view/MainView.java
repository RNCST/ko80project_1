package proj_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author OSH
 * 맨 처음 손님이 주문하는 창, 메뉴수정하는 창 , 전표보는 창을 고르는 창을 띄우기
 * Cview , Sview , Aview 세개로 나눠서
 */
public class MainView implements ActionListener{
	// 선언부
	static MainView mv= null;
	JFrame  jf        = null;
	JButton jbco      = new JButton("C.O");
	JButton jbul      = new JButton("U.L");
	JButton jbol      = new JButton("O.L");
	JPanel  jp_center = new JPanel();
	JPanel  jp_north  = new JPanel();
	JPanel  jp_south  = new JPanel();
	JLabel  jlb       = new JLabel();
	JLabel  jlb2      = new JLabel();
	JLabel  jlb3      = new JLabel();
	JLabel  jlb4      = new JLabel();
	CView   cv        = new CView();
	SView   sv        = new SView();
	OView   ov        = new OView();
	
	
	
	
	//화면처리부
	public void initDisplayMainView() {
		jf = new JFrame();
		jbco.addActionListener(this);
		jbul.addActionListener(this);
		jbol.addActionListener(this);
		
		jf.setSize(400,300);
		jf.setTitle("k80 키오스크 시스템");
		jf.setVisible(true);
		
		jf.getContentPane().setLayout(null);
		
        jlb.setBounds(0, 20, 400, 70);
        jlb.setHorizontalAlignment(JLabel.CENTER);
        jlb.setText("<html>KO80 키오스크 첫 화면입니다<br> C.O 는 손님모드 "
        		+ "<br> U.L 은 메뉴수정 <br> O. L 은 매출 전표입니다.</html>");
        jf.getContentPane().add(jlb);
        
		jbco.setBounds( 10, 170, 122, 30);
	    jbul.setBounds(130, 170, 122, 30);
	    jbol.setBounds(250, 170, 122, 30);
	    
	    jf.getContentPane().add(jbco);
        jf.getContentPane().add(jbul);
        jf.getContentPane().add(jbol);
        
		jf.setLocationRelativeTo(null);
		// 윈도우 위치.
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		mv = new MainView();
		mv.initDisplayMainView();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		// TODO Auto-generated method stub
		if(obj == jbco) {
			cv.setVisible(true);
		}else if(obj == jbul) {
			sv.setVisible(true);
		}else if(obj == jbol) {
			ov.setVisible(true);
			
		}
		
	}

}
