<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiunta prodotto</title>
    <link rel="stylesheet" href="Register.css">
</head>
<body>

<form method="post" action="AddProdotto">
    <div class="AddProd_panel">
        <h3>AGGIUNTA PRODOTTO </h3>
        <input name="nome" type="text" placeholder="Inserisci Nome"><br>
        <input name="descrizione" type="text" placeholder="Inserisci Descrizione"><br>
        <input name="prezzo" type="number" min="0" step="0.05" placeholder="Inserisci Prezzo"><br>
        <input name="immagine" type="number" min="0" placeholder="Inserisci Quantita'"><br>
        <input name="disponibilita" type="number" min="0" placeholder="Inserisci Disponibilita' "><br>
        <input type="submit" value="Aggiungi">
    </div>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
