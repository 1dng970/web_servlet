package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*로그아웃*/
public class session3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession se = request.getSession();
	/*se.invalidate();//모든 세션의 값을 초기화(삭제)*/
	
	se.removeAttribute("tel");/*특정 session 값만 삭제 */
	
	}

}
