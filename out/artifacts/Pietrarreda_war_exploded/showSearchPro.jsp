<%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 20/09/2022
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prodotti cercati </title>
</head>
<style>
    *{
        padding: 0;
        box-sizing: border-box;
        margin: 0;
    }
    body{
    }
    .prodCercati{
        float:left;
        margin:25px;
        background-color: #e49314;
        max-width: min-content;
        height: 450px;
        border-radius: 5%;
    }

    .imgProd{
        border-color: #292929;
        border-radius: 5%;
    }

    .prodCercati:hover{

        box-shadow: rgba(0, 0, 0, 0.25) 0px 54px 55px, rgba(0, 0, 0, 0.12) 0px -12px 30px, rgba(0, 0, 0, 0.12) 0px 4px 6px, rgba(0, 0, 0, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;

    }
</style>
<body>
<%@include file="header.jsp"%>
<% ArrayList<Prodotto> prodottos= (ArrayList<Prodotto>) request.getAttribute("search");%>
<div class="prod">
        <% for (Prodotto p: prodottos) {%>
    <div class="prodCercati">
        <table>
            <tr><td>Nome: <%=p.getNome()%></td></tr>
            <tr><td>Descrizione: <%=p.getDesc()%></td></tr>
            <tr><td>Prezzo al mq: <%=p.getPrezzo()%> Euro</td></tr>
            <tr><td>Disponibilità: <%=p.getDisponibilita()%></td></tr>
            <a href="ShowProdotto?id=<%=p.getIdprod()%>"><img class="imgProd" src="Immagini/ImgProdotti/0<%=p.getImgPath_prod()%>" width="225" height="225" alt="IMG_PATH_NOT_FOUND"></a>
            <%if(utenteLog!=null){%>
            <div>
                <form action="Carrello" method="post"><i class="fa-solid fa-cart-shopping"></i>
                    <input type="hidden" name="aggiungi-prod" value="true">
                    <input type="hidden" name="addNum" value="1">
                <input type="hidden" name="prodId" value="<%=p.getIdprod()%>">
                <input type="hidden" name="aggiungi-prod" value="true">

                    <input type="submit">
                </form>
            </div>

            <%}%>
        </table>
        <br><br>

    </div><%}%>


</body>
</html>