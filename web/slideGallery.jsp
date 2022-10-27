<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Slide Gallery</title>
    <script src="https://kit.fontawesome.com/f52bb1298e.js" crossorigin="anonymous">
    </script>
    <script src="slide.js"></script>
</head>
<style>
    * {box-sizing:border-box}

    /* Slideshow container */
    .slide-container {
        background-color: #e49314;
        border-radius: 15px;
        max-width: 1000px;
        position: relative;
        margin: auto;
        padding :35px;
        box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;
    }

    /* Nascondi le immagini di default  */
    .slide {
        display: none;
    }

    /* Next & previous buttons */
    .prev, .next {
        cursor: pointer;
        position: absolute;
        top: 50%;
        width: auto;
        height: max-content;
        margin-top: -22px;
        padding: 9px;
        color: #292929;
        font-weight: bold;
        font-size: 18px;
        transition: 0.6s ease;
        border-radius: 0 3px 3px 0;
        user-select: none;
    }

    /* Posiziona freccia a destra  */
    .next {
        right: 0;
        border-radius: 3px 0 0 3px;
    }
    /* Posiziona freccia a sinistra */
    .prev {
        left: 0;
        border-radius: 3px 0 0 3px;
    }

    /* Hover,oscura la freccia */
    .prev:hover, .next:hover {
        background-color: rgba(0,0,0,0.8);
    }


    /* pallini */
    .dot {
        cursor: pointer;
        height: 15px;
        width: 15px;
        margin: 10px 10px;
        background-color: #292929;
        border-radius: 50%;
        display: inline-block;
        transition: background-color 0.6s ease;
    }



</style>
<body>


<div class="slide-container">
    <% for (Categoria c: categorie) {%>
    <div class="slide">
        <a href="ShowCategoria?id=<%=c.getId()%>"><img class="imgCat" src="Immagini/ImgProdotti/0<%=c.getImg()%>" alt="IMG_<%=c.getCategoria_nome()%>_not_found" width="255" height="255"></a>
    </div><%}%>




    <!--Avanti e indietro-->
    <a class="prev" onclick="plusSlides(-1)"> <i class="fa-solid fa-arrow-left"></i> </a>
    <a class="next" onclick="plusSlides(1)"> <i class="fa-solid fa-arrow-right"></i> </a>

    <!--Pallini seleziona immagini-->
    <div style="text-align:center">
        <span class="dot" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
    </div>

</div>
</body>
</html>