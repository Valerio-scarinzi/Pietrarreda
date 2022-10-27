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
    .titolo{
        text-align: center;
    }

    .carrelloContainer{
        padding: 15px;
        margin: auto;
        margin-bottom: 40px;
        background-color: #e49314;
        border-radius: 15px;
        max-width: max-content;
        width: 800px;
        box-shadow: 0px 0px 15px 1px #292929;
    }
    fieldset{
        padding: 15px;
        border-color: #292929;
        margin: 20px;
    }

    .prodInCarrello{
        margin: 25px;
    }

    .resoconto{
        max-width: max-content;
        background-color: #292929;
        border-radius: 10px;
        margin: auto;
        padding: 25px;
       text-align: center;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }
    button{
        padding: 5px;
        margin: 5px;
        border-radius: 7px;
        text-align: center;
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
</style>
<body>
<%@include file="header.jsp"%>
<% CarrelloDAO carrelloDao=new CarrelloDAO();%>
<%Carrello carrello= (Carrello) session.getAttribute("carrello");%>
<div class="carrelloContainer">
<h2 class="titolo">Carrello</h2><hr>
    <%if (carrello.getSize()==0){%><h4>Carrello vuoto.</h4><%}%>
<grid class="Colonne"></grid>
        <%if (carrello.getProdotti()!=null){%>
         <%for (Carrello.ProdottoQuantita prodotto : carrello.getProdotti()) {%>
    <fieldset>
<form class="form-cart-dett" action="${pageContext.request.contextPath}/Carrello" method="post">
             <div class="prodInCarrello">
            <div col="1/3">
                <a href="ShowProdotto?id=<%=prodotto.getProdotto().getIdprod()%>"></a>
            </div>
            <div col="2/3">
                <p><%=prodotto.getProdotto().getNome()%></p>
                <h5>Quantità: <%=prodotto.getQuantita()%>, Prezzo unit.: <%=prodotto.getProdotto().getPrezzo()%> &euro;, Prezzo tot.:<%=prodotto.getPrezzoTotProd()%>;  &euro;</h5>
                <select name="numero-rimossi">
                    <c:forEach begin="1" end="10" varStatus="loop">
                        <option value="${loop.index}"> ${loop.index} </option>
                    </c:forEach>
                </select>
                <div>
                    <input type="hidden" name="prodId" value="<%=prodotto.getProdotto().getIdprod()%>">
                    <input type="hidden" name="rimuovi-prod" value="true">
                    <button class="submit" type="submit">Rimuovi<i class="fa-solid fa-trash-can"></i></button>
                </div>

            </div>
             </div>
</form></fieldset>
                 <%}%>  <%}%></div>
    <%if (carrello.getSize()!=0){%><div class="resoconto">
                 <div class="subtot">
                     <h2 class="titolo" style="color: #e49314">Prezzo totale:<%=carrello.getPrezzoTotCar()%></h2><hr>
                 </div>
                 <div>
                     <form action="${pageContext.request.contextPath}/Carrello" method="get">
                         <input type="hidden" name="pulisci-carrello" value="true">
                         <button class="submit" type="submit">
                           Pulisci carrello<i class="fa-solid fa-broom"></i>
                         </button>
                     </form>
                     <form action="${pageContext.request.contextPath}/confermaOrdine.jsp">
                         <input type="hidden" name="confermaordine" value="true">
                         <button class="submit" type="submit">Checkout<i class="fa-solid fa-arrow-right-to-bracket"></i></button>
                     </form>
                 </div>
    </div><%}%>

<%@include file="footer.jsp"%>
</body>
</html>