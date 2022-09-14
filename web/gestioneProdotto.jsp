<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 29/08/2022
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prodotti DB</title>
    <script src="https://kit.fontawesome.com/f52bb1298e.js" crossorigin="anonymous"></script>
    <script src="JavaScript/libraries/alert.js"></script>
</head>
<style>
*{
    box-sizing: border-box;
}
    .showProdotti{
        margin: auto;
    }
.submit{
    border-color: #e49314;
    color: #FFFFFF;
    background-color: #292929;
}
.submit:hover{
    color: #e79213;
}

</style>
<body>
<%@include file="header.jsp"%>
<%ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("listProdotti");%>

<div class="addProdotto" style="margin-left: 1%">
    <h2>Prodotti nel database.</h2>
    <button class="btn">
    <a href="addProdotto.jsp"> Aggiungi prodotto <i class="fa-solid fa-plus"></i></a>
    </button> <hr><hr>
</div>


    <div class="showProdotti" style="margin-left: 1%">
    <c:forEach items="${listProdotti}" var="prodotto">
        <fieldset>
        ID: <c:out value="${prodotto.idprod}" /><br>
        Nome:  <c:out value="${prodotto.nome}" /><br>
        Descrizione:  <c:out value="${prodotto.desc}" /><br>
        Prezzo:  <c:out value="${prodotto.prezzo}" /><br>
        IMG PATH:  <c:out value="${prodotto.imgPath_prod}" /><br>
        Disponibilita':  <c:out value="${prodotto.disponibilita}" /><br>

        <form id="updt" method="post" action="GestioneProdottoServlet?id=${prodotto.idprod}">
    <input type="text" name="cambiaNome" id="cambiaNome" value="${prodotto.nome}" required="required"> <br>

    <input type="text" name="cambiaDesc" id="cambiaDesc" value="${prodotto.desc}" required="required"> <br>

      <input type="number" min="0" step="0.05" name="cambiaPrezzo" id="cambiaPrezzo" value="${prodotto.prezzo}" required="required"> <br>

    <input type="text"  name="cambiaImg" id="cambiaImg" value="${prodotto.imgPath_prod}" required="required"> <br>

    <input type="number" min="0" name="cambiaDisp" id="cambiaDisp" value="${prodotto.disponibilita}" required="required"> <br>

            <button class="btn">
              <a href="DeleteProdotto?id=${prodotto.idprod}" onclick="elimina()">Elimina <i class="fa-solid fa-trash-can"></i></a>
            </button>
    <input  class="submit" type="submit" value="Modifica" onclick="modifica()"><br><br>
        </form>
</fieldset>
        <br>
    </c:forEach>
    </div>



<%@include file="footer.jsp"%>
</body>
</html>
