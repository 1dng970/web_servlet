<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%  
//controller에서 데이터를 이관하는 형태
  String result =(String)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[data]</title>
</head>
<body>
아이디 : <%=result %><br>

</body>
</html>