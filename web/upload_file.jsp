<%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2018/5/7
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File upload</title>
</head>
<body>
    <form action="upload/single" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="submit">
    </form>

    <br>

    <form action="upload/multi" method="post" enctype="multipart/form-data">
        <input type="file" name="files" />
        <input type="file" name="files" />
        <input type="file" name="files" />
        <input type="submit" value="submit">
    </form>
</body>
</html>
