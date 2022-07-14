<%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 11/07/2022
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="background-color: #1a1a1a" style="color: #fcf1ec" >
  <head>
    <title>HomePage Pietrarreda</title>
    <style>
      h1 {text-align: center;}
      h2{text-align: center;}
      form {text-align: center;}
    </style>
  </head>
  <body>
  <h1 style="color: #fcf1ec">Pietrarreda</h1><br>
  <h2 style="color: rgba(253,255,226,0.79)">Ciao benvenuto nel sito!<br> immetti i tuoi dati</h2>
  <hr>



  <form method="get" action="Servlet">
    nome
    <input name="nome" type="text"><br>
    cognome
    <input name="cognome" type="text"><br>
    username
    <input name="username" type="text"><br>
    passwordhash
    <input name="password" type="text"><br>
    email
    <input name="email" type="text"><br>
    admin
    <input name="admin" type="text"><br>
    indirizzo
    <input name="indirizzo" type="text"><br>

    <input type="submit">

  </form>




  </body>
</html>
