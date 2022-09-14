
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<style>

    *{
        padding: 0;
        box-sizing: border-box;
        margin: 0;
    }

    .utentePanel{
        text-align: center;
        margin: auto;
        max-width: max-content;
        padding: 60px;
        background:#e49314;
        border-radius: 15px;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }
</style>
<body>
<%@include file="header.jsp"%>
<% Utente utente = (Utente) session.getAttribute("utenteLoggato");%>
<div class="utentePanel">
    <table class="attUtente">
        <tr><td>Nome: <%=utente.getNome()%></td></tr>
        <tr><td>Cognome: <%=utente.getCognome()%></td></tr>
        <tr><td>E-mail: <%=utente.getEmail()%></td></tr>
        <tr><td>Username: <%=utente.getUsername()%></td></tr>
        <tr><td>Password: <%=utente.getPassword()%></td></tr>
    </table>
    <%if(utente.isAdmin()==false){%>
    <form id="updt" method="post" action="GestioneUtenteServlet?id=<%=utente.getId()%>">
        <input type="text" name="cambiaNome" id="cambiaNome" value="<%=utente.getNome()%>" placeholder="modifica nome" required="required"> <br>
        <input type="text" name="cambiaCognome" id="cambiaCognome" value="<%=utente.getCognome()%>" placeholder="modifica cognome" required="required"> <br>
        <input type="text" name="cambiaUsername" id="cambiaUsername" value="<%=utente.getUsername()%>" placeholder="modifica username" required="required"> <br>
        <input type="password" name="cambiaPass" id="cambiaPass" value="<%=utente.getPassword()%>" placeholder="modifica password" required="required"> <br>
        <input type="submit" value="Modifica" onclick="modifica()">
    </form>
    <%}%>
    <%if(utente.isAdmin()==true){%>
    <button style=""><a href="admin.jsp"> Admin Console </a></button><%}%>
    <form id="logOut" action="LogOut" method="post">
        <input type="submit" value="Log-Out" style="color: red"><br><br>
    </form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>