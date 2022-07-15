<%--
  Created by IntelliJ IDEA.
  User: elomi
  Date: 15/07/2022
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<link rel="stylesheet" href="${pageContext.request.contextPath}\Css\Header.css"> <%-- Link al css nominato Header.css (fallo sempre così) file esterno--%>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
</head>
<style>
</style>
<body>

<header>
    <div class="divLogo" href="#" ><img class="imgLogo" src="${pageContext.request.contextPath}\Immagini\Logo_Pietrarreda.png" alt="Logo.png"></div>

    <ul class="head">
        <li><a href="#">Home</a> </li>
        <li><a href="#">Categoria1</a> </li>
        <li><a href="#">Prova2</a> </li>
        <li><a href="#">Prova3</a> </li>
        <li><a href="#">Prova4</a> </li>
    </ul>
    <div class="search">
        <input type="text" placeholder="Cerca">
        <i class="fa fa-search" aria aria-hidden="true"></i>
    </div>
</header>
</body>
</html>
