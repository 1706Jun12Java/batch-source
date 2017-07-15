$(document).ready(function () {
    $('.btn-filter').on('click', function () {
      var $target = $(this).data('target');
      if ($target != 'All') {
        $('.table tr').css('display', 'none');
        $('.table tr[data-status="' + $target + '"]').fadeIn('fast');
      } else {
        $('.table tr').css('display', 'none').fadeIn('fast');
      }
    });
    
    getTickets();
    
 });

function renderTickets(resp){
	console.log(resp.responseText);
	try{
		var result = JSON.parse(resp.responseText);
		if(result.redirect){
			window.location.replace(result.redirect);
		}else{
			
			var table = document.getElementById("myTable");
			for(var r in result){
				var row = table.insertRow(-1);
				row.setAttribute("id", result[r].id);
				row.setAttribute("class", "clickable");
				row.setAttribute("data-status", result[r].statusName);
				var cell0 = row.insertCell(0);
				var cell1 = row.insertCell(1);
				cell1.setAttribute("class", result[r].statusName);
				var cell2 = row.insertCell(2);
				var cell3 = row.insertCell(3);
				cell0.innerHTML=result[r].submited;
				cell1.innerHTML="<span>"+result[r].statusName+"</span>";
				cell2.innerHTML=result[r].resolved;
				cell3.innerHTML="<a href=manageticket.html?id="+result[r].id+">"+result[r].description+"</a>";
			}
		}
	}catch(err){
		console.log(err);
	}
}

function getTickets(){
    var url = "http://localhost:8080/ERSystem/master?destination=gettickets";
	var resp = new XMLHttpRequest()
		|| new ActiveXObject("Microsoft.HTTPRequest");
	resp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
				console.log(this.responseText);
				renderTickets(this);
		}
	};
	resp.open("GET",url, true);
	resp.send();
  }

function getOneTicket(tid){
    var url = "http://localhost:8080/ERSystem/master?destination=gettickets&id=tid";
	var resp = new XMLHttpRequest()
		|| new ActiveXObject("Microsoft.HTTPRequest");
	resp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
				console.log(this.responseText);
//				renderTickets(this);
		}
	};
	resp.open("GET",url, true);
	resp.send();
  }

$(".clickable").on("click", function(){
	console.log("hi");
})
