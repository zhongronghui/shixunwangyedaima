<%--
  Created by IntelliJ IDEA.
  User: 钟同学
  Date: 2021/7/14
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="com.Client.Client"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>员工信息</title>
    <link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet">

    <script type="text/javascript">
        function sumbit_sure(){
            var gnl=confirm("确定要删除?");
            if (gnl==true){
                return true;
            }else{
                return false;
            }
        }
    </script>




    <!--导出excel的代码-->
    <script type="text/javascript">
        function base64 (content) {
            return window.btoa(unescape(encodeURIComponent(content)));
        }

        /* @tableId:allim
        *@fileName: 要生成excel文件的名字（不包括后缀，可随意填写）
       */
        function tableToExcel(tableID,fileName){
            var table = document.getElementById(tableID);
            var excelContent = table.innerHTML;
            var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
            excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
            excelFile += "<body><table>";
            excelFile += excelContent;
            excelFile += "</table></body>";
            excelFile += "</html>";
            var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
            var a = document.createElement("a");
            a.download = fileName+".xls";
            a.href = link;
            a.click();
        }
    </script>


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
            <div class="crumb-list">您可以在此页面查询本公司的所有员工信息！</div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="${pageContext.request.contextPath}/FindoneServlet.do?type=allfind" method="post" >
                    <table class="search-tab">
                        <tr>
                            <th width="70">请输入：</th>
                            <td><input class="common-text" placeholder="姓名/id/职位" name="user_name"  onkeyup="this.value=this.value.replace(/\s+/g,'') " type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                            <!--调用函数导出excel-->
                            <td><button  class="btn btn-primary btn2" type="button" onclick="tableToExcel('allim','data')">导出</button></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
                <div class="result-content">
                    <table class="result-tab" width="100%" id="allim">
                        <tr>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>密码</th>
                            <th>性别</th>
                            <th>生日</th>
                            <th>手机号</th>
                            <th>入职时间</th>
                            <th>职位</th>
                            <th>薪水</th>
                            <th>缺席次数</th>
                            <th>操作</th>
                            <th>操作</th>
                        </tr>
                        <%
                            //获取用户信息集合
                            List<Client> list = (List<Client>)request.getAttribute("list");
                            if(list == null || list.size() < 1){
                                System.out.print("没有数据 ");
                            }else{
                                for(Client client:list){
                        %>
                        <tr align="center">
                            <td> <%= client.getUser_id() %></td>
                            <td> <%= client.getUser_name() %></td>
                            <td> <%= client.getUser_password() %></td>
                            <td> <%= client.getUser_sex() %></td>
                            <td> <%= client.getUser_birthday()%></td>
                            <td> <%= client.getUser_number()%></td>
                            <td> <%= client.getUser_jointime()%></td>
                            <td> <%= client.getUser_position() %></td>
                            <td> <%= client.getUser_salary()%></td>
                            <td> <%= client.getUser_absent()%></td>
                            <td>
                                <form action="${pageContext.request.contextPath}/FindDetailsServlet.do?type=Detailsfind" method="post" οnsubmit="return check(this);" id="a">
                                    <input type="hidden" name="user_id" value="<%=client.getUser_id()%>">
                                    <input type="submit" value="详细信息">
                                </form>
                            </td>

                           <td>
                                <form action="DeleteServlet.do" method="post"  onsubmit="return sumbit_sure()"  >
                                      <input type="hidden" name="user_id" value="<%=client.getUser_id()%>">
                                      <input type="hidden" name="user_name" value="<%=client.getUser_name()%>">
                                    <input type="hidden" name="user_sex" value="<%=client.getUser_sex()%>">
                                    <input type="hidden" name="user_position" value="<%=client.getUser_position()%>">
                                    <input type="hidden" name="user_evaluate" value="<%=client.getUser_evaluate()%>">
                                    <input type="submit" value="删除"   >
                                </form>
                           </td>




                        </tr>




            <%
                    }
                }
            %>
                    </table>
                </div>

        </div>
    </div>
    <!--/main-->
</div>



</body>
</html>
