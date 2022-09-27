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
<style>
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    .container{
        background-color: #e49314;
        border-radius: 15px;
        margin: auto;
        margin-bottom: 20px;
        padding: 20px;
        text-align: center;
        max-width: max-content;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }
</style>
<body>
<%@include file="header.jsp"%>
<% Utente utente = (Utente) session.getAttribute("utenteLoggato");%>
<div class="container">
Ciao <%=utente.getCognome()%> <%=utente.getNome()%> !
Siamo lieti di darti il benvenuto sul nostro sito e-commerce Pietrarreda.<br>
<a href="index.jsp">Clicca qui per tornare alla homepage</a></div>
<%@include file="footer.jsp"%>
</body>
</html>
