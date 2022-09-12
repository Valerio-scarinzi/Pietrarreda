<%@ page import="model.Utente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="stylesheet">
    <script src="https://kit.fontawesome.com/f52bb1298e.js" crossorigin="anonymous">
    </script>
    <title>Header responsive</title>

<style>
    *{
        padding: 0;
        box-sizing: border-box;
        margin: 0;
    }


    .navBar{
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
        position: relative;
        top: auto;
        margin-bottom: 20px;
        width: 100%;
        height: auto;
        justify-content: space-between;
        display: flex;
        align-items: center;
        background-color: #292929;
        color: #ffffff;
    }

    .brand-img{

    }

    .SearchBar input{
        border-radius: 5px;
    }

    .SearchBar button{
        border-radius: 5px;
    }


    .navBar-links ul{
        margin: 0;
        padding: 0;
        display: flex;
    }
    .navBar-links li{
        list-style: none;
    }
    .navBar-links li a {
        font-family: sans-serif;
        text-decoration: none;
        color: #ffffff;
        padding: 16px;
        display: block;
    }
    .navBar-links li a:hover{
        color: rgb(231, 146, 19);
        transition-duration:0.1s;
    }
    .SearchBar {
        margin: auto;
        display: inline-flex;
    }
    .fa-magnifying-glass:hover{
        color: rgb(231, 146, 19);
    }

    /*submenu categorie*/
    .catDropdown {
        position: relative;
        display: flex;
        margin-bottom: 15px;
    }

    .dropdown-content{
        display: none;
        position: absolute;


    }

    .dropdown-content a{
        display: block;
        margin-top: auto;
        background-color: #292929;
    }

    .catDropdown:hover .dropdown-content{
        display: block;

    }

    /*hamburgher menu*/
    .toggle-button{
        position: fixed;
        display: none;
        top: 10px;
        right: 10px;
        flex-direction: column;
        justify-content: space-between;
        width: 25px;
        height: 15px;
        margin: 2px;
    }
    .toggle-button .bar{
        height: 3px;
        width: 100%;
        background-color: #e79213;
        border-radius: 10px;
    }

    @media (max-width: 590px) { /* RESPONSIVE if schermo 500px o meno allora:*/

        .toggle-button{
            display: flex;
        }

        .SearchBar{
            display: flex;
            float: right;
        }

        .navBar-links{
            display: none;
            width: 100%;
        }


        .navBar{
            flex-direction: column;
            align-items: flex-start;
        }
        .navBar ul {
            width: 100%;
            flex-direction: column;
        }

        .navBar-links li {
            text-align: center;
        }
        .dropBtn{
           margin: auto;
        }
        .SearchBar{
            margin:auto;
        }
        .navBar-links li a{
            padding: .5rem 1rem;
        }

        .navBar-links.active{
            display: flex;
        }
    }
    @media (max-width: 255px){
        .toggle-button .bar{
            background-color: #292929;
        }


    }
</style>
    <%Utente utenteLog = (Utente) session.getAttribute("utenteLoggato");%>

<nav class="navBar">
    <div class="brand-img" title="HOMEPAGE"><a href="index.jsp"><img src="Immagini/Logo-Pietrarreda%20(1).jpg" alt="Logo.aapg"> </a></div>
    <div class="hamburgher" onclick="opHBar()">
        <a href="#" class="toggle-button">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </a>
    <script>
        function opHBar() {const toggleButton=document.getElementsByClassName('toggle-button')[0];
            const navBarLinks=document.getElementsByClassName('navBar-links')[0];
            toggleButton.addEventListener('click', () => {
                navBarLinks.classList.toggle('active')
            });
        }
    </script></div>
    <div class="navBar-links">
        <ul>
            <li>
                <div class="catDropdown">

                <a href="/" class="dropBtn">Negozio</a>
                    <div class="dropdown-content">
                        <a href="negozio.jsp">Negozio</a>
                        <a href="ShowCategoria?id=1">Categoria 1</a>
                        <a href="ShowCategoria?id=2">Categoria 2</a>
                        <a href="ShowCategoria?id=3">Categoria 3</a>
                    </div>
            </div>
            </li>
            <%if(utenteLog == null){%>
            <li><a href="login.jsp" title="LOGIN"><i class="fa-solid fa-user"></i></a></li><%}%>
            <%if(utenteLog != null){%>
            <li><a href="pagUtente.jsp" title="UTENTE">Benvenuto: <%=utenteLog.getUsername()%></a></li><%}%>
            <li><a href="registrazione.jsp">Registrati</a> </li>
            <li> <a href="#"><i class="fa-solid fa-cart-shopping"></i></a></li>
            <div class="SearchBar">
                <form action="RicServ" method="get">
                    <input type="text" placeholder="Cerca qui..." name="search" onkeyup="ricerca(this.value)">
                    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
            </div>
        </ul>
    </div>
</nav>
</head>
<body class="body"></body>
</html>