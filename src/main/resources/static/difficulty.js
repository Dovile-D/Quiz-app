//const queryString = window.location.search;
//console.log(queryString);
//const urlParams = new URLSearchParams(queryString);
// console.log(urlParams.has('categories'));
//console.log("categoryLevel = " + window.categoryLevel);

document.getElementById("difficultyButton").addEventListener("click", getDifficulty);
//document.getElementsByName("input").addEventListener("submit", getDifficulty);
//var userName;
function getDifficulty(e) {
    e.preventDefault();
    let difficultySelector = document.getElementsByName("difficulty");
    for (let i of difficultySelector) {
        if (i.checked) {
                const queryString = window.location.search;
                const urlParams = new URLSearchParams(queryString);
                const cat = urlParams.get('categories')

                sessionStorage.setItem("difficultyLevel", i.value);
                window.location.replace("http://localhost:8080/playGame?categories="+cat+"&difficulty=" + i.value);
        }
    }
    }