package com.WEBDEMO.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.WEBDEMO.Pojo.User;
import com.WEBDEMO.Util.UtilJDBC;

public class RegistService {
	 PreparedStatement sql=null; 
     Connection con=null;
     boolean flag=false;      
	
		public boolean Save(User user){
			
		    try{
				con=UtilJDBC.getConnection();//连接数据	
				
			    sql=con.prepareStatement("insert into T_WEBDEMO_USER(userid,uname,upassword,usex) values(users_sequence.nextval,?,?,?)");
		    
			    sql.setString(1, user.getUname());
		        sql.setString(2, user.getUpassword());
		        sql.setString(3,"男");
		        if(sql.executeUpdate()>0){
		        	flag=true;
		        }; //执行！！！	   
			}catch(SQLException E){
				E.printStackTrace();
				flag=false;
			}finally
		       {    
		           if(sql!= null)
					try {
						sql.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} 
		           if(con != null)
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} 
		       } 
			return flag;
			
		}

}
