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

        position: relative;
        margin-left: auto;
        margin-right: auto;
        color: #d1aa11;
        background-color: #292929;
        max-width: 20%;
        width: auto;
        padding: 25px 30px;
        margin-top: 10%;
        margin-bottom: 15%;
        border-radius: 15px;
    }


    .Reg_panel input{

        padding-top: 10px;
        margin: 2%;

    }
</style>
<body>
<%@include file="header.jsp"%>
<form method="post" action="Registrazione">
    <div class="Reg_panel">
        <h3>REGISTRAZIONE</h3>

        <input name="nome" type="text" placeholder="Inserisci Nome"><br>
        <input name="cognome" type="text" placeholder="Inserisci Cognome"><br>
        <input name="username" type="text" placeholder="Inserisci Username"><br>
        <input name="password" type="text" placeholder="Inserisci Password"><br>
        <input name="email" type="text" placeholder="Inserisci E-mail"><br>
        <input type="submit" value="Registrati">
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
