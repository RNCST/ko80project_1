package proj_back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import proj_view.CView;


public class DBLogic {
	//선언부
	private static DBLogic 	 		db 		= null;
	private static final String 	_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String 	_URL 	= "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	private String					_USER	= "ko80project_1";
	private String					_PW		= "abcd1234";
	private Connection				con		= null;
	private PreparedStatement		pstmt	= null;
	String 							sql		= "";
	private ResultSet				rs		= null;
	private MenuVO[] 				mvoList = null;
	static EventHandler 			eh      = null;
	

	
	//생성자
	private DBLogic() {
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

	public Vector<MenuVO> getList() {
		Vector<MenuVO> mvoVec = new Vector<MenuVO>();
		sql = " SELECT m_name, m_price, m_type, m_lunch_date FROM menu WHERE m_lunch_date > ADD_MONTHS(sysdate, -1) ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MenuVO mVO = null;
				mVO = new MenuVO();
				mVO.setM_name(rs.getString("m_name"));
				mVO.setM_price(rs.getInt("m_price"));
				mVO.setM_type(rs.getString("m_type"));
				mVO.setM_lunch_date(rs.getString("m_lunch_date"));
				mvoVec.add(mVO);
			}
			pstmt.close();
		} catch (Exception e) {
			System.out.println("getList() : " + e);
		} finally {
			return mvoVec;
		}
	}
	
	
	//type을 매개변수로 받아서 main과 drink,side메뉴를 나누어 반환
	public Vector<MenuVO> getList(String type) {
		Vector<MenuVO> mvoVec = new Vector<MenuVO>();
		sql = " SELECT m_name, m_price, m_type, m_lunch_date FROM menu WHERE m_type = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MenuVO mVO = null;
				mVO = new MenuVO();
				mVO.setM_name(rs.getString("m_name"));
				mVO.setM_price(rs.getInt("m_price"));
				mVO.setM_type(rs.getString("m_type"));
				mVO.setM_lunch_date(rs.getString("m_lunch_date"));
				mvoVec.add(mVO);
			}
			pstmt.close();
		} catch (Exception e) {
			System.out.println("getList() : " + e);
		} finally {
			return mvoVec;
		}
	}
	
	public void insertMenu(String m_name, int m_price, String m_type, String m_lunch_date) {
		sql = "INSET INTO menu(m_num, m_name, m_price, m_type, m_lunch_date) values( ?, ?, ?, ?, ?)"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getLastIndex("menu"));
			pstmt.setString(2, m_name);
			pstmt.setInt(3, m_price);
			pstmt.setString(4, m_type);
			pstmt.setString(5, m_lunch_date);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("insertMenu() : " + e);
		}
	}
	
	int getLastIndex(String table) {

		if("menu".equals(table)) {
			sql = "SELECT MAX(m_num) FROM menu";
		}
		else if("users".equals(table)) {
			sql = "SELECT MAX(u_num) FROM users";
		}
		int idx = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			idx = rs.getInt(1);
			pstmt.close();
		} catch (Exception e) {
			System.out.println("getLastIndex() : " + e);
		}
		return idx;
	}
	
	public void updateMenu(String m_name, int m_price, String m_type, String m_lunch_date) {
		sql = "UPDATE SET  WHERE m_name=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1 ,m_name);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("deleteMenu() : " + e);
		}
	}
	
	public void deleteMenu(String m_name) {
		sql = "DELETE FROM menu WHERE m_name=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1 ,m_name);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("deleteMenu() : " + e);
		}
	}
	
	void close() {
		try {
			rs.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("exit() :" + e);
		}
	}

	public static void main(String[] args) {
		Vector<MenuVO> mv = null;
		DBLogic dl = new DBLogic();
		mv=dl.getList("beverage");
		System.out.println("getList test");
		for(int i = 0; i < mv.size(); i++) {
			System.out.println(mv.elementAt(i).getM_name() + ", " + mv.elementAt(i).getM_price() + ", " + mv.elementAt(i).getM_type() + ", " + mv.elementAt(i).getM_lunch_date());
		}
		System.out.println(dl.getLastIndex("users"));
		System.out.println(dl.getLastIndex("menu"));
	}
}
