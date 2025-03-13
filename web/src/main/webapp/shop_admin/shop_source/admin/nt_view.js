function writeok(){
	
if(frm.subject.value==""){//공지사항 제목 입력
	alert("공지사항 제목을 입력하세요.");
}
else if(frm.writer.value==""){
	alert("글쓴이를 입력하세요.");		
}


else{//공지사항 등록 조건
 
 //txt 변수 생성(CKEDITOR.instances id이름.getData():ckditor를 로드 )
var txt = CKEDITOR.instances.editor.getData();
	
	if(txt==""){//내용이 없을 경우 
		alert("내용을 입력하셔야 합니다.");		
	}else if(txt.length<40){
		
	}
	
}
}		