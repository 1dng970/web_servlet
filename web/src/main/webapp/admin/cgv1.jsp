<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화예매</title>
</head>
<body>
<P>영화 예매 시스템</P>
<form id="frm" method="get" action="./cgv1.do" onsubmit="return_fi()">
고객명 : <input type="text" name="mname" ><br>
연락처 : <input type="text" name="mtel"> "-"없이 숫자만 입력 <br><br>
영화선택 :<br>
<input type="radio" name="view" value="하트맨" >하트맨<br>
<input type="radio" name="view" value="써니데이">써니데이<br>
<input type="radio" name="view" value="브루탈리스트">브루탈리스트<br>
<input type="radio" name="view" value="히어">히어<br>
<input type="radio" name="view" value="하얼빈">하얼빈<br>

<br>
예매일자 : <input type="date" name="date"><br>

<input type="button" value="예매하기" onclick="cgv_op()">
</form>

</body>
<script >
function cgv_op(){//영화선택을 위한 반복문 
	
	 var mname = document.getElementsByName("mname");
     var mtel = document.getElementsByName("mtel");
     var view = document.getElementsByName("view");
     var date= document.getElementsByName("date");
     
    //날짜 가져오는 변수 추가
    
    var today= new Date();//날짜 비교 생성
    today.setHours(0, 0, 0, 0);
    
    //사용자가 선택한 날짜
    var selectdate = new Date(frm.date.value);
    
    
    if(frm.mname.value==""){//고객명
	
	alert("고객명을 입력하세요");
		return false;
				
	}
   else if(frm.mtel.value==""){		
		alert("연락처를 입력하세요");//연락처
		return false;
		
	}
    else if(frm.mtel.value.length < 10 || frm.mtel.value.length > 11) {//연락처 제한수 
        alert("연락처를 10~11자로 입력하세요");
        return false;
    }
	
    else if(frm.view.value==""){//영화선택	
		alert("영화를 선택해 주세요");
		return false;
   
	}else if(frm.date.value==""){//오늘이전 예매 불가 
    	alert("예약날짜를 선택해 주세요");
		return false;  	
		
    }
	else if(selectdate<today){//오늘이전 예매 불가 
    	alert("예매일자는 오늘 이후로 선택 가능 합니다.");
		return false;  
	} else{
		frm.submit();

		return true;
	
	}
  }
</script>
</html>