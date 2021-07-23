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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
@WebServlet(name = "FindDetailsServlet", value = "/FindDetailsServlet")
public class FindDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public FindDetailsServlet(){
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
        if (type != null && "Detailsfind".equals(type)) {
            try {
                this.Detailsfind(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (type != null && "Evaluatefind".equals(type)) {
            try {
                this.Evaluatefind(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    public void Detailsfind(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	String tablename = (String) request.getSession().getAttribute("loginUser");
    	
    	Dbutil dbutil=new Dbutil();
        try {

            String user_id=request.getParameter("user_id");

            Connection conn=dbutil.getCon();
            String sql = "SELECT * FROM "+tablename+" WHERE user_id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user_id);
            ResultSet rs = ps.executeQuery();
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
                client.setUser_evaluate(rs.getString("user_evaluate"));
                list.add(client);
            }
            request.setAttribute("list", list);
            ps.close();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        request.getRequestDispatcher("update.jsp").forward(request, response);

    }
    public void Evaluatefind(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	String tablename = (String) request.getSession().getAttribute("loginUser");
    	
    	Dbutil dbutil=new Dbutil();
        try {

            String user_id=request.getParameter("user_id");
            System.out.println("测试"+tablename);
            System.out.println("测试"+user_id);
            Connection conn=dbutil.getCon();
            String sql = "SELECT * FROM "+tablename+" WHERE user_id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user_id);
            ResultSet rs = ps.executeQuery();
            List<Client> list = new ArrayList<Client>();
            while (rs.next()) {
                Client client=new Client();
                client.setUser_id(rs.getString("user_id"));
                client.setUser_name(rs.getString("user_name"));
                client.setUser_sex(rs.getString("user_sex"));
                client.setUser_number(rs.getString("user_number"));
                client.setUser_jointime(rs.getString("user_jointime"));
                client.setUser_position(rs.getString("user_position"));
                client.setUser_absent(rs.getString("user_absent"));
                client.setUser_evaluate(rs.getString("user_evaluate"));
                list.add(client);
            }
            request.setAttribute("list", list);
            ps.close();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        request.getRequestDispatcher("evaluate.jsp").forward(request, response);




    }
    public void destroy()
    {
        super.destroy();
    }
}
