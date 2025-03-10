package notice;
//무조건 get으로
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //사용자가 페이지번호를 클릭 시 해당 값을 받는 역할
		//Integer pageno =Integer.parseInt(request.getParameter("pageno")); //integer은 null 사용 가능합
		
		/*
		 Integer의 특징
		 1.null 사용가능
		 2. 문자를 인식하지 못한다. 
		 equals => String만 적용 가능
		 */				
		String pageno =request.getParameter("pageno"); //integer은 null 사용 가능합
		if(pageno==null || pageno.equals("1")) {//pageno==null ,최조 해당 게시판에 접속시 페이지 배열번호 0로 처리
		    pageno = "0";	
		}
			
		//list를 출력하기 위한 Database Table을 로드는 Model
		m_noticelist nl = new m_noticelist(Integer.parseInt(pageno));
		//2차 클래스 배열로 저장된 table에 모든 데이터를 셋팅함
	    ArrayList<ArrayList<String>> result = nl.db_data();
	    //JSP로 2차 클래스 배열값을 전달(View)
	    request.setAttribute("result", result);
	  
	  
	 //System.out.println(result);			
	 RequestDispatcher rd = request.getRequestDispatcher("./notice_list.jsp");
     rd.forward(request, response);	
	}
}
