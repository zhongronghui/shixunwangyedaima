package com.Servlet;

import com.Client.Client;
import com.Dbutil.Dbutil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PersonServlet", value = "/PersonServlet")
public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public PersonServlet(){
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
        String tablename = (String) request.getSession().getAttribute("loginUser");
        String user_id=(String) request.getSession().getAttribute("loginid");

        Dbutil dbutil=new Dbutil();
        try {



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
        request.getRequestDispatcher("test.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
