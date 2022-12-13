// get category value
document.getElementById("categorySelectButton").addEventListener("click", getCategory)
//let window.categoryLevel;
function getCategory(e) {
    e.preventDefault();
    let categorySelector = document.getElementsByName("category");
    for (let i of categorySelector) {
        if (i.checked) {
            selectedCategory = i.value;
//            window.categoryLevel = i.value;
            sessionStorage.setItem("categoryLevel", selectedCategory);
            console.log("categoryLevel = " + sessionStorage.getItem("categoryLevel"));
        }
    }

    // make proper value for url

    switch (sessionStorage.getItem("categoryLevel")) {
        case 'arts': {
            sessionStorage.setItem("selectedCategory", 'categories=arts_and_literature');
            url.searchParams.append("categories", "arts_and_literature");
            break;
        }
        case 'film': {
            sessionStorage.setItem("selectedCategory", 'categories=film_and_tv'); break;
        }
        case 'food': {
            sessionStorage.setItem("selectedCategory", 'categories=food_and_drink'); break;
        }
        case 'general': {
            sessionStorage.setItem("selectedCategory", 'categories=general_knowledge'); break;
        }
        case 'geo': {
            sessionStorage.setItem("selectedCategory", 'categories=geography'); break;
        }
        case 'history': {
            sessionStorage.setItem("selectedCategory", 'categories=history'); break;
        }
        case 'music': {
            sessionStorage.setItem("selectedCategory", 'categories=music'); break;
        }
        case 'science': {
            sessionStorage.setItem("selectedCategory", 'categories=science'); break;
        }
        case 'society': {
            sessionStorage.setItem("selectedCategory", 'categories=society_and_culture'); break;
        }
        case 'sport': {
            sessionStorage.setItem("selectedCategory", 'categories=sport_and_leisure'); break;
        }
        default: {
            sessionStorage.setItem("selectedCategory", 'categories=arts_and_literature'); break;
        }
    }
    console.log("selectedCategory for url is " + sessionStorage.getItem('selectedCategory'));
//    window.location.href = "./selectDifficulty.html"

}

