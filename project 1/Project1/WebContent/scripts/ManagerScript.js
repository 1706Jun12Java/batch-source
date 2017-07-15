	var button = document.getElementById("view");
	button.addEventListener("click", view);
	

	function find(response) {
		var table = document.getElementById("table");
		var page = document.getElementById("page");
		var back = document.getElementById("back");
		var back2 = document.getElementById("back2");
		var h = document.getElementById("h");
		var employees = JSON.parse(response.responseText);
		var row1 = table.insertRow(0);
		row1.insertCell(0).outerHTML = "<th>Usernames</th>";
		row1.insertCell(1).outerHTML = "<th>First Name</th>";
		row1.insertCell(2).outerHTML = "<th>Last Name</th>";
		row1.insertCell(3).outerHTML = "<th>Email</th>";
		back2.innerHTML = "<a class='previous' href='ManagerHomePage.jsp'><span aria-hidden='true'>&larr;</span> Previous</a>";
		h.innerHTML = "<h1><small>View All Employees</small></h1>";
		page.innerHTML = "";
		back.innerHTML = "";
		for (var i = 0; i < employees.length; i++) {
			var row = table.insertRow(1);
			var cell0 = row.insertCell(0);
			var cell1 = row.insertCell(1);
			var cell2 = row.insertCell(2);
			var cell3 = row.insertCell(3);
			var cell4 = row.insertCell(4);
			cell0.innerHTML = employees[i].username;
			cell1.innerHTML = employees[i].firstName;
			cell2.innerHTML = employees[i].lastName;
			cell3.innerHTML = employees[i].email;
		}
	}
	function view() {
		var request = new XMLHttpRequest();
		request.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				find(this);
			}
		}
		request.open("GET", "http://localhost:8000/Project1/ViewEmployees",
				true);
		request.send();
		return request.responseText;
	}
	
	function findThem(response){
		var reim = JSON.parse(response.responseText);
		var table = document.getElementById("table");
		var h = document.getElementById("h");
		var row1 = table.insertRow(0);
		row1.insertCell(0).outerHTML = "<th><h4>Id</h4></th>";
		row1.insertCell(1).outerHTML = "<th><h4>Amount</h4></th>";
		row1.insertCell(2).outerHTML = "<th><h4>Description</h4></th>";
		row1.insertCell(3).outerHTML = "<th><h4>File</h4></th>";
		row1.insertCell(4).outerHTML = "<th><h4>Submitted</h4></th>";
		row1.insertCell(5).outerHTML = "<th><h4>Resolved</h4></th>";
		row1.insertCell(6).outerHTML = "<th><h4>Employee</h4></th>";
		row1.insertCell(7).outerHTML = "<th><h4>Manager</h4></th>";
		row1.insertCell(8).outerHTML = "<th><h4>Type</h4></th>";
		row1.insertCell(9).outerHTML = "<th><h4>Status</h4></th>";
		h.innerHTML = "<h1><small>View Resolved Reimbursements</small></h1>";
		for (var i = 0 ; i < reim.length ; i++){
			if (reim[i].file == null){
				reim[i].file = "N/A";
			}
			var row = table.insertRow(1);
			var cell0 = row.insertCell(0);
			var cell1 = row.insertCell(1);
			var cell2 = row.insertCell(2);
			var cell3 = row.insertCell(3);
			var cell4 = row.insertCell(4);
			var cell5 = row.insertCell(5);
			var cell6 = row.insertCell(6);
			var cell7 = row.insertCell(7);
			var cell8 = row.insertCell(8);
			var cell9 = row.insertCell(9);
			cell0.innerHTML = reim[i].r_id;
			cell1.innerHTML = "$"+reim[i].amount;
			cell2.innerHTML = reim[i].description;
			cell3.innerHTML = reim[i].file;
			cell4.innerHTML = new Date(reim[i].submitted).toLocaleDateString();
			cell5.innerHTML = new Date(reim[i].resolved).toLocaleDateString();
			cell6.innerHTML = reim[i].u_id.username;
			cell7.innerHTML = reim[i].uu_id.username;
			cell8.innerHTML = reim[i].t_id.type;
			cell9.innerHTML = reim[i].s_id.status;
		}
	}


	function findReimbursements(){
		var request = new XMLHttpRequest();
		request.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				findThem(this);
			}
		}
		request.open("GET", "http://localhost:8000/Project1/ViewReimbursementFromUser",
				true);
		request.send();
		return request.responseText;
	}