function displayError(err,id){
	var error = document.getElementById(id);
	error.style.display = "block";
	error.innerHTML=err;
	setTimeout(function(){error.style.display="none"}, 3000);
}

function loadData(){
		var url2 = window.location.href;
		var id = new URL(url2).searchParams.get("id");
		console.log(id);
		var url = "http://localhost:8080/ERSystem/master?destination=getticket&id="+id;
		var resp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
		resp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
					console.log(this.responseText);
					doRender(this);
			}
		};
		resp.open("GET",url, true);
		resp.send();
}

function doRender(resp){
	try{
		var result = JSON.parse(resp.responseText);
		if(result.error){
			displayError(result.error,'error');
		}else if(result.redirect){
			window.location.replace(result.redirect);
		} 
		else{
			console.log(result);
			document.getElementById('amount').innerHTML=result.amount;
			document.getElementById('description').innerHTML=result.description;
			document.getElementById('receiptURL').innerHTML="<a href="+result.receiptURL+" target='_blank'>"+result.receiptURL+"</a>";
			document.getElementById('submited').innerHTML=result.submited;
			document.getElementById('resolved').innerHTML=result.resolved;
			document.getElementById('statusName').innerHTML=result.statusName;
			document.getElementById('type').innerHTML=result.typeName;
			document.getElementById('resolverName').innerHTML=result.resolverName;
			document.getElementById('ticketid').value=result.id;
		}
		
	}catch(err){
		console.log(err);
	}
}

function approveTicket(id){
		url = "getticket"
		var fd = new FormData();
		var tid = document.getElementById("ticketid").value;
		console.log(tid);
		fd.append("id", tid);
		fd.append("action", "approve");
		var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
					console.log(this);
					loadData();
			}
		};
		xhr.open("POST", url, true);
		xhr.send(fd);
}

function denyTicket(id){
	url = "getticket"
	var fd = new FormData();
	var tid = document.getElementById("ticketid").value;
	console.log(tid);
	fd.append("id", tid);
	fd.append("action", "deny");
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
				console.log(this);
				loadData();
		}
	};
	xhr.open("POST", url, true);
	xhr.send(fd);
}

window.addEventListener("load", loadData);
document.getElementById("approve").addEventListener("click", approveTicket);
document.getElementById("deny").addEventListener("click", denyTicket);
