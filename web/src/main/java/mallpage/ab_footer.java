package mallpage;

import java.util.ArrayList;

public abstract class ab_footer {
	copyright cr = new copyright();// 클래스 로드 
	ArrayList<String> cdata = null;

	public void fts() {//fts 발동을 하게 작업을 해야한다. 
	this.cdata = this.cr.copyright_info(); //클래스 배열 결과값 들고옴 
	
	}

}
