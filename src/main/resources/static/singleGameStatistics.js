document.getElementById("singleScore").textContent = sessionStorage.getItem("gameScore") + " / " + sessionStorage.getItem("totalAnsweredQuestions");

document.getElementById("closeSingleStatistics", resetParams);

function resetParams(e) {
    e.preventDefault();
    sessionStorage.setItem("gameScore", null);
    sessionStorage.setItem("totalAnsweredQuestions", null);
}