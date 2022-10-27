<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiunta prodotto</title>
   <script src="alert.js"></script>
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

    .AddProd_panel{
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

    .AddProd_panel input{
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
    textarea{
        border-radius: 7px;
        padding: 5px;
        margin: 5px;
        text-align: center;
        resize: none;
    }
</style>
<body>
<%@include file="header.jsp"%>
<form id="add" method="post" action="AddProdotto">
    <div class="AddProd_panel">
        <h3>AGGIUNTA PRODOTTO </h3>
        <input name="nome" type="text" placeholder="Inserisci nome" required="required"><br>
        <textarea rows="5" cols="20" name="descrizione" id="cambiaDesc" placeholder="Inserisci descrizione" required="required"></textarea> <br>
        <input name="prezzo" type="number" min="0" step="0.05" placeholder="Inserisci prezzo" required="required"><br>
        <input name="immagine" type="text" placeholder="inserisci immagine" required="required"><br>
        <input name="disponibilita" type="number" min="0" placeholder="Inserisci disponibilita'" required="required"><br>
        <input class="submit" type="submit" value="Aggiungi" onclick="aggiunta()">
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
