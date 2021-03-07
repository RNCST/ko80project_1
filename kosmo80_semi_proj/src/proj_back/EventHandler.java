package proj_back;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import proj_view.CView;
import proj_view.MainView;
/**************************************************************
 * 
 **************************************************************/
//Main View 에서  ActionEvent를 받아오는 EventHandler 입니다.
public class EventHandler implements ActionListener {
	//선언부
	static MainView mv  = null;
	CView    cv  = null;
	
	//생성자
	public EventHandler(MainView mv) {
		System.out.println("mv eh 성공");
		this.mv = mv;
		this.mv.jbco.addActionListener(this);
		this.mv.jbul.addActionListener(this);
		this.mv.jbol.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("11");
		Object obj = ae.getSource();
		System.out.println("22");
		String cmd = ae.getActionCommand();
		System.out.println("33");
		// TODO Auto-generated method stub
		if("C.O".equals(cmd)) {
			cv = new CView();
			cv.initDisplay();
//		}else if(obj == jbul) {
////			sv.setVisible(true);
//		}else if(obj == jbol) {
////			ov.setVisible(true);
			
		}
	}
}