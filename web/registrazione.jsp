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
<form id="registrazione" name="registrazione" method="post" action="Registrazione" >
    <div class="Reg_panel">
        <h3>REGISTRAZIONE</h3>

        <input id="nome" name="nome" type="text" placeholder="Inserisci Nome" required="required"><br>
        <input id="cognome" name="cognome" type="text" placeholder="Inserisci Cognome" required="required"><br>
        <input id="username" name="username" type="text" placeholder="Inserisci Username" required="required" oninput="validateUsername()">
        <br>
        <input id="password" name="password" type="text" placeholder="Inserisci Password" required="required" minlength="5" oninput="validatePassword   ()">
        <br>
        <input id="email" name="email" type="email" placeholder="Inserisci E-mail" required="required" oninput="validateEmail()">
        <br>
       <div class="btn"><input class="submit" type="submit" value="Registrati"></div>
    </div>
</form>
<script>
    function validatePassword() {


        if(document.forms['registrazione']['password'].value == "" && document.forms['registrazione']['password'].value.length <7  ){
            document.forms['registrazione']['password'].style.borderColor = "red";
          }if (document.forms['registrazione']['password'].value.length <7){
        document.forms['registrazione']['password'].style.borderColor = "red";
    }else {document.forms['registrazione']['password'].style.borderColor = "white";}
    }
    </script>
    <script>
    function validateUsername() {


            if (document.forms['registrazione']['username'].value == ""  ) {
                document.forms['registrazione']['username'].style.borderColor = "red";
            }if (document.forms['registrazione']['username'].value.length <7){
                document.forms['registrazione']['username'].style.borderColor = "red";
            }else {document.forms['registrazione']['username'].style.borderColor = "white";}
        }
</script>
    <script>
    function validateEmail() {


            if (document.forms['registrazione']['email'].value == "") {
                document.forms['registrazione']['email'].style.borderColor = "red";
            }else{document.forms['registrazione']['email'].style.borderColor = "white";}
        }



</script>



<%@include file="footer.jsp"%>
</body>
</html>
