package proj_back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


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
	static EventHandler 			eh      = null;

	

	
	//생성자
	private DBLogic() {
		sql = new StringBuffer();
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, "ko80project_1", "abcd1234");
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
		sql.append(" SELECT m_num, m_name, m_price, m_type, m_lunch_date FROM menu WHERE m_lunch_date > ADD_MONTHS(sysdate, -1)");
		try {
			con = DriverManager.getConnection(_URL, "ko80project_1", "abcd1234");
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
		} finally {
			sql.setLength(0);
		}
		return mvoVec;
	}
	
	
	//type을 매개변수로 받아서 main과 drink,side메뉴를 나누어 반환
	public Vector<MenuVO> getList(String type) {
		Vector<MenuVO> mvoVec = new Vector<MenuVO>();
		sql = null;
		sql = new StringBuffer();
		sql.append("SELECT m_num, m_name, m_price, m_type, m_lunch_date FROM menu WHERE m_type = ?");
		try {
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
		} catch (Exception e) {
			System.out.println("getList() : " + e);
		} finally {
			sql.setLength(0);
		}
		return mvoVec;
	}
	
	public void insertMenu(MenuVO mVO) {
		sql = null;
		sql = new StringBuffer();
		sql.append("INSERT INTO menu (m_num, m_name, m_price) values (?, ?, ?)"); 
		try {
			con = DriverManager.getConnection(_URL, "ko80project_1", "abcd1234");
			System.out.println(con);
			pstmt = con.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			String menu = "menu";
			int index = getLastIndex(menu);
//			int index = 27;
			System.out.println(index);
			pstmt.setInt(1, index+1);
			System.out.println("1");
			pstmt.setString(2, mVO.getM_name());	
			System.out.println("2");
			pstmt.setInt(3, mVO.getM_price());
			System.out.println("3");
//			pstmt.setString(4, mVO.getM_type());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("insertMenu() : " + e);
			e.printStackTrace();
		} finally {
			sql.setLength(0);
		}
	}
	
	int getLastIndex(String table) {
		sql = null;
		sql = new StringBuffer();
		
		if("menu".equals(table)) {
			sql.append("SELECT MAX(m_num) as m_num FROM menu ");
		}
		else if("users".equals(table)) {
			sql.append("SELECT MAX(u_num) FROM users");
		}
		int idx = 0;
		try {
			
			con = DriverManager.getConnection(_URL, "ko80project_1", "abcd1234");
			System.out.println(con);
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rs.next();
			idx = rs.getInt("m_num");
			System.out.println("idx : " + idx);
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("getLastIndex() : " + e);
		} finally {
			sql.setLength(0);
		}
		return idx;
	}
	
	public void updateMenu(MenuVO mVO) {
		sql = null;
		sql = new StringBuffer();
		sql.append("UPDATE menu SET m_name=?, m_price=?, m_type=LOWER(?) WHERE m_num=? ");
		try {
			con = DriverManager.getConnection(_URL, "ko80project_1", "abcd1234");
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
		} finally {
			sql.setLength(0);
		}

	}
	
	public void deleteMenu(int m_num) {
		sql = null;
		sql = new StringBuffer();
		sql.append("DELETE FROM menu WHERE m_num=? ");
		try {
			con = DriverManager.getConnection(_URL, "ko80project_1", "abcd1234");
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
				con = DriverManager.getConnection(_URL, "ko80project_1", "abcd1234");
				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				rs.next();
				upw = rs.getString(1);	
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("checkPw() : " + e);
			} finally {
				sql.setLength(0);
			}
			return upw;
	}
	
	public String changePw(String text) {
		sql = null;
		sql = new StringBuffer();
		sql.append("UPDATE USERS SET u_pw=? ");
		String upw = null;
			try {
				con = DriverManager.getConnection(_URL, "ko80project_1", "abcd1234");
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
			} finally {
				sql.setLength(0);
			}
			return upw;
	}
	
	

	public static void main(String[] args) {
		Vector<MenuVO> mv = null;
		DBLogic dl = new DBLogic();
		mv=dl.getList("drink");
//		System.out.println("getList test");
//		for(int i = 0; i < mv.size(); i++) {
//			System.out.println(mv.elementAt(i).getM_name() + ", " + mv.elementAt(i).getM_price() + ", " + mv.elementAt(i).getM_type() + ", " + mv.elementAt(i).getM_lunch_date());}
		//System.out.println(dl.getLastIndex("users"));
		System.out.println(dl.getLastIndex("menu"));
		
//		System.out.println(dl.checkPw());
	}
}
