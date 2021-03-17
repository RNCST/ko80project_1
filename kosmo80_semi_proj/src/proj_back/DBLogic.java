package proj_back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Vector;

import proj_view.MainView;


public class DBLogic {
	//선언부
	private static DBLogic 	 		db 		= null;
	private static final String 	_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String 	_URL 	= "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	private String					_USER	= "ko80project_1";
	private String					_PW		= "abcd1234";
	private Connection				con		= null;
	private PreparedStatement		pstmt	= null;
	private StringBuffer 			sql		= null;
	private ResultSet				rs		= null;
	private MenuVO[] 				mvoList = null;
	private LoginVO[] 				lvoList = null;
	//private EventHandler 			eh      = null;

	

	
	//생성자
	private DBLogic() {
		sql = new StringBuffer();
		try {
			Class.forName(_DRIVER);
			//con = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (Exception e) {
			System.out.println("DBLogic() : " + e);
		}
	}
//	private DBLogic(String user, String pw) {
//		try {
//			Class.forName(_DRIVER);
//			con = DriverManager.getConnection(_URL, user, pw);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
	//메소드
	public static DBLogic getInstance() {
		if(db == null) {
			db = new DBLogic();
		}
		return db;
	}
	
//	public Connection getConnection() {
//		return con;
//	}	

	public Vector<MenuVO> getList() { //for NEW
		Vector<MenuVO> mvoVec = new Vector<MenuVO>();
		sql = null;
		sql = new StringBuffer();
		sql.append(" SELECT m_num, m_name, m_price, m_type, m_lunch_date"
				+ "    FROM menu WHERE m_lunch_date > ADD_MONTHS(sysdate, -1) "
				+ "    ORDER BY m_lunch_date");
		try {
			con = DriverManager.getConnection(_URL, _USER, _PW);
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MenuVO mVO = null;
				mVO = new MenuVO();
				mVO.setM_num(rs.getInt("m_num"));
				mVO.setM_name(rs.getString("m_name"));
				mVO.setM_price(rs.getInt("m_price"));
				mVO.setM_type(rs.getString("m_type"));
				if(rs.getNString("m_lunch_date")!=null) {
					mVO.setM_lunch_date(rs.getString("m_lunch_date").substring(0, 10));
				}
				mvoVec.add(mVO);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getList() : " + e);
		}
		return mvoVec;
	}
	
	
	//type을 매개변수로 받아서 main과 drink,side메뉴를 나누어 반환
	public Vector<MenuVO> getList(String type) {
		Vector<MenuVO> mvoVec = new Vector<MenuVO>();
		sql = null;
		sql = new StringBuffer();
		sql.append("SELECT m_num, m_name, m_price, m_type, m_lunch_date "
				+ "   FROM menu "
				+ "  WHERE m_type = ? "
				+ "  ORDER BY m_lunch_date ");
		try {
			con = DriverManager.getConnection(_URL, _USER, _PW);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MenuVO mVO = null;
				mVO = new MenuVO();
				mVO.setM_num(rs.getInt("m_num"));
				mVO.setM_name(rs.getString("m_name"));
				mVO.setM_price(rs.getInt("m_price"));
				mVO.setM_type(rs.getString("m_type"));
				if(rs.getNString("m_lunch_date")!=null) {
					mVO.setM_lunch_date(rs.getString("m_lunch_date").substring(0, 10));
				}
				mvoVec.add(mVO);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getList() : " + e);
		}
		return mvoVec;
	}
	
	public void insertMenu(int idx, MenuVO mVO) {
		sql = null;
		sql = new StringBuffer();
		sql.append("INSERT INTO menu (m_num, m_name, m_price, m_type , m_lunch_date) values (?, ?, ? ,?, TO_DATE(sysdate, 'RR/MM/DD'))" ); 
		try {
			con = DriverManager.getConnection(_URL, _USER, _PW);
			System.out.println(con + "여기까지");
			pstmt = con.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			pstmt.setInt(1, idx);
			System.out.println("1" + idx);
			pstmt.setString(2, mVO.getM_name());	
			System.out.println("2" + mVO.getM_name());
			pstmt.setInt(3, mVO.getM_price());
			System.out.println("3" + mVO.getM_price());
			pstmt.setString(4, mVO.getM_type().toLowerCase());
			System.out.println("4" + mVO.getM_type().toLowerCase());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("insertMenu() : " + e);
			e.printStackTrace();
		}
	}
	
	public int getLastIndex(String table) {
		sql = null;
		sql = new StringBuffer();
		
		if("menu".equals(table)) {
			sql.append("SELECT MAX(m_num) FROM menu ");
		}else if("users".equals(table)) {
			sql.append("SELECT MAX(u_num) FROM users");
		}else if("transaction".equals(table)) {
			sql.append("SELECT MAX(t_num) FROM transaction");
		}
		int idx = 0;
		try {
			
			con = DriverManager.getConnection(_URL, _USER, _PW);
			System.out.println(con);
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rs.next();
			idx = rs.getInt(1);
			System.out.println("idx : " + idx);
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getLastIndex() : " + e);
		} finally {
			return idx+1;
		}
	}
	
	public void updateMenu(MenuVO mVO) {
		sql = null;
		sql = new StringBuffer();
		sql.append("UPDATE menu SET m_name=?, m_price=?, m_type=LOWER(?) WHERE m_num=? ");
		try {
			con = DriverManager.getConnection(_URL, _USER, _PW);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mVO.getM_name());
			System.out.println(mVO.getM_name());
			pstmt.setInt(2, mVO.getM_price());
			System.out.println(mVO.getM_price());
			pstmt.setString(3, mVO.getM_type());
			System.out.println(mVO.getM_type());
			pstmt.setInt(4, mVO.getM_num());
			System.out.println(mVO.getM_num());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			System.out.println("update문 실행");
		} catch (Exception e) {
			System.out.println("updateMenu() : " + e);
		}
	}
	
	public void deleteMenu(int m_num) {
		sql = null;
		sql = new StringBuffer();
		sql.append("DELETE FROM menu WHERE m_num=? ");
		try {
			con = DriverManager.getConnection(_URL, _USER, _PW);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1 , m_num);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("deleteMenu() : " + e);
		}
	}

	public void setPw() {
		Vector<PwVO> pwVOS = new Vector<PwVO>();
	}
	
	 
	
	public String checkPw() {
		sql = null;
		sql = new StringBuffer();
//		sql.append("SELECT u_pw "
//				+ "FROM USERS");
		sql.append("select LPAD(u_pw, 4 , 0) from USERS");
		String upw = null;
			try {
				con = DriverManager.getConnection(_URL, _USER, _PW);
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				rs.next();
				upw = rs.getString(1);	
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("checkPw() : " + e);
			}
			return upw;
	}
	
	public String changePw(String text) {
		sql = null;
		sql = new StringBuffer();
		sql.append("UPDATE USERS SET u_pw=? ");
		String upw = null;
			try {
				con = DriverManager.getConnection(_URL, _USER, _PW);
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,  text);
				System.out.println(text);
				pstmt.executeUpdate();
				System.out.println("ChangePw");
				pstmt.close();
				System.out.println("close");
				con.close();
			} catch (Exception e) {
				System.out.println("changePw() : " + e);
			}
			return upw;
	}
	
	//거래 발생시 데이터베이스에 기록
	public void insertTransaction(int idx, int total) {
		sql = null;
		sql = new StringBuffer();
		sql.append("INSERT INTO transaction (t_num, t_date, t_total) values (?, sysdate, ?)"); 
		try {
			con = DriverManager.getConnection(_URL, _USER, _PW);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, idx);
			pstmt.setInt(2, total);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("insertTransaction() : " + e);
			e.printStackTrace();
		}
	}
	//거래기록과 메뉴를 연결
	public void insertConnection(int idx, Vector<MenuVO> mVec) {
		sql = null;
		sql = new StringBuffer();
		sql.append("INSERT INTO connection (t_num, m_num) values (?, ?)"); 
		MenuVO mVO = null;
		for(int i = 0; i < mVec.size(); i++) {
			mVO = mVec.elementAt(i);
			try {
				con = DriverManager.getConnection(_URL, _USER, _PW);
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(1, idx);
				pstmt.setInt(2, mVO.getM_num());
				pstmt.executeUpdate();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("insertTransaction() : " + e);
				e.printStackTrace();
			} 
		}
	}
	//거래 기록을 불러오기
	public Vector<TransactionVO> getTransactionList() {
		Vector<TransactionVO> tvoVec = new Vector<TransactionVO>();
		sql = null;
		sql = new StringBuffer();
		sql.append(" SELECT t_num, t_date t_total"
				+  "   FROM transaction "
				+  "  ORDER BY t.t_date DESC ");
		try {
			con = DriverManager.getConnection(_URL, _USER, _PW);
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TransactionVO tVO = null;
				tVO = new TransactionVO();
				tVO.setT_num(rs.getInt("t_num"));
				tVO.setT_date(rs.getString("t_date"));
				tVO.setT_total(rs.getInt("t_total"));
				tvoVec.add(tVO);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("getList() : " + e);
		}
		return tvoVec;
	}
	
	public Vector<MenuVO> getDetailList(int t_num) {
		Vector<MenuVO> mVec = new Vector<MenuVO>();
		sql = null;
		sql = new StringBuffer();
		sql.append(" SELECT m.m_num, m.m_name, m.m_price"
				+  "   FROM transaction t, connection c, menu m"
				+  "  WHERE c.t_num = ? AND c.num = m.num");
		try {
			con = DriverManager.getConnection(_URL, _USER, _PW);
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MenuVO mVO = null;
				mVO = new MenuVO();
				mVO.setM_num(rs.getInt("m.m_num"));
				mVO.setM_name(rs.getString("m.m_name"));
				mVO.setM_price(rs.getInt("m.m_price"));
				mVec.add(mVO);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("getList() : " + e);
		}
		return mVec;
	}
	
	public String getTimer() {
		Calendar cal = Calendar.getInstance();
	
		int year     = cal.get(Calendar.YEAR);
		int month    = cal.get(Calendar.MONTH);
		int day      = cal.get(Calendar.DATE);
		int hour     = cal.get(Calendar.HOUR_OF_DAY);
		int min      = cal.get(Calendar.MINUTE);
		int sec      = cal.get(Calendar.SECOND);
//		String str1   = Integer.toString(hour);
//		if(str1.length()==1) {
//			str1 = "0"+str1;
//		}
//		String str2   = Integer.toString(min);
//		if(str2.length()==1) {
//			str2 = "0"+str2;
//		}
//		String str3   = Integer.toString(sec);
//		if(str3.length()==1) {
//			str3 = "0"+str3;
//		}
		return year+"/"+month+"/"+day+" "+hour+":"+min+":"+sec;
}
	
	public boolean isNum(String str) {
		boolean isNumeric = true;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				isNumeric = false;
			}
		}
		return isNumeric;
	}

	public static void main(String[] args) {
		Vector<MenuVO> mv = null;
		DBLogic dl = new DBLogic();
		mv=dl.getList("drink");
//		System.out.println("getList test");
//		for(int i = 0; i < mv.size(); i++) {
//			System.out.println(mv.elementAt(i).getM_name() + ", " + mv.elementAt(i).getM_price() + ", " + mv.elementAt(i).getM_type() + ", " + mv.elementAt(i).getM_lunch_date());}
		//System.out.println(dl.getLastIndex("users"));
		System.out.println("menu idx : " + dl.getLastIndex("menu"));
		System.out.println("tran idx : " + dl.getLastIndex("transaction"));
		
//		System.out.println(dl.checkPw());
	}
}
