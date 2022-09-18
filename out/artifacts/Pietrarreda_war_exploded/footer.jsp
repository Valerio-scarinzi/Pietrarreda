<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<link rel="stylesheet">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <script src="https://kit.fontawesome.com/f52bb1298e.js" crossorigin="anonymous"></script>
</head>
<style>
    /*css footer*/
    *{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }

    body{

        font-family: sans-serif;
        font-weight: 300;
    }

    .footer{
        position:relative;
        bottom: auto;
        bottom: 0;
        margin-bottom: 0;
        margin-top: 35px;
        padding: 10px 10px 0px 10px;
        width: 100%;
        background-color: #292929;
    }

    .footer .social{
        text-align: center;
        padding-bottom: 25px;
        color: #ffffff;

    }

    .footer .social a{
        color: inherit;
        font-size: 30px;
        width: 40px;
        height: 40px;
        line-height: 38px;
        display: inline-block;
        border-radius: 50%;
        text-align: center;
        margin: 0 8px;
    }
    .footer .social a:hover{
        color: #e79213;
    }
    .footer .Cell{
        color: white;
    }
    .footer .chiSiamo{
        color: white;
    }
    .footer .mail{
        color: white;
    }
    .footer .support{
        color: white;
    }
    .footer ul{
        margin-top: 0;
        padding: 3px;
        list-style: none;
        font-size: 18px;
        line-height: 1.6;
        margin-bottom: 0;
        text-align: center;
    }

    .footer ul a {
        color:white;
        text-decoration: none;
    }
    .footer ul li a:hover{
        color: #e79213;
    }
    .footer ul li{
        display: inline-block;
        padding: 0 15px;
    }

    .footer .copyright{
        margin-top: 15px;
        text-align: center;
        font-size: 12px;
        color: darkgray;
    }
</style>
<body>
<div class="footer">
    <div class="social">
        <a href="#"><i class="fa-brands fa-facebook"></i></a>
        <a href="#"><i class="fa-brands fa-instagram"></i></a>
        <a href="#"><i class="fa-solid fa-map-location-dot"></i></a>
    </div>
    <ul class="lista">
        <li>
            <div class="chiSiamo">
                <i class="fa-solid fa-info"></i>
                     <a href="showBioServlet">Chi siamo</a>
                    </div>
            <div class="mail">
                <i class="fa-solid fa-envelope"></i>
                    <a href="#">Contattaci</a>
                </div>
            <div class="support">
                <i class="fa-solid fa-hand-holding-hand"></i>
                    <a href="#">Supporto</a>
                </div>
            <div class="Cell">
                <i class="fa-solid fa-phone"></i>
                <a>+39 123456789</a>
            </div>
        </li>
    </ul>
    <div class="copyright"><i class="fa-solid fa-copyright"></i><a>Copyright 2022 Pietrarreda - All rights reserved</a></div>
</div>

</body>
</html>
