<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Categoria" %>
<%@ page import="model.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: VaLeRiX
  Date: 03/09/2022
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Categorie</title>
</head>
<body>
<%@include file="header.jsp"%>
<% ArrayList<Categoria> categorie = (ArrayList<Categoria>) session.getServletContext().getAttribute("categorie");%>
<% ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) session.getServletContext().getAttribute("prodotti");%>
<% Categoria categoria = (Categoria) request.getAttribute("ShowCategoria");%>

<div class="forCategorie">
<%=categoria.getCategoria_nome()%>
</div>

</div>





</body>
</html>
