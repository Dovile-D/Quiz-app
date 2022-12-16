const queryURString = window.location.search;
const urlParameters1 = new URLSearchParams(queryURString);
var score = urlParameters1.get('score');
var user = urlParameters1.get('user');

if (sessionStorage.getItem("userID") != null) {
document.getElementById("card-title").textContent = "Amazing, " +sessionStorage.getItem("userName")+ "!"
}
else {}

let result = sessionStorage.getItem("gameScore");
document.getElementById("resultInfo").textContent = result;

document.getElementById("gameExitButton").addEventListener("click", singleGameExit);
function singleGameExit(e){
    e.preventDefault();
    if (sessionStorage.getItem("userEmail") == null){
        window.location.replace("http://localhost:8080");
    }
    else {window.location.replace("http://localhost:8080/userOptions?password=" + sessionStorage.getItem("userPassword") + "&email="+sessionStorage.getItem("userEmail"))}
}
