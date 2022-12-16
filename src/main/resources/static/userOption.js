document.getElementById("userStatsBttn").addEventListener("click", redirectToStats);

function redirectToStats(e){
e.preventDefault();
const redirectURL = "http://localhost:8080/statistics?&email=" + sessionStorage.getItem("userEmail");
console.log(redirectURL);
    window.location.replace(redirectURL);
}

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
