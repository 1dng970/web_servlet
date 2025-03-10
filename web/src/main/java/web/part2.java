package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class part2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
	
    //part1에서 get으로 전송하므로 doGet만 설정함 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	   try {
		   this.pw = response.getWriter();
		   /*getParameterValues->배열*/
		   String agree[] = request.getParameterValues("agree");
		   //System.out.println(agree.length);
		   int ea =agree.length;// 반복문
		   int ckcount=0;
		   int w =0;
		   while(w<ea) {
			   if(agree[w].equals("Y0")||agree[w].equals("Y1")||agree[w].equals("Y2")) {//필수선택번호
				   ckcount++;
			   }
			   w++;
		   }
		   
		   if(ckcount<3) {//카운트 조건
			this.pw.write("<script>"
				    +"alert('올바를 접근 방식이 아닙니다. 약관에 동의가 필요합니다.');"
				    + "location.href='./part1.jsp';"
				    +"</script>");			
					
		   }else {//해당 조건이 맞을 경우 part2.jsp로드 
			   RequestDispatcher re = request.getRequestDispatcher("./part2.jsp");
			   re.forward(request, response);
		   }
		   
		} catch (Exception e) {
			this.pw.write("<script>"
				    +"alert('시스템 오류로 인하여 데이터가 처리되지 않았습니다.');"
				    + "location.href='./part1.jsp';"
				    +"</script>");		
			
		}finally {
			this.pw.close();
			
		}
    }
}