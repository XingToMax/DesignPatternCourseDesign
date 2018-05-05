<%--
  Created by IntelliJ IDEA.
  User: VULCAN
  Date: 2018/2/23
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销</title>
    <%
        session.invalidate();
        out.print("<script>window.location.href = 'index.jsp'</script>");
    %>
</head>
<body>

</body>
</html>
