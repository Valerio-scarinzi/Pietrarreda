var borderOK='3px solid #e79213';
var borderNO='3px solid #c80009';
var emailOK=false;
var usernameOK=false;
var passOK=false;

function validaLEmail() {
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    var email=document.getElementById("email").value;

    if(reg.test(email)===false){
        document.forms['login']['email'].style.border=borderNO;
        emailOK=false;
    }else{
        document.forms['login']['email'].style.border=borderOK;
        emailOK=true;}
    abilitaLogin();
}

function validaLUsername() {
if(document.getElementById("username").value ===""){
    document.forms['login']['username'].style.border=borderNO;
usernameOK=false;
}
else{
    document.forms['login']['username'].style.border=borderOK;
    usernameOK=true;
}
abilitaLogin();
}

function validaLPassword() {
    var password=document.getElementById("password").value;
    if(password.length >= 8 && password.toUpperCase() !== password //la password deve essere con almeno 8 caratteri,includere in CAP e minuscole,e numeri.
        && password.toLowerCase() !== password && /[0-9]/.test(password)){
            document.forms['login']['password'].style.border = borderOK;
            passOK=true;
        }
    else{
        document.forms['login']['password'].style.border = borderNO;
        passOK=false;
    }
    abilitaLogin();

}



function abilitaLogin() {
    if(emailOK===true && usernameOK===true && passOK===true){
        document.getElementById('loggami').disabled = false;
        document.getElementById('loggami').style.border=borderOK;
    }
    else{
        document.getElementById('loggami').disabled = true;
        document.getElementById('loggami').style.border=borderNO;
    }
}