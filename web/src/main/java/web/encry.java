package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class encry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
/*encry_model class파일에서 암호화 생성 한 뒤 , 결과물 출력*/	
       
//암호화(encry)+ class(모델) 응용편
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String passwd = "a123456";/**/
		//해당 문자를 base 64를 이용하여 encood(암호화)
		encry_model em = new encry_model();/*암호화 model 클래스를 로드*/
		String result = em.dataencode(passwd);/*해당 메소드에 문자값을 전달 (값을 받을예정)*/
		System.out.println(result);/*최종 암호화된 사항을 출력*/
		
		//base64를 변환된 문자를 decode(복호화) 이용하여 원본 문자로 변환
		String repasswd = "YTEyMzQ1Ng==";
		String result2 = em.datadecode(repasswd);
		System.out.println(result2);
		
		
		//MD5 암호화
		String result3 = em.md5_encode(passwd);
		System.out.println(result3);
		
	}

}
