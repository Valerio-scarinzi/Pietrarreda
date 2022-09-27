<%@ page import="model.Ordine" %>
<%@ page import="model.Carrello" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 23/09/2022
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ordini</title>
</head>
<body>
<%@include file="header.jsp"%>
<%ArrayList<Ordine> list_ord = (ArrayList<Ordine>) session.getAttribute("listaOrdiniUsr");%>
<% for (Ordine ord:list_ord) {%>
<div id = "ConteinerOrdini">
    <p>Dettagli Ordine</p>
    <p><%=ord.getNomeOrdine()%></p>
    <p>emesso il:<%=ord.getDataEmissione()%></p>
    <% for(Carrello.ProdottoQuantita prod: ord.getProdotti()) {%>
    <div class="ContainerProdOrdine">
        <p>Prodotti</p>
        <p>nome: <%=prod.getProdotto().getNome()%></p>
        <p>prezzo: <%=prod.getProdotto().getPrezzo()%></p>
        <p>quantità: <%=prod.getQuantita()%></p>
    </div>
    <% }%>
    <p>Totale ordine:<%=ord.getPrezzoTotale()%></p>
</div>
<br><br><br>
<% } %>
<%@include file="footer.jsp"%>
</body>
</html>
