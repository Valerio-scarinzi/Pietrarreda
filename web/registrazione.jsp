<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrazione</title>
    <link rel="stylesheet" href="Register.css">
</head>
<body>
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
<%@include file="WEB-INF/result/footer.jsp"%>
</body>
</html>
