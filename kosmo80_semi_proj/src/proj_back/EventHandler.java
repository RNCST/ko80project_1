package proj_back;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import proj_view.CView;
import proj_view.CartView;
import proj_view.MainView;
/**************************************************************
 * 
 **************************************************************/
//Main View 에서  ActionEvent를 받아오는 EventHandler 입니다.
public class EventHandler implements ActionListener {
	//선언부
	     MainView mv  = null;
	     CView    cv  = null;
	     CartView cav = null; 
	
	//생성자
	public EventHandler(MainView mv) {
		this.mv = mv;
		this.mv.jbco.addActionListener(this);
		this.mv.jbul.addActionListener(this);
		this.mv.jbol.addActionListener(this);
	}
	
	public EventHandler(MainView mv, CartView cav) {
		System.out.println("mv eh 성공");
		this.mv = mv;
		this.mv.jbco.addActionListener(this);
		this.mv.jbul.addActionListener(this);
		this.mv.jbol.addActionListener(this);
		this.cav = cav;
		this.cav.jb_buy.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("11");
		Object obj = ae.getSource();
		String cmd = ae.getActionCommand();
		System.out.println("event labetl:"+cmd);
		// TODO Auto-generated method stub
		if("C.O".equals(cmd)) {
			cv = new CView();
			cv.initDisplay();
		}else if ("장바구니에 추가".equals(cmd)) {
			
		}else if ("결제하기".equals(cmd)) {
			
		}else if ("취소하기".equals(cmd)) {
			
		}else if ("새로 고침".equals(cmd)) {
			
		}
	}
}