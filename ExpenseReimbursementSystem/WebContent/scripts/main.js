function login() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("message").innerHTML = xhttp.responseText;
		}
	};
	xhttp.open("POST", "http://localhost:8080/Project1/signup", true);
	var mess = " {\"email\":\"" + document.getElementById("email").value
			+ "\",\"password\":\"" + document.getElementById("pass").value
			+ "\",\"firstname\":\"" + document.getElementById("fname").value
			+ "\",\"lastname\":\"" + document.getElementById("lname").value
			+ "\",\"role\":\"" + document.getElementById("role").value + "\"} ";
	xhttp.send(mess);
}