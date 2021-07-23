<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>

<%

//String companyname = (String)request.getAttribute("companyname");
//request.getSession().setAttribute("loginUser", companyname);

%>
    <meta charset="UTF-8"/>
    <title>登录系统</title>
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
            <form method="POST" action="${pageContext.request.contextPath}/LoginServlet.do">
                <label for="name">公司名</label>
                <input type="text" name="companyname">

                <label for="name">ID</label>
                <input type="text" name="username" placeholder="管理员ID为000001">

                <label for="message">密码</label>
                <input type="password" name="pwd">

                <input type="submit" class="send-message-cta" value="登录">
                <%
                String msg;
                    if((String)request.getAttribute("msg")==null)
                    {
                        msg="";
                    }else {
                        msg=(String)request.getAttribute("msg");
                    }
                String noms;
                    if ((String)request.getAttribute("noms")==null)
                    {
                        noms="";
                    }else {
                        noms=(String)request.getAttribute("noms");
                    }
                    String zhucechenggong;
                    if ((String)request.getAttribute("zhucechenggong")==null)
                    {
                        zhucechenggong="";
                    }else {
                        zhucechenggong=(String)request.getAttribute("zhucechenggong");
                    }

                %>

                <a   href="register.jsp">注册 </a>  <span style="color: red"> <%=msg%> <%=noms%><%=zhucechenggong%></span>


                <p>如果忘记密码，请向您所在单位的管理员提交申请，由管理员修改密码！</p>

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