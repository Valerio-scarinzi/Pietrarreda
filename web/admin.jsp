<%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 25/08/2022
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin console</title>
<h1>Benvenuti nell'admin console </h1>

</head>
<body>

<form method="post" action="ProdottoServlet">
    <p>gestione prodotto </p>  <input type="submit" name="invio"> <br>

</form>


<form method="post" action="adminCatServ">
    <p>gestione categoria </p>  <input type="submit" name="invio"> <br>

</form>


<form method="post" action="adminUtenteServ">
    <p>gestione utente </p>  <input type="submit" name="invio"> <br>

</form>



</body>
</html>
