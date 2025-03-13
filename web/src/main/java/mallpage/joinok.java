package mallpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mallpage/joinok.do")
public class joinok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PrintWriter pw = null;      
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");//한글 안깨지게 받음
		response.setContentType("text/html;charset=utf-8");//한글 안깨지게 보냄(전송)
		this.pw =response.getWriter();
       
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mtel = request.getParameter("mtel");
		
		String event_mail = request.getParameter("event_mail");
		String event_sms = request.getParameter("event_sms");	
	
		if(event_mail==null) {
			event_mail="N";
		}if(event_sms==null) {
			event_sms="N";
		}
		
		//DTO (setter 메소드에 프론트 엔드가 전달한 값을 모두 이관함)
		m_member dto = new m_member();
		dto.setMid(mid);
		dto.setMpass(mpass);
		dto.setMname(mname);
		dto.setMemail(memail);
		dto.setMtel(mtel);
		dto.setEvent_sms(event_sms);
		dto.setEvent_mail(event_mail);
		
		//DTO 값을 Insert Model 전달함
		Integer result = new insert_join().insert_member(dto);
		if(result>0) {
			this.pw.write("<script>"
					+ "alert('정상가입');"
					+ "location.href='./login.do';"
					+"</script>");
		}else {
			this.pw.write("<script>"
					+ "alert('시스템 점검으로 인하여 가입이 되지 않았습니다.');"
					+ "history.go(-1);"
					+"</script>");
			
		}
		this.pw.close();
	}

}
