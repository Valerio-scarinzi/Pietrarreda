<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Utente" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestione Utente</title>
    <script src="https://kit.fontawesome.com/f52bb1298e.js" crossorigin="anonymous"></script>
    <script src="JavaScript/libraries/alert.js"></script>
</head>
<style>
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
<%ArrayList<Utente> utenti = (ArrayList<Utente>) request.getAttribute("listUtenti");%>
<h2>Utenti nel database.</h2>
<div class="addUtente">
    <button class="btn">
        <a href="addUtente.jsp"> Aggiungi utente <i class="fa-solid fa-plus"></i></a>
    </button>
</div>
<hr>

<div class="showUtenti">

    <c:forEach items="${listUtenti}" var="utente"><fieldset>
        ID: <c:out value="${utente.id}" /><br>
        Nome:  <c:out value="${utente.nome}" /><br>
        Cognome:  <c:out value="${utente.cognome}" /><br>
        Username:  <c:out value="${utente.username}" /><br>
        Password:  <c:out value="${utente.password}" /><br>
        E-mail:  <c:out value="${utente.email}" /><br>
        Admin:  <c:out value="${utente.admin}" /><br>

        <form id="updt" method="post" action="GestioneUtenteServlet?id=${utente.id}">
            <input type="text" name="cambiaNome" id="cambiaNome" value="${utente.nome}" placeholder="modifica nome" required="required"> <br>

            <input type="text" name="cambiaCognome" id="cambiaCognome" value="${utente.cognome}" placeholder="modifica cognome" required="required"> <br>

            <input type="text" name="cambiaUsername" id="cambiaUsername" value="${utente.username}" placeholder="modifica username" required="required"> <br>

            <input type="password" name="cambiaPass" id="cambiaPass" value="${utente.password}" placeholder="modifica password" required="required"> <br>

            <input type="text" name="cambiaEmail" id="cambiaEmail" value="${utente.email}" placeholder="modifica email" required="required"> <br>

            Abilita admin:<input type="checkbox" name="cambiaAdmin" value="" id="cambiaAdmin"> <br>

            <button class="btn">
                <a href="DeleteUtente?id=${utente.id}" onclick="elimina()">Elimina <i class="fa-solid fa-trash-can"></i></a>
            </button>
            <input class="submit" type="submit" value="Modifica" onclick="modifica()"><br><br>
        </form>
    </fieldset>
        <br>
    </c:forEach>

</div>
</body>
</html>
