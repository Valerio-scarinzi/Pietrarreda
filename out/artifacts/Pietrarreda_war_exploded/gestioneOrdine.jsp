<%@ page import="model.Ordine" %>
<%@ page import="java.util.ArrayList" %>
<<<<<<< HEAD
<%@ page import="model.Carrello" %><%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 26/09/2022
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
=======
<%@ page import="model.Carrello" %>
>>>>>>> 4376b8ccef8f19982c01d73dd227b46aa06b7798
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestione ordine utente</title>
</head>
<body>
<%@include file="header.jsp"%>
<%ArrayList<Ordine> list_ord = (ArrayList<Ordine>) session.getAttribute("listaOrdiniUsrAdmin");%>
<% for (Ordine ord:list_ord) {%>
<div id = "ConteinerOrdini">
    <form id="updt" method="post" action="AdminGestioneOrdine?id=<%=ord.getIdOrdine()%>">
    <p>Dettagli Ordine</p>
    <p><%=ord.getNomeOrdine()%></p>
    <p>emesso il:<%=ord.getDataEmissione()%></p>
    <p>Spedito Verso: <%=ord.getIndirizzo()%></p>
    <p>Stato Attuale: <%=ord.getStatusOrdine()%></p>
     <p></p>
        <div class="ContainerProdOrdine">

            <input type="text" name="modificaIndirizzo" value="<%=ord.getIndirizzo()%>" placeholder="Modifica Indirizzo">

            <select name="option0" >
                <option name="option1"  >ordine in lavorazione</option>
                <option name="option2" >ordine confermato</option>
                <option name="option2" >ordine effettuato</option>

            </select>
            <button class="btn">
                <a href="DeleteOrdine?idDelete=<%=ord.getIdOrdine()%>" onclick="elimina()">Elimina <i class="fa-solid fa-trash-can"></i></a>
            </button>

            <input class="submit" type="submit" value="modifica" onclick="modifica()"><br><br>
        </div>
    </form>

    <% for(Carrello.ProdottoQuantita prod: ord.getProdotti()) {%>

        <h5>Prodotti</h5>
        <p>nome: <%=prod.getProdotto().getNome()%></p>
        <p>prezzo: <%=prod.getProdotto().getPrezzo()%></p>
        <p>quantità: <%=prod.getQuantita()%></p>
    </div>
    <% }%>
    <p>Totale ordine:<%=ord.getPrezzoTotale()%></p>
</div>
<br><br><br>
    </div></fieldset>
<% } %>
<%@include file="footer.jsp"%>
</body>
</html>
