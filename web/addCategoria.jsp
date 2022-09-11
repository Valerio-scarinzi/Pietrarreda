<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiunta categoria</title>
    <link rel="stylesheet" href="Register.css">
    <script src="JavaScript/libraries/alert.js"></script>
</head>
<body>

<form id="add" method="post" action="AddCategoria">
    <div class="AddCat_panel">
        <h3>AGGIUNTA CATEGORIA </h3>
        <input name="nome" type="text" placeholder="Inserisci Nome" required="required"><br>
        <input name="descrizione" type="text" placeholder="Inserisci Descrizione" required="required"><br>
        <input name="immagine" type="text" placeholder="immetti immagine" required="required"><br>
        <input type="submit" value="Aggiungi" onclick="aggiunta()">
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
