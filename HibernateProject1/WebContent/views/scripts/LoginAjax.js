//function getXhrObject(){
//	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
//	return xhr;
//}

function sendAjaxGet(url, func){
	var xhttp = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhttp.open("GET", url, true);
	xhttp.send();
	return xhttp.responseText;
}

//function handleServerResponse() {
//	if(xhr.readyState == 4) {
//		if (xhr.status == 200) {
//			document.getElementById('login-error').innerHTML = xhr.responseText;
//		} else {
//			alert("AJAX call error. Please try again");
//		}
//	}
//}

//function displayLoginError(){
//	xhr = getXhrObject();
//	if (xhr!=null) {
//		var url = "login?errorMessage=" + document.getElementById('errorMessage-error').value;
//		xhr.open("POST", url, true);
//		xhr.send(null);
//		xhr.onreadystatechange = handleServerResponse;
//	}
//}
function helloWorld(){
	document.getElementById('sampleButton').addEventListener(
			"click", function(){
				sendAjaxGet("employee-profile", function(){document.getElementById('addHere').innerHTML = "helloWorld!!";});
			});
}

function getEmployeeName(xhttp){
//	var res = JSON.parse(xhttp);
//	var html = res.employeeFirstName;
//	var html = JSON.parse(xhttp.employeeFirstName);
//	var asdf = JSON.parse(xhttp.responseText);
	var res = xhttp.responseText;
	var asdf = res;
	console.log(asdf);
	document.getElementById("employeeLastName").innerHTML = asdf;
}
//function employeeName(){
////	document.getElementById("employeeLastName").innerHTML = sendAjaxGet("employee-profile", getEmployeeName);
////	sendAjaxGet("employee-profile", getEmployeeName);
//}

function asdf(xhttp){
//	var res = JSON.parse(xhttp);
	var html = xhttp.rAmount;
	
}

document.getElementById("rInfo").addEventListener(
		"click", function(xhttp){
//			var asdf = JSON.parse(xhttp.employeeRList);
//			var asdf = JSON.
			console.log(xhttp.employeeRList);
//			sendAjaxGet("employee-profile", function(xhttp){xhttp.asdf});
			

			
		});
function employeeReimbursementInfo(){
	
//	document.getElementById("rInfo").addEventListener(
//			"click", function(){
//				document.getElementById("addRInfoHere").innerHTML = sendAjaxGet("employee-profile", function(xhttp){xhttp.rAmount;});
//			});
	document.getElementById("");

}
window.onload = function() {
//	employeeName();
//	sendAjaxGet("employee-profile", getEmployeeName);
//	sendAjaxGet("localhost:8080/ERS/employee-profile", function(){console.log("asd");});
//	employeeReimbursementInfo();
//	helloWorld();
//	displayNewReimbursementRequestForm();
};

