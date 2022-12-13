//const queryString = window.location.search;
//console.log(queryString);
//const urlParams = new URLSearchParams(queryString);
// console.log(urlParams.has('categories'));
//console.log("categoryLevel = " + window.categoryLevel);

document.getElementById("difficultyButton").addEventListener("click", getDifficulty);
//document.getElementsByName("input").addEventListener("submit", getDifficulty);

function getDifficulty(e) {
    e.preventDefault();
    let difficultySelector = document.getElementsByName("difficulty");
    for (let i of difficultySelector) {
        if (i.checked) {
//            selectedDifficulty = i.value;
//            sessionStorage.setItem("difficultyLevel", selectedDifficulty);
//            console.log(sessionStorage.getItem("difficultyLevel"));
                //---
                const queryString = window.location.search;
                console.log(queryString);
                const urlParams = new URLSearchParams(queryString);
                const cat = urlParams.get('categories')
                window.location.replace("http://localhost:8080/playGame?categories="+cat+"&difficulty=" + i.value);
        }
    }
//    window.location = location.href + "&categories=arts_and_literature";
//    url.searchParams.append('x', 42);


//on load:               http://localhost:8080/difficulty?categories=film_and_tv
//selecting with button: http://localhost:8080/difficulty?categories=film_and_tv
//console.log(window.location.href);

//let paramString = urlString.split('?')[1];
//let queryString = new URLSearchParams(paramString);

//const queryString = window.location.search;
//console.log(queryString);
//const urlParams = new URLSearchParams(queryString);
//const cat = urlParams.get('categories')
//window.location.replace("http://localhost:8080/playGame?categories="+cat+"&difficulty=" + sessionStorage.getItem("difficultyLevel"));

//setTimeout(() =>{
//window.location.replace("http://localhost:8080/" + "&categories="+sessionStorage.getItem("categoryLevel")+ "&difficulty=" +sessionStorage.getItem("difficultyLevel"));
//console.log("difficulty=" +sessionStorage.getItem("difficultyLevel"));
//window.location.replace("http://localhost:8080/playGame?categories="+cat+"&difficulty=" +sessionStorage.getItem("difficultyLevel"));
//}, 3000
//)

//http://localhost:8080/playGame?categories=geography&difficulty=medium

//console.log("category: " + cat);
//console.log("difficulty: " + sessionStorage.getItem("difficultyLevel"));

//for (let pair of queryString.entries()) {
//   console.log("Key is: " + pair[0]);
//   console.log("Value is: " + pair[1]);
//}

//http://localhost:8080/difficulty?categories=general_knowledge



// http://localhost:8080/playGame?categories=geography&difficulty=medium
//[Log] http://localhost:8080/difficulty?categories=general_knowledge (difficulty.js, line 28)
//[Log] &categories=null&difficulty=medium (difficulty.js, line 31)
//window.location.replace(window.location.href + "&difficulty=" +sessionStorage.getItem("difficultyLevel"));
//http://localhost:8080/difficulty?categories=film_and_tv
//http://localhost:8080/difficulty?categories=film_and_tv&difficulty=medium


//    switch (sessionStorage.getItem("difficultyLevel")) {
//        case '1': {
//            sessionStorage.setItem("selectedDifficulty", '&difficulty=easy'); break;
//        }
//        case '2': {
//            sessionStorage.setItem("selectedDifficulty", '&difficulty=medium'); break;
//        }
//        case '3': {
//            sessionStorage.setItem("selectedDifficulty", '&difficulty=hard'); break;
//        }
//        default: {
//            sessionStorage.setItem("selectedDifficulty", '&difficulty=easy'); break;
//        }
//    }
}
