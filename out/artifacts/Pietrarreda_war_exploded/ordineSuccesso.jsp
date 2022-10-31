<%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 19/09/2022
  Time: 03:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ordine OK</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    .container{
        background-color: #e49314;
        border-radius: 15px;
        margin: auto;
        margin-bottom: 20px;
        padding: 20px;
        text-align: center;
        max-width: max-content;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }

    @media (max-width: 400px){
        body{
            background-color: #1A1A1A;
            color: #e49314;
        }

    }
</style>
<body>
<%@include file="header.jsp"%>

<div class="container">
<h3>Ordine effettuato con successo</h3>
    <a href="index.jsp" style="text-decoration:none;color: #FFFFFF">Clicca qui per tornare alla homepage</a>
</div>


<%@include file="footer.jsp"%>
</body>
</html>
