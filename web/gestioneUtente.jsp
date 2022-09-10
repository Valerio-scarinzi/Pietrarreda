<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Utente" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 30/08/2022
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestione Utente</title>
    <script src="https://kit.fontawesome.com/f52bb1298e.js" crossorigin="anonymous"></script>
</head>
<body>
<%ArrayList<Utente> utenti = (ArrayList<Utente>) request.getAttribute("listUtenti");%>
<h2>Utenti nel database.</h2>
<div class="addUtente">
    <button class="btn">
        <a href="addUtente.jsp"> Aggiungi utente <i class="fa-solid fa-plus"></i></a>
    </button>
</div>

<div class="showUtenti">

    <c:forEach items="${listUtenti}" var="utente">
        ID: <c:out value="${utente.id}" /><br>
        Nome:  <c:out value="${utente.nome}" /><br>
        Cognome:  <c:out value="${utente.cognome}" /><br>
        Username:  <c:out value="${utente.username}" /><br>
        Password:  <c:out value="${utente.password}" /><br>
        E-mail:  <c:out value="${utente.email}" /><br>
        Admin:  <c:out value="${utente.admin}" /><br>

        <form method="post" action="GestioneUtenteServlet?id=${utente.id}">
            <input type="text" name="cambiaNome" id="cambiaNome" placeholder="modifica nome"> <br>

            <input type="text" name="cambiaCognome" id="cambiaCognome" placeholder="modifica cognome"> <br>

            <input type="text" name="cambiaUsername" id="cambiaUsername" placeholder="modifica username"> <br>

            <input type="password" name="cambiaPass" id="cambiaPass" placeholder="modifica password"> <br>

            <input type="text" name="cambiaEmail" id="cambiaEmail" placeholder="modifica email"> <br>

            Abilita admin:<input type="checkbox" name="cambiaAdmin" id="cambiaAdmin"> <br>

            <button class="btn">
                <a href="DeleteUtente?id=${utente.id}" >Elimina <i class="fa-solid fa-trash-can"></i></a>
            </button>
            <input type="submit" value="Modifica"><br><br><br>
        </form>
    </c:forEach>

</div>
</body>
</html>
