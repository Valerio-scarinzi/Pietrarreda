<%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 19/07/2022
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="login.css">
<head>

    <title>login panel</title>
</head>
<style>
    /*CSS login.jsp*/
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    body{

        justify-content: center;
        align-items: center;
        height: 700px;
    }

    .Log_panel{
        text-align: center;
        position: relative;
        margin-left: auto;
        margin-right: auto;
        padding: 25px 30px;
        padding-bottom: 5px;
        margin-top: 20px;
        margin-bottom: 20px;
        color: #e79213;
        background-color: #292929;
        max-width: 350px;
        width: 100%;
        border-radius: 15px;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }


    .Log_panel input{
        background-color: #dcdcdc;
        padding: 5px;
        margin: 5px;
        text-align: center;
    }
    .submit:hover{

        background-color: #e49314;

    }


</style>
<body>
<%@include file="header.jsp"%>
<div class="Log_panel">
    <h3>LOGIN PANEL </h3>
<form method="post" action="Login" >
     <input name="email" type="text" placeholder="inserisci e-mail"><br>
     <input name="password" type="password" placeholder="inserisci password"><br>
     <input name="username" type="text" placeholder="inserisci username"><br>
    <input class="submit" type="submit" value="Accedi">
</form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
