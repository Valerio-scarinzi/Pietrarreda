<%@ page import="model.Utente" %>
<%@ page import="com.mysql.cj.Session" %><%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 12/07/2022
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<% Utente utente = (Utente) session.getAttribute("utenteLoggato");%>
<div>
Ciao <%=utente.getCognome()%> <%=utente.getNome()%> !
Siamo lieti di darti il benvenuto sul nostro sito e-commerce Pietrarreda.</div>
<a href="index.jsp">Clicca qui per tornare alla homepage</a>
</body>
</html>
