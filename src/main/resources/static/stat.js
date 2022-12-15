document.getElementById("closeBtn").addEventListener("click", exitFn()=>{
window.location.replace("http://localhost:8080/userOptions?password=" + sessionStorage.getItem("userPassword") + "&email="+sessionStorage.getItem("userEmail"));
});

http://localhost:8080/userOptions?password=vaidas&email=vaidas@gmail.com
//
//function singleGameExit(e){
//    e.preventDefault();
//    if (sessionStorage.getItem("userEmail") == null){
//        window.location.replace("http://localhost:8080");
//    }
//    else {}
//}
