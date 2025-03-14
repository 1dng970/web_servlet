package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mallpage/product_list.do")
public class product_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//DTO
	dto_product pd = new dto_product();
	//select Model
	m_product mp = new m_product();	
		
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//상품 한가지를 클릭하였을 경우 Front-end에서 GET 전송값
    	String midx =request.getParameter("midx"); 
    	
    	String pagename="";//하나의 컨트롤러 => 두개의 View가 존재 
    	
    
    	if(midx==null){//상품 전체 리스트 
    	ArrayList<ArrayList<String>> all= this.mp.product_all();
    	request.setAttribute("all", all);
    	
    	pagename="./product_list.jsp"; 
    	
    	}
    	else {// 하나의 상품만 상세 내역
    	
    	this.pd.setMidx(Integer.parseInt(midx));//DTO전달
    	this.mp.oneproduct(this.pd);//dto의 객체를 모델로 전달 	
    		
        this.pd = this.mp.pd;// 모델에 있는 dto 객체를 가져옴
       //System.out.println(this.pd.getPnm());
 	
       //DTO Model을 전달하기 위한 Attribute
        request.setAttribute("dto",this.pd);
        
    		pagename="./product_view.jsp";
    	   }
    	//jsp 로드하여 view 역할로 데이터 출력
    		 RequestDispatcher rd = request.getRequestDispatcher(pagename);
    	     rd.forward(request, response);	
    		
    	}
        
    }


