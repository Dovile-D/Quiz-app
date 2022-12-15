const queryURLString = window.location.search;
const urlParameters = new URLSearchParams(queryURLString);
var score = urlParameters.get('score');
var totalQ = urlParameters.get('totalQ');
var user = urlParameters.get('user');
//console.log(" Score " + score);
//console.log(" Total Questions " + totalQ);
//console.log(" User " + user);

//document.getElementById("resultInfo").textContent = score;
let result = Math.round(sessionStorage.getItem("gameScore") / 2);
document.getElementById("resultInfo").textContent = result;
//+ " / " + totalQ;

document.getElementById("gameExitButton").addEventListener("click", singleGameExit);

function singleGameExit(e){
    e.preventDefault();
    if (sessionStorage.getItem("userID") == null){
        window.location.replace("http://localhost:8080");
    }
    else {window.location.replace("http://localhost:8080/userOptions?user="+sessionStorage.getItem("userID"))}
}
