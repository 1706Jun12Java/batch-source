function getReq() {
	var xhttp = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("code").innerHTML = xhr.responseText;
			var resp = JSON.parse(xhr.responseText);
			var arr = Object.keys(resp);
		}
	}
	xhttp.open("GET", "http://localhost:8080/CodeChallenge/main", true);
	xhttp.send();
};
function postResp() {
	var xhttp = new XMLHttpRequest()|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("code").innerHTML = xhr.responseText;
		}
	}
	xhttp.open("POST", "http://localhost:8080/CodeChallenge/main", true);
	xhttp.send(JSON.stringify(data));
};