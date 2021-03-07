package proj_back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBLogic {

	static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String _URL 	= "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	String				_USER	= "ko80project_1";
	String				_PW		= "abcd1234";
	//물리적으로 떨어져 있는 서버에 통로 만들기
	Connection			con		= null;
	//서버에 내가 작성한 select문을 전달해줄 객체선언
	PreparedStatement	pstmt	= null;
	//오라클의 커서를 조작하는 객체선언
	ResultSet			rs		= null;
	
	DBLogic() {
		
	}
}
