package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class deliveryok extends HttpServlet {
   private static final long serialVersionUID = 1L;
  
   PrintWriter pw = null;
   //HttpServletRequest request;
  // HttpServletResponse response;
   
   
   //즉시실행 메소드(servlet): 일반 class에서 사용하는 형태와 구조는 다릅니다.
  public deliveryok() {
	   /*
	   try {
		 this.request.setCharacterEncoding("utf-8");
         this.response.setContentType("text/html;charset=utf-8");
         this.pw = response.getWriter();
	   }catch(Exception e){
		   
	   }
	   */
  }
  // 
   
    public void deliveryok(HttpServletRequest request, HttpServletResponse response) {   // action에서 해당 class를 실행하면 즉시 작동하는 메소드
        try {
        	request.setCharacterEncoding("utf-8");
        	response.setContentType("text/html;charset=utf-8");
           this.pw = response.getWriter();
        }
        catch(Exception e) {
           System.out.println("해당 URL 경로가 올바르지 않습니다.");
        }
    }
    
/*void 꼭 추가하기,꼭 클래스 배열 사용하는것을 권장함!!*/
   protected void doPost(HttpServletRequest res, HttpServletResponse rep) throws ServletException, IOException {
       this.deliveryok(res,rep);
       String mname= res.getParameter("mname");
       String mtel= res.getParameter("mtel");
       String memail= res.getParameter("memail");
       String maddress= res.getParameter("maddress");
       //클래스 배열을 하는 이유는 setAtturibute 너무 많이 생성하여 jsp전달 시  getAtturibute 생성ㅎ
       ArrayList<String>data= new ArrayList<String>();
      data.add(mname) ;
      data.add(mtel) ;
      data.add(memail) ;
      data.add(maddress) ;
       
      /*클래스 배열을 jps로 전달 */
      res.setAttribute("data", data);
      
       RequestDispatcher rd = res.getRequestDispatcher("./deliveryok.jsp");
       
       rd.forward(res, rep);
       /*
      this.pw.write("<script>"
              + "alert('안녕하세요~');"
              + "</script>");
              */
   }
}