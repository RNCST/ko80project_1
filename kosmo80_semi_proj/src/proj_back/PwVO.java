package proj_back;

public class PwVO {
	
	private int     pw1   = 0;
	private int     pw2   = 0;
	private int     pw3   = 0;
	private int     pw4   = 0;
	private String     pw    = null;
	public int getPw1() {
		return pw1;
	}
	public void setPw1(int pw1) {
		this.pw1 = pw1;
	}
	public int getPw2() { 
		return pw2;
	}
	public void setPw2(int pw2) {
		this.pw2 = pw2;
	}
	public int getPw3() {
		return pw3;
	}
	public void setPw3(int pw3) {
		this.pw3 = pw3;
	}
	public int getPw4() {
		return pw4;
	}
	public void setPw4(int pw4) {
		this.pw4 = pw4;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

}
//
//
//public void updateMenu(MenuVO mVO) {
//	sql.append("UPDATE menu SET m_name=?, m_price=?, m_type=LOWER(?) WHERE m_num=? ");
//	try {
//		pstmt = con.prepareStatement(sql.toString());
//		pstmt.setString(1, mVO.getM_name());
//		System.out.println(mVO.getM_name());
//		pstmt.setInt(2, mVO.getM_price());
//		System.out.println(mVO.getM_price());
//		pstmt.setString(3, mVO.getM_type());
//		System.out.println(mVO.getM_type());
//		pstmt.setInt(4, mVO.getM_num());
//		System.out.println(mVO.getM_num());
//		pstmt.executeUpdate();
//		pstmt.close();
//		System.out.println("update문 실행");
//	} catch (Exception e) {
//		System.out.println("updateMenu() : " + e);
//	} finally {
//		sql.setLength(0);
//	}

