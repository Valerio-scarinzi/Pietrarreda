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
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
        color: #e79213;
        background-color: #292929;
        text-align: center;
        max-width: max-content;
        padding: 25px 30px;
        border-radius: 15px;
        position: relative;
        margin: auto;
        margin-top: 20px;
        margin-bottom: 20px;
    }
    .submit{
        border-color: #e49314;
        color: #FFFFFF;
        background-color: #292929;
    }
    .submit:hover{
        color: #e79213;
    }
    .admin_panel input{
        horiz-align: center;
    }
</style>
<body>
<%@include file="header.jsp"%>

<div class="admin_panel">
    <h3>ADMIN CONSOLE</h3>
    <div class="forms">
<form method="post" action="ProdottoServlet">
    <p>Gestione prodotto </p>  <input class="submit"type="submit" value="gestisci"> <br>
</form>
<form method="post" action="CategorieServlet">
    <p>Gestione categoria </p>  <input class="submit"type="submit" value="gestisci"> <br>
</form>
<form method="post" action="UtentiServlet">
    <p>Gestione utente </p>  <input  class="submit" type="submit" value="gestisci"> <br>
</form>
    </div>

</div>
<%@include file="footer.jsp"%>
</body>
</html>
