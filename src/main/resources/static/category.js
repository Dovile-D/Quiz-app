document.getElementById("categorySelectButton").addEventListener("click", getCategory)
function getCategory(e) {
    let categorySelector = document.getElementsByName("category");
    for (let i of categorySelector) {
        if (i.checked) {
            selectedCategory = i.value;
            sessionStorage.setItem("categoryLevel", selectedCategory);
            console.log("categoryLevel = " + sessionStorage.getItem("categoryLevel"));
        }
    }

