function updateReimbursement(info, id){

	var xhttp = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
		xhttp.onreadystatechange = function() {
			if (this.readyState === 4 && this.status === 200) {		
				window.location.href = '/ProjectOne/profile';
			}
	};
	var data = [{reimburseInfo : info, reimburseId : id}];
	xhttp.open("POST", "http://localhost:8080/ProjectOne/pending");
	console.log(data);
	xhttp.send(JSON.stringify(data));
}

function getReimburseInfo(information){
	var xhttp = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
		xhttp.onreadystatechange = function() {
			if (this.readyState === 4 && this.status === 200) {		

				var respData = JSON.parse(xhttp.responseText);
				var respArray = Object.keys(respData);
								
				var reimbursementTable = document.getElementById("userTables");
											
				
				while (reimbursementTable.firstChild) {
					reimbursementTable.removeChild(reimbursementTable.firstChild);
				}
				
				var tr = document.createElement('tr');   
			    
				var reimbursementArray = ["ID", "Author", "Amount", "Description","Receipt", "Date Submitted", "Date Resolved", "Type", "Status", "Resolver"];
				
			    for (var i = 0; i < reimbursementArray.length; i++){
				    var th1 = document.createElement('th');
				    var text = document.createTextNode(reimbursementArray[i]);
				    th1.appendChild(text);
				    tr.appendChild(th1);
			    }
			   

			    reimbursementTable.appendChild(tr);

			    var userRole = document.getElementById("reimburseRole").textContent;
			    
				reimbursementArray = ["reimburse_ID", "author", "amount", "description","receipt", "submitted", "resolved", "type", "status", "resolver"];

				for (var i = 0; i < respArray.length; i++){
					var tr2 = document.createElement('tr');
					
					var index = respData[respArray[i]];
										
					if (index[reimbursementArray[8]] === information || information === undefined || (index[reimbursementArray[8]] === 'DENIED' && information === 'APPROVED')){
						for (var j = 0; j < reimbursementArray.length; j++){
					    	
						    var td = document.createElement('td');
						    var text;

						    
						    if (j === 0 && userRole === "Manager" && index[reimbursementArray[8]] === "PENDING"){

						    	var div = document.createElement("div");
						    	div.className += "row";
						    	var divSecond = document.createElement("div");
						    	div.className += "row";
						    	
						    	var btn = document.createElement("button");
						    	var t = document.createTextNode("Approve");
						    	btn.className += "btn btn-success";
						    	
						    	var clickInfo = "updateReimbursement(" + "'2'" + ", '" + index[reimbursementArray[0]] + "')";
						    	btn.setAttribute("onclick", clickInfo);
						    	
						    	btn.appendChild(t);
						    	div.appendChild(btn);

						    	var btn2 = document.createElement("button");
						    	var t2 = document.createTextNode("Deny");
						    	btn2.className += "btn btn-danger";
						    	
						    	var clickInfo2 = "updateReimbursement(" + "'3'" + ", '" +index[reimbursementArray[0]] + "')";
						    	btn2.setAttribute("onclick", clickInfo2);
						    		
							    
						    	btn2.appendChild(t2);
						    	div.appendChild(btn2);

						    	
						    	text = document.createTextNode(index[reimbursementArray[j]]);

						    	td.appendChild(text);

							    td.appendChild(div);
							    td.appendChild(divSecond);
							    
							    tr2.appendChild(td);
						    }
						    //submitted 5
						    // resolved 6
						    else if (j === 4){
						    	var img = document.createElement('img');
						    	
						    	var src = 'data:image/png;base64,'+index[reimbursementArray[j]];
						    	img.setAttribute('src', src);
						    	img.setAttribute('width', '200px');
						    	img.setAttribute('height', '200px');
						    	
						        td.appendChild(img);
						    	tr2.appendChild(td);
						    }
						    else if (j === 5 || (j === 6 && index[reimbursementArray[6]] !== null)){
						    							    	
						    	var date = new Date(index[reimbursementArray[j]]);
						    	var day = date.getDate();
						    	var year = date.getUTCFullYear();
						    	var month = date.getMonth();
						    	var hours = date.getHours();
						    	var minutes = "0" + date.getMinutes();
						    	var seconds = "0" + date.getSeconds();

						    	var formattedTime = month + '/' + day + '/' + year + "\n" + hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
						    	
						    	text = document.createTextNode(formattedTime);
						    	
						    	
							    td.appendChild(text);
							    tr2.appendChild(td);
						    }
						    
						    else {
						    	text = document.createTextNode(index[reimbursementArray[j]]);
						    	
						    	
							    td.appendChild(text);
							    tr2.appendChild(td);
						    }

		    			    
					    }
					    reimbursementTable.appendChild(tr2);
					} else {
						continue;
					}             
				}
				
			    
			}
	};
	
	xhttp.open("GET", "http://localhost:8080/ProjectOne/reimbursementinfo");
	xhttp.send();
}