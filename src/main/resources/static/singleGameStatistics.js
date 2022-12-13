const queryURLString = window.location.search;
const urlParameters = new URLSearchParams(queryURLString);
var score = urlParameters.get('score');
var totalQ = urlParameters.get('totalQ');
var user = urlParameters.get('user');
console.log(" Score " + score);
console.log(" Total Questions " + totalQ);
console.log(" User " + user);

document.getElementById("resultInfo").textContent = score + " / " + totalQ;

document.getElementById("gameExitButton").addEventListener("click", singleGameExit);

function singleGameExit(e){
    e.preventDefault();
    if (!user){
        window.location.replace("http://localhost:8080");
    }
    else {window.location.replace("http://localhost:8080/userOptions?user="+user)}
}