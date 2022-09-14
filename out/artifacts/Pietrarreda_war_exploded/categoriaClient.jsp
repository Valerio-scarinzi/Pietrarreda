<%@ page import="java.util.ArrayList" %>
<%@ page import="model.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Categorie</title>
</head>
<body>
<%@include file="header.jsp"%>
<% ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) session.getServletContext().getAttribute("prodotti");%>
<% Categoria categoria = (Categoria) request.getAttribute("ShowCategoria");%>

<div class="forCategorie">
Prodotti della categoria: <%=categoria.getCategoria_nome()%>
</div>

<div>
    <% ProdottoDAO prodottoDAO=new ProdottoDAO(); %>
</div>





</body>
</html>
