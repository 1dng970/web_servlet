<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자메인페이지</title>
</head>
<body>

<header>
<jsp:include page="./top.jsp" flush="true"></jsp:include>
<%--  <%@ include file="./top.jsp"%>--%>
</header >

<section>
<jsp:include page="./product.jsp" flush="true"></jsp:include>
<%-- <%@include file="./product.jsp"%>--%>

</section>
<footer>
<jsp:include page="./copyright.jsp" flush="true"></jsp:include>
<%-- <%@include file="./copyright.jsp"%>--%>
</footer>
</body>
</html>