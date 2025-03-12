<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <title>Shop Bag</title>
    <meta charset="utf-8" />
    <link href="./index.css" rel="stylesheet" />
    <link href="./subpage.css" rel="stylesheet" />
    <link href="./menu.css?v=1" rel="stylesheet"/>
  </head>
<body>
<!--상단로고&메뉴-->
<%@ include file="./top.jsp" %>  
<!-- 상단 로고 & 메뉴 -->  
 <main>
<!-- 신상품 -->  
 <%@ include file="./login_view.jsp" %>    
 <!-- 신상품 -->  
</main>
 <!--카피라이터 및 하단--> 
<footer>
 <%@ include file="./footer.jsp" %>    
</footer>
 <!--카피라이터 및 하단--> 
  </body>
</html>