var button = document.getElementById("view");
var button2 = document.getElementById("view2");
button.addEventListener("click", viewPending);
button.onclick = function(){
	button.style.display = "none"; 
	button2.style.display = "none";
}
button2.addEventListener("click", viewResolved);
button2.onclick = function(){
	button.style.display = "none";
	button2.style.display = "none"; 
}

function view1(response){
	var reim = JSON.parse(response.responseText);
	var table = document.getElementById("table");
	var page = document.getElementById("page");
	var back = document.getElementById("back");
	var h = document.getElementById("h");
	var row1 = table.insertRow(0);
	row1.insertCell(0).outerHTML = "<th><h4>Id</h4></th>";
	row1.insertCell(1).outerHTML = "<th><h4>Amount</h4></th>";
	row1.insertCell(2).outerHTML = "<th><h4>Description</h4></th>";
	row1.insertCell(3).outerHTML = "<th><h4>Submitted</h4></th>";
	row1.insertCell(4).outerHTML = "<th><h4>Resolved</h4></th>";
	row1.insertCell(5).outerHTML = "<th><h4>Type</h4></th>";
	row1.insertCell(6).outerHTML = "<th><h4>Status</h4></th>";
	back.innerHTML = "<a class='previous' href='ReimbursementRequest.jsp'><span aria-hidden='true'>&larr;</span> Previous</a>";
	h.innerHTML = "<h1><small>View Pending Reimbursements</small></h1>";
	page.innerHTML = "";
	for (var i = 0 ; i < reim.length ; i++){
		var row = table.insertRow(1);
		var cell0 = row.insertCell(0);
		var cell1 = row.insertCell(1);
		var cell2 = row.insertCell(2);
		var cell3 = row.insertCell(3);
		var cell4 = row.insertCell(4);
		var cell5 = row.insertCell(5);
		var cell6 = row.insertCell(6);
		cell0.innerHTML = reim[i].r_id;
		cell1.innerHTML = "$"+reim[i].amount;
		cell2.innerHTML = reim[i].description;
		cell3.innerHTML = new Date(reim[i].submitted).toLocaleDateString();
		cell4.innerHTML = "unresolved";
		cell5.innerHTML = reim[i].t_id.type;
		cell6.innerHTML = reim[i].s_id.status;
	}	
}
		
function viewPending(){
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			view1(this);
		}
	}
	request.open("GET", "http://localhost:8000/Project1/ViewPendingReimbursement",
			true);
	request.send();
	return request.responseText;
}

function view2(response){
	var reim = JSON.parse(response.responseText);
	var table = document.getElementById("table");
	var page = document.getElementById("page");
	var back = document.getElementById("back");
	var h = document.getElementById("h");
	var row1 = table.insertRow(0);
	row1.insertCell(0).outerHTML = "<th><h4>Id</h4></th>";
	row1.insertCell(1).outerHTML = "<th><h4>Amount</h4></th>";
	row1.insertCell(2).outerHTML = "<th><h4>Description</h4></th>";
	row1.insertCell(3).outerHTML = "<th><h4>Submitted</h4></th>";
	row1.insertCell(4).outerHTML = "<th><h4>Resolved</h4></th>";
	row1.insertCell(5).outerHTML = "<th><h4>Type</h4></th>";
	row1.insertCell(6).outerHTML = "<th><h4>Status</h4></th>";
	back.innerHTML = "<a class='previous' href='ReimbursementRequest.jsp'><span aria-hidden='true'>&larr;</span> Previous</a>";
	h.innerHTML = "<h1><small>View Resolved Reimbursements</small></h1>";
	page.innerHTML = "";
	for (var i = 0 ; i < reim.length ; i++){
		var row = table.insertRow(1);
		var cell0 = row.insertCell(0);
		var cell1 = row.insertCell(1);
		var cell2 = row.insertCell(2);
		var cell3 = row.insertCell(3);
		var cell4 = row.insertCell(4);
		var cell5 = row.insertCell(5);
		var cell6 = row.insertCell(6);
		cell0.innerHTML = reim[i].r_id;
		cell1.innerHTML = "$"+reim[i].amount;
		cell2.innerHTML = reim[i].description;
		cell3.innerHTML = new Date(reim[i].submitted).toLocaleDateString();
		cell4.innerHTML = new Date(reim[i].resolved).toLocaleDateString();
		cell5.innerHTML = reim[i].t_id.type;
		cell6.innerHTML = reim[i].s_id.status;
	}	
}
		
function viewResolved(){
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			view2(this);
		}
	}
	request.open("GET", "http://localhost:8000/Project1/ViewResolvedReimbursement",
			true);
	request.send();
	return request.responseText;
}