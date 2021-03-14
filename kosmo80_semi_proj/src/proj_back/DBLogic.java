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
		sql.append(" SELECT m_num, m_name, m_price, m_type, m_lunch_date FROM menu WHERE m_lunch_date > ADD_MONTHS(sysdate, -1)");
		try {
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
		sql.append("INSERT INTO menu (m_num, m_name, m_price) values (?, ?, ?)"); 
		try {
			pstmt = con.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			pstmt.setInt(1, getLastIndex("menu")+1);
			pstmt.setString(2, mVO.getM_name());
			pstmt.setInt(3, mVO.getM_price());
//			pstmt.setString(4, mVO.getM_type());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("insertMenu() : " + e);
		} finally {
			sql.setLength(0);
		}
	}
	
	int getLastIndex(String table) {

		if("menu".equals(table)) {
			sql.append("SELECT MAX(m_num) FROM menu");
		}
		else if("users".equals(table)) {
			sql.append("SELECT MAX(u_num) FROM users");
		}
		int idx = 0;
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rs.next();
			idx = rs.getInt(1);
			System.out.println("idx : " + idx);
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("getLastIndex() : " + e);
		} finally {
			sql.setLength(0);
		}
		return idx;
	}
	
	public void updateMenu(MenuVO mVO) {
		sql.append("UPDATE menu SET m_name=?, m_price=?, m_type=LOWER(?) WHERE m_num=? ");
		try {
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
			System.out.println("update문 실행");
		} catch (Exception e) {
			System.out.println("updateMenu() : " + e);
		} finally {
			sql.setLength(0);
		}

	}
	
	public void deleteMenu(int m_num) {
		sql.append("DELETE FROM menu WHERE m_num=? ");
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1 , m_num);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("deleteMenu() : " + e);
		}
	}
	
	void close() {
		try {
			if(rs!=null)rs.close();
			if(con!=null)con.close();
			
		} catch (Exception e) {
			System.out.println("exit() :" + e);
		}
	}

	public static void main(String[] args) {
		Vector<MenuVO> mv = null;
		DBLogic dl = new DBLogic();
		mv=dl.getList("drink");
		System.out.println("getList test");
		for(int i = 0; i < mv.size(); i++) {
			System.out.println(mv.elementAt(i).getM_name() + ", " + mv.elementAt(i).getM_price() + ", " + mv.elementAt(i).getM_type() + ", " + mv.elementAt(i).getM_lunch_date());
		}
		//System.out.println(dl.getLastIndex("users"));
		System.out.println(dl.getLastIndex("menu"));
	}
}
