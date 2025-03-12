package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mallpage/join.do")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//copyright 정보 Model
	copyright cr = new copyright();// 클래스 로드 
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		footers ft= new footers();		   
		request.setAttribute("cpdata", ft.cdata);//jsp 전달 
				
		RequestDispatcher rd = request.getRequestDispatcher("./join.jsp");
	     rd.forward(request, response);
	   }	
	}

//do실행시 결과물이 보이게 테스트
class footers extends ab_footer{//fts 발동
	public footers() {
		this.fts();
	}	
@Override
public void fts() {//즉시실행
	super.fts();
	
      }
	}	
