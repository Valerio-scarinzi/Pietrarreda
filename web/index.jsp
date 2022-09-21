
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
  <title>Pietrarreda.com - Website </title>
</head>
<style>
  *{
    padding: 0;
    box-sizing: border-box;
    margin: 0;
  }

  .homepage{
    text-align: center;
  }

  .passion{
    margin: 20px;
    padding: 20px;
  }

</style>
<body>
<%@include file="header.jsp"%><% ArrayList<Prodotto> prodotti= new ArrayList<Prodotto>();%>  <%ProdottoDAO prodottoDAO = new ProdottoDAO();%>  <%prodotti = prodottoDAO.getAllProdotti();%>  <%session.getServletContext().setAttribute("prodotti",prodotti);%><div class="homepage">
  <h1 style="color: #e49314">Bevenuto su Pietrarreda.com</h1>
  <hr><br><br>
  <%@include file="slideGallery.jsp"%><div class="passion">
  <h2>La passione per la pietra</h2>
  Ad animare il nostro lavoro è la grande passione.
  Ed è proprio grazie alla passione per la pietra che siamo in grado di soddisfare qualsiasi richiesta, anche di  clientela molto attenta ed esigente.
  Sia che si tratti di nostre produzioni esclusive che di  proposte attentamente selezionate.
  Molto vasto il mondo della pietra e del marmo, nell’arredo privato come in quello urbano, nei decori come nelle lavorazioni.
</div>
</div>
<%@include file="footer.jsp"%></body>
</html>


