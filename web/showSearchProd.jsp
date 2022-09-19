<%@ page import="model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prodotti cercati </title>
</head>
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
                    <input type="submit">
                </form>
            </div>

            <%}%>
        </table>
        <br><br>

    </div><%}%>


</body>
</html>
