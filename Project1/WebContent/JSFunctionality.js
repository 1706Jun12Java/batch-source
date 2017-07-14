window.addEventListener("load", refresh);
function refresh() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			if (document.getElementById("r_requests") != null) {
				document.getElementById("r_requests").innerHTML = xhttp.responseText;
			}
		}
	};
	xhttp.open("GET", "http://localhost:8080/Project1/view", true);
	xhttp.send();
}

function signup() {
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

function update() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("message").innerHTML = xhttp.responseText;
		}
	};
	xhttp.open("POST", "http://localhost:8080/Project1/update", true);
	var mess = " {\"first\":\"" + document.getElementById("new").value
			+ "\",\"second\":\"" + document.getElementById("info").value
			+ "\"} ";
	xhttp.send(mess);
}

window.addEventListener("load", getInfo);
window.addEventListener("load", startGetInfo);
function startGetInfo() {
	setInterval(getInfo, 500);
}
function getInfo() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			if (document.getElementById("currNames") != null) {
				document.getElementById("currNames").innerHTML = xhttp.responseText;
			}
		}
	};
	xhttp.open("GET", "http://localhost:8080/Project1/update", true);
	xhttp.send();
}

function approveRequest() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			refresh();
		}
	};
	var options = document.getElementsByName("toResolve");
	for (var i = 0; i < options.length; i++) {
		if (options[i].checked) {
			var mess = " {\"value\":\"" + options[i].value + "\"} ";
			xhttp.open("POST", "http://localhost:8080/Project1/approve", true);
			xhttp.send(mess);
		}
	}

}

function rejectRequest() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			refresh();
		}
	};
	var options = document.getElementsByName("toResolve");
	for (var i = 0; i < options.length; i++) {
		if (options[i].checked) {
			var mess = " {\"value\":\"" + options[i].value + "\"} ";
			xhttp.open("POST", "http://localhost:8080/Project1/reject", true);
			xhttp.send(mess);
		}
	}

}

function search() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("r_requests").innerHTML = xhttp.responseText;
		}
	};
	xhttp.open("POST", "http://localhost:8080/Project1/search", true);
	var mess = " {\"first\":\"" + document.getElementById("searchText").value
			+ "\"} ";
	xhttp.send(mess);
}