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
//document.getElementById("checkAndNextButton").addEventListener("click", checkAnswer);
document.querySelector("form[id=game-form]").addEventListener("submit", checkAnswer);

function checkAnswer(e) {
    e.preventDefault();
    // get selected input
    let answer = document.getElementsByName("answer");
    console.log(answer);
    const pathEl = document.getElementById("info");
    // check selected answer
    for (let i of answer) {
        if (i.checked) {
            // console.log(i.value);
            if (i.value == indexes[3]) {
                console.log("Correct");
                pathEl.style.color = "green";
                pathEl.textContent = "Correct!";
            }
            else {
                console.log("NOT correct");
                pathEl.style.color = "red";
                pathEl.textContent = "Incorrect! Correct answer: " + indexes[3];
            }
        }
    }

    // uncheck inputs after 5 seconds
    let x = indexes[3];
    setTimeout(() => { answer[x].checked = false }, 5000) // DOES NOT WORK

    // get new fetch - call setQuestionContent() again
}

function saveCorrectAnsertsToDB() {

    // save to db
}
