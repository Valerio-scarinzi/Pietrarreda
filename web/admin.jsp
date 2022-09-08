<%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 25/08/2022
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet">
<head>
    <title>admin console</title>
</head>
<style>
    /*CSS admin.jsp*/
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
   /* body{
        display: flex;
        justify-content: center;
        align-items: center;
        height: 700px;
    }*/
    .admin_panel{
        color: #d1aa11;
        background-color: #292929;
        max-width: 700px;
        width: 100%;
        padding: 25px 30px;
        border-radius: 15px;
        position: relative;
        margin-left: auto;
        margin-right: auto;

        padding-bottom: 5px;
        margin-top: 20px;
        margin-bottom: 20px;
    }


    .admin_panel input{
        horiz-align: center;
    }
</style>
<body>
<%@include file="header.jsp"%>

<div class="admin_panel">
    <h3>ADMIN CONSOLE</h3>
<form method="post" action="ProdottoServlet">
    <p>Gestione prodotto </p>  <input type="submit" value="gestisci"> <br>
</form>

<form method="post" action="CategorieServlet">
    <p>Gestione categoria </p>  <input type="submit" value="gestisci"> <br>
</form>

<form method="post" action="UtentiServlet">
    <p>Gestione utente </p>  <input type="submit" value="gestisci"> <br>
</form>

</div>
<%@include file="footer.jsp"%>
</body>
</html>
