package exam;

import java.util.ArrayList;
import java.util.Arrays;

/*오버라이드는 재귀함수를 쓰면 위험함*/
public class ex8 extends ex8_box {//추상클래스,static 밖에서도 사용이 가능하다 
	@Override
		public void even() {/*짝수*/
		  ArrayList<Integer> number = new  ArrayList<Integer>(Arrays.asList(this.data));
		 
		  int w =0;
		  while(w<number.size()) {
			  if(number.get(w)%2==1) { //홀수값 조건은 배열에 삭제 
				  number.remove(w); //remove시 배열에 index 즉 node번호가 생성됨 
				 w=0; /*0사용은 배열에 값이 삭제 되면 노드변화로 처음부터 다시 검토 하도록 함*/
				  
				  
			  }else {/*해당조건(홀수) 가 아니면 증가하여 +1증가 시켜서 배열을 검토하는 형태 */
				  
				  w++;
			  }
		  }
			System.out.println(number);
		}
	@Override
		public void odd() {
		
			
		}
	public static void main(String[] args) {
	    new ex8().even();
	    new ex8().odd();

	}
     public void dataload() {
    	 
     }
}
//추상클래스 
abstract class ex8_box{
	/*무작위로 숫자 배열선언*/
	Integer data[] = {3,5,2,1,6,7,8,9,10,4};	
	abstract public void even(); //짝수
	abstract public void odd(); //홀수   
}

/*
abstract public even() {//짝수
	
	
}
//짝수
abstract public odd() {
	
	
}

}
*/