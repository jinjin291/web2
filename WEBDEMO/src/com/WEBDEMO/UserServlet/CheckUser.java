package com.WEBDEMO.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.WEBDEMO.Pojo.User;
import com.WEBDEMO.Service.CheckUserService;

public class CheckUser extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upassword =null;
		User user=new User(uname, upassword);
		response.setCharacterEncoding("UTF-8");
		JSONObject jb =new JSONObject();
		if(new CheckUserService().Check(user)){
			jb.put("code", 1);
		}else{
			jb.put("code", 0);
		}
		PrintWriter out=response.getWriter();
		out.print(jb);
		out.close();
	}

}
