package proj_back;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import proj_view.CView;
import proj_view.CaculationView;
import proj_view.CartView;
import proj_view.MainView;
import proj_view.OkView;

/**************************************************************
 * 
 **************************************************************/
//Main View 에서  ActionEvent를 받아오는 EventHandler 입니다.
public class EventHandler implements ActionListener {
	// 선언부
	MainView mv = null;
	CView cv = null;
	CartView cav = null;
	OkView okv = null;
	CaculationView clv = null;
	DBLogic db = null;
	MenuVO      mVOS[]      = null;
	// 생성자
//	public EventHandler(CView cv) {
//		this.cv = cv;
//		this.cv.jb_in.addActionListener(this);
//	}

	public EventHandler(MainView mv) {
		this.mv = mv;
		this.mv.jbco.addActionListener(this);
		this.mv.jbul.addActionListener(this);
		this.mv.jbol.addActionListener(this);

		this.cv = new CView(this.mv);
		this.cv.jb_in.addActionListener(this);

		this.cav = new CartView(this.mv);
		this.cav.jb_buy.addActionListener(this);
		this.cav.jb_cancel.addActionListener(this);

		this.okv = new OkView(this.mv);
		this.okv.jb_buy.addActionListener(this);
		this.okv.jb_no.addActionListener(this);

		this.clv = new CaculationView(this.mv);
//		this.clv.jb_rf.addActionListener(this);
		this.db = DBLogic.getInstance();
		this.mVOS = db.getList("main");

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		String cmd = ae.getActionCommand();
		if ("C.O".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			try {
				this.mVOS = db.getList("main");
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			cv.initDisplay();
			cv.setrow(this.mVOS);
			// CView띄우기
			
			
		} else if ("O.L".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			clv.initDisplay();
			// CView띄우기
			
			
			
		} else if ("장바구니에 추가".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			cav.initDisplay();
			// CartView 띄우기
			
			
			
		} else if ("결제하기".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			okv.initDiplayOkView();
			return;
			// OKView 띄우기
			
			
			
		} else if ("취소하기".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			this.okv.dispose();
			System.gc();
			return;
			// CartView 끄기
			
			
		} else if ("새로 고침".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			return;
			// CaculationView 새로고침하기
			
			
		} else if ("결제".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			return;
			// OkView 끄고 팝업 띄우기
			
			
		} else if ("취소".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			this.okv.dispose();
			System.gc();
			return;
			// OkView 끄기
		}
	}
}
