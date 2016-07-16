package com.WEBDEMO.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.WEBDEMO.Pojo.User;
import com.WEBDEMO.Util.UtilJDBC;

public class CheckUserService {
	PreparedStatement sql=null; 
    ResultSet rs=null;
    Connection con=null;
    public boolean Check(User user){
		    try{
		    	
		    	con=UtilJDBC.getConnection();//连接数据
		    	System.out.println(user.getUname());
		    	 sql = con.prepareStatement("SELECT * FROM T_WEBDEMO_USER WHERE uname=?");
		    	 sql.setString(1, user.getUname());
		    	 rs = sql.executeQuery();
		    	 while(rs.next()){
		    		 	return false;	    		 	    	
		    	 }
		    }catch (Exception e) { 
				// TODO: handle exception
		    	e.printStackTrace();
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
			return true;
    }
   
}
