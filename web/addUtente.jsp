<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiunta utente</title>
    <link rel="stylesheet" href="Register.css">
</head>
<body>

<form method="post" action="AddUtente">
    <div class="AddUtente_panel">
        <h3>AGGIUNTA UTENTE </h3>
        <input name="nome" type="text" placeholder="Inserisci Nome"><br>
        <input name="cognome" type="text" placeholder="Inserisci Cognome"><br>
        <input name="username" type="text"  placeholder="Inserisci Username"><br>
        <input name="password" type="text" placeholder="Inserisci Password"><br>
        <input name="email" type="text" placeholder="Inserisci Email "><br>
        Admin: <input name="admin" type="checkbox"><br>
        <input type="submit" value="Aggiungi">
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
