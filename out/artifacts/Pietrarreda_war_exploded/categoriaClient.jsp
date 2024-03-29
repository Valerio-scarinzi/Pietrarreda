<%@ page import="java.util.ArrayList" %>
<%@ page import="model.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Categorie</title>
</head>
<body>
<%@include file="header.jsp"%>
<%  ArrayList<Prodotto> listprodFromCat = (ArrayList<Prodotto>) request.getAttribute("ProdottiFromCat");%>
<% Categoria categoria = (Categoria) request.getAttribute("ShowCategoria");%>

<style>
    *{
        padding: 0;
        box-sizing: border-box;
        margin: 0;
    }
    body{
    }
    .InForNegozioJSP{
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

    .InForNegozioJSP:hover{

        box-shadow: rgba(0, 0, 0, 0.25) 0px 54px 55px, rgba(0, 0, 0, 0.12) 0px -12px 30px, rgba(0, 0, 0, 0.12) 0px 4px 6px, rgba(0, 0, 0, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;

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


<div class="ForNegozioJSP">
    <% for (Prodotto p: listprodFromCat) {%>
    <div class="InForNegozioJSP">

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
            </div><%}%>
        </table>
        <br><br>

    </div>
    <%}%></div>


</body>
</html>
