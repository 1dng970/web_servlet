<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 입력</title>
</head>
<body>
<!-- 
enctype="mutipart/form-data"->이미지 파일 저장시 반드시 필요함 
submit 사용시 -> 패턴 사용가능
 -->
<form id="frm" method="post" action="./part3.do" enctype="multipart/form-data">
<p>회원가입 정보 입력[간편입력]</p>
아이디 : <input type="text" name="mid"><br>
고객명 : <input type="text" name="mname"><br>
비밀번호 : <input type="password" name="mpass" maxlength="12">* 비밀번호 최소 6~12자리 입니다.<br>
이메일 : <input type="text" name="memail" ><br>
휴대폰번호:<input type="text" name="mtel" maxlength="11">* "-" 는 입력하지 않습니다.<br>
이미지<input type="file" name="mfile">*이미지 첨부는 최대 2MB 이하 입니다.<br>
<button type="button" onclick="gopage()">가입완료</button>
</form>
</body>
<script>
function gopage() {
    var frm = document.getElementById("frm");

    if (frm.mid.value == "") {
        alert("아이디를 입력하세요");
    } else if (frm.mname.value == "") {
        alert("이름을 입력하세요");
    } else if (frm.mpass.value == "") {
        alert("패스워드를 입력하세요");
    } else if (frm.mpass.value.length < 6) {
        alert("패스워드는 최소 6자 이상 입력하셔야 합니다.");
    } else if (frm.memail.value == "") {
        alert("이메일을 입력하세요");
    } else if (frm.mtel.value == "") {
        alert("휴대폰번호를 입력하세요");
    } else {
        if (confirm("회원가입을 진행 하시겠습니까?")) {
            frm.submit();
        } else {
            history.go(-1);
        }
    }
}
</script>

</html>