package exam;

import java.util.Random;
import java.util.Scanner;

public class ex1 {
/*
Random :자동으로 pc를 생성하는 원리=> 기본 소수점		
Math.random()
*/	
	public static void main(String[] args) {
		//난수 생성
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자하나를 입력하세요: ");
		int no =sc.nextInt();//사용자가 입력 값 
		
		for(int f=1; f<=no;f++ ) {
			int free=rand.nextInt(99);
			System.out.println(free);
		}		
		/*
		for(int i=0;i<5;i++) {			
		//문자를 랜덤으로 뽑는 함수
		double rd = Math.random();
		//char word = (char)((rd*26)+97);
		char word = (char)((rd*26)+65);
		System.out.println(word);
		
		}
        */
	}
}
