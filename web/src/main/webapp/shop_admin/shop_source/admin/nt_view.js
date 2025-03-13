function noticeok(){
		
var subject = frm.subject.value.trim();
		
if(frm.subject.value==""){
	alert("공지사항 제목을 입력하세요");	
	frm.subject.focus();
	
}else if(frm.writer.value==""){	
	alert("글쓴이를 입력하세요");
	  frm.writer.focus();	
	  
}

else if(frm.writer.value==""){	
	alert("글쓴이를 입력하세요");
	  frm.writer.focus();	
	  
}else if(){//첨부파일 
	
	
	
	
}



else{//공지내용

var txt = CKEDITOR.instances.editor.getData();

if(txt==""){
	alert("내용을 입력하세요");
		return false;
}
else if(txt.lengt<40){//40자이상 등록되게 조건 
	alert("최소  40자 이상 입력하셔야 합니다.");
		return false;
}	

else{

	frm.submit();
       }	
   }
	
}

	
	

