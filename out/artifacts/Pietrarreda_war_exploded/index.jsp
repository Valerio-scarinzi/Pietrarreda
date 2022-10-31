
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
  @media (max-width: 400px){
    body{
      background-color: #1A1A1A;
      color: #e49314;
    }

  }

</style>
<body>
<%@include file="header.jsp"%><% ArrayList<Prodotto> prodotti= new ArrayList<Prodotto>();%>  <%ProdottoDAO prodottoDAO = new ProdottoDAO();%>  <%prodotti = prodottoDAO.getAllProdotti();%>  <%session.getServletContext().setAttribute("prodotti",prodotti);%><div class="homepage">
  <h1 style="color: #e49314">Bevenuto su Pietrarreda.com</h1>
  <P>Pietrarreda è un'azienda che fornisce minerali naturali per pavimentazioni e rivestimenti per dare un tocco in più alla tua casa o anche ad infrastrutture pubbliche.</P>
  <br>
  <p>LA CAPACITA' CHE DA SEMPRE
    ci contraddistingue è coniugare tutti i campi che riguardano questo materiale, frutto di un’importante tradizione familiare. Lavorazione effettuata con grande perizia con l’obiettivo di dare al prodotto finale un gusto antico e suggestivo, visibile in tutte le nostre proposte. Oltre a pavimentazioni e rivestimenti in pietra, sia nuova produzione che recuperata, vastissima scelta di oggettistica in pietra, frutto di un’accurata ricerca e selezione. Bellissimi e scenografici sono i camini, i portali, le fontane, le statue,
    la terracotta e i tanti altri articoli di arredo sia da giardino che da interno.
    Con grande cura e attenzione ci dedichiamo inoltre alla lavorazione della pietra per l’arredamento interno ed esterno.</p>
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


