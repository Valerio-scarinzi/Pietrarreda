<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ordine" %>
<%@ page import="model.Utente" %>
<%@ page import="model.Carrello" %><%--
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
<%@include file="header.jsp"%>
<%Carrello carrello= (Carrello) session.getAttribute("carrello");%>
<%Ordine ord =new Ordine(carrello.getPrezzoTotCar(),carrello.getProdotti());%>
<% Utente utente = (Utente) session.getAttribute("utenteLoggato");%>
<h3>Il tuo Ordine <%utente.getUsername();%></h3>


<div id = "ConteinerOrdini">
    <p>Dettagli Ordine</p>


    <% for(Carrello.ProdottoQuantita prod:ord.getProdotti()) {%>
    <div class="ContainerProdOrdine">
        <p>Prodotti</p>
        <p>nome: <%=prod.getProdotto().getNome()%></p>
        <p>prezzo: <%=prod.getProdotto().getPrezzo()%></p>
        <p>quantità: <%=prod.getQuantita()%></p>
    </div>
    <% }%>
    <p>Totale ordine:<%=ord.getPrezzoTotale()%></p>
</div>



<form action="Ordine" method="post">
<h3>aggiungi indirizzo di spedizione </h3>

    <input type="text" name="IndirizzoSpedizione">




<h3>Conferma ordine </h3>

    <input type="hidden" name="conferma" value="ok">
    <input type="submit" name="conferma">
</form>
<a href="index.jsp"> torna alla home </a>
<%@include file="footer.jsp"%>
</body>
</html>
