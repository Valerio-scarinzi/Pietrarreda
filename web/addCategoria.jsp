<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiunta categoria</title>
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

    .AddCat_panel{
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

    .AddCat_panel input{
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
<% Utente utente = (Utente) session.getAttribute("utenteLoggato");%>
<%if(utente.isAdmin()==true){%>
<form id="add" method="post" action="AddCategoria">
    <div class="AddCat_panel">
        <h3>AGGIUNTA CATEGORIA </h3>
        <input name="nome" type="text" placeholder="Inserisci Nome" required="required"><br>
        <input name="descrizione" type="text" placeholder="Inserisci Descrizione" required="required"><br>
        <input name="immagine" type="text" placeholder="immetti immagine" required="required"><br>
        <input class="submit" type="submit" value="Aggiungi" onclick="aggiunta()">
    </div>
</form><%}%>
<%if(utente.isAdmin()==false){%>
<div>
    Non dovresti essere qui <br>
    <a href="index.jsp">premi qui</a> per tornare alla homepage
</div><%}%>
<%@include file="footer.jsp"%>
</body>
</html>
