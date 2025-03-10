package event;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class event_infook extends HttpServlet {
	private static final long serialVersionUID = 1L;
     Connection con = null;
     PrintWriter pw = null;
     Statement st = null;
     dbconfig db= new dbconfig();
	 public event_infook() {
		 try {
			 //dbconfig db= new dbconfig();
			 //this.con= db.info();
			 //this.con = new dbconfig().info();
			 
			//System.out.println("Database 연결 성공!!");
			
		} catch (Exception e) {
			//System.out.println("Database 연결 실패!!");
		}		 
	 }
	
   
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
	    res.setContentType("text/html;charset=utf-8");
	    String ename =req.getParameter("ename");
	    String etel =req.getParameter("etel");
	    String email =req.getParameter("email");
	    String ememo= req.getParameter("ememo");
	    String info1= req.getParameter("info1");
	    String info2= req.getParameter("info2");
	    
	    String sql ="insert into event(eidx,ename,etel,email,info1,info2,ememo,ejoin)"
	    		+ "values('0','"+ename+"','"+etel+"','"+email+"','"+info1+"','"+info2+"','"+ememo+"',now())";
	  this.pw=res.getWriter();
	    try {
	    this.con = this.db.info(); 			
		this.st = this.con.createStatement();
		int result =st.executeUpdate(sql);
		if(result>0) {
		this.pw.write("<script>"
				+ "alert('정상적으로 이벤트 되었습니다.');"
				+ "</script>");	
		}else{
			this.pw.write("<script>"
					+ "alert('이미 이벤트에 등록 되었습니다.');"
					+ "</script>");		
			
		}
	} catch (Exception e) {
		System.out.println("SQL 문법 오류!!");
		
	}finally {//정상적인 Database를 모두 핸들링 후 역순우르 close를 순차적으로 적용해야 함
		try {
	    this.pw.close();
		this.st.close(); //statement close 제대로 선언안되고 close 안하면 문법 오류 생긴다		
		this.con.close();
	}
		catch (Exception e) {
			System.out.println("Database가 올바르게 저장되지 않았습니다.");
		  }
	   }
	}
}