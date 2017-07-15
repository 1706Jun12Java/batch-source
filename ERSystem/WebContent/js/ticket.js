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
		console.log(resp);
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
		}
		
	}catch(err){
		console.log(err);
	}
}

function goBack(){
 window.location.replace("tickets.html");
}

window.addEventListener("load", loadData);
document.getElementById("goback").addEventListener("click", goBack);
