package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class cgv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		try {
			
			
		String mname= req.getParameter("mname");//고객명
		String mtel= req.getParameter("mtel");//연락처
		String date= req.getParameter("date");//예매날짜
		
		if (date != null && !date.isEmpty()) {
		    LocalDate localdate = LocalDate.parse(date);  // 문자열을 LocalDate로 변환
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  // 날짜 포맷 설정
		    String formattedDate = localdate.format(formatter);  // 날짜를 포맷팅
		    req.setAttribute("formattedDate", formattedDate);  // 포맷팅된 날짜를 전달
		}
		
		/*view가 하나만 선택 되기 때문애 단일 값으로 처리 하기*/
		String view =req.getParameter("view");
		if(view!=null&& !view.isEmpty()) { //null값이 아니고, 비어있는 값이아닐 경우 
			req.setAttribute("view", view);
		}
		
		
		req.setAttribute("mname",mname);
		req.setAttribute("mtel", mtel);
		
		//req.setAttribute("date",LocalDate.parse(date));	
			
			
			
			
		} catch (Exception e) {
			this.pw.write("<script>"
	                + "alert('올바른 값이 전달되지 않았습니다.');"
	                + "history.go(-1);" // 이전 페이지로 이동
	                + "</script>");
		}
		
		/*필수로 입력해주기, 입력안하면 조회가 안됨 */
		RequestDispatcher re= req.getRequestDispatcher("./cgv2.jsp");
		re.forward(req, res);
	}

}

