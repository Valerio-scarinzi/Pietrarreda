<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prodotto</title>
</head>
<style>
    *{
        padding: 0;
        box-sizing: border-box;
        margin: 0;
    }

    .product{
        background-color: #e49314;
        border-color: #292929;
        padding: 50px;
        border-radius: 15px;
        margin: 15px;
        box-shadow: rgba(41, 41, 41, 0.56) 0px 22px 70px 4px;
    }

    .imgProd{
        border-radius: 15px;
    }

    .attProd{

    }
    /*Bottone aggiungi a carrello*/
    .button-cart {
        float: right;
        appearance: none;
        background-color: #292929;
        border: 2px solid #1A1A1A;
        border-radius: 10px;
        box-sizing: border-box;
        color: #FFFFFF;
        cursor: pointer;
        display: inline-block;
        font-weight: 600;
        line-height: normal;
        margin: 0;
        min-height: 30px;
        min-width: 0;
        outline: none;
        padding: 10px 19px;
        text-align: center;
        text-decoration: none;
        transition: all 300ms cubic-bezier(.23, 1, 0.32, 1);
        user-select: none;
        -webkit-user-select: none;
        touch-action: manipulation;
        max-height: min-content;
        will-change: transform;
    }

    .button-cart:disabled {
        pointer-events: none;
    }

    .button-cart:hover {
        box-shadow: rgba(0, 0, 0, 0.25) 0 8px 15px;
        color: #e49314;
        transform: translateY(-2px);
    }

    .button-cart:active {
        box-shadow: none;
        transform: translateY(0);
    }
</style>
<body>
<%@include file="header.jsp"%>
<% Prodotto p = (Prodotto) request.getAttribute("ShowProdotto");%>
<div class="product">
        <a><img class="imgProd" src="Immagini/ImgProdotti/0<%=p.getImgPath_prod()%>" width="225" height="225" ></a>
    <a><img class="imgProd" src="Immagini/ImgProdotti/1<%=p.getImgPath_prod()%>" width="225" height="225" ></a>
        <table class="attProd">
            <tr><td>   Nome: <%=p.getNome()%></td></tr>
            <tr><td>Descrizione: <%=p.getDesc()%></td></tr>
            <tr><td>   Prezzo al mq: <%=p.getPrezzo()%> Euro</td></tr>
            <tr><td> Disponibilità: <%=p.getDisponibilita()%></td></tr>

            <%if(utenteLog!=null){%> <form action="Carrello" method="post">
                <input type="hidden" name="prodId" value="<%=p.getIdprod()%>">
                <tr><td>Quantita':<select name="addNum">
            <c:forEach begin="1" end="20" varStatus="loop">
                <option name="quantitaNum" value="${loop.index}"> ${loop.index} </option>
            </c:forEach>
        </select></td></tr>
           <tr><td><input type="submit"value="Aggiungi a carrello"></td></tr><%}%>
            </form>

    </table>
</div>
</body>
</html>