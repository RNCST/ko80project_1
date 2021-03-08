package proj_view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import proj_back.EventHandler;

/**
 * @author OSH
 * 맨 처음 손님이 주문하는 창, 메뉴수정하는 창 , 전표보는 창을 고르는 창을 띄우기
 * Cview , Sview , Aview 세개로 나눠서
 */
public class MainView extends JFrame{
	// 선언부
	static MainView   mv  = null;
    EventHandler   eh     = null;
    CView     cv          = null;
    CartView  cav         = null;
    
    
	public JFrame  jf     = null;
	Container      co     = null;
	public JButton jbco   = new JButton("C.O");
	public JButton jbul   = new JButton("U.L");
	public JButton jbol   = new JButton("O.L");
	JPanel    jp_center   = new JPanel();
	JPanel    jp_north    = new JPanel();
	JPanel    jp_south    = new JPanel();
	JLabel    jlb         = new JLabel();
	JLabel    jlb2        = new JLabel();
	JLabel    jlb3        = new JLabel();
	JLabel    jlb4        = new JLabel();
//	SView   sv        = new SView();
//	OView   ov        = new OView();
	
	//화면처리부
	public void initDisplayMainView() {
		jf = new JFrame();
		co = new Container();
		
//		jbco.addActionListener(this);
//		jbul.addActionListener(this);  EventHandler로 넘어감.
//		jbol.addActionListener(this);
		
		co=this.getContentPane();
		//container가 jframe에??
		
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
		
		cav = new CartView();
		eh = new EventHandler(this, cav);
		
		jf.setSize(400,300);
		jf.setTitle("k80 키오스크 시스템");
		jf.setVisible(true);
		//프레임에 버튼과 라벨을 놓지말고  패널을 두개 만들어서 놓을것.
		//제이프레임이 아닌 제일 바닥 바탕에 컨테인이라는 요소가 있는데 getContentPane을 하면 컨텐트에 요소가 추가가됨.
		//소켓통신
	}
	
		

	public static void main(String[] args) {
		mv = new MainView();
		mv.initDisplayMainView();

	
		
	}


	
}
