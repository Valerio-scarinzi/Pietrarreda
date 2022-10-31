<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrazione</title>
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
        color: #FFFFFF;
        background-color: #292929;
    }
    .submit:hover{
        color: #e79213;
    }
    .refLogin{
        margin:10px;
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
<script type="text/javascript" src="validate_registration.js"></script>
<form id="registrazione" name="registrazione" method="post" action="Registrazione" >
    <div class="Reg_panel">
        <h3>REGISTRAZIONE</h3><hr>
        <p class="refLogin">Possiedi un account? <br><a href="login.jsp" style="text-decoration: none">log-in</a></p>
        <input id="nome" name="nome" type="text" placeholder="Inserisci Nome" required="required" oninput="validaRNome()"><br>
        <input id="cognome" name="cognome" type="text" placeholder="Inserisci Cognome" required="required" oninput="validaRCognome()"><br>
        <input id="username" name="username" type="text" placeholder="Inserisci Username" required="required" oninput="validaRUsername()"><br>
        <input id="email" name="email" type="email" placeholder="Inserisci E-mail" required="required" oninput="validaREmail()"><br>
        <input id="password" name="password" type="text" placeholder="Inserisci Password" required="required"  oninput="validacPassword()"><br>
        <input id="cpassword" name="cpassword" type="text" placeholder="Conferma Password" required="required"  oninput="validacPassword()"><br>
        <h6 id="helpPass">La Password deve contenere una lettera maiuscola e minuscola,un numero ed essere di lunghezza di almeno 8</h6>
       <div class="btn"><input id="registrami" class="submit" type="submit" value="Registrati" disabled onclick="registrazioneSucc()"></div>
    </div>
</form>
<%@include file="footer.jsp"%>
</body>

</html>
