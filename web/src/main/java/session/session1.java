package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 *Session : 일정시간 동안 브라우저에 해당 값을 저장 및 유지시키는 방식(Back-end)=> 보안이 좋음, 암호화 
 *cookie : 브라우저에 cache 메모리에 값을 저장하는 방식(도메인 및 IP기준) -Front,Backend
 *storage : 메모리에 저장 (Front,Backend)=>local,session
 *
*/
public class session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   PrintWriter pw = null;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*클라이언트(사용자)가 보낸 데이터를 서버에서 가져오는 역할*/
	String mid = request.getParameter("mid");//아이디 
	String mpass= request.getParameter("mpass");//패스워드
	response.setContentType("text/html;charset=utf-8");
	this.pw =response.getWriter();
			
	/*정상적인 로그인*/
	if(mid.equals("hong")&&mpass.equals("a1234")) {
		String username= "홍길동";
		String usertel= "01012341004";
		
		/*HttpSession :브라우저에 cache메모리에 데이터를 임시저장 		
		브라우저 저장 */
		HttpSession se = request.getSession();//세션 시작
		//session을 생성
		se.setAttribute("id",mid);//아이디 
		se.setAttribute("name",username);//이름
		se.setAttribute("tel",usertel);//연락처 
	}
	else{	//아이디,패스워드가 틀릴 경우	
		this.pw.write("<script>"
				+ "alert('아이디 및 패스워드를 확인하세요');"
				+ "history.go(-1);"
				+ "</script>");
		
	}
	
	
	}

}
