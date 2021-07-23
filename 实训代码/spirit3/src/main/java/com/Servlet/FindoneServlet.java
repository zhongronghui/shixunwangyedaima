package com.Servlet;




import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.Client.Client;
import com.Dbutil.Dbutil;

@WebServlet(name = "FindoneServlet", value = "/FindoneServlet")
public class FindoneServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public FindoneServlet(){
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
        if (type != null && "recordfind".equals(type)) {
            try {
                this.recordfind(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (type != null && "allfind".equals(type)) {
            try {
                this.allfind(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (type != null && "findnew".equals(type)) {
            try {
                this.findnew(request, response);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

    public void allfind(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String tablename = (String) request.getSession().getAttribute("loginUser");
    	
        Dbutil dbutil=new Dbutil();
        try {

            String user_name=request.getParameter("user_name");

            Connection conn=dbutil.getCon();
            String sql = "SELECT * FROM "+tablename+" WHERE user_name=? or user_id=? or user_position=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user_name);
            ps.setString(2,user_name);
            ps.setString(3,user_name);
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
                list.add(client);
            }
            request.setAttribute("list", list);
            ps.close();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        request.getRequestDispatcher("information.jsp").forward(request, response);
    }

    public void recordfind(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       
    	String tablename = (String) request.getSession().getAttribute("loginUser");
    	
    	Dbutil dbutil=new Dbutil();
        try {

            String user_name=request.getParameter("user_name");


            Connection conn=dbutil.getCon();
            String sql = "SELECT * FROM "+tablename+" WHERE user_name=? or user_id=? or user_position=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user_name);
            ps.setString(2,user_name);
            ps.setString(3,user_name);
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
                list.add(client);
            }
            request.setAttribute("list", list);
            ps.close();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        request.getRequestDispatcher("record.jsp").forward(request, response);
    }

    public void findnew(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Dbutil dbutil=new Dbutil();
        try {
            String user_name=request.getParameter("user_name");
            Connection conn=dbutil.getCon();
            String sql = "SELECT * FROM allfree WHERE user_name=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user_name);
            ResultSet rs = ps.executeQuery();
            List<Client> list = new ArrayList<Client>();
            while (rs.next()) {
                Client client=new Client();
                client.setUser_name(rs.getString("user_name"));
                client.setUser_sex(rs.getString("user_sex"));
                client.setUser_position(rs.getString("user_position"));
                client.setUser_salary(rs.getString("user_salary"));
                client.setUser_evaluate(rs.getString("user_evaluate"));
                list.add(client);
            }
            request.setAttribute("list", list);
            ps.close();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        request.getRequestDispatcher("findnewclient.jsp").forward(request, response);
    }


    public void destroy()
    {
        super.destroy();
    }
}

