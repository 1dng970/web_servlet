<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 [약관동의]</title>
</head>
<body>
<!--get으로 보내는경우 절대 안됌-> 사고터친거임 ->
<form id="frm" method="get" action="./part2.do">
<p>회원가입 약관</p>
<!-- 
id는 중복 사용불가능 
name은 동일 사용 가능
onclick="ag_check() : 전체선택 해제 
 -->
 <form id="frm" method="get" action="./part2.do">
<input type="checkbox" id="all" onclick="all_check(this.checked)">전체선택<br><!-- 체크여부 받아서 처리  -->
<input type="checkbox" name="agree" value="Y0" onclick="ag_check()">서비스 이용약관 동의(필수)<br>
<input type="checkbox" name="agree" value="Y1" onclick="ag_check()">개인정보 수집 맟 이용(필수)<br>
<input type="checkbox" name="agree" value="Y2" onclick="ag_check()">이메일 정보 수신 약관(필수)<br>
<input type="checkbox" name="agree" value="Y3" onclick="ag_check()">광고성 정보 수신(선택)<br>
<input type="button" value="회원가입" onclick="go_page()">
</form>
</body>
<script >
function go_page() {
	if(frm.agree[0].checked==true&&frm.agree[1].checked==true&&frm.agree[2].checked==true&&frm.agree[2].checked==true){
		frm.submit();
		
	}else{
		alert("필수 조건은 무조건 동의하셔야만 회원가입이 진행 됩니다.")
	}
}


var all_check = function(z) {
	var ob = frm.agree; /* form태그 안에서 agree라는 name명을 가진 오브젝트 전체 */
	var ea = ob.length;
	var w = 0;

	do {
		ob[w].checked = z; // 같은 name 속성의 값은 배열로 순차적으로 처리됨
		w++;
	} while (w < ea);

	ag_check(); // 전체 선택 후 상태 갱신
}

// 하나라도 false일 경우 전체선택 해제, 모두 체크되었을 경우 전체 선택 체크
var ag_check = function() {
	var ob = frm.agree; /* form태그 안에서 agree라는 name명을 가진 오브젝트 전체 */
	var ea = ob.length;
	var w = 0;
	var count = 0;

	while (w < ea) {
		if (ob[w].checked == true) { // 비교 연산자 주의
			count++;
		}
		w++;
	}

	if (ea == count) {
		document.getElementById("all").checked = true;
	} else {
		document.getElementById("all").checked = false;
	}
}

</script>
</html>