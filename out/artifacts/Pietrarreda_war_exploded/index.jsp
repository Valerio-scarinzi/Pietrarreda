<%@ page import="java.util.List" %>
<%@ page import="model.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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

  </style>
  <body>
  <%@include file="header.jsp"%>

<div class="homepage">
  <h2 style="color: #e49314">Bevenuto su Pietrarreda.com</h2>
  <hr><br><br>
  <%@include file="slideGallery.jsp"%>
</div>



  <%@include file="footer.jsp"%>
  </body>
</html>
