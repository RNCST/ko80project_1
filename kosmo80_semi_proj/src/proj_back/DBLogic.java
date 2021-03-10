package proj_back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import proj_view.CView;


public class DBLogic {
	//선언부
	private static DBLogic 	 db 	= null;
	private static final String 	_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String 	_URL 	= "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	private String					_USER	= "ko80project_1";
	private String					_PW		= "abcd1234";
	private String					sql		= "";
	private Connection				con		= null;
	private PreparedStatement		pstmt	= null;
	private ResultSet				rs		= null;
	private MenuVO[] 				mvoList = null;
	static EventHandler eh         = null;
		        CView        cv                 = null;
	
	//생성자
	private DBLogic() {
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, "ko80project_1", "abcd1234");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private DBLogic(String user, String pw) {
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, user, pw);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//메소드
	public static DBLogic getInstance() {
		if(db == null) {
			db = new DBLogic();
		}
		return db;
	}
	
	public Connection getConnection() {
		return con;
	}	

	public MenuVO[] getList(String type) {
		sql = " SELECT m_num, m_name, m_price, m_type FROM menu WHERE m_type = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			MenuVO mVO = null;
			Vector<MenuVO> mvoVec = new Vector<MenuVO>();
			
			
			while(rs.next()) {
				mVO = new MenuVO();
				mVO.setM_num(rs.getInt("m_num"));
				System.out.println("m_num에 적제성공");
				mVO.setM_name(rs.getString("m_name"));
				System.out.println("m_name에 적제성공");
				mVO.setM_price(rs.getInt("m_price"));
				System.out.println("m_price에 적제성공");
				mVO.setM_type(rs.getString("m_type"));
				System.out.println("m_type에 적제성공");
				mvoVec.add(mVO);
				System.out.println("mvoVec에 적제성공");
			}
			mvoList = new MenuVO[mvoVec.size()];
			mvoVec.copyInto(mvoList);
			
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			return mvoList;
		}
		
	}
	
	

	public static void main(String[] args) {
		MenuVO[] mv = null;
		DBLogic dl = new DBLogic();
		mv=dl.getList("main");
		System.out.println("getList test");
		for(int i = 0; i < mv.length; i++) {
			System.out.println(mv[i].getM_num() + ", " + mv[i].getM_name() + ", " + mv[i].getM_price() + ", " + mv[i].getM_type());
		}
		
		
	}
}
