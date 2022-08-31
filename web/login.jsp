<%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 19/07/2022
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="login.css">
<head>

    <title>login panel</title>
</head>
<body>
<div class="Log_panel">
    <h3>LOGIN PANEL </h3>
<form method="post" action="Login" >
    E-mail: <input name="email" type="text" placeholder="inserisci e-mail"><br>
    Password:  <input name="password" type="password" placeholder="inserisci password"><br>
    Username:  <input name="username" type="text" placeholder="inserisci username"><br>
    <input type="submit" value="Accedi">
</form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
