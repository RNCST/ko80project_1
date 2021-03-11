package proj_back;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import proj_view.BuyOkView;
import proj_view.CView;
import proj_view.CalculationView;
import proj_view.CartView;
import proj_view.ChangeMenuView;
import proj_view.DeleteOkView;
import proj_view.InterView;
import proj_view.MainView;
import proj_view.UView;

/**************************************************************
 * 
 **************************************************************/
//Main View 에서  ActionEvent를 받아오는 EventHandler 입니다.
public class EventHandler implements ActionListener 
                                    ,ItemListener{
	// 선언부
	MainView 		mv 		= null;
	CView 			cv 		= null;
	UView           uv      = null;
	CartView 		cav 	= null;
	BuyOkView 		bokv 	= null;
	DeleteOkView    dokv    = null;
	ChangeMenuView  cmv     = null;
	CalculationView clv 	= null;
	DBLogic 		db 		= null;
	Vector<MenuVO>  mVOS 	= null;
	MenuVO			cart[]	= null;
	InterView		iv		= null;
	String[]		m_type	= {"main", "beverage", "side"};
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
		this.cv.jb_see.addActionListener(this);
		this.cv.jb_new.addActionListener(this);
//		this.cv.jb_set.addActionListener(this);
		this.cv.jb_hot.addActionListener(this);
		this.cv.jb_main.addActionListener(this);
		this.cv.jb_drink.addActionListener(this);
		this.cv.jb_side.addActionListener(this);
		
		
		this.uv = new UView(this.uv);
		this.uv.jb_ins.addActionListener(this);
		this.uv.jb_upd.addActionListener(this);
		this.uv.jb_del.addActionListener(this);
		this.uv.jb_out.addActionListener(this);
		this.uv.jb_new.addActionListener(this);
		this.uv.jb_hot.addActionListener(this);
		this.uv.jb_main.addActionListener(this);
		this.uv.jb_drink.addActionListener(this);
		this.uv.jb_side.addActionListener(this);

		this.cav = new CartView(this.mv);
		this.cav.jb_buy.addActionListener(this);
		this.cav.jb_cancel.addActionListener(this);

		this.bokv = new BuyOkView(this.mv);
		this.bokv.jb_buy.addActionListener(this);
		this.bokv.jb_no.addActionListener(this);
		
		this.dokv = new DeleteOkView(this.mv);
		this.dokv.jb_delete.addActionListener(this);
		this.dokv.jb_no.addActionListener(this);
		
		this.cmv = new ChangeMenuView(this.mv);
		this.cmv.jbrun.addActionListener(this);
		this.cmv.jbno.addActionListener(this);
		this.cmv.jcb1.addItemListener(this);
		this.cmv.jcb1.addActionListener(this);

		this.clv = new CalculationView(this.mv);
		this.clv.jb_out.addActionListener(this);
		this.clv.jb_rf.addActionListener(this);
		
		this.db = DBLogic.getInstance();
		this.mVOS = db.getList("main");

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		String cmd = ae.getActionCommand();
		if ("C.O".equals(cmd)) {
			iv = this.cv;
			cv.refresh();
			System.out.println("event labetl:" + cmd);
			try {
				this.mVOS = db.getList("main");
				
			} catch (Exception e) {
				System.out.println(e);
			}
			cv.initDisplay();
			cv.setVisible(true);
			cv.setrow(this.mVOS);
			// CView띄우기
			
		} else if ("N E W".equals(cmd)) {
			iv.refresh();
			System.out.println("event labetl:" + cmd);
			try {
				this.mVOS = db.getList();
				
			} catch (Exception e) {
				System.out.println(e);
			}
			iv.setrow(this.mVOS);
			
		} else if ("H O T".equals(cmd)) {
			//판매량에 따른 분류
			System.out.println("event labetl:" + cmd);
			return;
			
//		} else if ("S E T".equals(cmd)) {
//			System.out.println("event labetl:" + cmd);
//			return;
			
		}else if ("M A I N".equals(cmd)) {
			iv.refresh();
			System.out.println("event labetl:" + cmd);
			try {
				this.mVOS = db.getList("main");
				
			} catch (Exception e) {
				System.out.println(e);
			}
			iv.setrow(this.mVOS);
			// main 눌렀을떄
			
		}else if ("DRINK".equals(cmd)) {
			iv.refresh();
			System.out.println("event labetl:" + cmd);
			try {
				this.mVOS = db.getList("beverage");
				
			} catch (Exception e) {
				System.out.println(e);
			}
			iv.setrow(this.mVOS);
			return;
			// drink 눌렀을때
			
		}else if ("S I D E".equals(cmd)) {
			iv.refresh();
			System.out.println("event labetl:" + cmd);
			try {
				this.mVOS = db.getList("side");
				
			} catch (Exception e) {
				System.out.println(e);
			}
			iv.setrow(this.mVOS);
			// side 눌렀을때
			

		} else if ("O.L".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			clv.initDisplay();
			return;
			// CalculationView띄우기
			
			
		} else if ("U.L".equals(cmd)) {
			uv.refresh();
			System.out.println("event labetl:" + cmd);
			iv = this.uv;
			try {
				this.mVOS = db.getList();
				
			} catch (Exception e) {
				System.out.println(e);
			}
			uv.initDisplay();
			uv.setVisible(true);
			uv.setrow(this.mVOS);
			return;
			// UView띄우기
			
			
			
		} else if ("장바구니에 담기".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			try {
				cav.addCartList(mVOS.elementAt(cv.jtb.getSelectedRow()));
				System.out.println("addCartList실행됨");
				JOptionPane.showMessageDialog(cv, "장바구니에 추가되었습니다.");
				cav.refresh();
				cav.showCartList();
				cav.initDisplay();
			} catch(ArrayIndexOutOfBoundsException ie) {
				JOptionPane.showMessageDialog(cv, "메뉴를 선택하여 주십시오");
			}
			
			
		} else if ("장바구니 확인".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			cav.refresh();
			cav.showCartList();
			cav.initDisplay();
			// CartView 띄우기
			
			
			
		} else if ("결제하기".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			bokv.initDiplayOkView();
			return;
			// OKView 띄우기
			
			
		} else if ("취소하기".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			cav.cartRemove();
			this.cav.dispose();
			return;
			// CartView 끄기
			
			
			
			
		} else if ("결제".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			cav.cartRemove();
			System.out.println(bokv.getTimer());
			return;
			// OkView 끄고 팝업 띄우기
			
			
		} else if (cav.jb_cancel==obj) {
			System.out.println("event labetl:" + cmd);
			this.bokv.dispose();
			return;
			
			
		} else if (dokv.jb_delete==obj) {
			System.out.println("event labetl:" + cmd);
			int idx = uv.jtb.getSelectedRow();
			db.deleteMenu(mVOS.elementAt(idx).getM_name());
			mVOS.remove(idx);
			uv.refresh();
			uv.setrow(this.mVOS);
			this.dokv.dispose();
			return;
			//DeleteOkView
			
		} else if ("아니요".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			this.dokv.dispose();
			return;
			//DeleteOkView
			
		} else if (cmv.jcb1==obj) {
			System.out.println("event labetl:" + cmd);
			String name = (String)cmv.jcb1.getSelectedItem();
			System.out.println(name);
			
			return;
		} else if ("항목 추가".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			cmv.initDisplay();
			return;
			
		} else if ("항목 수정".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			cmv.initDisplay();
			return;
			
		} else if ("항목 삭제".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			dokv.initDiplayOkView();
			return;
			
		} else if ("처리".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
	
			this.cmv.dispose();
			return;
			
		} else if (cmv.jbno==obj) {
			System.out.println("event labetl:" + cmd);
			
			this.cmv.dispose();
			return;
			
		} else if ("U L 모드 종료".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			this.uv.dispose();
			return;
			
		} else if ("O L 모드 종료".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			this.clv.dispose();
			return;
			
		} else if ("새로 고침".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			return;
			// CaculationView 새로고침하기
	}
}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		 	System.out.println("JCombobox 감지");
		}
		
}

