<%@ page import="model.*" %>
<%@ page import="java.util.Collection" %>
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
<% CarrelloDAO carrelloDao=new CarrelloDAO();%>
<%Carrello carrello= (Carrello) session.getAttribute("carrello");%>

<h1 class="titolo">Carrello</h1>
<grid class="Colonne"></grid>
        <%if (carrello.getProdotti()!=null){%>
         <%for (Carrello.ProdottoQuantita prodotto : carrello.getProdotti()) {%>
<form class="form-cart-dett" action="${pageContext.request.contextPath}/Carrello" method="post">


             <div class="prodInCarrello">
            <div col="1/3">
                <a href="ShowProdotto?id=<%=prodotto.getProdotto().getIdprod()%>"></a>
            </div>
            <div col="2/3">
                <p><%=prodotto.getProdotto().getNome()%></p>
                <h5>Quantità: <%=prodotto.getQuantita()%>, Prezzo unit.: <%=prodotto.getProdotto().getPrezzo()%> &euro;, Prezzo tot.:<%=prodotto.getPrezzoTot()%>;  &euro;</h5>
                <select name="numero-rimossi">
                    <c:forEach begin="1" end="10" varStatus="loop">
                        <option value="${loop.index}"> ${loop.index} </option>
                    </c:forEach>
                </select>
                <div>
                    <input type="hidden" name="prodId" value="<%=prodotto.getProdotto().getIdprod()%>">
                    <input type="hidden" name="rimuovi-prod" value="true">
                    <input class="remove-prd" type="submit" value="Rimuovi Prodotto">
                </div>

            </div>
             </div>
</form>
                 <%}%>  <%}%>
                 <div class="subtot">
                     <p>Prezzo totale:<%=carrello.getPrezzoTotCar()%></p>
                 </div>
                 <div>
                     <form action="${pageContext.request.contextPath}/Carrello" method="get">
                         <input type="hidden" name="pulisci-carrello" value="true">
                         <input class="BtnCarrello" type="submit" value="Pulisci Carrello">
                     </form>
                     <form action="${pageContext.request.contextPath}/confermaOrdine.jsp">
                         <input type="hidden" name="confermaordine" value="true">
                         <input class="BtnCheckout" type="submit" value="Checkout">
                     </form>

                 </div>

</body>
</html>