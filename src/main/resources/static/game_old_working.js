const url = 'https://the-trivia-api.com/api/questions?limit=1';
let correct = 0;

// Sets the array for the random indexes to put the answers to random labels
function shuffleArray(indexes) {
    indexes.sort(() => Math.random() - 0.5);
}
let indexes = [1, 2, 3, 4];
shuffleArray(indexes);


// fetch the data from API
function getQuestions() {
    fetch(url)
        .then((response) => {
            if (response.ok) {
                return response.json();
            }
            else {
                throw new Error("Network connection error: " + response);
            }
        })
        .then(data => {
            //assigning values to card elements
            document.querySelector("h4").textContent = data[0].question;
            document.querySelector("h6").textContent = "Category: " + data[0].category;
            document.getElementById(`answer${indexes[0]}`).textContent = data[0].incorrectAnswers[0];
            document.getElementById(`answer${indexes[1]}`).textContent = data[0].incorrectAnswers[1];
            document.getElementById(`answer${indexes[2]}`).textContent = data[0].incorrectAnswers[2];
            document.getElementById(`answer${indexes[3]}`).textContent = data[0].correctAnswer;
            // self check
            console.log("Correct answer " + indexes[3] + ": " + data[0].correctAnswer);

            //            return data;
        })
        .catch((error) => console.error("FETCH ERROR:", error));
}
getQuestions();
// function play() {
//     for (let i = 0; i < 5; i++) {
//         getQuestions();
//         checkAnswer();
//     }

//     console.log(correct);
// }


// Set the card content from the API response
function setQuestionContent(data) {

    /*
    *
    * Nežinau kaip padaryti iš fetch data normalų array, kurį būtų galima grąžinti
    * ir kurį būtų galima naudoti čia tam, kad
    * iš čia iškviesti fetch su startQuestioning() ir čia perkelti visus
    * document.querySelector("h5").textContent = data[0].question;
    * ir tt.
    *
    */

}

// Check if the answer is correct
//document.querySelector("button").addEventListener("submit", checkAnswer);
document.getElementById('.checkAndNextButton').addEventListener("click", checkAnswer);
//document.querySelector("form[id=game-form]").addEventListener("submit", checkAnswer);
//
//function checkAnswer(e) {
//    e.preventDefault();
//    // get selected input
//    let answer = document.getElementsByName("answer");
//    console.log(answer);
//    const pathEl = document.getElementById("info");
//    // check selected answer
//    for (let i of answer) {
//        if (i.checked) {
//            // console.log(i.value);
//            if (i.value == indexes[3]) {
//                console.log("Correct");
//                pathEl.style.color = "green";
//                pathEl.textContent = "Correct!";
//                correct++;
//            }
//            else {
//                console.log("NOT correct");
//                pathEl.style.color = "red";
//                pathEl.textContent = "Incorrect! Correct answer: " + indexes[3];
//            }
//        }
//    }
//
//    // uncheck inputs after 5 seconds
//    let x = indexes[3];
//    setTimeout(() => { answer[x].checked = false }, 5000) // DOES NOT WORK
//
//    // get new fetch - call setQuestionContent() again
//}

function saveCorrectAnsertsToDB() {

    // save to db
}
// --------------------------------------------------


// https://the-trivia-api.com/api/questions?categories=arts_and_literature&limit=1&difficulty=easy
//
//let correctAnswers = 0;
//let answeredQuestions = 0;
//let selectedDifficulty = "";
//let selectedCategory = "";
//let changedURL = "";
//
//// Global session variables
//var gameScore;
//var difficultyLevel;
//var categoryLevel;
//var totalAnsweredQuestions;
//
//const TOTAL_QUESTIONS = 5;
//const mainURL = 'https://the-trivia-api.com/api/questions?';
//const limitURL = "&limit=1";
//
//// sessionStorage.setItem("score", correctAnswers);
//console.log(sessionStorage.getItem("gameScore"));
//// correctAnswers++;
//// }
//
//selectedCategory = "categories=arts_and_literature";
//selectedDifficulty = "&difficulty=" + "easy"
//correctAnswers = sessionStorage.getItem("url");
//changedURL = mainURL + selectedCategory + limitURL + selectedDifficulty;
//sessionStorage.setItem("url", changedURL);
//console.log(changedURL);
//
//// document.getElementById
//// function difficultyLevel() { }
//
//
//
//// Sets the array for the random indexes to put the answers to random labels
//function shuffleArray(indexes) {
//    indexes.sort(() => Math.random() - 0.5);
//}
//let indexes = [1, 2, 3, 4];
//shuffleArray(indexes);
//
//startQuestioning()
//
//// fetch the data from API
//function startQuestioning() {
//    fetch(sessionStorage.getItem("url"))
//        .then((response) => {
//            if (response.ok) { return response.json(); }
//            else {
//                throw new Error("Network connection error: " + response);
//            }
//        })
//        .then(data => { setQuestionContent(data) })
//        .catch((error) => console.error("FETCH ERROR:", error));
//}
//document.querySelector("button").addEventListener("click", checkAnswer);
//// Set the card content from the API
//function setQuestionContent(data) {
//    if (sessionStorage.getItem("totalAnsweredQuestions") < TOTAL_QUESTIONS || (sessionStorage.getItem("totalAnsweredQuestions") == null)) {
//        document.querySelector("h5").textContent = data[0].question;
//        document.querySelector("h6").textContent = "Category: " + data[0].category +
//            ". Difficulty: " + data[0].difficulty +
//            "Question: " + sessionStorage.getItem("totalAnsweredQuestions") + " / " + TOTAL_QUESTIONS +
//            ". Correct answers: " + sessionStorage.getItem("gameScore");
//        document.getElementById(`answer${indexes[0]}`).textContent = data[0].incorrectAnswers[0];
//        document.getElementById(`answer${indexes[1]}`).textContent = data[0].incorrectAnswers[1];
//        document.getElementById(`answer${indexes[2]}`).textContent = data[0].incorrectAnswers[2];
//        document.getElementById(`answer${indexes[3]}`).textContent = data[0].correctAnswer;
//        // self check
//        console.log("Correct answer " + indexes[3] + ": " + data[0].correctAnswer);
//        // increment total  questions
//        answeredQuestions = sessionStorage.getItem("totalAnsweredQuestions")
//        answeredQuestions++;
//        sessionStorage.setItem("totalAnsweredQuestions", answeredQuestions);
//        console.log("Total answered: " + sessionStorage.getItem("totalAnsweredQuestions"));
//    } else {
//        for (let i = 0; i < 4; i++) {
//            document.getElementsByClassName("form-check")[i].style.display = "none";
//        }
//        document.getElementById("info").style.textAlign = "center";
//        document.getElementById("info").style.fontSize = "30px";
//        document.getElementById("info").style.fontWeight = "800";
//        document.getElementById("info").style.color = "#5ca4da";
//        document.getElementById("info").textContent = "Done!";
//        document.getElementById("checkAndNextButton").textContent = "See results ➡️";
//    }
//}
//
//// Check if the answer is correct
//function checkAnswer(e) {
//    e.preventDefault();
//    // get selected input
//    let answer = document.getElementsByName("answer");
//    console.log(answer);
//    const pathEl = document.getElementById("info")
//    // check selected answer
//    for (let i of answer) {
//        if (i.checked) {
//            // console.log(i.value);
//            if (i.value == indexes[3]) {
//                console.log("Correct");
//                pathEl.style.color = "green";
//                pathEl.textContent = "Correct!";
//                correctAnswers = sessionStorage.getItem("gameScore")
//                correctAnswers++;
//                sessionStorage.setItem("gameScore", correctAnswers);
//                // correct++;
//                // console.log(correct);
//            }
//            else {
//                // console.log("NOT correct");
//                pathEl.style.color = "red";
//                pathEl.textContent = "Incorrect! Correct answer: " + indexes[3] + " ";
//            }
//        }
//    }
//
//    // uncheck inputs after 5 seconds
//    let x = indexes[3];
//    //disable all inputs
//    setTimeout(() => { answer[x].checked = false }, 5000) // DOES NOT WORK
//
//    // get new fetch - call setQuestionContent() again
//    // return correct;
//}
//
//function saveCorrectAnswersToDB() {
//    // correct++;
//    // save to db
//}

