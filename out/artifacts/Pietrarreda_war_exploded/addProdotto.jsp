<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiunta prodotto</title>
    <link rel="stylesheet" href="Register.css">
   <script src="JavaScript/libraries/alert.js"></script>
</head>
<body>


<form id="add" method="post" action="AddProdotto">
    <div class="AddProd_panel">
        <h3>AGGIUNTA PRODOTTO </h3>
        <input name="nome" type="text" placeholder="Inserisci Nome" required="required"><br>
        <input name="descrizione" type="text" placeholder="Inserisci Descrizione" required="required"><br>
        <input name="prezzo" type="number" min="0" step="0.05" placeholder="Inserisci Prezzo" required="required"><br>
        <input name="immagine" type="text" placeholder="inserisci immagine" required="required"><br>
        <input name="disponibilita" type="number" min="0" placeholder="Inserisci Disponibilita'" required="required"><br>
        <input type="submit" value="Aggiungi" onclick="aggiunta()">
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
