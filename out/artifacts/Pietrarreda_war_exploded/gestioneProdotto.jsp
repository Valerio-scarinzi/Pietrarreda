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
</head>
<body>
<%ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("listProdotti");%>
<h2>Prodotti nel database.</h2>
<div class="addProdotto">
    <button class="btn">
    <a href="addProdotto.jsp"> Aggiungi prodotto <i class="fa-solid fa-plus"></i></a>
    </button>
</div>

    <div class="showProdotti">

    <c:forEach items="${listProdotti}" var="prodotto">
        ID: <c:out value="${prodotto.idprod}" /><br>
        Nome:  <c:out value="${prodotto.nome}" /><br>
        Descrizione:  <c:out value="${prodotto.desc}" /><br>
        Prezzo:  <c:out value="${prodotto.prezzo}" /><br>
        Quantita' prodotto:  <c:out value="${prodotto.quantprodotto}" /><br>
        Disponibilita':  <c:out value="${prodotto.disponibilita}" /><br>

        <form method="post" action="GestioneProdottoServlet?id=${prodotto.idprod}">
    <input type="text" name="cambiaNome" id="cambiaNome" placeholder="modifica nome"> <br>

    <input type="text" name="cambiaDesc" id="cambiaDesc" placeholder="modifica descrizione"> <br>

      <input type="number" min="0" step="0.05" name="cambiaPrezzo" id="cambiaPrezzo" placeholder="modifica prezzo"> <br>

    <input type="number" min="0" name="cambiaQuant" id="cambiaQuant" placeholder="modifica quantita"> <br>

    <input type="number" min="0" name="cambiaDisp" id="cambiaDisp" placeholder="modifica disponibilità"> <br>

            <button class="btn">
              <a href="DeleteProdotto?id=${prodotto.idprod}" >Elimina <i class="fa-solid fa-trash-can"></i></a>
            </button>
    <input type="submit" value="Modifica"></form><br><br><br>
    </c:forEach>

    </div>
</body>
</html>
