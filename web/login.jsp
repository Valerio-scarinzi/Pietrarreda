<%@ page import="model.Utente" %>
<%@ page import="java.util.Iterator" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
        margin: auto;
        padding: 35px 30px;
        padding-bottom: 10px;
        margin-top: 30px;
        margin-bottom: 35px;
        color: #e79213;
        background-color: #292929;
        max-width: 350px;
        width: 100%;
        border-radius: 15px;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }


    .Log_panel input{
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


</style>
<body>
<%@include file="header.jsp"%>
<div class="Log_panel">
    <h3>LOGIN PANEL </h3><hr>
<form method="post" action="Login" >
     <input name="email" type="email" placeholder="inserisci e-mail" required="required"><br>
     <input name="password" type="password" placeholder="inserisci password" required="required"><br>
     <input name="username" type="text" placeholder="inserisci username" required="required"><br>
    <input class="submit" type="submit" value="Accedi">
</form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
