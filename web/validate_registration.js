var passOK=false;
var emailOK=false;
var nomeOK=false;
var nome2OK=false;
var usernameOK=false;
var borderOK='3px solid #e79213';
var borderPass='3px solid #9de700';
var borderNO='3px solid #c80009';

function validaRNome() {
    var nome=document.forms['registrazione']['nome'].value;
    if(nome.length<=1){
        document.forms['registrazione']['nome'].style.border=borderNO;
        nomeOK=false;
    }
    else{
        document.forms['registrazione']['nome'].style.border=borderOK;
        nomeOK=true;
    }
   abilitaRegistrazione();
}

function validaRCognome() {
   if(document.getElementById("cognome").value.length<=3){
       document.forms['registrazione']['cognome'].style.border=borderNO;
       nome2OK=false;
   }
   else {
       document.forms['registrazione']['cognome'].style.border=borderOK;
       nome2OK=true;
   }
   abilitaRegistrazione();

}

function validaRUsername() {
    if(document.getElementById("username").value ===""){
        document.forms['registrazione']['username'].style.border=borderNO;
        usernameOK=false;
    }
    else{
        document.forms['registrazione']['username'].style.border=borderOK;
        usernameOK=true;
    }
    abilitaRegistrazione();

}

function validaREmail(){
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    var email=document.getElementById("email").value;
    if(reg.test(email)===false){
        document.forms['registrazione']['email'].style.border=borderNO;
        emailOK=false;
    }else{
        document.forms['registrazione']['email'].style.border=borderOK;
        emailOK=true;
    }
    abilitaRegistrazione();
}

function validacPassword() {
    var password=document.getElementById("password").value;
    var cpass=document.getElementById("cpassword").value;

    if(password.length >= 8 && password.toUpperCase() !== password //la password deve essere con almeno 8 caratteri,includere in CAP e minuscole,e numeri.
        && password.toLowerCase() !== password && /[0-9]/.test(password)){
        document.forms['registrazione']['password'].style.border=borderPass;
        if(password===cpass){
            document.forms['registrazione']['password'].style.border = borderOK;
            document.forms['registrazione']['cpassword'].style.border = borderOK;
            passOK=true;
    }}
   else{
        document.forms['registrazione']['password'].style.border = borderNO;
        document.forms['registrazione']['cpassword'].style.border = borderNO;
        passOK=false;
    }
    abilitaRegistrazione();
}

function abilitaRegistrazione() {
    if(passOK===true && emailOK===true && nomeOK===true && nome2OK===true && usernameOK===true){
        document.getElementById('registrami').disabled = false;
        document.getElementById('registrami').style.border=borderOK;
    }
    else
    { document.getElementById('registrami').style.border=borderNO;
        document.getElementById('registrami').disabled = true;

    }

}