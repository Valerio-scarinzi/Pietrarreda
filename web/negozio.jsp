<%@ page import="model.Prodotto" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 08/09/2022
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<% ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) session.getServletContext().getAttribute("prodotti");%>

<div class="ForNegozioJSP">

<% for (Prodotto p: prodotti) {%>
 <div class="InForNegozioJSP">
     <fieldset>
      <table>

          <tr> <td>   id : <%=p.getIdprod()%></td></tr>
          <tr><td>   Nome: <%=p.getNome()%></td></tr>
          <tr><td>Descrizione: <%=p.getDesc()%></td></tr>
          <tr><td>   prezzo al mq: <%=p.getPrezzo()%> Euro</td></tr>
          <tr><td> Disponibilità: <%=p.getDisponibilita()%></td></tr>
        </table>
    <img src="Immagini/ImgProdotti/0<%=p.getImgPath_prod()%>" width="225" height="225" >

    <img src="Immagini/ImgProdotti/1<%=p.getImgPath_prod()%>" width="225" height="225" >

     <a href=""></a>
    <br><br>

    </fieldset>
    </div>
    <%}%></div>


</body>
</html>
