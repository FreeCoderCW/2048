<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.*" %>
<%@ page import="util.DBCPTest" %>
<html>
<head>
<title>网页版2048</title>
</head>
<body>
<script>
    <%
    request.setCharacterEncoding("utf-8");
       DBCPTest.update(request.getParameter("newName"),Integer.parseInt(request.getParameter("newScore")));
    %>
    alert("成绩已保存成功!");
    window.location.href = "index.jsp";
</script>
</body>
</html>