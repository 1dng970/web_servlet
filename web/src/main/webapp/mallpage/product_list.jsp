<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ArrayList<String>> all =(ArrayList)request.getAttribute("all");
%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트 출력파트</title>
<style>
s{
   color : red;
}
</style>

</head>
<body>
<table>
<tbody>
<%
int w =0;
while(w<all.size()){
	DecimalFormat df= new DecimalFormat("###,###");
%>
<!-- 상품에 대한 고유값 (auto_increment)-->
<tr onclick="product_view('<%=all.get(w).get(0)%>')">
<!--경로가 빠져서 안됨  -->
<td><img src=".<%=all.get(w).get(6)%>"></td>
<td>상품명:<%=all.get(w).get(2)%></td>
<!--  <td>상품금액:<%=df.format(Integer.parseInt(all.get(w).get(3)))%> 원</td>-->

<td>
<% if(all.get(w).get(4).equals("0")) { %>
상품금액:<%=df.format(Integer.parseInt(all.get(w).get(3)))%> 원
<%}else{ %>
<s>상품금액: <%=df.format(Integer.parseInt(all.get(w).get(3)))%></s>
</td>
<% } %>



<%if(all.get(w).get(4)!="0"){ %>
<td>할인율:<%=all.get(w).get(4)%> %</td>
<td>할인금액:<%=df.format(Integer.parseInt(all.get(w).get(5)))%> 원</td>
<% } %>
</tr>
<%
     w++;	
}
%>
</tbody>
</table>
<script>
//sap 
//product_list.do : 전체리스트상품 출력 & 각 상품에 대한 상세내역
function product_view(midx) {
	location.href='./product_list.do?midx='+midx;
}


</script>

</body>
</html>