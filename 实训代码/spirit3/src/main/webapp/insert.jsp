<%--
  Created by IntelliJ IDEA.
  User: 钟同学
  Date: 2021/7/14
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>增加员工</title>
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
                        <li><a href="ChangeRecordServlet.do"><i class="icon-font">&#xe006;</i>考勤记录</a></li>
                        <li><a href="findnewclient.jsp"><i class="icon-font">&#xe006;</i>查看应聘人历史</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list">请在以下页面输入您想添加的员工信息</div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="AddServlet.do" method="post" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>员工ID</th>
                            <td>
                                <input class="common-text required"  name="user_id" size="50"  type="text"onkeyup="this.value=this.value.replace(/\s+/g,'')">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>姓名</th>
                            <td>
                                <input class="common-text required" name="user_name" size="50"  type="text"onkeyup="this.value=this.value.replace(/\s+/g,'')">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>密码</th>
                            <td>
                                <input class="common-text required"  name="user_password" size="50"  type="text"onkeyup="this.value=this.value.replace(/\s+/g,'')">
                            </td>
                        </tr>
                        <tr>
                            <th width="120"><i class="require-red">*</i>性别</th>
                            <td>
                                <select name="user_sex" id="catid" class="required">
                                    <option value="">请选择</option>
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>生日</th>
                            <td><input type="date" name="user_birthday"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>手机号</th>
                            <td><input type="text" name="user_number" onkeyup="this.value=this.value.replace(/\s+/g,'')"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>入职时间</th>
                            <td><input type="date" name="user_jointime"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>职位</th>
                            <td><input type="text" name="user_position" onkeyup="this.value=this.value.replace(/\s+/g,'')"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>薪水</th>
                            <td><input type="text" name="user_salary" onkeyup="this.value=this.value.replace(/\s+/g,'')"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>缺席</th>
                            <td><input type="text" name="user_absent" onkeyup="this.value=this.value.replace(/\s+/g,'')"></td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="添加" type="submit">
                            </td>
                        </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>