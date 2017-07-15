function displayError(err, id){
	var error = document.getElementById(id);
	error.style.display = "block";
	error.innerHTML="<strong>Warning! </strong>"+err;
	setTimeout(function(){error.style.display="none"}, 3000);
}

function doRender(resp){
	try{
		console.log(resp);
		var result = JSON.parse(resp.responseText);
		if(result.error){
			displayError(result.error,'error');
		}else if(result.redirect){
			window.location.replace(result.redirect);
		} 
		else{
			console.log(result);
			document.getElementById('username').innerHTML=result.username;
			document.getElementById('firstname').innerHTML=result.firstName;
			document.getElementById('lastname').innerHTML=result.lastName;
			document.getElementById('email').innerHTML=result.email;
			document.getElementById('nfirstname').value=result.firstName;
			document.getElementById('nlastname').value=result.lastName;
			document.getElementById('userID').value=result.userID;	
		}
		
	}catch(err){
		console.log(err);
	}
}

function loadData(){
		var url = "http://localhost:8080/ERSystem/master?destination=getprofile";
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


function doSave(firstname,lastname,password,userID){
	
	var url = "http://localhost:8080/ERSystem/master?destination=getprofile";
	data = {
			firstname:firstname,
			lastname:lastname,
			userID:userID,
			password:password
	};
	$.post(url, data).done(function(result){$("#myModal").modal("toggle");loadData();});
	
}

function saveInfo(){
	var firstname = document.getElementById('nfirstname').value;
	var lastname = document.getElementById('nlastname').value;
	var password = document.getElementById('npassword').value;
	var userID = document.getElementById('userID').value;
	if(firstname=="" || lastname=="" || password ==""){
		displayError("Fill out all the fields.", "formError");
	}else{
		doSave(firstname,lastname,password,userID);
	}
}

window.addEventListener("load", loadData);
document.getElementById("save").addEventListener("click", saveInfo);