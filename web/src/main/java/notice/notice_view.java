package notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class notice_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	  int nidx =Integer.parseInt(request.getParameter("nidx"));//getParameter 자체가 문자열
	  //System.out.println(nidx);
	  m_noticeview mv = new m_noticeview();
	  mv.viewconut(nidx);
	 	  
	}

}
