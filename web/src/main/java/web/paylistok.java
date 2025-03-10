package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class paylistok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			this.pw= response.getWriter();
						
			// 선택된 제품과 가격을 저장할 리스트 생성-> 수정본
           ArrayList<String> productlist = new ArrayList<>();
           ArrayList<String> pricelist = new ArrayList<>();
            int price_all = 0;

            // product1 ~ product5와 price1 ~ price5를 반복문으로 처리
            for (int i = 1; i <= 5; i++) {
                String product = request.getParameter("product" + i);
                String price = request.getParameter("price" + i);
 
                if (product != null && price != null && !product.isEmpty() && !price.isEmpty()) {
                    productlist.add(product);
                    pricelist.add(price);

                    
                    	price_all += Integer.parseInt(price);
                    
                    }
                }
            
	
            // ArrayList를 배열로 변환하여 JSP로 전달
            request.setAttribute("products", productlist.toArray(new String[0]));
            request.setAttribute("prices", pricelist.toArray(new String[0]));
            request.setAttribute("price_all",price_all);
			
			//Front-end 값을 받는 역할
			//변수명을 여러개 해서 배열로 선언을 함
			//제품명 받고
			/*원시배열 이용해서 작업
		    String[] products = new String[5];
			products[0] = request.getParameter("product1");
			products[1] = request.getParameter("product2");
			products[2] = request.getParameter("product3");
			products[3] = request.getParameter("product4");
			products[4] = request.getParameter("product5");
			
			//가격 배열선언
			String[] prices = new String[5];
			prices[0] = request.getParameter("price1");
			prices[1] = request.getParameter("price2");
			prices[2] = request.getParameter("price3");
			prices[3] = request.getParameter("price4");
			prices[4] = request.getParameter("price5");
			
			//총가격 계산
			
			
			
			/*
			  int price_all = 0;
			  
	            for (String price : prices) {//null값이 아닌지 확인,빈문자열인지 확인 
	               if (price != null && !price.isEmpty()) {
	                  price_all += Integer.parseInt(price);
	                  */
			/*
	                  int price_all = 0; // 총 금액 초기화
	                  for (int i = 0; i < products.length; i++) {
	                      String product = products[i];  // 제품명
	                      String priceStr = prices[i];  // 가격
	                      if (product != null && priceStr != null && !product.isEmpty() && !priceStr.isEmpty()) {
	                          int price = Integer.parseInt(priceStr);  // 가격을 정수로 변환
	                          price_all += price;  // 총 금액에 더하기
	                          //out.print(product + " - " + price + "원<br>");  // 제품명과 가격 출력
	                      }
	                  }
	                  
	               	*/	
	           
	          /*  
			//JSP로 사용 할 수있도록 전달 			
			request.setAttribute("products",products);  
            request.setAttribute("prices", prices);            
            request.setAttribute("price_all", price_all);
            
            */
            // JSP로 포워딩
            RequestDispatcher dispatcher = request.getRequestDispatcher("./paylistok.jsp");
            dispatcher.forward(request, response);
		 	
		} catch (Exception e) { 
			
	        pw.write("<script>"
	                + "alert('올바른 값이 전달되지 않았습니다.');"
	                + "history.go(-1);" // 이전 페이지로 이동
	                + "</script>");
	               
           }
		}
		
	}

