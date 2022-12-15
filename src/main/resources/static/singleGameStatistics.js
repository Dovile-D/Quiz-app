const queryURLString = window.location.search;
const urlParameters = new URLSearchParams(queryURLString);
var score = urlParameters.get('score');
var totalQ = urlParameters.get('totalQ');
var user = urlParameters.get('user');

if (sessionStorage.getItem("userID") != null) {
document.getElementById("card-title").textContent = "Amazing, " +sessionStorage.getItem("userName")+ "!"
}
else {}

//document.getElementById("resultInfo").textContent = score;
let result = Math.round(sessionStorage.getItem("gameScore") / 2);
document.getElementById("resultInfo").textContent = result;
//+ " / " + totalQ;

document.getElementById("gameExitButton").addEventListener("click", singleGameExit);

function singleGameExit(e){
    e.preventDefault();
    if (sessionStorage.getItem("userEmail") == null){
        window.location.replace("http://localhost:8080");
    }
    else {window.location.replace("http://localhost:8080/userOptions?password=" + sessionStorage.getItem("userPassword") + "&email="+sessionStorage.getItem("userEmail"))}
}
