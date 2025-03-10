package web;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//HttpServlet : java를 웹에서 사용 할 수있도록 처리하는 클래스 


public class login extends HttpServlet {
	/* serialVersionUID : Backend 가상의 페이지 일련번호 */	
	private static final long serialVersionUID = 1L;
	/*
    - doGet,doPost :front-end가 method를 설정한 사항과 동일한 정보를 처리하는 호스트	
	- request : Front- end에게 전달 받는 값
	- response : Back-end가 처리한 결과값을 출력하는 역할
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*getParameter : front-end에서 전달되는 네임 이름을 말함*/
		request.setCharacterEncoding("UTF-8");//=>front의 한글일 경우 한글깨짐 방지(언어셋)
		
		/*결과 내용을 한글 깨짐 없이 사용하는 언어셋 셋팅*/
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		//PrintWriter pw :javascritp를 핸들링 
		PrintWriter pw = response.getWriter();
		//response.getWriter() :현재 페이지에 문자로 출력
		
		if(mid.equals("hong")&& mpass.equals("a123456")) {
			pw.write("<script>"
		    +"alert('정상적으로 로그인 하셨습니다.');"
		    +"</script>");			
		}
		else {
		pw.write( "<script>"
                + "alert('아이디 또는 패스워드를 다시 확인하세요.');"
                + "location.href='./login.html';"
                + "</script>");
		}
		
		
		
}
	
	}

