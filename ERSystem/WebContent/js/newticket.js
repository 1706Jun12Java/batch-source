function displayError(err,id){
	var error = document.getElementById(id);
	error.style.display = "block";
	error.innerHTML=err;
	setTimeout(function(){error.style.display="none"}, 5000);
}


function renderTypes(res){
	var ertypes = document.getElementById("ertypes");
	try{
		var result = JSON.parse(res);
		for(var i in result){
			var option = document.createElement('option');
			option.setAttribute("value", result[i].id);
			option.innerHTML = result[i].type;
			ertypes.add(option);
		}
	}catch(err){
		console.log(err);
	}
	
}

function doResponse(res){
	try{
		var result = JSON.parse(res);
		if(result.error){
			displayError(result.error,"error");
		}else{
			displayError(result.status,"success");
		}
	}catch(err){
		console.log(err);
	}
}

window.onload= function (){
	var url = "http://localhost:8080/ERSystem/master?destination=getertypes";
	var resp = new XMLHttpRequest()
		|| new ActiveXObject("Microsoft.HTTPRequest");
	resp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
				renderTypes(this.responseText);
		}
	};
	resp.open("GET",url, true);
	resp.send();
	
};

function createTicket(){
	var amount = document.getElementById("amount").value;
	var type = document.getElementById("ertypes").value;
	var description = document.getElementById("description").value;
	var img = document.getElementById("img").files[0];
	if(amount=="" || description==""){
		displayError("missing fields.", "error");
	}else{
		var url = "gettickets";
		var fd = new FormData();
		fd.append("amount", Number(amount));
		fd.append("ertype",type);
		fd.append("description",description);
		fd.append("img", img);
		var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
					console.log(this);
					doResponse(this.responseText);
			}
		};
		xhr.open("POST", url, true);
		xhr.send(fd);
	}
}

document.getElementById("createTicket").addEventListener("click", createTicket);
