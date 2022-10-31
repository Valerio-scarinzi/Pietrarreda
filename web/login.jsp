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
        color: #FFFFFF;
        background-color: #292929;
    }
    .submit:hover{
        color: #e79213;
    }

    @media (max-width: 400px){
        body{
            background-color: #1A1A1A;
        }
        input{
            width: 100%;
            height: auto;
            background-color: #e49314;
        }
    }


</style>
<body>
<%@include file="header.jsp"%>
<script src="validate_login.js"></script>
<div class="Log_panel">
    <h3>LOGIN PANEL </h3><hr>
<form method="post" action="Login" name="login">
     <input id="email" name="email" type="email" placeholder="inserisci e-mail" required="required" oninput="validaLEmail()"><br>
     <input id="username" name="username" type="text" placeholder="inserisci username" required="required" oninput="validaLUsername()"><br>
     <input id="password" name="password" type="password" placeholder="inserisci password" required="required" oninput="validaLPassword()"><br>
    <input id="loggami" class="submit" type="submit" value="Accedi" disabled>
</form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
