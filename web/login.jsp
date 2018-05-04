<%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2018/2/20
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="css/user/user_normal.css">
<link rel="stylesheet" href="css/button.css">
<%
    String username = "";
    String password = "";
    String flag = "false";
    Cookie [] cookies = request.getCookies();
    if (cookies != null){
        for (Cookie in : cookies){
            if (in.getName().equals("trainUsername")){
                username = in.getValue();
            }
            if (in.getName().equals("trainPass")){
                password = in.getValue();
            }
            if (in.getName().equals("trainFlag")){
                flag = in.getValue();
            }
        }
    }
%>
<body>
<div class="container">
    <form class="form-signin">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-md-5"><h2>登录</h2></div>
                    <div class="col-md-5"></div>
                    <div class="col-md-2"><br>
                        <button type="button" class="button button-primary button-circle" onclick="go_to_register()">注册</button>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <label for="username">用户名</label>
                <input type="text" id="username" class="form-control" placeholder="Username" name="username" value="<%=username%>" required autofocus>
                <br>
                <label for="password">密码</label>
                <input type="password" id="password" class="form-control" placeholder="Password" name="password" value="<%=password%>" required>
                <br>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me" id="remb"> 记住密码
                    </label>
                </div>
                <br>
            </div>
            <button type="button" onclick="loginAction()" class="btn btn-lg btn-primary btn-block" id="loginBtn">登录</button>
        </div>
    </form>

</div>
<script src="js/jquery/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/common/ajaxfunc.js"></script>
<script src="js/user/login.js"></script>
<script>
    var flag = <%=flag%>
    if(flag == true){
        $("#remb").attr('checked','checked')
    }
</script>
</body>
</html>
