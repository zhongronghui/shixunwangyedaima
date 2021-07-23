<%--
  Created by IntelliJ IDEA.
  User: 钟同学
  Date: 2021/7/14
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="com.Client.Client"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>员工个人信息</title>
    <link href="<%=request.getContextPath()%>/css/main1.css" rel="stylesheet">
    <style>
        table td{
            /* background-color:#ffffff; */
            /* width: 1500px; */
            height:40px;
            line-height:150%;
        }
    </style>
</head>
<body>
<div class="navbar">
    <div class="container">
        <a class="logo" href="#">Me and<span> paratroopers</span></a>
    </div>
</div>

<section class="hero">
    <div class="container">
        <div class="left-col">
            <!-- <p class="subhead">您的人事管理专家</p> -->
            <h1>The information of you:</h1>

            <div class="hero-cta">
                <a href="index.html" class="primary-cta">返回首页</a>
            </div>
        </div>

        <table class="hero-img">
            <tr>
                <th>项目</th>
                <th>详细信息</th>
            </tr>
            <%
                List<Client> list = (List<Client>)request.getAttribute("list");
                if(list == null || list.size() < 1){
                    System.out.print("没有数据 ");
                }else{
                    for(Client client:list){
            %>
            <tr>
                <td>ID</td>
                <td> <%= client.getUser_id()%></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td> <%= client.getUser_name()%></td>
            </tr>
            <tr>
                <td>密码</td>
                <td> <%= client.getUser_password()%></td>
            </tr>
            <tr>
                <td>性别</td>
                <td> <%= client.getUser_sex()%></td>
            </tr>
            <tr>
                <td>生日</td>
                <td> <%= client.getUser_birthday()%></td>
            </tr>
            <tr>
                <td>电话号码</td>
                <td> <%= client.getUser_number()%></td>
            </tr>
            <tr>
                <td>入职时间</td>
                <td> <%= client.getUser_jointime()%></td>
            </tr>
            <tr>
                <td>职务</td>
                <td> <%= client.getUser_position()%></td>
            </tr>
            <tr>
                <td>薪水</td>
                <td> <%= client.getUser_salary()%></td>
            </tr>
            <tr>
                <td>缺席次数</td>
                <td> <%= client.getUser_absent()%></td>
            </tr>
            <tr>
                <td>评价</td>
                <td><textarea rows="10" readonly ><%= client.getUser_evaluate()%></textarea></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
</section>

</body>
</html>