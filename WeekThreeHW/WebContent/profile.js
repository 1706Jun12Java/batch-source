function movebar() {
    var elem = document.getElementById("myBar"); 
    var width = 1;
    var id = setInterval(frame, 250);
    function frame() {
        if (width >= 100) {
            clearInterval(id);
        } else {
            width++; 
            elem.style.width = width + '%'; 
        }
    }
}


var data = {};
var username = ""; 

var table_temp = `<tr>
			        <td>t_id</td>
			        <td>t_type</td>
			        <td>t_amt</td>
			        <td>t_date</td>
			      </tr>`;

var panel_temp = ` <div class="panel panel-default" id="account_tree_a_id">
	      <div class="panel-heading">
	        <div class="panel-title">  
	        	<div class="row">
				  	<div class="col-md-3">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse_a_id">Account ID: a_id</a> 
					</div>
				  	<div class="col-md-3">Balance: $a_balance</div>
				  	<div class="col-md-3"><a data-toggle="modal" data-target="#exampleModal" data-whatever="a_id" >Make Transaction</a></div>
				  	<div class="col-md-3"><a data-toggle="modal" data-target="#confirm-delete" data-whatever="a_id" >Delete Account</a></div>
				</div> 
	        </div>  
	      </div>
	      <div id="collapse_a_id" class="panel-collapse collapse">
	        <table class="table table-hover">
			    <thead>
			      <tr>
			        <th style="width: 25%">Transaction ID</th>
			        <th style="width: 25%">Type</th>
			        <th style="width: 25%">Amount</th>
			        <th style="width: 25%">Date</th>
			      </tr>
			    </thead>
			    <tbody>
			       t_table
			    </tbody>
			  </table>
	      </div>
	    </div> `;

  

var recipient;

$(document).ready(function(){
		
	movebar();
	
	
	var transactionBalanceAPI = "http://localhost:8080/JDBCBankFullStack/profile";
	
	$.getJSON( transactionBalanceAPI, { 
	    format: "json"
	  }) .done(function( res ) {	
		  
		  data = res.accounts;
		  //alert("done");
		  document.getElementById("welcome_user").innerHTML = "Welcome, " + res.username + " !";

			document.getElementById("myProgress").style.width = "100%";
			var innerh = ""
			for (var k in data){
				var transa_table ="";
				 for(var i =0; i<data[k].listTransaction.length; i++){
					 var date = data[k].listTransaction[i].transaction_date; 
					 var transa_row = table_temp.replace("t_id", data[k].listTransaction[i].transaction_id)
					 						.replace("t_type", data[k].listTransaction[i].transaction_type)
					 						.replace("t_amt", data[k].listTransaction[i].transaction_amt) 
					 						.replace("t_date", date.dayOfMonth + "-" + date.month + "-" + date.year + " " + date.hour+":"+date.minute+":"+date.second); 
					 transa_table += transa_row;
					 //alert(transa_row);
				 }
				
				  var inner_row= panel_temp.replace("t_table", transa_table)
				 						.replace("a_balance", data[k].balance)
				 						.replace(/a_id/g, k);
				  innerh += inner_row; 	
				  //alert(inner_row);
			 }
			 //alert(innerh); 
			 document.getElementById("accordion").innerHTML = innerh; 
			 document.getElementById("myProgress").innerHTML = "";
			 
	});
    
	
	     
	$('#exampleModal').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  recipient = button.data('whatever') // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	 
	  var modal = $(this)
	  modal.find('.modal-title').text('Transaction for Account ID: ' + recipient)
	  document.getElementById("account_id").value = recipient; 
	  
	}),
	
	$('#confirm-delete').on('show.bs.modal', function(event) {
	  
	 var button = $(event.relatedTarget) ; 
	  recipient = button.data('whatever') ;   
	  document.getElementById("account_id_delete").value = recipient;   
	});
	
	 
	
	
});
  
function deleteTree(){
	event.preventDefault();
	$("#confirm-delete").modal('hide');
	//alert(event);
	
	$.ajax({
		  type: 'POST',
		  url: $(".delete_account").attr("action"),
		  data: $(".delete_account").serialize(),  
		  success: function(response) {
			  	//alert("done");
		  },
		});
	document.getElementById("account_tree_"+recipient).outerHTML  = ""; 
}

function checkOverDraf(){ 
	 
	
	if (document.getElementById("transaction_type").value === "withdraw" && 
			document.getElementById("Amount").value > data[recipient].balance){
	
		document.getElementById("error_overdraf").innerHTML = "You are overdrafting";
		document.getElementById("transact_btn").disabled = true;
	}
	else{
		document.getElementById("error_overdraf").innerHTML = "";
		document.getElementById("transact_btn").disabled = false;
	} 
}

