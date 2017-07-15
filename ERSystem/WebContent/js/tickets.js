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
			var rows = "";
			for(var r in result){
				console.log(result[r].status);
				rows+='<tr data-status="'+result[r].statusName+'"><td><div class="media"><a href="#" class="pull-left"><img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo"></a><div class="media-body"><span class="media-meta pull-right">'+(result[r].resolved? result[r].resolved : "" )+'</span><h4 class="title">'+result[r].submited+'<span class="pull-right '+result[r].statusName+'">'+result[r].statusName+'</span></h4><p class="summary">'+result[r].description+'</p></div></div></td></tr>'
			}
			table.innerHTML = rows;
			
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