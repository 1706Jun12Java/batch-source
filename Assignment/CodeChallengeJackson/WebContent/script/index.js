console.log('test');

function getInfo(){
 	var xhttp = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
 	
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("jackson").innerHTML = xhttp.responseText;
			
			
			var respData = JSON.parse(xhttp.responseText);
			
			var respArray = Object.keys(respData);
						
			var table = document.createElement('table');

			var header = table.createTHead();
			
			
			{
				var tr = document.createElement('tr');   
			    
			    var th1 = document.createElement('th');
			    var th2 = document.createElement('th');
			    var th3 = document.createElement('th');
			    

			    var text1 = document.createTextNode('First Name');
			    var text2 = document.createTextNode('Last Name');
			    var text3 = document.createTextNode('Age');
			    
			    th1.appendChild(text1);
			    th2.appendChild(text2);
			    th3.appendChild(text3);
			    
			    tr.appendChild(th1);
			    tr.appendChild(th2);
			    tr.appendChild(th3);

			    table.appendChild(tr);
			}
		    
			for (var i = 0; i < respArray.length; i++){
				console.log(respData[respArray[i]].firstName);
				
				
			    			    
				
			    var tr = document.createElement('tr');   

			    var td1 = document.createElement('td');
			    var td2 = document.createElement('td');
			    var td3 = document.createElement('td');
			    

			    var text1 = document.createTextNode(respData[respArray[i]].firstName);
			    var text2 = document.createTextNode(respData[respArray[i]].lastName);
			    var text3 = document.createTextNode(respData[respArray[i]].age);

			    td1.appendChild(text1);
			    td2.appendChild(text2);
			    td3.appendChild(text3);
			    
			    tr.appendChild(td1);
			    tr.appendChild(td2);
			    tr.appendChild(td3);

			    table.appendChild(tr);
			}
			
			document.body.appendChild(table);
		}
	};
	
	xhttp.open("GET", "http://localhost:8080/CodeChallengeJackson/person", true);
	xhttp.send();
}

function postInfo(){
	var xhttp = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("jackson").innerHTML = xhttp.responseText;
		}
	};
	
	var data = [
		{
			firstName : 'p1',
			lastName : 'p1Last',
			age : 1
		},
		{
			firstName : 'p2',
			lastName : 'p2Last',
			age : 2
		},
		{
			firstName : 'p3',
			lastName : 'p3Last',
			age : 3
		},
		{
			firstName : 'p4',
			lastName : 'p4Last',
			age : 3
		}
	];
	
	xhttp.open("POST", "http://localhost:8080/CodeChallengeJackson/person", true);
	xhttp.send(JSON.stringify(data));
}