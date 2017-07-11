/**
 * 
 */
document.getElementById("get").addEventListener("click",get);
document.getElementById("post").addEventListener("click",post);
function get() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	// whenever the state changes this will get called
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {

			document.getElementById("present").innerHTML = xhttp.responseText;
			// var keys = Object.keys(obj);

			var body = document.getElementsByTagName('body')[0];
			/*
			 * var div = document.createElement('div');
			 * body.appendChild(document.createTextNode("Did get"))
			 */

			var obj = JSON.parse(xhttp.responseText);
			var body = document.getElementsByTagName('body')[0];
			var tbl = document.createElement('table');
			tbl.setAttribute('border', '1');
			var tbdy = document.createElement('tbody');

			var tr = document.createElement('tr');
			var th = document.createElement('th');
			th.setAttribute('colspan','3');
			th.appendChild(document.createTextNode("Did get"));
			tr.appendChild(th);
			tbdy.appendChild(tr);


			// var tr = document.createElement('tr');
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
			body.appendChild(tbl)
		}
	};
	xhttp
			.open("GET", "http://localhost:8080/July11CodeChallenge/servlet",
					true);
	xhttp.send();
}

function post() {
	var xhttp = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhttp.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			document.getElementById("present").innerHTML = xhttp.responseText;
			var obj = JSON.parse(xhttp.responseText);
			var body = document.getElementsByTagName('body')[0];
			var tbl = document.createElement('table');
			tbl.setAttribute('border', '1');
			var tbdy = document.createElement('tbody');

			var tr = document.createElement('tr');
			var th = document.createElement('th');
			th.setAttribute('colspan','3');
			th.appendChild(document.createTextNode("Post: sent some info to servlet"));
			tr.appendChild(th);
			tbdy.appendChild(tr);

			// var tr = document.createElement('tr');
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
			body.appendChild(tbl)
		}
	};
	xhttp.open("POST", "http://localhost:8080/July11CodeChallenge/servlet",
			true);

	xhttp.send("Information to be sent right here");
}