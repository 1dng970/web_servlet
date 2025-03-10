<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //controller에서 session을 받은 후 해당 session 값을 문자열로 변환 후 HTML에 출력
    HttpSession se =(HttpSession)request.getAttribute("se");
    String userid =(String)se.getAttribute("id");
    String usernm =(String)se.getAttribute("name").toString();
    String usertel=(String)se.getAttribute("tel").toString();
    if(userid==null){//연산기호 사용을 해야 에러가 나지 않는다 
    	out.print("<script>('로그인하셔야만 됩니다.');location.href='./login.html';</script>");
    }
    		
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인정보출력</title>
</head>
<body>
<%=usernm%> 님 환영 합니다.<input type="button" value="로그아웃" onclick="logout()"><br>
아이디 : <%=userid%><br>
연락처 : <%=usertel%><br>

</body>
<script type="text/javascript">
function logout() {
	
	if(confirm("로그아웃 하시겠습니까?")){
		
	location.href="login.html";
	
	}
}
</script>
</html>