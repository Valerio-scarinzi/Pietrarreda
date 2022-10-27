
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
    .titolo{
        text-align: center;
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
    button{
        padding: 5px;
        margin: 5px;
        border-radius: 7px;
        text-align: center;
    }
    .btn{
        border-color: #e49314;
        color: #FFFFFF;
        background-color: #292929;
    }
    .btn:hover{
        color: #e79213;
    }


    .submit{
        margin: 10px;
        border-color: #e49314;
        color: #FFFFFF;
        background-color: #292929;
    }
    .submit:hover{
        color: #e79213;
    }
    .submitExit{
        margin: 10px;
        border-color: #e49314;
        color: #FFFFFF;
        background-color: #292929;
    }
    .submitExit:hover{
        color: #c80009;
    }
    i{
        margin: 5px;
    }
</style>
<body>
<%@include file="header.jsp"%>
<% Utente utente = (Utente) session.getAttribute("utenteLoggato");%>
<div class="utentePanel">
    <h2 class="titolo">User panel</h2><hr>
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
        <button class="submit" type="submit" onclick="modifica()">Modifica<i class="fa-solid fa-wrench"></i></button>
    </form>
    <%}%>
    <%if(utente.isAdmin()==true){%> <!-- Nel pannello compare un href al pannello admin se l utente che accede è un admin-->
    <button class="btn"><a href="admin.jsp" style="text-decoration: none;color: #e49314"> Admin Console </a></button><%}%>
    <form id="logOut" action="LogOut" method="post">
        <button class="submitExit" type="submit" value="gestisci">Log-out<i class="fa-solid fa-arrow-right-from-bracket"></i></button><br>
    </form>
   <button class="btn"> <a href="imieiOrdini.jsp" style="text-decoration: none;color: #FFFFFF">Storico Ordini</a></button>
    <br>
</div>
<%@include file="footer.jsp"%>
</body>
</html>