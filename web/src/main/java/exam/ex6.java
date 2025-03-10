package exam;

import java.util.Scanner;

public class ex6 {

	public static void main(String[] args) {
		String user[][]= {
				{"마동석","01053514423"},
				{"김무열","01010042223"},
				{"박지환","01069822901"},		
				{"마동석","01008081010"},	
		};
		Scanner sc = new Scanner(System.in);
		System.out.println("고객명을 입력하세요");
        String name =sc.nextLine().replaceAll("","");/*띄어쓰기 해서 쓸수 있는것을 혹시 몰라 대비책으로 넣어둔거*/
        System.out.println(name);
        
        int w = 0;//while문은 변수명선언
        while(w < user.length) {
        	if(name.equals(user[w][0])) {
        		
        		System.out.println(user[w][0] + "님 연락처 "+ user[w][1]+"입니다.");
        	}
        	w++;
        }
        
        
        sc.close();
	}

}
