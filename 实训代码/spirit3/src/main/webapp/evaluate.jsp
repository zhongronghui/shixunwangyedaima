<%--
  Created by IntelliJ IDEA.
  User: 钟同学
  Date: 2021/7/19
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="com.Client.Client"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>修改员工信息</title>
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

        <div class="crumb-wrap">
            <div class="crumb-list">您可以在本页面修改员工信息，请注意，您不可以修改员工ID！</div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/UpdateServlet.do?type=evaluate" method="post"  >
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <%
                            List<Client> list = (List<Client>)request.getAttribute("list");
                            if(list == null || list.size() < 1){
                                System.out.print("没有数据 ");
                            }else{
                                for(Client client:list){
                        %>
                        <tr>
                            <th><i class="require-red">*</i>员工ID</th>
                            <td>
                                <input class="common-text required"  name="user_id" size="50"  type="text" readonly  value="<%= client.getUser_id()%>">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>姓名</th>
                            <td>
                                <input class="common-text required"  name="user_name" size="50" readonly value="<%= client.getUser_name()%>" type="text"onkeyup="this.value=this.value.replace(/\s+/g,'')">
                            </td>
                        </tr>
                        <tr>
                            <th width="120"><i class="require-red">*</i>性别</th>
                            <td>
                                <select name="user_sex" id="catid"  readonly class="required">
                                    <option value="<%= client.getUser_sex()%>" >  <%= client.getUser_sex()%> </option>
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>手机号</th>
                            <td><input type="text" name="user_number" readonly value="<%= client.getUser_number()%>"  onkeyup="this.value=this.value.replace(/\s+/g,'')"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>入职时间</th>
                            <td><input type="date" name="user_jointime" readonly value="<%= client.getUser_jointime()%>" ></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>职位</th>
                            <td><input type="text" name="user_position" readonly value="<%= client.getUser_position()%>"onkeyup="this.value=this.value.replace(/\s+/g,'')" ></td>
                        </tr>

                        <tr>
                            <th><i class="require-red">*</i>缺席</th>
                            <td><input type="text" name="user_absent" value="<%= client.getUser_absent()%>" onkeyup="this.value=this.value.replace(/\s+/g,'')"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>评价</th>
                            <td><textarea rows="10" name="user_evaluate"  > <%= client.getUser_evaluate()%> </textarea></td>
                        </tr>

                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="保存" type="submit">
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>

