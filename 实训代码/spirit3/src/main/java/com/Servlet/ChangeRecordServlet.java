package com.Servlet;

import com.Client.Client;
import com.Dbutil.Dbutil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@WebServlet(name = "ChangeRecordServlet", value = "/ChangeRecordServlet")
public class ChangeRecordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ChangeRecordServlet(){
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
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
        
        Dbutil dbutil=new Dbutil();
        try {
            Connection conn=dbutil.getCon();
            Statement stmt = conn.createStatement();
            String sql = "select * from "+tablename+" where user_id<>000001";
            ResultSet rs = stmt.executeQuery(sql);

            List<Client> list = new ArrayList<Client>();
            while (rs.next()) {
                Client client=new Client();
                client.setUser_id(rs.getString("user_id"));
                client.setUser_name(rs.getString("user_name"));
                client.setUser_password(rs.getString("user_password"));
                client.setUser_sex(rs.getString("user_sex"));
                client.setUser_birthday(rs.getString("user_birthday"));
                client.setUser_number(rs.getString("user_number"));
                client.setUser_jointime(rs.getString("user_jointime"));
                client.setUser_position(rs.getString("user_position"));
                client.setUser_salary(rs.getString("user_salary"));
                client.setUser_absent(rs.getString("user_absent"));
                list.add(client);
            }
            request.setAttribute("list", list);
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        request.getRequestDispatcher("record.jsp").forward(request, response);
    }
    public void destroy()
    {
        super.destroy();
    }
}

