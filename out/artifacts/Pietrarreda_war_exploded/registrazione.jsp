<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrazione</title>
    <link rel="stylesheet">
</head>
<style>
    /*CSS registrazione.jsp*/
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
    .Reg_panel{
        text-align: center;
        position: relative;
        margin-left: auto;
        margin-right: auto;
        color: #e79213;
        background-color: #292929;
        max-width:270px;
        width: 100%;
        padding: 25px 30px;
        margin-top: 10%;
        margin-bottom: 15%;
        border-radius: 15px;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }


    .Reg_panel input{
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
<form method="post" action="Registrazione">
    <div class="Reg_panel">
        <h3>REGISTRAZIONE</h3>

        <input name="nome" type="text" placeholder="Inserisci Nome" required="required"><br>
        <input name="cognome" type="text" placeholder="Inserisci Cognome" required="required"><br>
        <input name="username" type="text" placeholder="Inserisci Username" required="required"><br>
        <input name="password" type="text" placeholder="Inserisci Password" required="required" minlength="5"><br>
        <input name="email" type="email" placeholder="Inserisci E-mail" required="required"><br>
       <div class="btn"><input class="submit" type="submit" value="Registrati"></div>
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
