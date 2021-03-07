package proj_back;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import proj_view.MainView;
/**************************************************************
 * 
 **************************************************************/
//Main View 에서  ActionEvent를 받아오는 EventHandler 입니다.
public class EventHandler implements ActionListener {
	//선언부
	MainView mView = null;
	
	//생성자
	EventHandler(MainView mView) {
		this.mView = mView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//Object obj = ae.getSource();
		String cmd = ae.getActionCommand();

		if("".equals(cmd)) {
			
		}
	}

}
