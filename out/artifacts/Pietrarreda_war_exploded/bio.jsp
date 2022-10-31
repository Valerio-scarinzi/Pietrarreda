
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bio</title>
</head>
<style>

    *{
        padding: 0;
        box-sizing: border-box;
        margin: 0;
    }
    img{
        align-content: center;
    }
    fieldset{
        padding: 5px;
        border-color: #292929;
        margin: 10px;
    }
.bio-devs{
    text-align: center;
    background-color: #e49314;
    border-radius: 15px;
    border: 3px solid #292929;
    padding: 15px;}
</style>
<body>
<%@include file="header.jsp"%>

<div class="bio-devs">
    <div class="Francesco"><fieldset>
    <img class="imgFDD" src="#" alt="Immagine_Francesco">
    <p class="bio1">
        Mi chiamo Francesco Di Domenico <br> sono uno studente alla facoltà di informatica nel campus Unisa <br>
        Sono nato  il 23/03/2000 a Nocera inferiore(SA) e vivo a Castel San Giorgio (SA),ho 22 anni <br>
    </p>     </fieldset></div>
    <div class="Valerio"><fieldset>
    <img class="imgVS" src="" alt="Immagine_Valerio">
    <p class="bio2">
        Mi chiamo Valerio Scarinzi <br> sono uno studente alla facoltà di informatica nel campus Unisa <br>
        Sono nato il 16/09 a Benevento(BN) e vivo a Foglianise(BN),ho 22 anni <br>
    </p></fieldset></div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
