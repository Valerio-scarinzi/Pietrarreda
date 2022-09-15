var thumb_count;
var thumb_current = 1; // BLOCCO DI PARTENZA
var thumb_number = 4; // NUMERO DI BLOCCHI DI THUMB
function thumb_move(where)
{
    // DECREMENTO E CAMBIO IMMAGINE PER LO SCORRIMENTO A SINISTRA
    if (where == "left")
    {
        if (thumb_current > 1) thumb_current--;
        if (thumb_current == 1) document.getElementById("thumb_img_left").src = "thumb_img_left_no.png";
        if (thumb_current < thumb_number) document.getElementById("thumb_img_right").src = "thumb_img_right.png";
    }
    // INCREMENTO E CAMBIO IMMAGINE PER LO SCORRIMENTO A DESTRA
    else
    {
        if (thumb_current < thumb_number) thumb_current++;
        document.getElementById("thumb_img_left").src = "thumb_img_left.png";
        if (thumb_current == thumb_number) document.getElementById("thumb_img_right").src = "thumb_img_right_no.png";
    }
    // CAMBIO DEL BLOCCO DI THUMB DA VISUALIZZARE
    if (thumb_current <= thumb_number)
    {
        for (thumb_count=1; thumb_count<thumb_number+1; thumb_count++)
        {
            document.getElementById("thumb_item_" + thumb_count).className = "thumb_hide";
            if (thumb_count == thumb_current) document.getElementById("thumb_item_" + thumb_count).className = "thumb_show";
        }
    }
}