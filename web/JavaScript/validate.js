function validate() {

    var email = document.getElementById("email").style.border = "100px solid #ccc";
    var pass = document.getElementsByName("password");
    var user = document.getElementsByName("username");




    if(email.value == ""){
        alert("riempire il campo email");
        email.focus();
        email.style.border = "3px solid #990033";
        return false;
    }
    if(pass.value == "" && pass.value.length <7){
        alert("riempire il campo password")
        email.
        pass.style.border    = "3px solid #990033";
        return false
    }
    if(user.value == "" && user.value.length <8 ){
        alert("riempire il campo username")

        user.style.border = "3px solid #990033";
        return false
}


}