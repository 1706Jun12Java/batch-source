/**
 * 
 */

window.onload = function loadPage() {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			var view = xhr.responseText;
			var array = view.split("\n");
			if (array[0].trim() === "M") {
				loadManagerView(this);
			} else if (array[0].trim() === "E") {
				loadEmployeeView(this);
			} else {
				window.location = "http://localhost:8080/Project1Assignment/LogIn.html";
			}
		}
	}
	xhr.open("GET", "http://localhost:8080/Project1Assignment/default?id=1",
			true);
	xhr.send();
}
function approvalForm(){
	var contentBody = document.getElementById("contentBody");
	var container = document.createElement("div");
	container.setAttribute("id", "approvalForm");
	container.setAttribute("class","container-fluid");
	contentBody.appendChild(container);
	var row1 = document.createElement("div");
	row1.setAttribute("class", "row");
	container.appendChild(row1);
	var offsetDiv = document.createElement("div");
	offsetDiv.setAttribute("class", "col-sm-6 col-sm-offset-3");
	row1.appendChild(offsetDiv);
	var panel = document.createElement("div");
	panel.setAttribute("class","panel panel-default");
	panel.setAttribute("id","panelRequestForm");
	offsetDiv.appendChild(panel);
	var panelHeader = document.createElement("div");
	panelHeader.setAttribute("class","panel-heading");
	panel.appendChild(panelHeader);
	var panelTitle = document.createElement("h3");
	panelTitle.innerHTML = "Approval Form";
	panelTitle.setAttribute("class","panel-title text-center");
	panelHeader.appendChild(panelTitle);
	var panelBody = document.createElement("div");
	panelBody.setAttribute("class","panel-body");
	panelBody.setAttribute("id","panelBodyRequestForm");
	panel.appendChild(panelBody);
	var inputGroup1 = document.createElement("div");
	inputGroup1.setAttribute("class","input-group input-group-sm");
	panelBody.appendChild(inputGroup1);
	var amountSpan = document.createElement("span");
	amountSpan.setAttribute("class","input-group-addon");
	amountSpan.innerHTML = "Request ID:";
	inputGroup1.appendChild(amountSpan);
	var amountInput = document.createElement("input");
	amountInput.setAttribute("class","form-control");
	amountInput.setAttribute("id","RequestID");
	amountInput.setAttribute("type","text");
	inputGroup1.appendChild(amountInput);
	var selector = document.createElement("select");
	selector.setAttribute("class","selectpicker");
	selector.setAttribute("id","app");
	var option1 = document.createElement("option");
	option1.innerHTML = "";
	selector.appendChild(option1);
	var option2 = document.createElement("option");
	option2.innerHTML = "APPROVED";
	selector.appendChild(option2);
	var option4 = document.createElement("option");
	option1.innerHTML = "DENIED";
	selector.appendChild(option4);
	panelBody.appendChild(selector);
	var submitBtn = document.createElement("input");
	submitBtn.setAttribute("type","submit");
	submitBtn.setAttribute("class", "btn btn-primary btn-block");
	submitBtn.addEventListener("click",function(){
		var xhr = new XMLHttpRequest()
		|| new ActiveXObject("Microsoft.HTTPRequest");
		xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		var view = xhr.responseText;
		var array = view.split("\n");
		if (array[0].trim() === "SUCCESS") {
			alert("Successfulyl Updated")
		} else if (array[0].trim() === "ERROR") {
			alert(array[1].trim());
		} else {
			window.location = "http://localhost:8080/Project1Assignment/LogIn.html";
		}
	}
		}
		var id = document.getElementById("RequestID").value;
		var sele = document.getElementById("app");
xhr.open("POST", "http://localhost:8080/Project1Assignment/default?id=4",
		true);
	xhr.send(id + "\n" + sele.options[sele.selectedIndex].text);
	});
	panelBody.appendChild(submitBtn);
}

function loadManagerView(xhr) {
	var serverResponse = xhr.responseText;
	var array = serverResponse.split("\n");
	var logoButton = document.getElementById("logoButton");
	logoButton.addEventListener("click", setView("requestTables"));
	var navBarLeft = document.getElementById("navBarLeft");
	var button = document.createElement("li");
	var requestButton = document.createElement("button");
	requestButton.setAttribute("class","btn btn-default navbar-btn");
	requestButton.addEventListener("click", function(){setView("approvalForm")});
	requestButton.innerHTML = "Approve/Deny Request";
	button.appendChild(requestButton);
	navBarLeft.appendChild(button);
	var button2 = document.createElement("li");
	var viewTablesBtn = document.createElement("button");
	viewTablesBtn.setAttribute("class","btn btn-default navbar-btn");
	viewTablesBtn.addEventListener("click", function(){setView("requestTables")});
	viewTablesBtn.innerHTML = "Show All Requests";
	button2.appendChild(viewTablesBtn);
	navBarLeft.appendChild(button2);
	var button3 = document.createElement("li");
	var ViewByUser = document.createElement("button");
	ViewByUser.setAttribute("class","btn btn-default navbar-btn");
	ViewByUser.addEventListener("click", function(){setView("viewByUser")});
	ViewByUser.innerHTML = "View Request By User";
	button3.appendChild(ViewByUser);
	navBarLeft.appendChild(button3);
	var title = document.getElementById("title");
	var titleH = document.createElement("h2");
	titleH.innerHTML = "Welcome to your dashboard, " + array[1].trim();
	title.appendChild(titleH);
	setTimeout(function() {
		var target = document.getElementById("title");
		var children = target.getElementsByTagName("h2");
		for (var i = 0; i < children.length; i++) {
			target.removeChild(children[i]);
		}
	}, 10000);
	approvalForm();
	viewByUserForm();
	loadEmployeeRequests();
	tableLoad = setInterval(loadEmployeeRequests,10000);
	setView("requestTables")
}

function viewByUserForm(){
	var contentBody = document.getElementById("contentBody");
	var container = document.createElement("div");
	container.setAttribute("id", "viewByUser");
	container.setAttribute("class","container-fluid");
	contentBody.appendChild(container);
	var row1 = document.createElement("div");
	row1.setAttribute("class", "row");
	container.appendChild(row1);
	var offsetDiv = document.createElement("div");
	offsetDiv.setAttribute("class", "col-sm-6 col-sm-offset-3");
	row1.appendChild(offsetDiv);
	var panel = document.createElement("div");
	panel.setAttribute("class","panel panel-default");
	panel.setAttribute("id","viewByUser");
	offsetDiv.appendChild(panel);
	var panelHeader = document.createElement("div");
	panelHeader.setAttribute("class","panel-heading");
	panel.appendChild(panelHeader);
	var panelTitle = document.createElement("h3");
	panelTitle.innerHTML = "Approval Form";
	panelTitle.setAttribute("class","panel-title text-center");
	panelHeader.appendChild(panelTitle);
	var panelBody = document.createElement("div");
	panelBody.setAttribute("class","panel-body");
	panelBody.setAttribute("id","panelBodyRequestForm");
	panel.appendChild(panelBody);
	var inputGroup1 = document.createElement("div");
	inputGroup1.setAttribute("class","input-group input-group-sm");
	panelBody.appendChild(inputGroup1);
	var amountSpan = document.createElement("span");
	amountSpan.setAttribute("class","input-group-addon");
	amountSpan.innerHTML = "User ID:";
	inputGroup1.appendChild(amountSpan);
	var amountInput = document.createElement("input");
	amountInput.setAttribute("class","form-control");
	amountInput.setAttribute("id","UserID");
	amountInput.setAttribute("type","text");
	inputGroup1.appendChild(amountInput);
	var submitBtn = document.createElement("input");
	submitBtn.setAttribute("type","submit");
	submitBtn.setAttribute("class", "btn btn-primary btn-block");
	submitBtn.addEventListener("click",function(){
		var xhr = new XMLHttpRequest()
		|| new ActiveXObject("Microsoft.HTTPRequest");
		xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		var view = xhr.responseText;
		var array = view.split("\n");
		if (array[0].trim() === "List") {
			document.getElementById("ripme").innerHTML = "";
			var jsonArray = array[1].trim();
			for(x in jsonArray){
				document.getElementById("ripme").innerHTML += jsonArray[x];
			}
		} else if (array[0].trim() === "ERROR") {
			alert(array[1].trim());
		} else {
			window.location = "http://localhost:8080/Project1Assignment/LogIn.html";
		}
	}
		}
		var id = document.getElementById("UserID").value;
xhr.open("POST", "http://localhost:8080/Project1Assignment/default?id=5",
		true);
	xhr.send(id);
	});
	panelBody.appendChild(submitBtn);
	var spane = document.createElement("span");
	spane.setAttribute("id","ripme");
	panelBody.appendChild(spane);
}
function settingsForm(){
	
}
function setView(view) {
	var contentBody = document.getElementById("contentBody");
	var children = contentBody.children;
	for (var i = 0; i < children.length; i++) {
		if (children[i].getAttribute("id") === view) {
			children[i].style.display = "";
		} else {
			children[i].style.display = "none";
		}
	}
}
function loadEmployeeView(xhr) {
	var serverResponse = xhr.responseText;
	var array = serverResponse.split("\n");
	var logoButton = document.getElementById("logoButton");
	logoButton.addEventListener("click", setView("requestTables"));
	var navBarLeft = document.getElementById("navBarLeft");
	var button = document.createElement("li");
	var requestButton = document.createElement("button");
	requestButton.setAttribute("class","btn btn-default navbar-btn");
	requestButton.addEventListener("click", function(){setView("requestForm")});
	requestButton.innerHTML = "Make Request";
	button.appendChild(requestButton);
	navBarLeft.appendChild(button);
	var button2 = document.createElement("li");
	var viewTablesBtn = document.createElement("button");
	viewTablesBtn.setAttribute("class","btn btn-default navbar-btn");
	viewTablesBtn.addEventListener("click", function(){setView("requestTables")});
	viewTablesBtn.innerHTML = "Show All Requests";
	button2.appendChild(viewTablesBtn);
	navBarLeft.appendChild(button2);
	var title = document.getElementById("title");
	var titleH = document.createElement("h2");
	titleH.innerHTML = "Welcome to your dashboard, " + array[1].trim();
	title.appendChild(titleH);
	setTimeout(function() {
		var target = document.getElementById("title");
		var children = target.getElementsByTagName("h2");
		for (var i = 0; i < children.length; i++) {
			target.removeChild(children[i]);
		}
	}, 10000);
	displayRequestForms();
	loadEmployeeRequests();
	tableLoad = setInterval(loadEmployeeRequests,10000);
	setView("requestTables")
}

function loadEmployeeRequests() {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			makeTables(this);
		}
	}
	xhr.open("GET", "http://localhost:8080/Project1Assignment/default?id=2",
			true);
	xhr.send();
}

function makeTables(xhr) {
	var response = xhr.responseText;
	var array = response.split("\n");
	var code = array[0].trim();
	console.log(code);
	switch (code) {
	case "Login":
		window.location = "http://localhost:8080/Project1Assignment/LogIn.html";
		break;
	case "List": var table = document.getElementById("unresTable");
	var jsonArray = JSON.parse(array[1].trim());
	for(x in jsonArray){
		if(document.getElementById(jsonArray[x].id) === null && jsonArray[x].status === "UNRESOLVED"){
		var tableRow = document.createElement("tr");
		tableRow.setAttribute("id",jsonArray[x].id);
		var td1 = document.createElement("td");
		td1.appendChild(document.createTextNode(jsonArray[x].id));
		tableRow.appendChild(td1);
		var td2 = document.createElement("td");
		td2.appendChild(document.createTextNode(jsonArray[x].amount));
		tableRow.appendChild(td2);
		var td4 = document.createElement("td");
		td4.appendChild(document.createTextNode(jsonArray[x].type));
		tableRow.appendChild(td4);
		var td3 = document.createElement("td");
		var descript = document.createElement("button");
		descript.setAttribute("class","btn btn-primary");
		descript.addEventListener("click", function(){showDescription(jsonArray[x].description)})
		descript.innerHTML = "View";
		td3.appendChild(descript);
		tableRow.appendChild(td3);
		var td7 = document.createElement("td");
		var span = document.createElement("span");
		span.setAttribute("class","'label label-info");
		span.appendChild(document.createTextNode(jsonArray[x].status))
		td7.appendChild(span);
		tableRow.appendChild(td7);
		var td5 = document.createElement("td");
		td5.appendChild(document.createTextNode(jsonArray[x].submittedBy.firstName + " " + jsonArray[x].submittedBy.lastName));
		tableRow.appendChild(td5);
		var td6 = document.createElement("td");
		td6.appendChild(document.createTextNode(jsonArray[x].submitted));
		tableRow.appendChild(td6);
		if(jsonArray[x].handledBy === null){
			var td8 = document.createElement("td");
			td8.appendChild(document.createTextNode("N/A"));
			tableRow.appendChild(td8);
		} else{
			var td8 = document.createElement("td");
			td8.appendChild(document.createTextNode(jsonArray[x].handledBy.firstName + " " + jsonArray[x].handledBy.lastName));
			tableRow.appendChild(td8);
		}
		if(jsonArray[x].resolved === null){
			var td9 = document.createElement("td");
			td9.appendChild(document.createTextNode("N/A"));
			tableRow.appendChild(td9);
		} else {
			var td9 = document.createElement("td");
			td9.appendChild(document.createTextNode(jsonArray[x].resolved));
			tableRow.appendChild(td9);
		}
		var td10 = document.createElement("td");
		var picture = document.createElement("button");
		picture.setAttribute("class","btn btn-primary");
		picture.addEventListener("click", function(){showPicture(jsonArray[x].picture)});
		picture.innerHTML = "View";
		td10.appendChild(picture);
		tableRow.appendChild(td10);
		table.appendChild(tableRow);
		} else if(document.getElementById(jsonArray[x].id) !== null && jsonArray[x].status === "UNRESOLVED"){
			var tableRow = document.getElementById(jsonArray[x].id);
			table.removeChild(tableRow);
			tableRow = document.createElement("tr");
			tableRow.setAttribute("id",jsonArray[x].id);
			var td1 = document.createElement("td");
			td1.appendChild(document.createTextNode(jsonArray[x].id));
			tableRow.appendChild(td1);
			var td2 = document.createElement("td");
			td2.appendChild(document.createTextNode(jsonArray[x].amount));
			tableRow.appendChild(td2);
			var td4 = document.createElement("td");
			td4.appendChild(document.createTextNode(jsonArray[x].type));
			tableRow.appendChild(td4);
			var td3 = document.createElement("td");
			var descript = document.createElement("button");
			descript.setAttribute("class","btn btn-primary");
			descript.addEventListener("click", function(){showDescription(jsonArray[x].description)})
			descript.innerHTML = "View";
			td3.appendChild(descript);
			tableRow.appendChild(td3);
			var td7 = document.createElement("td");
			var span = document.createElement("span");
			span.setAttribute("class","'label label-info");
			span.appendChild(document.createTextNode(jsonArray[x].status))
			td7.appendChild(span);
			tableRow.appendChild(td7);
			var td5 = document.createElement("td");
			td5.appendChild(document.createTextNode(jsonArray[x].submittedBy.firstName + " " + jsonArray[x].submittedBy.lastName));
			tableRow.appendChild(td5);
			var td6 = document.createElement("td");
			td6.appendChild(document.createTextNode(jsonArray[x].submitted));
			tableRow.appendChild(td6);
			if(jsonArray[x].handledBy === null){
				var td8 = document.createElement("td");
				td8.appendChild(document.createTextNode("N/A"));
				tableRow.appendChild(td8);
			} else{
				var td8 = document.createElement("td");
				td8.appendChild(document.createTextNode(jsonArray[x].handledBy.firstName + " " + jsonArray[x].handledBy.lastName));
				tableRow.appendChild(td8);
			}
			if(jsonArray[x].resolved === null){
				var td9 = document.createElement("td");
				td9.appendChild(document.createTextNode("N/A"));
				tableRow.appendChild(td9);
			} else {
				var td9 = document.createElement("td");
				td9.appendChild(document.createTextNode(jsonArray[x].resolved));
				tableRow.appendChild(td9);
			}
			var td10 = document.createElement("td");
			var picture = document.createElement("button");
			picture.setAttribute("class","btn btn-primary");
			picture.addEventListener("click", function(){showPicture(jsonArray[x].picture)});
			picture.innerHTML = "View";
			td10.appendChild(picture);
			tableRow.appendChild(td10);
			table.appendChild(tableRow);
		}
	}
	listForResTable(jsonArray);		 
		break;
	case "Error":
			alert('No Requests');
			clearInterval(tableLoad);
			setView("requestForm");
		break;
	case "Good":
		break;
	case "Init":
		var jsonArray = JSON.parse(array[1].trim());
		var container = document.createElement("div");
		container.setAttribute("id", "requestTables");
		container.setAttribute("class","container-fluid");
		document.getElementById("contentBody").appendChild(container);
		var row1 = document.createElement("div");
		row1.setAttribute("class", "row");
		container.appendChild(row1);
		var offsetDiv = document.createElement("div");
		offsetDiv.setAttribute("class", "col-sm-12");
		row1.appendChild(offsetDiv);
		var panel = document.createElement("div");
		panel.setAttribute("class","panel panel-default");
		panel.setAttribute("id","panelUnres");
		offsetDiv.appendChild(panel);
		var panelHeader = document.createElement("div");
		panelHeader.setAttribute("class","panel-heading");
		panel.appendChild(panelHeader);
		var panelTitle = document.createElement("h3");
		panelTitle.innerHTML = "Unresolved Requests";
		panelTitle.setAttribute("class","panel-title text-center");
		panelHeader.appendChild(panelTitle);
		var panelBody = document.createElement("div");
		panelBody.setAttribute("class","panel-body");
		panelBody.setAttribute("id","panelBody");
		panelBody.innerHTML="No Requests Found";
		panel.appendChild(panelBody);
		var tableDiv = document.createElement ("div");
		tableDiv.setAttribute("class","table-responsive");
		tableDiv.setAttribute("id", "tableDiv");
		panel.appendChild(tableDiv);
		var table = document.createElement("table");
		table.setAttribute("class","table");
		table.setAttribute("id","unresTable");
		tableDiv.appendChild(table);
		var tableHead1 = document.createElement("th");
		tableHead1.appendChild(document.createTextNode("ID"));
		table.appendChild(tableHead1);
		var tableHead2 = document.createElement("th");
		tableHead2.appendChild(document.createTextNode("Amount"));
		table.appendChild(tableHead2);
		var tableHead3 = document.createElement("th");
		tableHead3.appendChild(document.createTextNode("Reason"));
		table.appendChild(tableHead3);
		var tableHead9 = document.createElement("th");
		tableHead9.appendChild(document.createTextNode("Description"));
		table.appendChild(tableHead9);
		var tableHead4 = document.createElement("th");
		tableHead4.appendChild(document.createTextNode("Status"));
		table.appendChild(tableHead4);
		var tableHead5 = document.createElement("th");
		tableHead5.appendChild(document.createTextNode("Submitted by"));
		table.appendChild(tableHead5);
		var tableHead8 = document.createElement("th");
		tableHead8.appendChild(document.createTextNode("Subission Date"));
		table.appendChild(tableHead8);
		var tableHead6 = document.createElement("th");
		tableHead6.appendChild(document.createTextNode("Handled By"));
		table.appendChild(tableHead6);
		var tableHead7 = document.createElement("th");
		tableHead7.appendChild(document.createTextNode("Reviewed Date"));
		table.appendChild(tableHead7);
		var tableHead10 = document.createElement("th");
		tableHead10.appendChild(document.createTextNode("Picture"));
		table.appendChild(tableHead10);
		var hasRequest = false;
		for(x in jsonArray){
			if(document.getElementById(jsonArray[x].id) === null && jsonArray[x].status === "UNRESOLVED"){
			hasRequest = true
			var tableRow = document.createElement("tr");
			tableRow.setAttribute("id",jsonArray[x].id);
			var td1 = document.createElement("td");
			td1.appendChild(document.createTextNode(jsonArray[x].id));
			tableRow.appendChild(td1);
			var td2 = document.createElement("td");
			td2.appendChild(document.createTextNode(jsonArray[x].amount));
			tableRow.appendChild(td2);
			var td4 = document.createElement("td");
			td4.appendChild(document.createTextNode(jsonArray[x].type));
			tableRow.appendChild(td4);
			var td3 = document.createElement("td");
			var descript = document.createElement("button");
			descript.setAttribute("class","btn btn-primary");
			descript.addEventListener("click", function(){showDescription(jsonArray[x].description)})
			descript.innerHTML = "View";
			td3.appendChild(descript);
			tableRow.appendChild(td3);
			var td7 = document.createElement("td");
			var span = document.createElement("span");
			span.setAttribute("class","'label label-info");
			span.appendChild(document.createTextNode(jsonArray[x].status))
			td7.appendChild(span);
			tableRow.appendChild(td7);
			var td5 = document.createElement("td");
			td5.appendChild(document.createTextNode(jsonArray[x].submittedBy.firstName + " " + jsonArray[x].submittedBy.lastName));
			tableRow.appendChild(td5);
			var td6 = document.createElement("td");
			td6.appendChild(document.createTextNode(jsonArray[x].submitted));
			tableRow.appendChild(td6);
			if(jsonArray[x].handledBy === null){
				var td8 = document.createElement("td");
				td8.appendChild(document.createTextNode("N/A"));
				tableRow.appendChild(td8);
			} else{
				var td8 = document.createElement("td");
				td8.appendChild(document.createTextNode(jsonArray[x].handledBy.firstName + " " + jsonArray[x].handledBy.lastName));
				tableRow.appendChild(td8);
			}
			if(jsonArray[x].resolved === null){
				var td9 = document.createElement("td");
				td9.appendChild(document.createTextNode("N/A"));
				tableRow.appendChild(td9);
			} else {
				var td9 = document.createElement("td");
				td9.appendChild(document.createTextNode(jsonArray[x].resolved));
				tableRow.appendChild(td9);
			}
			var td10 = document.createElement("td");
			var picture = document.createElement("button");
			picture.setAttribute("class","btn btn-primary");
			picture.addEventListener("click", function(){showPicture(jsonArray[x].picture)});
			picture.innerHTML = "View";
			td10.appendChild(picture);
			tableRow.appendChild(td10);
			table.appendChild(tableRow);
			} 
		}
		if(!hasRequest){
			document.getElementById("tableDiv").style.display = "none";
			document.getElementById("panelBody").style.display = "";
		}else {
			document.getElementById("tableDiv").style.display = "";
			document.getElementById("panelBody").style.display = "none";
		}
		resolvedTableSetUp(jsonArray,container);
		break;
	}
}
function showPicture(string){
	if(string !== ""){
		/*var modal = document.createElement("div");
		modal.setAttribute("class", "modal");
		modal.setAttribute("id", "myModal");
		var contentBody = document.getElementById("contentBody");
		var closeBtn = document.createElement("span");
		closeBtn.addEventListener("click",function(){
			var contentBody = document.getElementById("contentBody");
			contentBody.removeChild(document.getElementById("myModal"))});
		var img = document.createElement("img");
		img.setAttribute("class","modal-content");
		img.setAttribute("id", "img01");
		modal.appendChild(closeBtn);
		modal.appendChild(img);
		img.setAttribute("src",string);
		contentBody.appendChild(modal);*/
		var modal = document.getElementById('myModal');

		// Get the image and insert it inside the modal - use its "alt" text as a caption
		var modalImg = document.getElementById("img01");
		    modal.style.display = "block";
		    modalImg.setAttribute("src",string);
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() { 
		  modal.style.display = "none";
		}
	}else {
		alert("No picture provided");
	}
}
function showDescription(text){
	alert(text);
}
function listForResTable(jsonArray){
	var table = document.getElementById("resTable");
	for(x in jsonArray){
		if(document.getElementById(jsonArray[x].id) === null && jsonArray[x].status !== "UNRESOLVED"){
		var tableRow = document.createElement("tr");
		tableRow.setAttribute("id",jsonArray[x].id);
		var td1 = document.createElement("td");
		td1.appendChild(document.createTextNode(jsonArray[x].id));
		tableRow.appendChild(td1);
		var td2 = document.createElement("td");
		td2.appendChild(document.createTextNode(jsonArray[x].amount));
		tableRow.appendChild(td2);
		var td4 = document.createElement("td");
		td4.appendChild(document.createTextNode(jsonArray[x].type));
		tableRow.appendChild(td4);
		var td3 = document.createElement("td");
		var descript = document.createElement("button");
		descript.setAttribute("class","btn btn-primary");
		descript.addEventListener("click", function(){showDescription(jsonArray[x].description)})
		descript.innerHTML = "View";
		td3.appendChild(descript);
		tableRow.appendChild(td3);
		var td7 = document.createElement("td");
		var span = document.createElement("span");
		span.setAttribute("class","'label label-info");
		span.appendChild(document.createTextNode(jsonArray[x].status))
		td7.appendChild(span);
		tableRow.appendChild(td7);
		var td5 = document.createElement("td");
		td5.appendChild(document.createTextNode(jsonArray[x].submittedBy.firstName + " " + jsonArray[x].submittedBy.lastName));
		tableRow.appendChild(td5);
		var td6 = document.createElement("td");
		td6.appendChild(document.createTextNode(jsonArray[x].submitted));
		tableRow.appendChild(td6);
		if(jsonArray[x].handledBy === null){
			var td8 = document.createElement("td");
			td8.appendChild(document.createTextNode("N/A"));
			tableRow.appendChild(td8);
		} else{
			var td8 = document.createElement("td");
			td8.appendChild(document.createTextNode(jsonArray[x].handledBy.firstName + " " + jsonArray[x].handledBy.lastName));
			tableRow.appendChild(td8);
		}
		if(jsonArray[x].resolved === null){
			var td9 = document.createElement("td");
			td9.appendChild(document.createTextNode("N/A"));
			tableRow.appendChild(td9);
		} else {
			var td9 = document.createElement("td");
			td9.appendChild(document.createTextNode(jsonArray[x].resolved));
			tableRow.appendChild(td9);
		}
		table.appendChild(tableRow);
		} else if(document.getElementById(jsonArray[x].id) !== null && jsonArray[x].status !== "UNRESOLVED"){
			var tableRow = document.getElementById(jsonArray[x].id);
			table.removeChild(tableRow);
			tableRow = document.createElement("tr");
			tableRow.setAttribute("id",jsonArray[x].id);
			var td1 = document.createElement("td");
			td1.appendChild(document.createTextNode(jsonArray[x].id));
			tableRow.appendChild(td1);
			var td2 = document.createElement("td");
			td2.appendChild(document.createTextNode(jsonArray[x].amount));
			tableRow.appendChild(td2);
			var td4 = document.createElement("td");
			td4.appendChild(document.createTextNode(jsonArray[x].type));
			tableRow.appendChild(td4);
			var td3 = document.createElement("td");
			var descript = document.createElement("button");
			descript.setAttribute("class","btn btn-primary");
			descript.addEventListener("click", function(){showDescription(jsonArray[x].description)})
			descript.innerHTML = "View";
			td3.appendChild(descript);
			tableRow.appendChild(td3);
			var td7 = document.createElement("td");
			var span = document.createElement("span");
			span.setAttribute("class","'label label-info");
			span.appendChild(document.createTextNode(jsonArray[x].status))
			td7.appendChild(span);
			tableRow.appendChild(td7);
			var td5 = document.createElement("td");
			td5.appendChild(document.createTextNode(jsonArray[x].submittedBy.firstName + " " + jsonArray[x].submittedBy.lastName));
			tableRow.appendChild(td5);
			var td6 = document.createElement("td");
			td6.appendChild(document.createTextNode(jsonArray[x].submitted));
			tableRow.appendChild(td6);
			if(jsonArray[x].handledBy === null){
				var td8 = document.createElement("td");
				td8.appendChild(document.createTextNode("N/A"));
				tableRow.appendChild(td8);
			} else{
				var td8 = document.createElement("td");
				td8.appendChild(document.createTextNode(jsonArray[x].handledBy.firstName + " " + jsonArray[x].handledBy.lastName));
				tableRow.appendChild(td8);
			}
			if(jsonArray[x].resolved === null){
				var td9 = document.createElement("td");
				td9.appendChild(document.createTextNode("N/A"));
				tableRow.appendChild(td9);
			} else {
				var td9 = document.createElement("td");
				td9.appendChild(document.createTextNode(jsonArray[x].resolved));
				tableRow.appendChild(td9);
			}
			var td10 = document.createElement("td");
			var picture = document.createElement("button");
			picture.setAttribute("class","btn btn-primary");
			picture.addEventListener("click", function(){showPicture(jsonArray[x].picture)});
			picture.innerHTML = "View";
			td10.appendChild(picture);
			tableRow.appendChild(td10);
			
			table.appendChild(tableRow);
		}
	}
}

function resolvedTableSetUp(jsonArray,container){
	var row1 = document.createElement("div");
	row1.setAttribute("class", "row");
	container.appendChild(row1);
	var offsetDiv = document.createElement("div");
	offsetDiv.setAttribute("class", "col-sm-12");
	row1.appendChild(offsetDiv);
	var panel = document.createElement("div");
	panel.setAttribute("class","panel panel-default");
	panel.setAttribute("id","panelRes");
	offsetDiv.appendChild(panel);
	var panelHeader = document.createElement("div");
	panelHeader.setAttribute("class","panel-heading");
	panel.appendChild(panelHeader);
	var panelTitle = document.createElement("h3");
	panelTitle.innerHTML = "Resolved Requests";
	panelTitle.setAttribute("class","panel-title text-center");
	panelHeader.appendChild(panelTitle);
	var panelBody = document.createElement("div");
	panelBody.setAttribute("class","panel-body");
	panelBody.setAttribute("id","panelBodyRes");
	panelBody.innerHTML="No Requests Found";
	panel.appendChild(panelBody);
	var tableDiv = document.createElement ("div");
	tableDiv.setAttribute("class","table-responsive");
	tableDiv.setAttribute("id", "tableDivRes");
	panel.appendChild(tableDiv);
	var table = document.createElement("table");
	table.setAttribute("class","table");
	table.setAttribute("id","resTable");
	tableDiv.appendChild(table);
	var tableHead1 = document.createElement("th");
	tableHead1.appendChild(document.createTextNode("ID"));
	table.appendChild(tableHead1);
	var tableHead2 = document.createElement("th");
	tableHead2.appendChild(document.createTextNode("Amount"));
	table.appendChild(tableHead2);
	var tableHead3 = document.createElement("th");
	tableHead3.appendChild(document.createTextNode("Reason"));
	table.appendChild(tableHead3);
	var tableHead3 = document.createElement("th");
	tableHead3.appendChild(document.createTextNode("Description"));
	table.appendChild(tableHead3);
	var tableHead4 = document.createElement("th");
	tableHead4.appendChild(document.createTextNode("Status"));
	table.appendChild(tableHead4);
	var tableHead5 = document.createElement("th");
	tableHead5.appendChild(document.createTextNode("Submitted by"));
	table.appendChild(tableHead5);
	var tableHead8 = document.createElement("th");
	tableHead8.appendChild(document.createTextNode("Subission Date"));
	table.appendChild(tableHead8);
	var tableHead6 = document.createElement("th");
	tableHead6.appendChild(document.createTextNode("Handled By"));
	table.appendChild(tableHead6);
	var tableHead7 = document.createElement("th");
	tableHead7.appendChild(document.createTextNode("Reviewed Date"));
	table.appendChild(tableHead7);
	var tableHead10 = document.createElement("th");
	tableHead10.appendChild(document.createTextNode("Picture"));
	table.appendChild(tableHead10);
	var hasRequest = false;
	for(x in jsonArray){
		if(document.getElementById(jsonArray[x].id) === null && jsonArray[x].status !== "UNRESOLVED"){
			hasRequest = true;
		var tableRow = document.createElement("tr");
		tableRow.setAttribute("id",jsonArray[x].id);
		var td1 = document.createElement("td");
		td1.appendChild(document.createTextNode(jsonArray[x].id));
		tableRow.appendChild(td1);
		var td2 = document.createElement("td");
		td2.appendChild(document.createTextNode(jsonArray[x].amount));
		tableRow.appendChild(td2);
		var td4 = document.createElement("td");
		td4.appendChild(document.createTextNode(jsonArray[x].type));
		tableRow.appendChild(td4);
		var td3 = document.createElement("td");
		var descript = document.createElement("button");
		descript.setAttribute("class","btn btn-primary");
		descript.addEventListener("click", function(){showDescription(jsonArray[x].description)})
		descript.innerHTML = "View";
		td3.appendChild(descript);
		tableRow.appendChild(td3);
		var td7 = document.createElement("td");
		var span = document.createElement("span");
		span.setAttribute("class","'label label-info");
		span.appendChild(document.createTextNode(jsonArray[x].status))
		td7.appendChild(span);
		tableRow.appendChild(td7);
		var td5 = document.createElement("td");
		td5.appendChild(document.createTextNode(jsonArray[x].submittedBy.firstName + " " + jsonArray[x].submittedBy.lastName));
		tableRow.appendChild(td5);
		var td6 = document.createElement("td");
		td6.appendChild(document.createTextNode(jsonArray[x].submitted));
		tableRow.appendChild(td6);
		if(jsonArray[x].handledBy === null){
			var td8 = document.createElement("td");
			td8.appendChild(document.createTextNode("N/A"));
			tableRow.appendChild(td8);
		} else{
			var td8 = document.createElement("td");
			td8.appendChild(document.createTextNode(jsonArray[x].handledBy.firstName + " " + jsonArray[x].handledBy.lastName));
			tableRow.appendChild(td8);
		}
		if(jsonArray[x].resolved === null){
			var td9 = document.createElement("td");
			td9.appendChild(document.createTextNode("N/A"));
			tableRow.appendChild(td9);
		} else {
			var td9 = document.createElement("td");
			td9.appendChild(document.createTextNode(jsonArray[x].resolved));
			tableRow.appendChild(td9);
		}
		var td10 = document.createElement("td");
		var picture = document.createElement("button");
		picture.setAttribute("class","btn btn-primary");
		picture.addEventListener("click", function(){showPicture(jsonArray[x].picture)});
		picture.innerHTML = "View";
		td10.appendChild(picture);
		tableRow.appendChild(td10);
		table.appendChild(tableRow);
		} 
	}
	if(!hasRequest){
		document.getElementById("tableDivRes").style.display = "none";
		document.getElementById("panelBodyRes").style.display = "";
	}else {
		document.getElementById("tableDivRes").style.display = "";
		document.getElementById("panelBodyRes").style.display = "none";
	}
}
function displayRequestForms() {
	var contentBody = document.getElementById("contentBody");
	var container = document.createElement("div");
	container.setAttribute("id", "requestForm");
	container.setAttribute("class","container-fluid");
	contentBody.appendChild(container);
	var row1 = document.createElement("div");
	row1.setAttribute("class", "row");
	container.appendChild(row1);
	var offsetDiv = document.createElement("div");
	offsetDiv.setAttribute("class", "col-sm-6 col-sm-offset-3");
	row1.appendChild(offsetDiv);
	var panel = document.createElement("div");
	panel.setAttribute("class","panel panel-default");
	panel.setAttribute("id","panelRequestForm");
	offsetDiv.appendChild(panel);
	var panelHeader = document.createElement("div");
	panelHeader.setAttribute("class","panel-heading");
	panel.appendChild(panelHeader);
	var panelTitle = document.createElement("h3");
	panelTitle.innerHTML = "Create New Request";
	panelTitle.setAttribute("class","panel-title text-center");
	panelHeader.appendChild(panelTitle);
	var panelBody = document.createElement("div");
	panelBody.setAttribute("class","panel-body");
	panelBody.setAttribute("id","panelBodyRequestForm");
	panel.appendChild(panelBody);
	var inputGroup1 = document.createElement("div");
	inputGroup1.setAttribute("class","input-group input-group-sm");
	panelBody.appendChild(inputGroup1);
	var amountSpan = document.createElement("span");
	amountSpan.setAttribute("class","input-group-addon");
	amountSpan.innerHTML = "Amount:";
	inputGroup1.appendChild(amountSpan);
	var amountInput = document.createElement("input");
	amountInput.setAttribute("class","form-control");
	amountInput.setAttribute("id","amountField");
	amountInput.setAttribute("type","text");
	inputGroup1.appendChild(amountInput);
	var inputGroup2 = document.createElement("div");
	inputGroup2.setAttribute("class","input-group input-group-sm");
	panelBody.appendChild(inputGroup2);
	var descriptSpan = document.createElement("span");
	descriptSpan.setAttribute("class","input-group-addon");
	descriptSpan.innerHTML = "Description:";
	inputGroup2.appendChild(descriptSpan);
	var descriptInput = document.createElement("input");
	descriptInput.setAttribute("class","form-control");
	descriptInput.setAttribute("id","descriptField");
	descriptInput.setAttribute("type","text");
	inputGroup2.appendChild(descriptInput);
	var selector = document.createElement("select");
	selector.setAttribute("class","selectpicker");
	selector.setAttribute("id","type");
	var option1 = document.createElement("option");
	option1.innerHTML = "Travel";
	selector.appendChild(option1);
	var option2 = document.createElement("option");
	option2.innerHTML = "Business";
	selector.appendChild(option2);
	var option4 = document.createElement("option");
	option1.innerHTML = "Other";
	selector.appendChild(option4);
	panelBody.appendChild(selector);
	var imgFilePicker = document.createElement("input");
	imgFilePicker.setAttribute("type","file");
	imgFilePicker.setAttribute("accept","image/*");
	imgFilePicker.setAttribute("id","image");
	panelBody.appendChild(imgFilePicker);
	var submitBtn = document.createElement("input");
	submitBtn.setAttribute("type","submit");
	submitBtn.setAttribute("class", "btn btn-primary btn-block");
	submitBtn.addEventListener("click",function(){createRequest()});
	panelBody.appendChild(submitBtn);
}
function createRequest(){
	clearInterval(tableLoad);
	var imgPicked = document.getElementById("image");
	var reader = new FileReader();
	reader.onloadend = function() {
	     getImg(reader.result);
	}
	if(typeof imgPicked.files[0] !== 'undefined'){
	reader.readAsDataURL(imgPicked.files[0]);
	} else{
		getImg("");
	}
}

function getImg(imgAs64){
	 var amount = document.getElementById("amountField").value;
	 console.log(amount);
	 var descript = document.getElementById("descriptField").value;
	 console.log(descript);
	 var type = document.getElementById("type");
	 var xhr = new XMLHttpRequest()|| new ActiveXObject("Microsoft.HTTPRequest");
xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		var array = xhr.responseText.split("\n");
		if(array[0].trim() === "ERROR"){
			alert(array[1]);
		} else if (array[0].trim() === "SUCCESS"){
			alert("Request Successfuly Created");
			tableLoad = setInterval(loadEmployeeRequests,10000);
			setView("requestTables");
		} else if (array[0].trim() === "Login"){
			window.location = "http://localhost:8080/Project1Assignment/LogIn.html";
		}
	}
}
xhr.open("POST", "http://localhost:8080/Project1Assignment/default?id=3",
		true);
xhr.send(amount + "\n" + descript + "\n" + imgAs64 + "\n" + type.options[type.selectedIndex].text);
	 
}