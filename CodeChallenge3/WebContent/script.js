"use strict";
var button = document.getElementById("button");
function doUpdate(resp){
	var employees = JSON.parse(resp.responseText);
	for(var i = 0; i < employees.length; i++){
		var table = document.getElementById("results");
		var row = table.insertRow(1);
		var cell1 = row.insertCell(0);
	    var cell2 = row.insertCell(1);
	    cell1.innerHTML=employees[i].name;
	    cell2.innerHTML=employees[i].email;
	}
};

function onButtonClick(){
	var req = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	req.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			doUpdate(this);
		}
	};
	req.open("GET", "http://localhost:8080/CodeChallenge3/codechallenge", true);
	req.send();
	return req.responseText;
};

function doPost(resp){
	console.log(resp);
	document.getElementById("dopost").innerHTML = resp.responseText;
}

function onSubmit(){
	var req = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	req.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			doPost(this);
		}
	};
	req.open("POST", "http://localhost:8080/CodeChallenge3/codechallenge", true);
	req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	req.send("name="+encodeURIComponent(name)+"&email="+encodeURIComponent(email));
}

var but2 = document.getElementById("postData");
button.addEventListener("click", onButtonClick);
but2.addEventListener("click", onSubmit);