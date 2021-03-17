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
import proj_view.SignUpView;
import proj_view.UView;
import proj_view.isAdminView;
import proj_view.pwView;

/**************************************************************
 * 
 **************************************************************/
//Main View 에서  ActionEvent를 받아오는 EventHandler 입니다.
public class EventHandler implements ActionListener, ItemListener {
	// 선언부
	MainView mv = null;
	CView cv = null;
	UView uv = null;
	CartView cav = null;
	BuyOkView bokv = null;
	DeleteOkView dokv = null;
	ChangeMenuView cmv = null;
	CalculationView clv = null;
	DBLogic db = null;
	MenuVO mVO = null;
	Vector<MenuVO> mVOS = null;
	MenuVO cart[] = null;
	PwVO   pw[]   = null;
	InterView iv = null;
	isAdminView iav = null;
	SignUpView  suv = null;
	pwView      pv  = null; 
	String[] m_type = { "main", "drink", "side" };
	
	StringBuilder sb = new StringBuilder(4);
	String        st[] = {"0","0","0","0"};
	int idx = 0;
	public static int menuidx = 0;
	String type = "";
	public static String menutype = "";
	int isul    = 0;
	int isChangePw  = 0;
	int isSignUp    = 0;
	

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

		this.iav = new isAdminView(this.mv);
		this.iav.jb_login.addActionListener(this);
		this.iav.jb_chpw.addActionListener(this);
		this.iav.jb_out.addActionListener(this);
		this.iav.jb_input.addActionListener(this);
		
		this.suv = new SignUpView(this.mv);
		this.suv.jb_chpw.addActionListener(this);
		this.suv.jb_out.addActionListener(this);
		
		this.pv = new pwView(this.mv);
		this.pv.jb_1.addActionListener(this);
		this.pv.jb_2.addActionListener(this);
		this.pv.jb_3.addActionListener(this);
		this.pv.jb_4.addActionListener(this);
		this.pv.jb_5.addActionListener(this);
		this.pv.jb_6.addActionListener(this);
		this.pv.jb_7.addActionListener(this);
		this.pv.jb_8.addActionListener(this);
		this.pv.jb_9.addActionListener(this);
		this.pv.jb_0.addActionListener(this);
		this.pv.jb_b1.addActionListener(this);
		this.pv.jb_b2.addActionListener(this);

		this.db = DBLogic.getInstance();
		//this.mVOS = db.getList("main");
		//mVO = mVOS.elementAt(0);

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
				this.mVOS = db.getList();

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
			type = "";
			try {
				this.mVOS = db.getList();

			} catch (Exception e) {
				System.out.println(e);
			}
			iv.setrow(this.mVOS);

		} else if ("H O T".equals(cmd)) {
			// 판매량에 따른 분류
			System.out.println("event labetl:" + cmd);
			return;

//		} else if ("S E T".equals(cmd)) {
//			System.out.println("event labetl:" + cmd);
//			return;

		} else if ("M A I N".equals(cmd)) {
			iv.refresh();
			this.cmv.jcb1.setSelectedIndex(0);
			type = "main";
			System.out.println("event labetl:" + cmd);
			try {
				this.mVOS = db.getList("main");

			} catch (Exception e) {
				System.out.println(e);
			}
			iv.setrow(this.mVOS);
			// main 눌렀을떄

		} else if ("DRINK".equals(cmd)) {
			iv.refresh();
			this.cmv.jcb1.setSelectedIndex(1);
			System.out.println("콤보박스 drink로 변경");
			type = "drink";
			System.out.println("event labetl:" + cmd);
			try {
				this.mVOS = db.getList(type);

			} catch (Exception e) {
				System.out.println(e);
			}
			iv.setrow(this.mVOS);
			// drink 눌렀을때

		} else if ("S I D E".equals(cmd)) {
			iv.refresh();
			this.cmv.jcb1.setSelectedIndex(2);
			type = "side";
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
			isul = 0;
			iav.initDisplay();
			return;
			// CalculationView띄우기

		} else if ("U.L".equals(cmd)) {
			isul= 1;
			iav.initDisplay();
		
			return;
			// UView띄우기

		} else if ("장바구니에 담기".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			try {
				cav.addCartList(mVOS.elementAt(cv.jtb.getSelectedRow()));
				System.out.println("addCartList실행됨");
				int result = JOptionPane.showConfirmDialog(cv, "장바구니에 추가되었습니다.\n장바구니를 확인하시겠습니까?", "장바구니 확인", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					cav.refresh();
					cav.showCartList();
					cav.initDisplay();
				}else {
					
				}
			} catch (ArrayIndexOutOfBoundsException ie) {
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
			
			if(cav.isEmpty() == true) {
				JOptionPane.showMessageDialog(cav, "장바구니에 물건이 없습니다.");
			}
			else {
				bokv.initDiplayOkView();
			}
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
			int idx = db.getLastIndex("transaction");
			db.insertTransaction(idx, cav.getTotal());
			db.insertConnection(idx, cav.getCartList());
			bokv.dispose();
			cav.cartRemove();
			cav.dispose();
			JOptionPane.showMessageDialog(cv, "거래가 완료되었습니다.");
			return;
			// OkView 끄고 팝업 띄우기

		} else if (bokv.jb_no == obj) { //BuyOkView에서 취소
			System.out.println("event labetl:" + cmd);
			bokv.dispose();
			return;

		} else if (dokv.jb_delete == obj) { //항목삭제 시 최종 확인
			System.out.println("event labetl:" + cmd);
			int idx = uv.jtb.getSelectedRow();
			db.deleteMenu(mVOS.elementAt(idx).getM_num());
			mVOS.remove(idx);
			uv.refresh();
			uv.setrow(this.mVOS);
			this.dokv.dispose();
			return;
			// DeleteOkView

		} else if ("아니요".equals(cmd)) {
			System.out.println("아니요 event labetl:" + cmd);
			this.dokv.dispose();
			return;
			// DeleteOkView

		} else if (cmv.jcb1 == obj) {
			System.out.println("event labetl:" + cmd);
			menutype = (String) cmv.jcb1.getSelectedItem();
			System.out.println(menutype);
			
			return;
			
		} else if ("항목 추가".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			cmv.reset();
			cmv.setAdd(true);
			cmv.initDisplay();
			return;

		} else if ("항목 수정".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			cmv.setAdd(false);
			try {
				idx = uv.jtb.getSelectedRow();
				mVO = mVOS.elementAt(idx);
				cmv.setMVO(mVO);
				cmv.setDisplay();
				cmv.initDisplay();
				System.out.println("출력");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(cmv, "수정할 메뉴를 선택하여 주십시오");
			}
			return;

		} else if ("항목 삭제".equals(cmd)) {
			System.out.println("event labetl:" + cmd);
			dokv.initDiplayOkView();
			return;

		} else if ("처리".equals(cmd) && cmv.checkToAdd() == true) { // 항목추가에서 처리를 눌렀을때
			System.out.println("항목추가에서 처리를 눌렀을때");
			cmv.getDisplay();
			//System.out.println("cmv에서 mvo를 받아온 직후");
			int i = db.getLastIndex("menu");
			//System.out.println("db에서 idx를 받아온 직후");
			db.insertMenu(i , cmv.getMVO());
			//System.out.println("오라클에 전송");

			if (type.equals("")) {
				this.mVOS = db.getList();
			} else {
				this.mVOS = db.getList(type);
			}
			iv.refresh();
			iv.setrow(this.mVOS);
			this.cmv.dispose();

		} else if ("처리".equals(cmd) && cmv.checkToAdd() == false) { // 항목수정에서 처리를 눌렀을때
			System.out.println("항목수정에서 처리를 눌렀을때");
			cmv.getDisplay();
			db.updateMenu(cmv.getMVO());
			System.out.println("event labetl:" + "update실행");
			if (type.equals(""))
				this.mVOS = db.getList();
			else
				this.mVOS = db.getList(type);
			iv.refresh();
			iv.setrow(this.mVOS);
			this.cmv.dispose();

		} else if (cmv.jbno == obj) {
			System.out.println("취소 event labetl:" + cmd);
			cmv.dispose();
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

		} else if (iav.jb_login == obj) {
			pv.initDisplay();
			isChangePw = 0;
			
			
			//패스워드가 맞다면 UL모드 나 OL모드 띄우기
			
		} else if (iav.jb_chpw == obj) {
			System.out.println("event labetl:" + cmd);
			isChangePw = 1;
			String text = iav.get_text();
			pv.initDisplay();

			return;

			//SignUpView 띄우기
		} else if (suv.jb_chpw == obj) {
			isSignUp = 1;
			pv.initDisplay();
			System.out.println("event labetl:" + cmd);
//			String text = suv.get_text();
//			if(text.length()<4) {
//				JOptionPane.showMessageDialog(suv, "비밀번호는 네자리입니다.");
//			}else{
//				db.changePw(text);
//			}
			return;
		} else if (iav.jb_out == obj) {
			System.out.println("event labetl:" + cmd);
			this.iav.dispose();
			sb.setLength(0);
			return;
			
			//isAdminView 끄기

		} else if (iav.jb_input == obj) {
			System.out.println("event labetl:" + cmd);
			pv.initDisplay();
			return;
		} else if (pv.jb_0 == obj) {
			System.out.println("event labetl:" + cmd);
			if(isSignUp == 0) {
			if(sb.length() ==4 ) {
				JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
				sb = new StringBuilder();
				iav.jtf_pw.setText("");
				suv.jtf_pw.setText("");
				return;
			}
			sb.append("0");
			iav.jtf_pw.setText(sb.toString());
			return;}else if(isSignUp == 1) {
				if(sb.length() ==4 ) {
					JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
					sb = new StringBuilder();
					iav.jtf_pw.setText("");
					suv.jtf_pw.setText("");
					return;
				}
				sb.append("0");
				suv.jtf_pw.setText(sb.toString());
			}
		} else if (pv.jb_1 == obj) {
			System.out.println("event labetl:" + cmd);
			if(isSignUp == 0) {
			if(sb.length() ==4 ) {
				JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
				sb = new StringBuilder();
				iav.jtf_pw.setText("");
				suv.jtf_pw.setText("");
				return;
			}
			sb.append("1");
			iav.jtf_pw.setText(sb.toString());
			return;}else if(isSignUp == 1) {
				if(sb.length() ==4 ) {
					JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
					sb = new StringBuilder();
					iav.jtf_pw.setText("");
					suv.jtf_pw.setText("");
					return;
				}
				sb.append("1");
				suv.jtf_pw.setText(sb.toString());
				return;
			}
		} else if (pv.jb_2 == obj) {
			System.out.println("event labetl:" + cmd);
			if(isSignUp == 0) {
			if(sb.length() ==4 ) {
				JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
				sb = new StringBuilder();
				iav.jtf_pw.setText("");
				suv.jtf_pw.setText("");
				return;
			}
			sb.append("2");
			iav.jtf_pw.setText(sb.toString());
			return;}else if(isSignUp == 1) {
				if(sb.length() ==4 ) {
					JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
					sb = new StringBuilder();
					iav.jtf_pw.setText("");
					suv.jtf_pw.setText("");
					return;
				}
				sb.append("2");
				suv.jtf_pw.setText(sb.toString());
				return;
			}
		} else if (pv.jb_3 == obj) {
			System.out.println("event labetl:" + cmd);
			if(isSignUp == 0) {
			if(sb.length() ==4 ) {
				JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
				sb = new StringBuilder();
				iav.jtf_pw.setText("");
				suv.jtf_pw.setText("");
				return;
			}
			sb.append("3");
			iav.jtf_pw.setText(sb.toString());
			return;}else if(isSignUp == 1) {
				if(sb.length() ==4 ) {
					JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
					sb = new StringBuilder();
					iav.jtf_pw.setText("");
					suv.jtf_pw.setText("");
					return;
				}
				sb.append("3");
				suv.jtf_pw.setText(sb.toString());
				return;
			}
		} else if (pv.jb_4 == obj) {
			System.out.println("event labetl:" + cmd);
			if(isSignUp == 0) {
			if(sb.length() ==4 ) {
				JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
				sb = new StringBuilder();
				iav.jtf_pw.setText("");
				suv.jtf_pw.setText("");
				return;
			}
			sb.append("4");
			iav.jtf_pw.setText(sb.toString());
			return;}else if(isSignUp == 1) {
				if(sb.length() ==4 ) {
					JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
					sb = new StringBuilder();
					iav.jtf_pw.setText("");
					suv.jtf_pw.setText("");
					return;
				}
				sb.append("4");
				suv.jtf_pw.setText(sb.toString());
				return;
			}
		} else if (pv.jb_5 == obj) {
			System.out.println("event labetl:" + cmd);
			if(isSignUp == 0) {
			if(sb.length() ==4 ) {
				JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
				sb = new StringBuilder();
				iav.jtf_pw.setText("");
				suv.jtf_pw.setText("");
				return;
			}
			sb.append("5");
			iav.jtf_pw.setText(sb.toString());
			return;}else if(isSignUp == 1) {
				if(sb.length() ==4 ) {
					JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
					sb = new StringBuilder();
					iav.jtf_pw.setText("");
					suv.jtf_pw.setText("");
					return;
				}
				sb.append("5");
				suv.jtf_pw.setText(sb.toString());
				return;
			}
		} else if (pv.jb_6 == obj) {
			System.out.println("event labetl:" + cmd);
			if(isSignUp == 0) {
			if(sb.length() ==4 ) {
				JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
				sb = new StringBuilder();
				iav.jtf_pw.setText("");
				suv.jtf_pw.setText("");
				return;
			}
			sb.append("6");
			iav.jtf_pw.setText(sb.toString());
			return;}else if(isSignUp == 1) {
				if(sb.length() ==4 ) {
					JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
					sb = new StringBuilder();
					iav.jtf_pw.setText("");
					suv.jtf_pw.setText("");
					return;
				}
				sb.append("6");
				suv.jtf_pw.setText(sb.toString());
				return;
			}
		} else if (pv.jb_7 == obj) {
			System.out.println("event labetl:" + cmd);
			if(isSignUp == 0) {
			if(sb.length() ==4 ) {
				JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
				sb = new StringBuilder();
				iav.jtf_pw.setText("");
				suv.jtf_pw.setText("");
				return;
			}
			sb.append("7");
			iav.jtf_pw.setText(sb.toString());
			return;}else if(isSignUp == 1) {
				if(sb.length() ==4 ) {
					JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
					sb = new StringBuilder();
					iav.jtf_pw.setText("");
					suv.jtf_pw.setText("");
					return;
				}
				sb.append("7");
				suv.jtf_pw.setText(sb.toString());
				return;
			}
		} else if (pv.jb_8 == obj) {
			System.out.println("event labetl:" + cmd);
			if(isSignUp == 0) {
			if(sb.length() ==4 ) {
				JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
				sb = new StringBuilder();
				iav.jtf_pw.setText("");
				suv.jtf_pw.setText("");
				return;
			}
			sb.append("8");
			iav.jtf_pw.setText(sb.toString());
			return;}else if(isSignUp == 1) {
				if(sb.length() ==4 ) {
					JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
					sb = new StringBuilder();
					iav.jtf_pw.setText("");
					suv.jtf_pw.setText("");
					return;
				}
				sb.append("8");
				suv.jtf_pw.setText(sb.toString());
				return;
			}
		} else if (pv.jb_9 == obj) {
			System.out.println("event labetl:" + cmd);
			if(isSignUp == 0) {
			if(sb.length() ==4 ) {
				JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
				sb = new StringBuilder();
				iav.jtf_pw.setText("");
				suv.jtf_pw.setText("");
				return;
			}
			sb.append("9");
			iav.jtf_pw.setText(sb.toString());
			return;}else if(isSignUp == 1) {
				if(sb.length() ==4 ) {
					JOptionPane.showMessageDialog(iav, "비밀번호는 네자리입니다. 네자리 이하로만 입력해주세요");
					sb = new StringBuilder();
					iav.jtf_pw.setText("");
					suv.jtf_pw.setText("");
					return;
				}
				sb.append("9");
				suv.jtf_pw.setText(sb.toString());
				return;
			}
		} else if (pv.jb_b1 == obj) {
			System.out.println("event labetl:" + cmd);
			iav.jtf_pw.setText("");
			suv.jtf_pw.setText("");
			
			sb.setLength(0);
			System.out.println(iav.jtf_pw.getText());
			return;
		} else if (pv.jb_b2 == obj) {
			System.out.println("event labetl:" + cmd);
			String text = iav.get_text();
			String text2 = suv.get_text();
			System.out.println("jtf텍스트는 "+ text+"|");
			System.out.println("jtf2텍스트는 "+ text2+"|");
			System.out.println("db.cjecl는 "+db.checkPw()+"|");
			System.out.println(text.equals(db.checkPw()));
			System.out.println(isSignUp);
			System.out.println(isChangePw);
			if(isSignUp == 1) {
				System.out.println("signup진입");
				isChangePw = 0;
				suv.jtf_pw.setText("");
				db.changePw(text2);
				JOptionPane.showMessageDialog(suv, "비밀번호가 변경되었습니다");
				sb.setLength(0);
				System.out.println(isSignUp);
				return;
			}
			if(db.checkPw().equals(text)){
				this.pv.dispose();
				if(isChangePw == 1) {
					System.out.println("icp진입");
					if(db.checkPw().equals(text)) {
						this.suv.initDisplay();
						sb.setLength(0);
						iav.jtf_pw.setText(sb.toString());
						return;
					}else{JOptionPane.showMessageDialog(iav, "비밀번호를 확인해주세요.");};
					sb.setLength(0);
					iav.jtf_pw.setText(sb.toString());
					isChangePw = 0;
					return;
				}
				if(isul ==0) {
					System.out.println("ol 진입");
					clv.initDisplay();
					sb.setLength(0);
					iav.jtf_pw.setText(sb.toString());
					return;}
				if(isul ==1) {
					System.out.println("uv 진입");
					uv.refresh();
					System.out.println("event labetl:" + cmd);
					iv = this.uv;
					sb.setLength(0);
					iav.jtf_pw.setText(sb.toString());
					try {
						this.mVOS = db.getList();

					} catch (Exception e) {
						System.out.println("U.L" + e);
					}
				uv.initDisplay(); 
				uv.setVisible(true);
				uv.setrow(this.mVOS);
				return;}
			}else{JOptionPane.showMessageDialog(iav, "비밀번호를 확인해주세요.");};
			sb.setLength(0);
			iav.jtf_pw.setText(sb.toString());
			isChangePw = 0;
			return;
	} else if (suv.jb_out == obj) {
		System.out.println("event labetl:" + cmd);
		this.suv.dispose();
		sb.setLength(0);
		iav.jtf_pw.setText(sb.toString());
		isSignUp = 0;
		return;
		
		//isAdminView 끄기
	}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		System.out.println("JCombobox 감지");
//		String name = (String) cmv.jcb1.getSelectedItem();
//		System.out.println(name);
		
	}

}
