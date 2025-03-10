<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%    
String mname = (String)request.getAttribute("mname");
String mtel = (String)request.getAttribute("mtel");
String view = (String)request.getAttribute("view");
String formattedDate = (String) request.getAttribute("formattedDate"); 

%>
<!DOCTYPE html>


<html>
<style>
.btn {
  

    background-color:blue;
    color: #fff;
    border:none; 
    border-radius:10px; 
    padding:15px;
    min-height:30px; 
    min-width: 120px;
  }

</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>영화 예매 확인</p>
고객명 : <%=mname%><br>
연락처 : <%=mtel%><br>
영화선택 :<%=view%><br>
예매일자 : <%=formattedDate%><br><br>
<input type="button" value="예매확인" class=btn>
</body>
</html>
