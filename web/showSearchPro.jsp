
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
        border-radius: 15px;
    }

    .imgProd{
        border-color: #292929;
        border-radius: 15px;
    }

    .prodCercati:hover{
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

    .container{
        background-color: #e49314;
        border-radius: 15px;
        margin: auto;
        margin-bottom: 20px;
        padding: 20px;
        text-align: center;
        max-width: max-content;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }

    @media (max-width: 400px){
        .button-cart{
            width: 100%;
        }

        body{
            background-color: #1A1A1A;
        }
        table{
             text-align: center;
         }
        .prodCercati{
            border:4px solid  #292929;
        }

        .prodCercati:hover{

            box-shadow: rgba(231, 146, 19, 0.25) 0px 54px 55px, rgba(231, 146, 19, 0.12) 0px -12px 30px, rgba(231, 146, 19, 0.12) 0px 4px 6px, rgba(231, 146, 19, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;

        }
    }
</style>
<body>
<%@include file="header.jsp"%>
<% ArrayList<Prodotto> prodottos= (ArrayList<Prodotto>) request.getAttribute("search");%> <!--Setta l oggetto con i prodotti trovati nel database-->
<%if (prodottos.isEmpty()){%> <!--Se non ci sono prodotti che corrispondono alla ricerca -->
<div class="container">
    <h3>Non abbiamo trovato nessun prodotto con questo nome</h3>
    <a href="index.jsp" style="text-decoration:none;color: #FFFFFF">Clicca qui per tornare alla homepage</a>
</div><%}%>
<div class="prod">
        <% for (Prodotto p: prodottos) {%><!--Per ogni prodotto trovato che corrisponde alla ricerca:   -->
    <div class="prodCercati">
        <table>
            <tr><td>Nome: <%=p.getNome()%></td></tr>
            <tr><td>Descrizione: <%=p.getDesc()%></td></tr>
            <tr><td>Prezzo al mq: <%=p.getPrezzo()%> Euro</td></tr>
            <tr><td>Disponibilità:<%if (p.getDisponibilita()>=1){%> <%=p.getDisponibilita()%> <%}else{%> N.D <%}%></td></tr>
            <a href="ShowProdotto?id=<%=p.getIdprod()%>"><img class="imgProd" src="Immagini/ImgProdotti/0<%=p.getImgPath_prod()%>" width="225" height="225" alt="IMG_PATH_NOT_FOUND"></a><!--Href nell immagine che indirizza alla pagina del prodotto tramite servlet,dall id del prodotto-->
            <%if(utenteLog!=null){%>
            <%if(p.getDisponibilita()>=1){%> <!--Se la disponibilità è maggiore di 1 allora :   -->
            <div>
                <form action="Carrello" method="post"> <!--Button che passa la richiesta a CarrelloServlet :   -->
                    <input type="hidden" name="aggiungi-prod" value="true">
                    <input type="hidden" name="addNum" value="1">
                <input type="hidden" name="prodId" value="<%=p.getIdprod()%>">
                <input type="hidden" name="aggiungi-prod" value="true">
                    <button  class="button-cart" type="submit"> <i class="fa-solid fa-cart-shopping"></i> </button>
                </form>
            </div><%}%>

            <%}%>
        </table>
        <br><br>

    </div><%}%>


</body>
</html>