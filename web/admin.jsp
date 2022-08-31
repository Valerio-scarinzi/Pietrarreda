<%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 25/08/2022
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="admin.css">
<head>
    <title>admin console</title>

</head>
<body>

<div class="admin_panel">
    <h3>ADMIN CONSOLE</h3>
<form method="post" action="ProdottoServlet">
    <p>Gestione prodotto </p>  <input type="submit" value="gestisci"> <br>
</form>

<form method="post" action="adminCatServ">
    <p>Gestione categoria </p>  <input type="submit" value="gestisci"> <br>
</form>

<form method="post" action="adminUtenteServ">
    <p>Gestione utente </p>  <input type="submit" value="gestisci"> <br>
</form>

</div>
<%@include file="footer.jsp"%>
</body>
</html>
