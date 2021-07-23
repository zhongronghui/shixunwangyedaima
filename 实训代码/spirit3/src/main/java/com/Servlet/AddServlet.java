package com.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import com.Client.Client;

import com.Dbutil.Dbutil;

@SuppressWarnings("unused")
@WebServlet(name = "AddServlet", value = "/AddServlet")
public class AddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
   public AddServlet()
   {
       super();
   }

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

    	String tablename = (String) request.getSession().getAttribute("loginUser");

       Client client=new Client();
       String user_id=request.getParameter("user_id");
       String user_name=request.getParameter("user_name");
       String user_password=request.getParameter("user_password");
       String user_sex=request.getParameter("user_sex");
       String user_birthday   =request.getParameter("user_birthday");
       String user_number  =request.getParameter("user_number");
       String user_jointime =request.getParameter("user_jointime");
       String user_salary=request.getParameter("user_salary");
       String user_absent=request.getParameter("user_absent");
       String user_position=request.getParameter("user_position");
       String user_evaluate=request.getParameter("user_evaluate");
       Dbutil dbutil=new Dbutil();

        try{


            Connection conn=dbutil.getCon();
          
            System.out.println("添加信息"+tablename);
            
            String sql = "insert into "+tablename+"(user_id,user_name,user_password,user_sex,user_birthday,user_number,user_jointime,user_position,user_salary,user_absent,user_evaluate)values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,user_id);
            ps.setString(2,user_name);
            ps.setString(3,user_password);
            ps.setString(4,user_sex);
            ps.setString(5,user_birthday);
            ps.setString(6, user_number);
            ps.setString(7,user_jointime);
            ps.setString(8,user_position);
            ps.setString(9, user_salary);
            ps.setString(10,user_absent);
            ps.setString(11,user_evaluate);
            int row = ps.executeUpdate();
            ps.close();
            conn.close();
            if(row > 0){
                /*PrintWriter out =response.getWriter();

                out.print("添加成功"+row+"条信息");*/
                request.getRequestDispatcher("FindallServlet.do").forward(request, response);
            }
        }catch(Exception e){

                //System.out.print("添加信息失败  " + e.toString());

               // response.sendError(403,"添加失败");
        }

    }
    public void destroy() {
        super.destroy();
    }
}
