package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ajax_postok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    PrintWriter pw = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 CORS를 해결하기 위해서 사용하는 방식의 코드이며, 해당 Origin, Credentials
		 를 사용하여 도메인이 다르게 접근하더라도 Ajax 통신이 되도록 허락하는 명령어 
		 "*"
		*/
		
		response.addHeader("Access-Control-Allow-Origin","*");// "*" : 모든 IP 받음, "172.30.1.80"-> 해당 아이피만 받음
		response.addHeader("Access-Control-Allow-Credentials","true");//도메인이 다르더라도 받는 다는 의미 
		
		

		String userid = request.getParameter("userid");
		String usermail = request.getParameter("usermail");
		
		//System.out.println(userid);
		//System.out.println(usermail);	//null생성시 프론트 문의
		String msg="";//ok: 정상아이디, no :아이디오류, error :Back-end 오류
		
		this.pw=response.getWriter();
		
		if(userid.equals("hong")&& usermail.equals("hong@nate.com")) {
		   msg="no";	
		}
		else {
		   msg="ok";	
			
		}
		
		this.pw.print(msg);//프론트 엔드에게 보내지는값
		
	}

}
