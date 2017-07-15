var login = document.getElementById('login');

function displayError(err,id){
	var error = document.getElementById(id);
	error.style.display = "block";
	error.innerHTML="<strong>Warning! </strong>"+err;
	setTimeout(function(){error.style.display="none"}, 3000);
}

function doLogin(resp){
	var result = JSON.parse(resp.responseText);
	console.log(result);
	if(result.error){
		displayError(result.error);
	}else{
		window.location.replace(result.redirect);
	}
}

login.onclick = function(){
	var url = "http://localhost:8080/ERSystem/master";
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if(username=="" || password==""){
		displayError("missing username/password.", "error");
	}else{
		var data = "username="+username+"&password="+password+"&destination=login";
		var xhttp = new XMLHttpRequest()
		|| new ActiveXObject("Microsoft.HTTPRequest");
		xhttp.onreadystatechange = function() {
			console.log(this.readyState);
			if (this.readyState == 4 && this.status == 200) {
				console.log(this.responseText);
				doLogin(this);
			}
		};
		xhttp.open("POST", url, true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send(data);
	}
}