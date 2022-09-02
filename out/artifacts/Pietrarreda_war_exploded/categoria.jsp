<%@ page import="model.Categoria" %><%--
  Created by IntelliJ IDEA.
  User: elomi
  Date: 25/08/2022
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>categoria</title>
</head>
<body>
<%Categoria categoria1 ,categoria2 ,categoria3; categoria1 = (Categoria) request.getAttribute("Categoria1");categoria2 = (Categoria) request.getAttribute("Categoria2");categoria3 = (Categoria) request.getAttribute("Categoria3");%>
<%=categoria1.toString()%><br>
<%=categoria2.toString()%><br>
<%=categoria3.toString()%><br>
</body>
</html>
