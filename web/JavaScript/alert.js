
// alert aggiunta prodotto/utente/categoria
function aggiunta() {
    var form=document.getElementById("add");
    if (form.checkValidity()){
    window.alert("Aggiunta avvenuta con successo!");}
}
// alert modifica prodotto/utente/categoria
function modifica() {
    var form=document.getElementById("updt");
        if (form.checkValidity()){
            window.alert("Modifica avvenuta con successo!");}
}
// alert rimozione prodotto/utente/categoria
function elimina() {
    var form=document.getElementById("updt");
    if (form.checkValidity()){
        window.alert("Rimozione avvenuta con successo!");}
}
//alert logout
function logout() {
    var form=document.getElementById("logOut");
    if (form.checkValidity()){
        window.alert("Logout!");}
}
