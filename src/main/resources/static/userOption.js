
//let pic = sessionStorage.getItem("userAvatar");
//document.getElementById("avatar").src=pic;
//document.getElementById("avatar").src=sessionStorage.getItem("userName");

//console.log("UO: Avatar: " + sessionStorage.getItem("userAvatar"));
console.log("UO: Name: " + sessionStorage.getItem("userName"));
document.getElementById("card-title").textContent = "Let's roll, " + sessionStorage.getItem("userName") + "!";
document.getElementById("logoutBtn").addEventListener("click", resetUser);

function resetUser(e){
e.preventDefault();
sessionStorage.removeItem("userName");
sessionStorage.removeItem("userEmail");
sessionStorage.removeItem("userID");
sessionStorage.removeItem("gameScore");
sessionStorage.removeItem("difficultyLevel");
sessionStorage.removeItem("incorrectAnswers");
sessionStorage.removeItem("totalAnsweredQuestions");
sessionStorage.removeItem("userPassword");
window.location.replace("http://localhost:8080/");
}
