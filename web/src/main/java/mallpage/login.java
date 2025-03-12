package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mallpage/login.do")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//copyright 정보 Model
	copyright cr = new copyright();// 클래스 로드 
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> cpdata = this.cr.copyright_info(); //클래스 배열 결과값 들고옴 
		   request.setAttribute("cpdata", cpdata);//jsp 전달 
		
		
		 RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
	       rd.forward(request, response);
	}

}
