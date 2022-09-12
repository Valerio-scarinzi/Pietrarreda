
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<%@include file="header.jsp"%>
<% Utente utente = (Utente) session.getAttribute("utenteLoggato");%>
<div class="utentePanel">
    <table class="attUtente">
        <tr><td>   Nome: <%=utente.getNome()%></td></tr>
        <tr><td>Cognome: <%=utente.getCognome()%></td></tr>
        <tr><td>E-mail: <%=utente.getEmail()%></td></tr>
        <tr><td> Username: <%=utente.getUsername()%></td></tr>
        <tr><td> Password: <%=utente.getPassword()%></td></tr>
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
    <h3>Per tornare alla admin console<a href="admin.jsp"> premi qui</a></h3><%}%>
    <form id="logOut" action="LogOut" method="post">
        <input type="submit" value="LogOut" onclick="logout()"><br><br>
    </form>

</div>
</body>
</html>