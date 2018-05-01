<%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2018/4/29
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单提交</title>
</head>
<body>
    <form action="form" method="post">
        <label>姓名</label><input name="name" type="text">
        <label>签名</label><input name="signature" type="text">
        <input type="submit" value="提交">
    </form>
</body>
</html>
