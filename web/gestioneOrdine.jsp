<%@ page import="model.Ordine" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Carrello" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestione ordine utente</title>
</head>
<body>
<%@include file="header.jsp"%>
<%ArrayList<Ordine> list_ord = (ArrayList<Ordine>) session.getAttribute("listaOrdiniUsrAdmin");%>
<% for (Ordine ord:list_ord) {%><fieldset>
<div id = "ConteinerOrdini">
    <form id="updt" method="post" action="GestioneUtenteServlet?id=${utente.id}">
    <p>Dettagli Ordine</p>
    <p><%=ord.getNomeOrdine()%></p>
    <p>emesso il:<%=ord.getDataEmissione()%></p>
    <% for(Carrello.ProdottoQuantita prod: ord.getProdotti()) {%>
    <div class="ContainerProdOrdine">
        <input type="text" name="modificaIndirizzo" placeholder="Modifica Indirizzo">
        <select>
            <option name="option1" >confermato</option>
            <option name="option3" >In consegna</option>
        </select>
        <button class="btn">
            <a href="DeleteOrdine?id=${utente.id}" onclick="elimina()">Elimina <i class="fa-solid fa-trash-can"></i></a>
        </button>
            <input class="submit" type="submit" value="modifica" onclick="modifica()"><br><br>
      </div>
    </form>
        <p>Prodotti</p>
        <p>nome: <%=prod.getProdotto().getNome()%></p>
        <p>prezzo: <%=prod.getProdotto().getPrezzo()%></p>
        <p>quantità: <%=prod.getQuantita()%></p>
    </div>
    <% }%>
    <p>Totale ordine:<%=ord.getPrezzoTotale()%></p>
    </div></fieldset>
<% } %>
<%@include file="footer.jsp"%>
</body>
</html>
