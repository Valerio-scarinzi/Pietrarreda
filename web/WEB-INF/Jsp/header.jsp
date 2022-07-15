

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
    <div class="divHeader" href="#" ><img class="imgLogo" src="${pageContext.request.contextPath}\Immagini\Logo_Pietrarreda.png" alt="Logo.png">
<nav class="head_Category">
    <ul class="head_CatUl">
        <li><a href="#">Categoria</a> </li>
        <li><a href="#">Catalogo</a> </li>
        <li><a href="#">Contatti</a> </li>
        <li><a href="#">Login</a> </li>
        <li><a href="#">Registrazione</a> </li>
        <li><a href="#"><img style="width: 20px" height="20px"   src="${pageContext.request.contextPath}\Immagini\carrello.png" alt="carrello.png"></a> </li>
    </ul>
    <div class="head_Search">
    <input type="text" placeholder="Cerca">
    <i class="fa fa-search" aria aria-hidden="true"></i>
    </div>
</nav>
    </div>

    </div>
</header>
</body>
</html>
