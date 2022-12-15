// reikia parsitempti varda  emaila  ir  paveiksliuka

var userID;
var userName;
//var userAvatar;

//getUrlParam
document.getElementById("loginBtn").addEventListener("click", setValues);

function setValues(){
//    e.preventDefault();
    let userOnLogin = document.getElementById("user").value
    sessionStorage.setItem("userName", userOnLogin);
    sessionStorage.setItem("userID","5");
    console.log("LoginB: userName: " + sessionStorage.getItem("userName"));
    console.log("LoginB: userID: " + sessionStorage.getItem("userID"));
}