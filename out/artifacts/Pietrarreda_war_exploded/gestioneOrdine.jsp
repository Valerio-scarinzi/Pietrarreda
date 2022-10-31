<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Ordine" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Carrello" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestione ordine utente</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    .title{
        padding: 10px;
        text-align: center;
        color: #e49314;
    }

    .showOrdini{
        margin: 10px;
        padding: 25px;
        background-color: #292929;
        border-radius: 15px;
        color: #e49314;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }
fieldset{
    padding: 5px;
    border-color: #e49314;
    margin: 10px;
    }

    button{
        padding: 5px;
        margin: 5px;
        border-radius: 7px;
        text-align: center;
    }
    .btn{
        border-color: #e49314;
        color: #FFFFFF;
        background-color: #292929;
    }
    .btn:hover{
        color: #e79213;
    }
    .submit{
        border-color: #e49314;
        color: #FFFFFF;
        background-color: #292929;
    }
    .submit:hover{
        color: #e49314;
    }
    i{
        margin: 5px;
    }
    @media (max-width: 400px){
        body{
            background-color: #1A1A1A;
        }

    }
</style>
<body>
<%@include file="header.jsp"%>
<%ArrayList<Ordine> list_ord = (ArrayList<Ordine>) session.getAttribute("listaOrdiniUsrAdmin");%>
<div class="showOrdini">
<h2 class="title">Ordini effettuati </h2>
<% for (Ordine ord:list_ord) {%>
    <fieldset>
<div id = "ConteinerOrdini">
    <form id="updt" method="post" action="AdminGestioneOrdine?id=<%=ord.getIdOrdine()%>">
    <p>Dettagli Ordine</p>
    <p><%=ord.getNomeOrdine()%></p>
    <p>Emesso il:<%=ord.getDataEmissione()%></p>
    <p>Spedito Verso: <%=ord.getIndirizzo()%></p>
    <p>Stato Attuale: <%=ord.getStatusOrdine()%></p>
        <div class="ContainerProdOrdine">
            <input type="text" name="modificaIndirizzo" value="<%=ord.getIndirizzo()%>" placeholder="Modifica Indirizzo">
            <select name="option0" >
                <option name="option1"  >ordine in lavorazione</option>
                <option name="option2" >ordine confermato</option>
                <option name="option2" >ordine effettuato</option>
            </select>
              <button class="btn"><a href="DeleteOrdine?idDelete=<%=ord.getIdOrdine()%>" onclick="elimina()" style="text-decoration: none;color: #c80009">Elimina <i class="fa-solid fa-trash-can"></i></a></button>
            <button class="submit" type="submit" onclick="modifica()">Modifica<i class="fa-solid fa-wrench"></i></button><br><br>
        </div>
    </form>
    <h5>Prodotti</h5><hr>
    <% for(Carrello.ProdottoQuantita prod: ord.getProdotti()) {%>
        <p>nome: <%=prod.getProdotto().getNome()%></p>
        <p>prezzo: <%=prod.getProdotto().getPrezzo()%></p>
        <p>quantità: <%=prod.getQuantita()%></p><br><br>
    <% }%>
    <p>Totale ordine: <%=ord.getPrezzoTotale()%></p>
</div> </fieldset><%}%>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
