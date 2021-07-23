package com.Dbutil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Client.Client;

@SuppressWarnings("unused")
public class Dbutil {

//    private static Logger logger = LogManager.getLogger(Dbutil.class.getName());
    public Connection getCon() throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://116.62.228.207:3306/demo", "demo", "password");
            System.out.println("连接成功");


            return conn;

        } catch (Exception e) {

            System.out.println("连接失败");
            // 通知调用者，创建连接出错
           throw e;

        }

    }
    public static void closeConnection(Connection conn ){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
