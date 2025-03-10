package notice;
//Database에 있는 Table 사항 중 where 및 조회수 증가
//Query :select ,update
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shop.m_dbinfo;

public class m_noticeview {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql ="";//쿼리 문법
	m_dbinfo db = new m_dbinfo(); //Database 정보
	//int result=0;
	public void viewconut(int nidx) {
	try {//조회수 카운팅 올라가는것 
		this.con = this.db.getConnection();
		//해당 컬럼에 값을 +1씩 증가시키는 Query문 
		this.sql="update notice set nview=nview+1 where nidx=?";
		this.ps = this.con.prepareStatement(this.sql);
		this.ps.setInt(1, nidx);//setInt : nidx 자료형이 int이므로 
		this.ps.executeUpdate(); //Query문을 실행!!		
	} catch (Exception e) {
		
	}finally {
		try {
			this.ps.close();
			this.con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	  }
	}
	
}
