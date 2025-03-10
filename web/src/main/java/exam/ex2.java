package exam;
/*
1~46 : 5 10
[문항2] 사용자가 6개의 숫자를 입력합니다.
총 몇개의 숫자를 맞췄는지를 출력하는 코드를 작성하시오.
만약 사용자가 6개의 숫자를 입력하지 않을 경우 무조건 6개의 숫자를 입력하도록 합니다. (동일한 숫자는 사용하지 못함)
*/

import java.util.ArrayList;
import java.util.Scanner;

import admin.main;

public class ex2 {

	//필드 밖에서 입력하면 재귀함수가 초기화가 되지 않음 
	//ArrayList<Integer> user = new ArrayList<Integer>();
	public static void main(String[] args) {
		
		ex2_box ea = new ex2_box();
		ea.aaa();
		
	}

}

class ex2_box{
	ArrayList<Integer> user = null;
	ArrayList<Integer> pc = null;
	Scanner sc = null;

	public ex2_box() {
		this.sc = new Scanner(System.in);		
		this.user = new ArrayList<Integer>();
		this.pc = new ArrayList<Integer>();
	}
		public Integer pc_return() {
			Integer npc =(int)Math.ceil(Math.random()*46);
		if(this.pc.contains(npc)==false) {
			pc_return();
		}
			return npc ;
        }
 
		public void aaa() {
			//System.out.println(this.user);
			try {
				while(true) {
			if(this.user.size()==6) {
				break;
			}
			if(this.pc.size()<6) {
			Integer npc  = (int)Math.ceil(Math.random()*46);
			if(this.pc.contains(npc)==false) {
				this.pc.add(npc);
			}else {//중복 되었을 경우
			   /*외부 return 메소드 재핸들링*/	
				Integer result = this.pc_return();
				this.pc.add(result);
			}
			
			}
						
			System.out.println("숫자를 입력하세요 (1~46): ");		
				Integer no = this.sc.nextInt();//Integer도 사용이 가능.예외처리 안에서 쓰기								
				/*숫자검토*/
				if(no>0 &&no<=46) {/*&&-> 유의해서 사용하기*/
					//같은 숫자 확인					
					if(this.user.contains(no)==false) {//객체가 ㅈ존재한다면					
					this.user.add(no);//사용자가 입력한 숫자 들어감
					 }
					
				 }else {	
					 System.out.println("숫자는 1~46까지 입력가능 합니다.");
				 }
				//System.out.println(this.user);
				//System.out.println(this.pc);
			  }
		}catch(Exception e) {
				System.out.println("숫자만 입력하세요");
				new ex2_box().aaa();

			  }finally {//반복문 안에 close를 쓰지 말기 		
			sc.close();//제일 아래에 사용		
			  }
		}
	}
