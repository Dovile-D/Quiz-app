window.onload = function (){
document.getElementById("closeBtn").addEventListener("click", exitFn);
}

function exitFn(e){
e.preventDefault();
const redURL = "http://localhost:8080/userOptions?email="+sessionStorage.getItem("userEmail")+"&password="+sessionStorage.getItem("userPassword");
console.log(redURL);
window.location.replace(redURL);
};