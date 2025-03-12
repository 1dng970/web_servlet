package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import event.dbconfig;
import shop.m_dbinfo;

//copyright Model + Login Model
public class copyright {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null; //쿼리문 사용
	ArrayList<String> cp = null;//1차 배열로 받음 
    m_dbinfo db = new m_dbinfo();
    String result = null;
    m_member mb = new m_member();
    
 
    //login //dto는 클로즈가 없음 
    public String user_login(m_member dto) {
    	try {
			this.con = this.db.getConnection();
	        this.sql = "select mid,mname,memail from joins where mid=? and mpass=?";  		
    		this.ps = this.con.prepareStatement(this.sql);
    		this.ps.setString(1,dto.getMid());
    		this.ps.setString(2,dto.getMpass());
    		this.rs=this.ps.executeQuery();
    		if(this.rs.next()==true) {//정상적으로 아이디및 패스워드가 맞을 경우 
    		   this.result ="ok";
    			m_member mb = new m_member();//기존에 사용된 DTO를 초기화 및 새로운 DTO값을 구성하기 위함
    		  mb.setMid(this.rs.getString("mid")); //아이디
    		  mb.setMname(this.rs.getString("mname"));//가입자명 
    		  mb.setMemail(this.rs.getString("memail"));//이메일명 
    		}
    		
		}catch (Exception e) {
	
		}finally {
	      try {
	    	this.ps.close();
	    	this.rs.close(); 
			this.con.close();
		} catch (Exception e) {
			// TODO: handle exception
		   }		
		} 	
    	return this.result;
    }
    
    
    
    /*
     값 잘 가지고 왓는지 확인 시 조회용
    public static void main(String[] args) {
         new copyright().main2();
   }
    */
    public ArrayList<String> copyright_info(){
       try {
    		this.con =this.db.getConnection();   		
    		//System.out.println(this.con);//sql 연결 잘 되엇는지 확인 
       this.sql ="select * from corp_info";
       this.ps = this.con.prepareStatement(this.sql);
       this.rs = this.ps.executeQuery();//select
       //1차클래스 배열
       this.rs.next();//넣어야 클래스 배열에 들어감
       this.cp= new ArrayList<String>();
       this.cp.add(this.rs.getString("corp_nm"));
       this.cp.add(this.rs.getString("ceo_nm"));
       this.cp.add(this.rs.getString("corp_addr"));
       this.cp.add(this.rs.getString("corp_tel"));
       this.cp.add(this.rs.getString("corp_time"));
       this.cp.add(this.rs.getString("ceo_email"));
       this.cp.add(this.rs.getString("corp_no"));
       this.cp.add(this.rs.getString("corp_no2"));
       this.cp.add(this.rs.getString("corp_master"));
       this.cp.add(this.rs.getString("corp_domain"));
       //System.out.println(this.cp);//배열 잘 들어갔는지 확인
                 
       }catch (Exception e) {
    		
    		
    			
    		}finally{
    			try {
    				this.rs.close();
    				this.ps.close();
					this.con.close();
				} catch (Exception e) {
				System.out.println("데이터베이스에로");
				}
    		 }
	
       return this.cp;
    }
}

