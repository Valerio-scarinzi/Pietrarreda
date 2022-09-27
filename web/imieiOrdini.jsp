<%@ page import="model.Ordine" %>
<%@ page import="model.Carrello" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ordini</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    .titolo{
        text-align: center;
    }
    .storicoContainer{
        margin-top: 15px;
        max-width:max-content;
        padding: 30px;
        background-color: #e49314;
        border-radius: 15px;
        margin: auto;
        box-shadow: 0px 0px 15px 1px #292929;
    }
    #ConteinerOrdini{
        padding: 15px;
        border-radius: 5px;
        border:2px solid #292929;
    }

    fieldset{
        padding: 5px;
        border-color: #292929;
        margin: 10px;
    }
    .totale{
    }
</style>
<body>
<%@include file="header.jsp"%>
<%ArrayList<Ordine> list_ord = (ArrayList<Ordine>) session.getAttribute("listaOrdiniUsr");%>
<div class="storicoContainer">
    <h2 class="titolo">Ordini Effettuati </h2>
<% for (Ordine ord:list_ord) {%>
<div id = "ConteinerOrdini">
    <p>Dettagli Ordine</p>
    <p><%=ord.getNomeOrdine()%></p>
    <p>Emesso il: <%=ord.getDataEmissione()%></p>
    <p>Prodotti: </p>
    <% for(Carrello.ProdottoQuantita prod: ord.getProdotti()) {%>
    <fieldset>
    <div class="ContainerProdOrdine">
        <p>Nome: <%=prod.getProdotto().getNome()%></p>
        <p>Prezzo: <%=prod.getProdotto().getPrezzo()%></p>
        <p>Quantità: <%=prod.getQuantita()%></p>
    </div>
    </fieldset>
    <% }%><p class="totale">Totale ordine:<%=ord.getPrezzoTotale()%> euro</p>

</div>
<br>
<% } %>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
