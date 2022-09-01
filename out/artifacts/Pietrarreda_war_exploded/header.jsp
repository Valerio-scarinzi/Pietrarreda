<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="header.css">
    <script src="https://kit.fontawesome.com/f52bb1298e.js" crossorigin="anonymous">
    </script>
    <title>Header responsive</title>
</head>
<style>
</style>
<body>
<nav class="navBar">
    <div class="brand-img"><a href="#"><img src="Immagini/Logo-Pietrarreda%20(1).jpg" alt="Logo.aapg"> </a></div>
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
        <input>

            <li> <a href="AdminCategoria">Categorie</a></li>
            <li><a href="login.jsp"><i class="fa-solid fa-user"></i></a></li>

            <li> <a href="#"><i class="fa-solid fa-cart-shopping"></i></a></li>
            <div class="SearchBar">
                <form>
                    <input type="text" placeholder="Cerca qui...">
                    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
            </div>
        </ul>
    </div>
</nav>
</body>
</html>