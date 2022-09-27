<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ordine" %>
<%@ page import="model.Utente" %>
<%@ page import="model.Carrello" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conferma Ordine</title>
    <script src="https://kit.fontawesome.com/f52bb1298e.js" crossorigin="anonymous"></script>
    <script src="JavaScript/alert.js"></script>
</head>
<style>
    *{
        padding: 0;
        box-sizing: border-box;
        margin: 0;
    }

    .titolo{
        text-align: center;
    }

    #ConteinerOrdini{
        padding: 30px;
        margin: auto;
        margin-bottom: 40px;
        background-color: #e49314;
        border-radius: 15px;
        max-width: max-content;
        width: 800px;
        box-shadow: 0px 0px 15px 1px #292929;
    }
    fieldset{
        padding: 15px;
        border-color: #292929;
        margin: 20px;
    }
    input{
        padding: 5px;
        margin: 5px;
        border-radius: 7px;
        text-align: center;
    }
    button{
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
        color: #e49314;
    }

    .confirm{
        max-width: max-content;
        background-color: #292929;
        border-radius: 10px;
        margin: auto;
        margin-bottom: 40px;
        padding: 25px;
        text-align: center;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }
    i{
        margin: 5px;
    }

</style>
<body>
<%@include file="header.jsp"%>
<%Carrello carrello= (Carrello) session.getAttribute("carrello");%>
<%Ordine ord =new Ordine(carrello.getPrezzoTotCar(),carrello.getProdotti());%>
<% Utente utente = (Utente) session.getAttribute("utenteLoggato");%>


<div id = "ConteinerOrdini">
    <h1 class="titolo"><%=utente.getUsername()%>  ecco il tuo ordine:</h1>
    <% for(Carrello.ProdottoQuantita prod:ord.getProdotti()) {%>
    <fieldset>
    <div class="ContainerProdOrdine">
        <p>Nome: <%=prod.getProdotto().getNome()%></p>
        <p>Prezzo: <%=prod.getProdotto().getPrezzo()%></p>
        <p>Quantità: <%=prod.getQuantita()%></p>
    </div></fieldset>
    <% }%>
    <p style="float: right">Totale ordine:<%=ord.getPrezzoTotale()%></p>
</div>


<div class="confirm">
<form id="conf" action="Ordine" method="post">
<h2 class="titolo" style="color: #e49314"> Indirizzo di spedizione </h2><hr>
    <input type="text" name="IndirizzoSpedizione" required="required">
    <input type="hidden" name="conferma" value="ok">
    <button class="submit" type="submit">Conferma<i class="fa-solid fa-check"></i></button>
</form></div>
<%@include file="footer.jsp"%>
</body>
</html>
