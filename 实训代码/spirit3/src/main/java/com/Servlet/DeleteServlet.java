package com.Servlet;

import com.Client.Client;
import com.Dbutil.Dbutil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@SuppressWarnings("unused")
@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 构造函数
     */
    public DeleteServlet()
    {
        super();
    }

    /**
     * 初始化
     */
    public void init() throws ServletException
    {}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

    	String tablename = (String) request.getSession().getAttribute("loginUser");
        
        try {
            this.save(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Dbutil dbutil =new Dbutil();

        try {
            String user_id=request.getParameter("user_id");
            Connection conn=dbutil.getCon();

            String sql = "DELETE FROM "+tablename+" WHERE user_id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_id);
            int a = ps.executeUpdate();
            ps.close();
            conn.close();
            log("删除失败");
            if(a > 0){

                request.getRequestDispatcher("FindallServlet.do").forward(request, response);
            }
        }
        catch (Exception e) {

            log("删除失败");
            System.out.print("删除信息失败  " + e.toString());

        }


    }

    public void save (HttpServletRequest request, HttpServletResponse response) throws Exception {
        Dbutil dbutil=new Dbutil();
        try {
            String user_id=request.getParameter("user_id");
            String user_name=request.getParameter("user_name");
            String user_sex=request.getParameter("user_sex");
            String user_position=request.getParameter("user_position");
            String user_salary=request.getParameter("user_salary");
            String user_evaluate=request.getParameter("user_evaluate");
            Connection conn=dbutil.getCon();
            String sql = "insert into allfree(user_name,user_sex,user_position,user_salary,user_evaluate)values(?,?,?,?,?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user_name);
            ps.setString(2,user_sex);
            ps.setString(3,user_position);
            ps.setString(4,user_salary);
            ps.setString(5,user_evaluate);
            int a = ps.executeUpdate();


        }
        catch (Exception e) {

        }
    }
    public void destroy() {
        super.destroy();
    }
}

