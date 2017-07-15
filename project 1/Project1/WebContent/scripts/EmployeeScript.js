var button = document.getElementById("view");
button.addEventListener("click", myInfo);
button.onclick = function(){
	button.style.display = "none";
}

function view(response){
	var user = JSON.parse(response.responseText);
	var page = document.getElementById("page");
	var back = document.getElementById("back");
	var h = document.getElementById("h");
	page.innerHTML = "<h3>Username:</h3>"+user.username+"<h3>Password:</h3>"+user.password+
	"<h3>First Name:</h3>"+user.firstName+"<h3>Last Name:</h3>"+user.lastName+"<h3>Email:</h3>"+user.email;
	back.innerHTML = "<a class='previous' href='employeeinfo.jsp'><span aria-hidden='true'>&larr;</span> Previous</a>";
	h.innerHTML = "<h1><small><span class='glyphicon glyphicon-user'></span> View Account Settings</small></h1>"
	
	
}
		
function myInfo(){
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			view(this);
		}
	}
	request.open("GET", "http://localhost:8000/Project1/EmployeeInfo",
			true);
	request.send();
	return request.responseText;
}