/**
 * 
 */

function postEmpInfo() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			//document.getElementById("empId").innerHTML = xhttp.responseText;
			var obj = JSON.parse(xhttp.responseText);
			
			var tbl = document.getElementsByTagName('table')[0];
			//var div = document.createElement('div');
			//div.classList.add("container");
			//div.classList.add("col-md-12");
			
			var thead = document.createElement('thead');

			var tr = document.createElement('tr');
			var th = document.createElement('th');
			th.setAttribute('colspan','7');
			th.appendChild(document.createTextNode("Employee's info"));
			tr.appendChild(th);
			thead.appendChild(tr);
			
			tbl.appendChild(thead);
			
			var tbdy = document.createElement('tbody');
			var txt;
			var y;
			console.log(obj.length);
			
			
			var tr = document.createElement('tr');
			var objinner = obj[0];
			for (y in objinner) {
				txt = y;
				// console.log(txt);
				var th = document.createElement('th');
				th.appendChild(document.createTextNode(txt.toUpperCase()))
				tr.appendChild(th);
			}
			tbdy.appendChild(tr);

			for (var i = 0; i < obj.length; i++) {
				var objinner = obj[i];
				var tr = document.createElement('tr');

				for (y in objinner) {
					txt = objinner[y];
					// console.log(txt);
					var td = document.createElement('td');
					td.appendChild(document.createTextNode(txt))
					tr.appendChild(td)
				}
				tbdy.appendChild(tr);

			}

			tbl.appendChild(tbdy);
			
			//div.appendChild(tbl)
			//body.appendChild(div)
			console.log(xhttp.responseText)
		}
	};
	xhttp.open("POST", "http://localhost:8080/Project1Reimbursements/postEmpInfo",true);
	xhttp.send(document.getElementById("empId").innerHTML);
}
function printMyReim() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			//document.getElementById("empId").innerHTML = xhttp.responseText;
			var obj = JSON.parse(xhttp.responseText);
			
			var tbl = document.getElementsByTagName('table')[0];
			//var div = document.createElement('div');
			//div.classList.add("container");
			//div.classList.add("col-md-12");
			
			var thead = document.createElement('thead');

			var tr = document.createElement('tr');
			var th = document.createElement('th');
			th.setAttribute('colspan','7');
			th.appendChild(document.createTextNode("My Reimbursement Tickets"));
			tr.appendChild(th);
			thead.appendChild(tr);
			
			tbl.appendChild(thead);
			
			var tbdy = document.createElement('tbody');
			var txt;
			var y;
			console.log(obj.length);
			var tr = document.createElement('tr');
			var objinner = obj[0];
			for (y in objinner) {
				txt = y;
				// console.log(txt);
				var th = document.createElement('th');
				th.appendChild(document.createTextNode(txt.toUpperCase()))
				tr.appendChild(th);
			}
			tbdy.appendChild(tr);

			for (var i = 0; i < obj.length; i++) {
				var objinner = obj[i];
				var tr = document.createElement('tr');

				for (y in objinner) {
					txt = objinner[y];
					// console.log(txt);
					var td = document.createElement('td');
					td.appendChild(document.createTextNode(txt))
					tr.appendChild(td)
				}
				tbdy.appendChild(tr);

			}

			tbl.appendChild(tbdy);
			
			//div.appendChild(tbl)
			//body.appendChild(div)
			console.log(xhttp.responseText)
		}
	};
	xhttp.open("POST", "http://localhost:8080/Project1Reimbursements/postReimInfo",true);
	xhttp.send(document.getElementById("empId").innerHTML);
}
function postAllEmpInfo() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			//document.getElementById("empId").innerHTML = xhttp.responseText;
			var obj = JSON.parse(xhttp.responseText);
			
			var tbl = document.getElementsByTagName('table')[0];
			//var div = document.createElement('div');
			//div.classList.add("container");
			//div.classList.add("col-md-12");
			
			var thead = document.createElement('thead');

			var tr = document.createElement('tr');
			var th = document.createElement('th');
			th.setAttribute('colspan','7');
			th.appendChild(document.createTextNode("Employee's info"));
			tr.appendChild(th);
			thead.appendChild(tr);
			
			tbl.appendChild(thead);
			
			var tbdy = document.createElement('tbody');
			var txt;
			var y;
			console.log(obj.length);
			var tr = document.createElement('tr');
			var objinner = obj[0];
			for (y in objinner) {
				txt = y;
				// console.log(txt);
				var th = document.createElement('th');
				th.appendChild(document.createTextNode(txt.toUpperCase()))
				tr.appendChild(th);
			}
			tbdy.appendChild(tr);

			for (var i = 0; i < obj.length; i++) {
				var objinner = obj[i];
				var tr = document.createElement('tr');

				for (y in objinner) {
					txt = objinner[y];
					// console.log(txt);
					var td = document.createElement('td');
					td.appendChild(document.createTextNode(txt))
					tr.appendChild(td)
				}
				tbdy.appendChild(tr);

			}

			tbl.appendChild(tbdy);
			
			//div.appendChild(tbl)
			//body.appendChild(div)
			console.log(xhttp.responseText)
		}
	};
	xhttp.open("POST", "http://localhost:8080/Project1Reimbursements/postEmpInfo",true);
	xhttp.send("0");
}