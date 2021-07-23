<%--
  Created by IntelliJ IDEA.
  User: 钟同学
  Date: 2021/7/13
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="com.Client.Client"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加个人信息</title>
    <link rel="stylesheet" href="./css/details.css">
</head>
<body>
    <div class="pentitle">
        <h1>员工详情页面</h1>
    </div>
    
    <div class="container">
        <form action="UpdateServlet.do" method="post">
            <table align="center" width="100%" cellpadding="6" style="font-size: 25px;">
        
                <tr>
                    <th colspan="2" align="center" >详细信息</th><%--th加粗， cellpadding和android padding含义一样--%>
                </tr>
                    <%
                        List<Client> list = (List<Client>)request.getAttribute("list");
                if(list == null || list.size() < 1){
                System.out.print("没有数据 ");
                }else{
                for(Client client:list){
                %>
                <tr align="center">
        
                <tr>
                    <td align="center" >工号</td>
                    <td align="left" ><%= client.getUser_id()%></td>
                </tr>
                <tr>
                    <td align="center" >姓名</td>
                    <td align="left" ><input type="text" name="user_name" value=" <%= client.getUser_name() %>"></td>
                </tr>
                <tr>
                    <td align="center" >密码</td>
                    <td align="left" ><input type="text" name="user_password" value="<%= client.getUser_password() %>"></td>
                </tr>
                <tr>
                    <td align="center" >性别</td>
                    <td align="left" >
                        <select name="user_sex" style="width: 200px;height: 40px;">
                            <option value=" <%= client.getUser_sex() %>"> <%= client.getUser_sex() %> </option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="center" >生日</td>
                    <td align="left" ><input type="date" name="user_birthday" value="<%= client.getUser_birthday() %>"></td>
                </tr>
                <tr>
                    <td align="center" >手机号</td>
                    <td align="left" ><input type="text" name="user_number"value="<%= client.getUser_number() %>"></td>
                </tr>
                <tr>
                    <td align="center" >入职时间</td>
                    <td align="left" ><input type="date" name="user_jointime" value="<%= client.getUser_jointime() %>"></td>
                </tr>
                <tr>
                    <td align="center" >职位</td>
                    <td align="left" ><input type="text" name="user_position" value="<%= client.getUser_position() %>"></td>
                </tr>
                <tr>
                    <td align="center" >薪水</td>
                    <td align="left" ><input type="text" name="user_salary" value="<%= client.getUser_salary() %>"></td>
                </tr>
                <tr>
                    <td align="center" >缺席</td>
                    <td align="left" ><input type="text" name="user_absent" value="<%= client.getUser_absent() %>"></td>
                </tr>
        
                <td>
                        <form action="UpdateServlet.do" method="post" οnsubmit="return check(this);">
                            <input type="hidden" name="user_id" value="<%=client.getUser_id()%>">
                            <input type="submit" value="保存">
                        </form>
                </td>
                </tr>
        
                    <%
                    }
                }
            %>
            </table>
        </form>
    </div>
</body>
</html>
