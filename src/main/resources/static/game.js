// Temporary variables
var correct;
var answeredQuestions;
var selectedDifficulty = "";
var selectedCategory = "";
var gameUrlApiFetch = "";

// Global session variables
var TOTAL_QUESTIONS = 20;

// Getting user selected parameters
const queryURLString = window.location.search;
const urlParameters = new URLSearchParams(queryURLString);
var category = urlParameters.get('categories');
var difficulty = urlParameters.get('difficulty');

// URL for API fetch constructor
// API URL example with parameters :
// https://the-trivia-api.com/api/questions?categories=arts_and_literature&limit=1&difficulty=easy
var mainURL = 'https://the-trivia-api.com/api/questions?categories=';
var interimParam = "&limit=1&difficulty=";
gameUrlApiFetch = mainURL + category + interimParam + difficulty;

// Initial call to load question and answers
    if (
    (sessionStorage.getItem("totalAnsweredQuestions") == null) ||
    (sessionStorage.getItem("totalAnsweredQuestions") < TOTAL_QUESTIONS))
//if (sessionStorage.getItem("totalAnsweredQuestions") == null)
{getQuestions();}
 else { lastQuestionAnswered(); }

// Sets the array for the random indexes to put the answers to random labels
function shuffleArray(indexes) {
    indexes.sort(() => Math.random() - 0.5);
}
var indexes = [1, 2, 3, 4];
shuffleArray(indexes);

// fetch the data from API
function getQuestions() {
    document.getElementById("seeResultsBttn").style.disabled = true;
    document.getElementById("seeResultsBttn").style.display = "none";
            fetch(gameUrlApiFetch)
            .then((response) => {
                if (response.ok) { return response.json(); }
                else {throw new Error("Network connection error: " + response);}})
            .then(data => { setQuestionContent(data) ; console.log(" "+sessionStorage.getItem("totalAnsweredQuestions"));})
            .catch((error) => console.error("FETCH ERROR:", error));}

// Set the card content from the API
function setQuestionContent(data) {
    // Set question and related info
    document.querySelector("h5").textContent = data[0].question;
    document.querySelector("h6").textContent = "Category: " + data[0].category + ". Difficulty: " + data[0].difficulty;
    document.getElementById(`answer${indexes[0]}`).textContent = data[0].incorrectAnswers[0];
    document.getElementById(`answer${indexes[1]}`).textContent = data[0].incorrectAnswers[1];
    document.getElementById(`answer${indexes[2]}`).textContent = data[0].incorrectAnswers[2];
    document.getElementById(`answer${indexes[3]}`).textContent = data[0].correctAnswer;
    // self check
    console.log("Correct answer " + indexes[3] + ": " + data[0].correctAnswer);}

// Check if the answer is correct
document.querySelector("button[id=checkAndNextButton]").addEventListener("click", checkAnswer);
function checkAnswer(e) {
    e.preventDefault();
        answeredQuestions = sessionStorage.getItem("totalAnsweredQuestions");
        answeredQuestions++;
        sessionStorage.setItem("totalAnsweredQuestions", answeredQuestions);
    // get selected input
    let answer = document.getElementsByName("answer");
    const pathEl = document.getElementById("info")
    // check selected answer and show to user if it was correct
    for (let i of answer) { i.disabled = true; }
    for (let i of answer) {
        if (i.checked) {
            if (i.value == indexes[3]) {
                document.body.style.background = "green";
                pathEl.style.color = "green";
                pathEl.textContent = "Correct!";
                correct = sessionStorage.getItem("gameScore");
                correct++;
                sessionStorage.setItem("gameScore", correct);
                Math.round(sessionStorage.getItem("gameScore") / 2)
            } else {
                document.body.style.background = "red";
                let incorrect = sessionStorage.getItem("incorrectAnswers");
                incorrect++;
                sessionStorage.setItem("incorrectAnswers", incorrect);
                pathEl.style.color = "red";
                pathEl.textContent = "Incorrect! Correct answer: " + indexes[3];
            }}}
    // reloads page to itself after 2 seconds after the answer correctness is showed to a user
    setTimeout(() => {
        location.reload();
    }, 2000);
}

function lastQuestionAnswered() {
    for (let i = 0; i < 4; i++) {
        document.getElementsByClassName("form-check")[i].style.display = "none";
    }
    document.getElementById("info").style.textAlign = "center";
    document.getElementById("info").style.fontSize = "30px";
    document.getElementById("info").style.fontWeight = "800";
    document.getElementById("info").style.color = "#5ca4da";
    document.getElementById("info").textContent = "Done!";
    document.getElementById("checkAndNextButton").style.disabled = true;
    document.getElementById("checkAndNextButton").style.display = "none";
    document.getElementById("seeResultsBttn").style.disabled = false;
    document.getElementById("seeResultsBttn").style.display = "inline-block";
}

document.getElementById("seeResultsBttn").addEventListener("click", redirect);
 function redirect(e){
    e.preventDefault();
    var lastUrl = "http://localhost:8080/singleGameStatistics?categories="+category+"&difficulty=" + difficulty + "&score=" + Math.round(sessionStorage.getItem("gameScore") / 2) + "&user=" + sessionStorage.getItem("userID") ;
    window.location.replace(lastUrl);
    }
