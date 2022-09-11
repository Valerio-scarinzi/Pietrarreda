<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiunta utente</title>
    <link rel="stylesheet" href="Register.css">
    <script src="JavaScript/libraries/alert.js"></script>
</head>
<body>

<form method="post" action="AddUtente">
    <div class="AddUtente_panel">
        <h3>AGGIUNTA UTENTE </h3>
        <input name="nome" type="text" placeholder="Inserisci Nome" required="required"><br>
        <input name="cognome" type="text" placeholder="Inserisci Cognome" required="required"><br>
        <input name="username" type="text"  placeholder="Inserisci Username" required="required"><br>
        <input name="password" type="text" placeholder="Inserisci Password" required="required"><br>
        <input name="email" type="text" placeholder="Inserisci Email " required="required"><br>
        Admin: <input name="admin" type="checkbox"><br>
        <input type="submit" value="Aggiungi" onclick="aggiunta()">
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
