<%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 19/09/2022
  Time: 03:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conferma Ordine</title>
</head>
<body>
<form action="Ordine" method="post">
<h3>aggiungi indirizzo di spedizione </h3>

    <input type="text" name="IndirizzoSpedizione">




<h3>Conferma ordine </h3>
    <input type="hidden" name="conferma" value="ok">
    <input type="submit" name="invio">
</form>
<a href="index.jsp"> torna alla home </a>

</body>
</html>
