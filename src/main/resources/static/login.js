// reikia parsitempti varda  emaila  ir  paveiksliuka

var userID;
var userName;
var userEmail;
var userPassword;
//var userAvatar;

console.log(window.performance.getEntriesByType("navigation"));


if (window.location.pathname == "/registered"){
document.getElementById("regSuccess").textContent="Registration successful! Please log-in:";
document.getElementById("regSuccess").style.color="white";
document.getElementById("regSuccess").style.backgroundColor="#5ca4da";
} else if(window.location.pathname == "/userOptions"){
document.getElementById("regSuccess").textContent="Wrong credentials, try again";
document.getElementById("regSuccess").style.color="white";
document.getElementById("regSuccess").style.backgroundColor="red";
}
 else {document.getElementById("regSuccess").style.display = "none"}

document.getElementById("loginBtn").addEventListener("click", setValues);
function setValues(){
    let userOnLogin = document.getElementById("userEmail").value
    sessionStorage.setItem("userEmail", userOnLogin);
    let passOnLogin = document.getElementById("password").value
    sessionStorage.setItem("userPassword", passOnLogin);
    let nameGetter = userOnLogin.split("@")[0]
    let firstLetter = nameGetter.charAt(0)
    let firstLetterCap = firstLetter.toUpperCase()
    let remainingLetters = nameGetter.slice(1)
    let capitalizedName = firstLetterCap + remainingLetters
    sessionStorage.setItem("userName", capitalizedName);
//    sessionStorage.setItem("userID","5");
}