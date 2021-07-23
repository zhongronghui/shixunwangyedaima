<%--
  Created by IntelliJ IDEA.
  User: 钟同学
  Date: 2021/7/21
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.List"%>
<%@page import="com.Client.Client"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>公司主页</title>
    <link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet">

</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="main.jsp">首页</a></li>
                <li><a href="index.html" target="_blank">网站首页</a></li>

            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <ul class="sub-menu">
                        <li><a href="main.jsp"><i class="icon-font">&#xe008;</i>我的信息</a></li>
                        <li><a href="FindallServlet.do"><i class="icon-font">&#xe008;</i>员工信息</a></li>
                        <li><a href="insert.jsp"><i class="icon-font">&#xe005;</i>添加员工</a></li>
                        <li><a href="ChangeRecordServlet.do"><i class="icon-font">&#xe006;</i>考勤记录和评价</a></li>
                        <li><a href="findnewclient.jsp"><i class="icon-font">&#xe006;</i>查看应聘人历史</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <%
            String tablename = (String) request.getSession().getAttribute("loginUser");
            String user_id=(String) request.getSession().getAttribute("loginid");
        %>

       <center> <p style="font-size:50px;color: #1E9FFF" > 欢迎公司 <%=tablename%>,感谢您的使用</p></center>
        <br>
        <br><br><br>



        <center>  <p style="font-size:50px;color: #1E9FFF" >超级管理员 <%=user_id%></p></center></center>



    </div>
    <!--/main-->
</div>



</body>
</html>
