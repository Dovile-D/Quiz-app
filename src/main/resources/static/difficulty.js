document.getElementById("difficultyButton").addEventListener("click", getDifficulty);
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