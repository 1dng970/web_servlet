package mallpage;
//상품 리스트 Database연결 Model

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;

public class m_product {
	//DTO(setter,getter)
	dto_product pd = new dto_product();//void 메소드일 경우 controller 가져가는 객체
		
	//여러게 가져와야되기 때문에 2차 배열 생성 (전역변수)
	ArrayList<ArrayList<String>> all= null;
	ArrayList<String> al = null;
	
	//void도 사용 가능
	//db정보 연결
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null; //DB 쿼리문
	
	//DB 접속정보 
	m_dbinfo db = new m_dbinfo();
		
	//상품하나의 정보만 가져오는 모델
	public void oneproduct(dto_product p) {//Conroller 에서 보내주 DTO의 값을 받음 
		//System.out.println(p.getMidx());
		
	try {
		this.con= this.db.getConnection();
		this.sql = "select * from mall_product where midx=?";
		this.ps= this.con.prepareStatement(this.sql);
		this.ps.setInt(1, p.getMidx());
		this.rs=this.ps.executeQuery();
		if(this.rs.next()==false) {
			this.pd.setMidx(0);
			//System.out.println("데이터 없음");
		}else {
			//System.out.println("데이터 있음");
				
			this.pd.setMidx(this.rs.getInt("midx"));
			this.pd.setPcode(this.rs.getString("pcode"));
		    this.pd.setPdate(this.rs.getString("pdate"));
		    this.pd.setPimg(this.rs.getString("pimg"));
		    this.pd.setPmoney(this.rs.getString("pmoney"));
		    this.pd.setPnm(this.rs.getString("pnm"));
		    this.pd.setPsales(this.rs.getString("psales"));
		    this.pd.setPsmoney(this.rs.getString("psmoney"));
		    /*
			this.pd.setMidx(this.rs.getInt("midx"));
			this.pd.setPcode(this.rs.getString("pcode"));
			this.pd.setPdate(sql);
			this.pd
		     */
	
		}
		
	} catch (Exception e) {
		
			
	  }finally {
		  try {
			this.rs.close();
			this.ps.close();		  
			this.con.close();
		  }catch (Exception e) {
			
		  }	
		  
		 }		
	}
	
	//전체 리스트를 가져오는 모델
	public ArrayList<ArrayList<String>> product_all(){
		
	  try {
		this.con =this.db.getConnection();
       // System.out.println(this.con);
		this.sql ="select * from mall_product order by midx desc";//쿼리문 작동
		this.ps= this.con.prepareStatement(this.sql);
	    this.rs = ps.executeQuery();//select
	    this.all= new ArrayList<ArrayList<String>>();//2차 배열 선언
	    while(this.rs.next()) {//쿼리 돌때 까지 배열로 들어간다 
          this.al = new ArrayList<String>();
          //this.al =String.valueOf(this.rs.getInt("midx"));
	    this.al.add(String.valueOf(this.rs.getInt("midx")));
	    this.al.add(this.rs.getString("pcode"));
	    this.al.add(this.rs.getString("pnm"));
	    this.al.add(this.rs.getString("pmoney"));
	    this.al.add(this.rs.getString("psales"));
	    this.al.add(this.rs.getString("psmoney"));
	    this.al.add(this.rs.getString("pimg"));
	    this.al.add(this.rs.getString("pdate"));
	    this.all.add(this.al);//배열 다넣음 
	    //System.out.println(this.all);
	    }	
	    
	  }catch(Exception e) {
	  this.all= null;
	  }finally {
	  try {
		this.rs.close();
		this.ps.close();		  
		this.con.close();
	  }catch (Exception e) {
		   this.all = null;

	  }	
	  
	 }
		
		
		return this.all;		
	}
	
}
