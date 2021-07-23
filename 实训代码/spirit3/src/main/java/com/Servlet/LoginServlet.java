/*@Author:WangKai
  @Create Date:2021/7/16
  @Update Date:2021/7/20 17:22
*/

package com.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.Client.*;
import com.Dbutil.Dbutil;

@SuppressWarnings({ "unused", "serial" })
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

	public LoginServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String userid = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String companyname = request.getParameter("companyname");
		
		request.setAttribute("companyname", companyname);
		
		boolean existOrNot=false;
		try {
			existOrNot = this.existtable(companyname);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String pwd_if = "123";//用以储存从后台数据库获取的密码

		if(existOrNot) {
		//向数据库中查找用户名对应的密码

		    try {
			
			Dbutil dbutil = new Dbutil();
            Connection conn = dbutil.getCon();
            Statement stmt = conn.createStatement();
            String sql = "select user_password from "+companyname+" where user_id="+userid;
            ResultSet rSet = stmt.executeQuery(sql);
        
            
            while(rSet.next())
            {
               pwd_if = rSet.getString("user_password");
               System.out.println("获取密码成功："+pwd_if);
            }
        
            rSet.close();
            stmt.close();
            conn.close();
            
		    }catch(ClassNotFoundException e) {
			       e.printStackTrace();
		       }catch(SQLException e) {
			       e.printStackTrace();
		       }catch(Exception e) {
			       e.printStackTrace();
		       }
			
			System.out.println(userid+"  "+pwd_if);
		
		    if (userid.equals("000001")&&pwd.equals(pwd_if)) {
			
//			    Client user = new Client(companyname,userid, pwd);
			    request.getSession().setAttribute("loginUser", companyname);
				request.getSession().setAttribute("loginid", userid);
			    request.getRequestDispatcher("main.jsp").forward(request, response);
			    
		    }else if((!userid.equals("000001"))&&pwd.equals(pwd_if)){
			
//			    Client user = new Client(companyname,userid,pwd);
			    request.getSession().setAttribute("loginUser",companyname);
				request.getSession().setAttribute("loginid", userid);
			    request.getRequestDispatcher("PersonServlet.do").forward(request, response);
			
		    }else {
		
				request.setAttribute("msg","账号密码错误");
			    request.getRequestDispatcher("/login.jsp").forward(request,response);
		    }
		
		}else{//没有该公司的表则创建并添加该管理员用户

			request.setAttribute("noms","用户不存在请去注册");
		    request.getRequestDispatcher("/login.jsp").forward(request, response);
		    
		}
		
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
    	doGet(req, resp);
               
    }

    public boolean existtable(String tablename) throws Exception {
	
			Dbutil dbutil = new Dbutil();
            Connection conn = dbutil.getCon();
            ResultSet rs = conn.getMetaData().getTables(null, null, tablename, null);
            if (rs.next()) {
                  
            	System.out.println("True");
            	return true;
                  
            }else {
            	  
            	System.out.println("False");
                return false;
                  
            }
			   	
   }
    
/*    public void getPwd(String tablename,String userid,String password) throws Exception {
    	
		    Dbutil dbutil = new Dbutil();
            Connection conn = dbutil.getCon();
            Statement stmt = conn.createStatement();
            String sql = "select user_password from "+tablename+" where user_id="+userid;
            ResultSet rSet = stmt.executeQuery(sql);
        
            
            while(rSet.next())
            {
               password = rSet.getString("user_password");
               System.out.println("获取密码成功："+password);
            }
        
            rSet.close();
            stmt.close();
            conn.close();
    	
    }*/
    
}
            

    

