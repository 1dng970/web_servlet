package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class payok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       //Controller (Front-end 전송된 값 처리 및 사칙연산 처리후 View 전달)
        
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();//자바스크립트 사용하기 위한 프린트 오픈
		try {//예와처리
			//Front-end 값을 받는 역할
			String m = request.getParameter("money");
			String s = request.getParameter("sales");
			String p = request.getParameter("point");
			
			//해당 데이터를 수자로 변환 후 사칙연산
			int product_m= Integer.parseInt(m);
			int product_s = Integer.parseInt(s);
			int product_p = Integer.parseInt(p);
			int total = (product_m-(product_m*product_s)/100)-product_p;
			System.out.println(total);
			
			//controller=>view(.jsp에서 사용 할 수있도록 함)
			request.setAttribute("product_m",product_m);
			request.setAttribute("product_s",product_s);
			request.setAttribute("product_p",product_p);
			request.setAttribute("total", total);
			
			
			//RequestDispatcher : View를 선언하여 웹페이지를 출력되도록 설정
			RequestDispatcher re = request.getRequestDispatcher("./payok.jsp");
					re.forward(request, response);//controller에서 사용된정보를 jsp로 이관 
					
		} catch (Exception e) { 
	        pw.write("<script>"
	                + "alert('올바른 값이 전달되지 않았습니다.');"
	                + "history.go(-1);" // 이전 페이지로 이동
	                + "</script>");
		}
	}

}
