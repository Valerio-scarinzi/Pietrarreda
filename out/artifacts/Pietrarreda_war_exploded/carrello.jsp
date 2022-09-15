<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrello</title>
   </head>
<style>
    *{
        padding: 0;
        box-sizing: border-box;
        margin: 0;
    }

    .prodInCarrello{
        margin: auto;
        background-color: #e49314;
        max-width: max-content;
        border-radius: 15px;
        box-shadow: rgba(41, 41, 41, 0.56) 0px 22px 70px 4px;
    }

    .resoconto{
        float: right;
        background-color: #292929;
        border-radius: 10px;
        margin: auto;
        padding: 25px;
    }

    .imgProd{
        border-radius: 10px;
    }
</style>
<body>
<%@include file="header.jsp"%>
<section>
    <h1 class="titolo">Carrello</h1>
    <grid class="Colonne">
        <c:forEach items="${carrello.prodotti}" var="pq">
            <div class="prodInCarrello">
            <div col="1/3">
                <a href="ShowProdotto?id=${pq.prodotto.idprod}"><img class="imgProd" src="Immagini/ImgProdotti/0${pq.prodotto.imgPath_prod}" width="180" height="180" ></a>
            </div>
            <div col="2/3">
                <p>${pq.prodotto.nome}</p>
                <h5>Quantità: ${pq.quantita}, Prezzo unit.: ${pq.prodotto.prezzo} &euro;, Prezzo tot.:${pq.prezzoTot}  &euro;</h5>
                <form action="Carrello" method="post">
                    <input type="hidden" name="prodId" value="${pq.prodotto.idprod}">
                    <input type="hidden" name="setNum" value="0">
                    <input type="submit" value="Rimuovi">
                </form>
            </div></div>
        </c:forEach>
        <c:if test="${empty carrello.prodotti}">
            <div col="1">Nessun prodotto nel carrello</div>
        </c:if>
    </grid>
</section>
<c:if test="${not empty carrello.prodotti}">
    <div class="resoconto"><section>
        <grid>
            <div col="1/3">
                <h2>Totale: ${carrello.prezzoTot} &euro;</h2>
            </div>
            <c:choose>
                <c:when test="${utente == null}">
                    <div col="1/3">
                        <form action="Registrazione">
                            <input type="submit" value="Completa acquisto" onclick="y()">
                        </form>
                    </div>
                </c:when>
                <c:otherwise>
                    <div col="1/3">
                        <form action="todo">
                            <input type="submit" id="Acquisto" value="Completa acquisto" onclick="x()">
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
        </grid>
    </section></div>
</c:if>
</body>
</html>