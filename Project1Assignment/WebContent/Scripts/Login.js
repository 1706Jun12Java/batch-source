/**
 * 
 */
var loginbtn = document.getElementById("loginbtn");
loginbtn.addEventListener("click",function(){
	sendLoginRequest("http://localhost:8080/Project1Assignment/default?id=0",onLogin);
});
function sendLoginRequest(url, func){
    var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200){
            func(this);
        }
    }
    xhr.open("POST", url, true); 
    xhr.send(document.getElementById("username").value + "\n" + document.getElementById("password").value);
}


function onLogin(xhr){
	var response = xhr.responseText;
	var array = response.split("\n");
	if(array[0].trim() === "success"){
		window.location = array[1].trim();
	}else{
		alert(array[1]);
	}
}