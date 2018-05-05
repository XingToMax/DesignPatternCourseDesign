<%@ page import="cn.nuaa.tomax.entity.UserEntity" %><%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2018/4/20
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>留言板</title>
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<style>
  body{
    background-color: #f9f9f9;
  }
  .top{
    height: 60px;
    background-color: #ffffff;
    margin-bottom: 40px;
  }
  .top > div{
    display: flex;
    align-items: center;
    height: 60px;
  }
  .top-text{
    color: #65508f;
    font-size: 18px;
  }
  .scroll{
    width: 50%;
    height: 400px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 4px;
    overflow-y: scroll;
  }
  .btn{
    color: #65508f;
    border: none;
  }
  .list-group{
    width: 100%;
    margin: 0 auto;
    padding-bottom: 20px;
  }
  .input-group{
    width: 50%;
    margin: 0 auto;
  }
</style>
</head>
<%
  UserEntity user = (UserEntity) session.getAttribute("user");
  String username = "未登录";
  Integer userId = -1;
  if (user != null){
      username = user.getName();
      userId = user.getId();
  }
%>
<body>
<div>
  <div class="top row">
    <div class="col-md-1"></div>
    <div class="col-md-9 top-text">留言板</div>
    <div class="col-md-2 row">
      <div class="col-md-6 top-text" id="username">Username</div>
      <div class="col-md-6">
        <button type="button" class="btn btn-default" id="log">Logout</button>
      </div>
    </div>
  </div>
  <div class="scroll">
    <ul class="list-group" id="msg_list"></ul>
  </div>
  <div class="input-group">
    <input type="text" class="form-control" placeholder="Content" id="msg_con">
    <span class="input-group-addon" id="msg_btn" style="cursor: pointer">提交</span>
  </div>
</div>
<script src="js/jquery/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/common/ajaxfunc.js"></script>
<script>
  var username = '<%=username%>'
  var userId = <%=userId%>
  $("#username").text(username)
  $("#log").text(userId==-1?'Login':'Logout')
</script>
<script src="js/message/message.js"></script>
</body>
</html>
