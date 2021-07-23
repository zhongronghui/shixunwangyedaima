package com.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import com.Client.Client;
import com.Dbutil.Dbutil;


@SuppressWarnings("unused")
@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public  UpdateServlet(){
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
        String type = request.getParameter("type");
        if (type != null && "changeall".equals(type)) {
            try {
                this.changeall(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (type != null && "changeabsent".equals(type)) {
            try {
                this.changeabsent(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (type != null && "evaluate".equals(type)) {
            try {
                this.evaluate(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }




    public void changeall(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	String tablename = (String) request.getSession().getAttribute("loginUser");
    	
    	Dbutil dbutil=new Dbutil();
        try {
            Client client = new Client();
            String user_id = request.getParameter("user_id");
            String user_name = request.getParameter("user_name");
            String user_password = request.getParameter("user_password");
            String user_sex = request.getParameter("user_sex");
            String user_birthday = request.getParameter("user_birthday");
            String user_number = request.getParameter("user_number");
            String user_jointime = request.getParameter("user_jointime");
            String user_position = request.getParameter("user_position");
            String user_salary = request.getParameter("user_salary");
            String user_absent = request.getParameter("user_absent");
            String user_evaluate=request.getParameter("user_evaluate");


            Connection conn=dbutil.getCon();
            String sql = "update "+tablename+" set user_name=? ,user_password=?, user_sex=?, user_birthday=?, user_number=?, user_jointime=? ,user_position=?, user_salary=?, user_absent=?,user_evaluate=? where user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2, user_password);
            ps.setString(3, user_sex);
            ps.setString(4, user_birthday);
            ps.setString(5, user_number);
            ps.setString(6, user_jointime);
            ps.setString(7, user_position);
            ps.setString(8, user_salary);
            ps.setString(9, user_absent);
            ps.setString(10,user_evaluate);
            ps.setString(11, user_id);


            int a = ps.executeUpdate();
            if (a > 0) {

                request.getRequestDispatcher("FindallServlet.do").forward(request, response);
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("修改失败");

        };


    }
    public void changeabsent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	String tablename = (String) request.getSession().getAttribute("loginUser");
    	
    	Dbutil dbutil=new Dbutil();
        try {
            Client client = new Client();
            String user_id = request.getParameter("user_id");
            String user_name = request.getParameter("user_name");
            String user_password = request.getParameter("user_password");
            String user_sex = request.getParameter("user_sex");
            String user_birthday = request.getParameter("user_birthday");
            String user_number = request.getParameter("user_number");
            String user_jointime = request.getParameter("user_jointime");
            String user_position = request.getParameter("user_position");
            String user_salary = request.getParameter("user_salary");
            String user_absent = request.getParameter("user_absent");

            Connection conn=dbutil.getCon();
            String sql = "update "+tablename+" set  user_absent=? where user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_absent);
            ps.setString(2, user_id);
            int a = ps.executeUpdate();
            if (a > 0) {
                System.out.println("更新成功");
                request.getRequestDispatcher("ChangeRecordServlet.do").forward(request, response);
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("更新失败");

        };

    }
    public void evaluate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Dbutil dbutil=new Dbutil();
        String tablename = (String) request.getSession().getAttribute("loginUser");
        try {
            Client client = new Client();
            String user_id = request.getParameter("user_id");
            String user_absent = request.getParameter("user_absent");
            String user_evaluate=request.getParameter("user_evaluate");

            Connection conn=dbutil.getCon();
            String sql = "update "+tablename+ " set  user_absent=? ,user_evaluate=?  where user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_absent);
            ps.setString(2,user_evaluate);
            ps.setString(3, user_id);
            int a = ps.executeUpdate();
            if (a > 0) {
                System.out.println("评价成功");
                request.getRequestDispatcher("ChangeRecordServlet.do").forward(request, response);
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("更新失败");

        };

    }



    public void destroy() {
        super.destroy();
    }
}
