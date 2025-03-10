package model;
//Model(난수를 생성하는 모델)

import java.util.ArrayList;
import java.util.Random;

public class rmd {
 ArrayList<String> num =null;
 int ea =0 ;//자리수
 
 public rmd(int n) { //즉시실행
	 this.ea =n;//자동등록방지 4자리 또는 게시판 보안코드 6자리등등....
	 this.num = new ArrayList<String>();
	 
 }
	public ArrayList<String> make_num() {//난수를 생성
		Random rd = new Random();//클래스명 난수
		int w = 1;
		while(w<this.ea) {
			this.num.add(String.valueOf(rd.nextInt(10)));
			
			w++;
		}
		return this.num;
	}
}
