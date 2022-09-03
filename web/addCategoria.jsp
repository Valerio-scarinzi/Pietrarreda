<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiunta categoria</title>
    <link rel="stylesheet" href="Register.css">
</head>
<body>

<form method="post" action="AddCategoria">
    <div class="AddCat_panel">
        <h3>AGGIUNTA CATEGORIA </h3>
        <input name="nome" type="text" placeholder="Inserisci Nome"><br>
        <input name="descrizione" type="text" placeholder="Inserisci Descrizione"><br>
        <input name="immagine" type="text" placeholder="immetti immagine"><br>
        <input type="submit" value="Aggiungi">
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
