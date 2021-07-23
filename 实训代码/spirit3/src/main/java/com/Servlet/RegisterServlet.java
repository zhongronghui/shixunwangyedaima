package com.Servlet;

import com.Dbutil.Dbutil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public RegisterServlet(){
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
        String userid = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String companyname = request.getParameter("companyname");

        boolean existOrNot=false;//判断公司是否存在
        try {
            existOrNot = this.existtable(companyname);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if(!existOrNot) {
            try {
                Dbutil dbutil = new Dbutil();
                Connection conn = dbutil.getCon();
                Statement stmt = conn.createStatement();
                String sql = "create table "+companyname+" like newcopy";
                stmt = conn.createStatement();



                int counts = stmt.executeUpdate(sql);
                if (counts>0) {

                    System.out.println("创建新表操作成功");

                }

                conn.close();
                stmt.close();

            }catch(ClassNotFoundException e) {
                e.printStackTrace();
            }catch(SQLException e) {
                e.printStackTrace();
            }catch(Exception e) {
                e.printStackTrace();
            }

            try {
                Dbutil dbutil = new Dbutil();
                Connection conn = dbutil.getCon();
                String imm= "000001";
                String sql = "insert into "+companyname+"(user_id,user_name,user_password,user_sex,user_birthday,user_number,user_jointime,user_position,user_salary,user_absent,user_evaluate)values(?,null,?,null,null,null,null,null,null,null,null)";
                PreparedStatement prestmt = conn.prepareStatement(sql);

                prestmt.setString(1,imm);
                prestmt.setString(2,pwd);

                int counts = prestmt.executeUpdate();
                if (counts>0) {

                    System.out.println("数据库操作成功");

                }

                conn.close();
                prestmt.close();

            }catch(ClassNotFoundException e) {
                e.printStackTrace();
            }catch(SQLException e) {
                e.printStackTrace();
            }catch(Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("zhucechenggong","用户注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }else {

            request.setAttribute("yijingcunzai","用户已经存在，请重新注册");
            request.getRequestDispatcher("/register.jsp").forward(request,response);

        }

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

    @Override
    public void destroy() {

    }
}

