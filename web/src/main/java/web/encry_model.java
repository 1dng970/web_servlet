package web;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

//문자를 암호화 변경하는 model
public class encry_model {
/*
암호화 public,dataencode 예정, 암호화생성 작업 하는 클래스
*/	
	
public String dataencode(String word) { /*base64 복호화(암호화), word 받을값 대입*/
	Encoder ec = Base64.getEncoder();/*Base64 암호화 생성*/
	String sercurity = ec.encodeToString(word.getBytes());/*암호화 byte 이므로 조회*/
	
	
	return sercurity;/*클래스를 불러와서 사용*/
}
public String datadecode(String word) {
	
	Decoder dc = Base64.getDecoder();
	/*
	byte dec[] = dc.decode(word);
	String security = new String(dec);
	*/
	String security = new String(dc.decode(word));
	
	return security;
	
}
/* 
MD5 : 02x 기본 => %x =>%03x 부터 자릿수가 변경( x:소문자, X:대문자 ) 
sha-1 : 16진수 40자로 생성되는 암호화 기술(%01x,%02x)
sha-2 : sha-224, ,sha-224 ,sha-384 ,sha-512->512bit 암호화(제일 긴 암호화 기술)
sha-3 : sha3-224, ,sha3-224 ,sha3-384 ,sha3-512 -> 가장많이 사용되는 알고리즘
*/

/* 복화 암호화 기술 => base 64 => md5 */
/* 복화 암호화 기술 => md5 + sha-2 */
public String md5_encode(String word) {
	String security ="";
	
/*MessageDigest : 암호화 클래스 구성 형태를 가지고 있는 라이브러리*/	
	try {	
		//MessageDigest md = MessageDigest.getInstance("md5");
		/*MD5->sha-1로발전*/
	MessageDigest md = MessageDigest.getInstance("sha3-256");		
	md.update(word.getBytes());/*모든 암호화는 byte 문자로 변환*/
	byte md5byte[] = md.digest();/*원시배열에 해당되 암호화된 byte로저장*/
	
	
	StringBuilder sb = new StringBuilder();/*문자열 클래스를연속화*/
	
	for(byte s:  md5byte) {/*문자로 저장을 해서 핸들링 작업*/
		sb.append(String.format("%01x", s));
				/*%02x=> 2자리 문자 =>1234 =>01,02,03,04*/
		        /*%01x=> 1자리 문자 =>1234 =>1,2,3,4*/
		        /*%05x=> 5자리 문자 =>1234 =>00001,00002,3,4*/
	  }	
	   security =String.valueOf(sb);
	
	}catch(Exception e) {
		
		security ="MD5 Error!!";
	}
	return security;
   }

}
