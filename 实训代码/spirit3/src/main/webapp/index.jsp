<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>首页</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default navbar-inverse" role="navigation">
                    <div class="navbar-header">
                         <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
                   </div>
                    
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active">
                                 <a href="information.html">Employee Task</a>
                            </li>
                            <li>
                                 <a href="manager.html">manager Task</a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                &nbsp;
                                <span style="color:red"></span>
                            </li>
                            <li>
                                <a href="/LoginServlet.do">登录</a>
                            </li>
                        </ul>
                    </div>
                    
                </nav>
                <div class="jumbotron">
                    <h1>
                        你好，欢迎使用本系统！
                    </h1>
                    <p>
                        我们的系统很好，非常好！
                    </p>
                    <p>
                         <a class="btn btn-primary btn-large" href="login.jsp">登录</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>