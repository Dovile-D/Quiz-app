//console.log(queryString)
// https://the-trivia-api.com/api/questions?categories=arts_and_literature&limit=1&difficulty=easy

var correct;
var answeredQuestions;
var selectedDifficulty = "";
var selectedCategory = "";
var changedURL = "";

// Global session variablesexport 
var gameScore;
var difficultyLevel;
var categoryLevel;
var totalAnsweredQuestions;

var TOTAL_QEUSTIONS = 10;
// sessionStorage.setItem("totalAnsweredQuestions", answeredQuestions);

// URL constructor
var mainURL = 'https://the-trivia-api.com/api/questions?';
var limitURL = "&limit=1";
changedURL = mainURL + sessionStorage.getItem("selectedCategory") +
    limitURL + sessionStorage.getItem("selectedDifficulty");
sessionStorage.setItem("url", changedURL);

getQuestions();

// document.getElementById("seeResultsBttn").style.disabled = true;

// Sets the array for the random indexes to put the answers to random labels
function shuffleArray(indexes) {
    indexes.sort(() => Math.random() - 0.5);
}
var indexes = [1, 2, 3, 4];
shuffleArray(indexes);

// fetch the data from API
function getQuestions() {
    document.getElementById("seeResultsBttn").disabled = true;
    if (sessionStorage.getItem("totalAnsweredQuestions") < TOTAL_QEUSTIONS || (sessionStorage.getItem("totalAnsweredQuestions") == 0)) {
        fetch(sessionStorage.getItem("url"))
            .then((response) => {
                if (response.ok) { return response.json(); }
                else {
                    throw new Error("Network connection error: " + response);
                }
            })
            .then(data => { setQuestionContent(data) })
            .catch((error) => console.error("FETCH ERROR:", error));
    } else { lastQuestionAnswered() }
}

// Set the card content from the API
function setQuestionContent(data) {
    // if (sessionStorage.getItem("totalAnsweredQuestions") < TOTAL_QEUSTIONS || (sessionStorage.getItem("totalAnsweredQuestions") == 0)) {
    document.querySelector("h5").textContent = data[0].question;
    document.querySelector("h6").textContent = "Category: " + data[0].category +
        ". Difficulty: " + data[0].difficulty +
        ".\n  Question: " + sessionStorage.getItem("totalAnsweredQuestions") + " / " + TOTAL_QEUSTIONS;
    // +". Correct answers: " + sessionStorage.getItem("gameScore");
    document.getElementById(`answer${indexes[0]}`).textContent = data[0].incorrectAnswers[0];
    document.getElementById(`answer${indexes[1]}`).textContent = data[0].incorrectAnswers[1];
    document.getElementById(`answer${indexes[2]}`).textContent = data[0].incorrectAnswers[2];
    document.getElementById(`answer${indexes[3]}`).textContent = data[0].correctAnswer;
    // self check
    console.log("Correct answer " + indexes[3] + ": " + data[0].correctAnswer);
    // increment total questions
    answeredQuestions = sessionStorage.getItem("totalAnsweredQuestions")
    answeredQuestions++;
    sessionStorage.setItem("totalAnsweredQuestions", answeredQuestions);
    // console.log("Total answered: " + sessionStorage.getItem("totalAnsweredQuestions"));
    // } else { }
}

document.querySelector("button[id=checkAndNextButton]").addEventListener("click", checkAnswer);

// Check if the answer is correct    
function checkAnswer(e) {
    e.preventDefault();
    // get selected input
    let answer = document.getElementsByName("answer");
    console.log(answer);
    const pathEl = document.getElementById("info")
    // check selected answer
    for (let i of answer) { i.disabled = true; }
    for (let i of answer) {
        if (i.checked) {
            if (i.value == indexes[3]) {
                console.log("Correct");
                pathEl.style.color = "green";
                pathEl.textContent = "Correct!";
                correct = sessionStorage.getItem("gameScore");
                correct++;
                sessionStorage.setItem("gameScore", correct);
                console.log(sessionStorage.getItem("gameScore"));
            } else {
                pathEl.style.color = "red";
                pathEl.textContent = "Incorrect! Correct answer: " + indexes[3] + " ";
            }
        }
    }
    setTimeout(() => {
        history.go(0)
    }, 2000);
}

function sendData() {
    let data = new URLSearchParams();
    // {
    //     // (A1) DATA
    //     data.append("category", "Jon Doe");
    //     data.append("difficulty", "jon@doe.com");
    // }
    // // (A2) FETCH
    // fetch("http://127.0.0.1:5500/userOptions", { method: "post", body: data })
    //     .then(res => res.text())
    //     .then(txt => console.log(txt))
    //     .catch(err => console.log(error));
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
    document.getElementById("seeResultsBttn").style.display = "inline-block";
    console.log(sessionStorage.getItem("gameScore") + " / " + TOTAL_QEUSTIONS);
    sendData();
}


function displayResults() {
    document.getElementById("singleScore").textContent = sessionStorage.getItem("gameScore") + " / " + TOTAL_QEUSTIONS;
    // document.getElementById("singleScore").textContent = result + " / " + TOTAL_QEUSTIONS;

}

