package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class shop_loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	Connection con= null;
	PreparedStatement ps = null;
	HttpSession session = null;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=utf-8");
    	String spart =request.getParameter("spart");
    	/*
    	this.con =
    	if(spart.equals("P")) {//개인회원ㅇㅇㅇ
    		
    	}
    	*/
	}

}
