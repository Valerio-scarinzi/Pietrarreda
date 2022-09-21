function ricerca(str) {

    var dataList = document.getElementById("ricercaAjax");
    if (str.length === 0) {
        //rimuovi elementi <option>
        dataList.innerHTML = "";
        return;
    }

    var xmlHttpReq = new XMLHttpRequest();
    xmlHttpReq.responseType = 'json';
    xmlHttpReq.onreadystatechange = function () {

        if (this.readyState === 4 && this.status === 200) {
            dataList.innerHTML = "";
            var lista=xmlHttpReq.response;

            for (var i in lista){
                // Creo il componente di ul
                var figlioUl=document.createElement("li");
                //Creo link per andare subito ai detagli prodotto
                var hrefNode=document.createElement("a");
                var attrHref=document.createAttribute("href");
                attrHref.value="DetServ?idsearch="+lista[i].Id_Prodotto;
                hrefNode.setAttributeNode(attrHref);
                // Creo testo per il link
                var spanNode=document.createElement("span");
                var attrSpan=document.createAttribute("id");
                attrSpan.value="testoSpan";
                spanNode.setAttributeNode(attrSpan);
                var textNode=document.createTextNode(lista[i].Nome);
                //Lego tutto componendo il nuovo DOM modificando la ul nella pagina web
                spanNode.appendChild(textNode);
                hrefNode.appendChild(spanNode);
                figlioUl.appendChild(hrefNode);
                dataList.appendChild(figlioUl);

            }

        }
    }

    xmlHttpReq.open("GET", "RicercaAjax?ricerca=" + encodeURIComponent(str), true);
    xmlHttpReq.send();
}