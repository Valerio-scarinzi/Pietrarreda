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
</head>
<body>
<%ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("listProdotti");%>
<h2>prodotti nel database.</h2>





    <div class="showProdotti">

    <c:forEach items="${listProdotti}" var="prod">
        <c:out value="${prod.nome}" /><br>
        <c:out value="${prod.desc}" /><br>
        <c:out value="${prod.prezzo}" /><br>
        <c:out value="${prod.quantprodotto}" /><br>
        <c:out value="${prod.disponibilita}" /><br>




        <form method="post" action="GestioneProdottoServlet">
    <input type="text" name="cambiaNome" id="cambiaNome" placeholder="modifica nome"> <br><br>


    <input type="text" name="cambiaDesc" id="cambiaDesc" placeholder="modifica descrizione"> <br>

      <input type="text" name="cambiaPrezzo" id="cambiaPrezzo" placeholder="modifica prezzo"> <br>

    <input type="text" name="cambiaQuant" id="cambiaQuant" placeholder="modifica quantita"> <br>

    <input type="text" name="cambiaDisp" id="cambiaDisp" placeholder="modifica disponibilità"> <br>

    Vuoi eliminare l'elemento dal DB  <input type="checkbox" name="elimina" >

    <c:set var="id" value="${prod.idprod}" scope="request"/>
            <c:out value="${requestScope.id}"/>

    <input type="submit" value="Modifica/Elimina"> <br><br><br>
    </c:forEach>
</form>

    </div>







</body>
</html>
