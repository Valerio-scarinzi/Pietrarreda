
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error page : ${requestScope["javax.servlet.error.status_code"]}</title>
</head>
<style>
    *{
        padding: 0;
        box-sizing: border-box;
        margin: 0;
    }

    .container{
        background-color: #e49314;
        border-radius: 15px;
        margin: auto;
        margin-bottom: 20px;
        padding: 20px;
        text-align: center;
        max-width: max-content;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }
</style>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <h1>ERRORE</h1>
   <!-- <%if(exception!=null){%><h1 class="error_title">Error ${requestScope["javax.servlet.error.status_code"]}: <%=exception.getClass().getSimpleName()%></h1>
    <p class="error_message">
        Si è presentato un errore nel server: <br>
        <%=exception.getMessage()%>
    </p>
<%}%>else{%>
    <h1 class="error_title">Errore: ${requestScope["javax.servlet.error.status_code"]}</h1>
    <p class="error_message">Si è riscontrato un errore nell'accesso alla segeunte risorsa: <br>
        errore: ${requestScope["javax.servlet.error.status_code"]}.</p>
    <%}%>
</div>  -->
<%@include file="footer.jsp"%>
</body>
</html>
