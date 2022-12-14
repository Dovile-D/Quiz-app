const queryString = window.location.search;
console.log(queryString);
const urlParams = new URLSearchParams(queryString);
 console.log(urlParams.has('categories'));
//console.log("categoryLevel = " + window.categoryLevel);
// window.location = location.href += "&qa=newParam";

document.getElementById("difficultyButton").addEventListener("click", getDifficulty());
//document.getElementsByName("input").addEventListener("submit", getDifficulty);

function getDifficulty(e) {
    e.preventDefault();


    let difficultySelector = document.getElementsByName("difficulty");
    for (let i of difficultySelector) {
        if (i.checked) {
            selectedDifficulty = i.value;
            sessionStorage.setItem("difficultyLevel", selectedDifficulty);
            console.log(sessionStorage.getItem("difficultyLevel"));
        }
    }

    switch (sessionStorage.getItem("difficultyLevel")) {
        case '1': {
            sessionStorage.setItem("selectedDifficulty", '&difficulty=easy'); break;
        }
        case '2': {
            sessionStorage.setItem("selectedDifficulty", '&difficulty=medium'); break;
        }
        case '3': {
            sessionStorage.setItem("selectedDifficulty", '&difficulty=hard'); break;
        }
        default: {
            sessionStorage.setItem("selectedDifficulty", '&difficulty=easy'); break;
        }
    }
}
