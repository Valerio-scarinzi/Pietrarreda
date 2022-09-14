<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Categoria" %>
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
    <title>Categorie DB</title>
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


<h2>Categorie nel database</h2>
<div class="addCategoria">
    <button class="btn">
        <a href="addCategoria.jsp"> Aggiungi Categoria <i class="fa-solid fa-plus"></i></a>
    </button>
</div><hr>

<div class="showCategorie">
    <c:forEach items="${listCategorie}" var="categoria"><fieldset>
    ID: <c:out value="${categoria.id}" /><br>
    Nome:  <c:out value="${categoria.categoria_nome}" /><br>
    Descrizione:  <c:out value="${categoria.descrizione}" /><br>
    Immagine:  <c:out value="${categoria.img}" /><br>


    <form id="updt"  method="post" action="GestioneCategoriaServlet?id=${categoria.id}">
        <input type="text" name="cambiaNome" id="cambiaNome" value="${categoria.categoria_nome}" placeholder="modifica nome" required="required"> <br>
        <input type="text" name="cambiaDesc" id="cambiaDesc" value="${categoria.descrizione}" placeholder="modifica descrizione" required="required"> <br>
        <input type="text" name="cambiaImg" id="cambiaImg" value="${categoria.img}" placeholder="modifica immagine" required="required"> <br>
        <button class="btn">
            <a id="del" href="DeleteCategoria?id=${categoria.id}" onclick="elimina()">Elimina <i class="fa-solid fa-trash-can"></i></a>
        </button>
        <input class="submit" type="submit" value="Modifica" onclick="modifica()"><br><br>
    </form>
    </fieldset>
        <br>
        </c:forEach>
</div>







</body>
</html>
