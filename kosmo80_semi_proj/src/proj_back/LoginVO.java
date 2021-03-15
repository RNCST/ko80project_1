package proj_back;

public class LoginVO {
	
	private int     l_pw   = 0;

	public int getL_pw() {
		return l_pw;
	}

	public void setL_pw(int l_pw) {
		this.l_pw = l_pw;
	}

}

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
//
//}