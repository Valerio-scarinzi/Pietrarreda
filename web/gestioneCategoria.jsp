<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Categoria" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categorie DB</title>
    <script src="https://kit.fontawesome.com/f52bb1298e.js" crossorigin="anonymous"></script>
    <script src="alert.js"></script>
</head>
<style>
    .title{
        padding: 10px;
        text-align: center;
        color: #e49314;
    }
    .addCategoria{
        padding: 10px;
        text-align: center;
    }

    .btnAdd{
        color: #FFFFFF;
        background-color: #e49314;
        padding: 5px;
        margin: 5px;
        border-radius: 7px;
        text-align: center;
    }

    .showCategorie{
        margin: 10px;
        padding: 25px;
        background-color: #292929;
        border-radius: 15px;
        color: #e49314;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }
    input{
        padding: 5px;
        margin: 5px;
        border-radius: 7px;
        text-align: center;
    }
    .submit{
        border-color: #e49314;
        color: #FFFFFF;
        background-color: #292929;
    }
    .submit:hover{
        color: #e79213;
    }
    fieldset{
        padding: 15px;
        border-color: #e49314;
        margin: 20px;
    }
    .formContainer{
        text-align: center;
        float: right;

    }

    .description{

    }
    .btnAdd{
        color: #FFFFFF;
        background-color: #e49314;
        padding: 5px;
        margin: 5px;
        border-radius: 7px;
        text-align: center;
    }
    button{
        padding: 5px;
        margin: 5px;
        border-radius: 7px;
        text-align: center;
    }

    .btn{
        border-color: #e49314;
        color: #FFFFFF;
        background-color: #292929;
    }
    .btn:hover{
        color: #e79213;
    }


    .submit{
        border-color: #e49314;
        color: #FFFFFF;
        background-color: #292929;
    }
    .submit:hover{
        color: #e49314;
    }
    i{
        margin: 5px;
    }

</style>
<body>
<%@include file="header.jsp"%>




<div class="showCategorie">
    <h2 class="title">Categorie nel database</h2>
    <div class="addCategoria"><hr>
        <button class="btnAdd">
            <a href="addCategoria.jsp" style="text-decoration: none;color: white"> Aggiungi Categoria <i class="fa-solid fa-plus"></i></a>
        </button>
    </div>
    <c:forEach items="${listCategorie}" var="categoria"><fieldset>
    ID: <c:out value="${categoria.id}" /><br>
    Nome:  <c:out value="${categoria.categoria_nome}" /><br>
    Descrizione:  <c:out value="${categoria.descrizione}" /><br>
    Immagine:  <c:out value="${categoria.img}" /><br>

        <div class="formContainer">
            <p>Modifica con:</p><hr>
    <form id="updt"  method="post" action="GestioneCategoriaServlet?id=${categoria.id}">
        <input type="text" name="cambiaNome" id="cambiaNome" value="${categoria.categoria_nome}" placeholder="modifica nome" required="required"> <br>
        <input class="description" type="text" name="cambiaDesc" id="cambiaDesc" value="${categoria.descrizione}" placeholder="modifica descrizione" required="required"> <br>
        <input type="text" name="cambiaImg" id="cambiaImg" value="${categoria.img}" placeholder="modifica immagine" required="required"> <br>
        <button class="btn">
            <a id="del" href="DeleteCategoria?id=${categoria.id}" onclick="elimina()" style="text-decoration: none;color: #c80009">Elimina <i class="fa-solid fa-trash-can"></i></a>
        </button>
        <button class="submit" type="submit" onclick="modifica()">Modifica<i class="fa-solid fa-wrench"></i></button><br><br>
    </form></div>
    </fieldset>
        </c:forEach>
</div>







</body>
</html>
