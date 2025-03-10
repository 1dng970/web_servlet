<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <%    
    // -getAttribute : controller에서 getAttribute로 생성된 이관 값을 받음
    
   String products[] =(String[])request.getAttribute("products");  
   String prices[] =(String[])request.getAttribute("prices");            
   //int price_all =(int)request.getAttribute("price_all");
   Integer price_all = (Integer) request.getAttribute("price_all");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>basketpart2</title>
</head>
<style>
.pay-btn {
     background-color: #175676; /* 버튼 색상 */
     color: white; /* 글자 색상 */
        border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px; /* 둥근 모서리 */
            cursor: pointer;
            transition: background 0.3s ease;
}

.pay-btn:hover {
background-color: #133d52; /* 호버 효과 */
    
}
</style>
<body>
<!--  -->
<p>구매확정 물품</p>
<% for (int i = 0; i < products.length; i++) { %>
<%= products[i] %> - <%= prices[i] %>원<br>
<% } %>
<br>
 <font class="font1"> 최종 결제 금액 : </font>
 <div class="total"><%= price_all %>원</div>

<br>
<form id="frm" method=get action="http://172.30.1.86:8080/web/basketok.do" >
<input type="radio" name="op"  value="신용카드" >신용카드<br>
<input type="radio" name="op"  value="가상계좌" >가상계좌<br>
<input type="radio" name="op"  value="휴대폰 결제" >휴대폰 결제<br>
<input type="radio" name="op"  value="무통장 입금" >무통장 입금<br>
<br>
<input type="button" value="결제진행" class="pay-bth" onclick="op_pay()"> 
 
</form>
</body>
<script>
	var op_pay = function(){
		var op = document.getElementsByName("op");/*실행할 옵션*/
		var ea = op.length; //카운트 갯수 = op의 배열
		var w = 0; //반복문을 돌리기 위한 변수 선언
		var count = 0;//라디오 박스 선택 
		while(w < ea){
			if(op[w].checked==true){
				count++;
				
			}
			w++;			
		}
		if(count > 0){
			frm.submit();	//Back-end에 전송
			alert("결제수단 선택 완료되었습니다.");
		}
		else{
			alert("결제수단을 선택하시기 바랍니다.");
		}
	}

//}


</script>

</html>