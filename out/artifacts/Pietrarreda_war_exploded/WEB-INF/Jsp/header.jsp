

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
    <div class="divHeader">
        <a href="#">
        <img class="imgLogo" src="${pageContext.request.contextPath}\Immagini\Logo_Pietrarreda.png" alt="Logo.png">
        </a>
<nav class="head_Category">
    <ul class="head_CatUl">
        <li><a href="#">Categoria</a> </li>
        <li><a href="#">Catalogo</a> </li>
        <li><a href="#">Contatti</a> </li>
        <li><a href="#">Login</a> </li>
        <li><a href="#">Registrazione</a> </li>
        <li><a href="#"><img src="${pageContext.request.contextPath}\Immagini\carrello.png" alt="carrello.png" class="carrello_icon"></a> </li>
    </ul>
    <div class="head_Search">
    <input type="text" placeholder="Cerca" id="header_cerca">
    </div>
</nav>
    </div>
    </div>
</header>
</body>
</html>
