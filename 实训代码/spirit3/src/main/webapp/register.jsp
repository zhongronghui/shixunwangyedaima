<%--
  Created by IntelliJ IDEA.
  User: 钟同学
  Date: 2021/7/21
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>

    <%

        //String companyname = (String)request.getAttribute("companyname");
//request.getSession().setAttribute("loginUser", companyname);

    %>
    <meta charset="UTF-8"/>
    <title>注册账号</title>
    <link href="<%=request.getContextPath()%>/css/main1.css" rel="stylesheet">
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
            <form method="POST" action="${pageContext.request.contextPath}/RegisterServlet.do">
                <label for="name">公司名</label>
                <input type="text" name="companyname">

                <label for="name">ID</label>
                <input type="text" name="username" >

                <label for="message">密码</label>
                <input type="password" name="pwd">

                <input type="submit" class="send-message-cta" value="注册">
                <%
                    String yijingcunzai;
                    if((String)request.getAttribute("yijingcunzai")==null)
                    {
                        yijingcunzai="";
                    }else {
                        yijingcunzai=(String)request.getAttribute("yijingcunzai");
                    }
                %>
                <a   href="login.jsp">登录 </a> <span style="color: red"><%=yijingcunzai%></span>
              <p>注册公司请输入公司名，并且账号为000001</p>
            </form>

        </div>

        <img src="images/illustration.svg" class="hero-img" alt="Illustration">
    </div>
</section>

<script>
    function validateForm(){
        var x=document.forms["myForm"]["company"].value;
        var y=document.forms["myForm"]["ID"].value;
        var z=document.forms["myForm"]["password"].value;
        if (x==null || x==""){
            alert("公司名必须填写");
            return false;
        }
        if (y==null || y==""){
            alert("ID必须填写");
            return false;
        }
        if (z==null || z==""){
            alert("密码必须填写");
            return false;
        }
    }
</script>
</body>
</html>
