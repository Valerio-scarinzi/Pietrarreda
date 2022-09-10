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
     <img src="<%=p.getImgPath_prod()%>" >
    <%=p.getIdprod()%><br>
     <%=p.getNome()%><br><br>

    <%}%></div>


</body>
</html>
