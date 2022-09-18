<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiunta utente</title>
    <script src="JavaScript/alert.js"></script>
</head>
<style>
    *{
        padding: 0;
        box-sizing: border-box;
        margin: 0;
    }

    body{

        justify-content: center;
        align-items: center;
    }

    .AddUtente_panel{
        margin: auto;
        text-align: center;
        position: relative;
        color: #e49314;
        background-color: #292929;
        padding: 25px;
        border-radius: 15px;
        max-width: min-content;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }

    .AddUtente_panel input{
        padding: 5px;
        margin: 5px;
        border-radius: 7px;
        text-align: center;
    }

    .submit{
        border-color: #e49314;
        color: #FFFFFF;
        background-color: #292929;
    }
    .submit:hover{
        color: #e79213;
    }
</style>
<body>
<%@include file="header.jsp"%>
<form method="post" action="AddUtente">
    <div class="AddUtente_panel">
        <h3>AGGIUNTA UTENTE </h3>
        <input name="nome" type="text" placeholder="Inserisci Nome" required="required"><br>
        <input name="cognome" type="text" placeholder="Inserisci Cognome" required="required"><br>
        <input name="username" type="text"  placeholder="Inserisci Username" required="required"><br>
        <input name="password" type="text" placeholder="Inserisci Password" required="required"><br>
        <input name="email" type="text" placeholder="Inserisci Email " required="required"><br>
        Admin: <input name="admin" type="checkbox"><br>
        <input class="submit" type="submit" value="Aggiungi" onclick="aggiunta()">
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
