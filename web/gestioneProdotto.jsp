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
    <title>aggiungi un prodotto</title>
    <script src="https://kit.fontawesome.com/f52bb1298e.js" crossorigin="anonymous"></script>
</head>
<body>
<%ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("listProdotti");%>
<h2>Prodotti nel database.</h2>
<div class="addProdotto">
    <a href="addProdotto.jsp"> Aggiungi prodotto <i class="fa-solid fa-plus"></i></a>
</div>

    <div class="showProdotti">

    <c:forEach items="${listProdotti}" var="prodotto">
        ID: <c:out value="${prodotto.idprod}" /><br>
        Nome:  <c:out value="${prodotto.nome}" /><br>
        Descrizione:  <c:out value="${prodotto.desc}" /><br>
        Prezzo:  <c:out value="${prodotto.prezzo}" /><br>
        Quantita' prodotto:  <c:out value="${prodotto.quantprodotto}" /><br>
        Disponibilita':  <c:out value="${prodotto.disponibilita}" /><br>



        <form method="post" action="GestioneProdottoServlet">
    <input type="text" name="cambiaNome" id="cambiaNome" placeholder="modifica nome"> <br>

    <input type="text" name="cambiaDesc" id="cambiaDesc" placeholder="modifica descrizione"> <br>

      <input type="text" name="cambiaPrezzo" id="cambiaPrezzo" placeholder="modifica prezzo"> <br>

    <input type="text" name="cambiaQuant" id="cambiaQuant" placeholder="modifica quantita"> <br>

    <input type="text" name="cambiaDisp" id="cambiaDisp" placeholder="modifica disponibilità"> <br>

    Vuoi eliminare l'elemento dal DB ?  <input type="checkbox" name="elimina" ><br>

    <c:set var="id" value="${prod.idprod}" scope="request"/>
            <c:out value="${id}"/>
            <c:out value="${requestScope.id}"/>

    <input type="submit" value="Modifica/Elimina"> <br><br><br>
    </c:forEach>
</form>
    </div>
</body>
</html>
