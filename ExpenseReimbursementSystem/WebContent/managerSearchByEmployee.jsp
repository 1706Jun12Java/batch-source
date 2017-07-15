<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- ISO-8859-1 -->
<html>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="managerHomepage.jsp">Expense Reimbursement System</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right"> 
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reimbursements<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="managerViewRequests.jsp">View All Requests</a>
            </li>
            <li><a href="managerUpdateRequests.jsp">Update Requests</a>
            </li>
             <li><a href="managerViewReceipts.jsp">View Receipt Images</a>
            </li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Employees<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="managerViewEmployees.jsp">View All Employees</a>
            </li>
            <li><a href="managerSearchByEmployee.jsp">Search Requests by Employee</a>
            </li>
          </ul>
        </li>
        <li><a href="logout.html">Logout</a>
        </li>
      </ul>
    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container-fluid -->
</nav>
<head>
<title>Manager Search Requests By Employee - ERS</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    body {
        background-color: #212f3d;
        margin: 0;
        padding: 0;
        font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
        
    }
     h1 {
     	align: center;
    	color:  #5dade2;
    	font-family: 'Lato', sans-serif;
    	}
    h3 {
     	align: center;
    	color:  white;
    	font-family: 'Lato', sans-serif;
    	}
    </style>    
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
     

</head>
<body>
</br>
<h1><center>Search Requests By Employee</center></h1>
</br>

<h3><center>Employee Directory</center></h3>
<div style="color:white;margin:60px;font-family:'Lato',sans-serif;">
<div id="display_directory" >
</div>

<div style="color:white;margin:60px;font-family:'Lato',sans-serif;">

<h3><center>Employee Selection</center></h3> 
</br>


<!-- <form method="post" action="ManagerSearchByEmployeeServlet"> -->
<form>
    <div class="form-group row">
      <label for="empID" class="col-sm-2 col-form-label">Employee ID</label>
      <div class="col-sm-10">
        <input type="text" name="empID" class="form-control" id="empID" placeholder="Enter the ID of the employee whose requests you would like to see...">
      </div>
    </div>
    
    <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
        <button type="button" class="btn btn-primary" id="viewAll" onclick="loaddata();">View Pending Requests</button>
      </div>
    </div>   
  </form>
  </div>
  
  
<div id="display_info" >
</div>  
</div>


</body>
<script type="text/javascript">

window.onload = function() {
	  $.ajax({
		  type: 'post',
		  url: 'http://localhost:8080/ExpenseReimbursementSystem/ManagerViewEmployeesServlet',
		  data: {
		  },
		  success: function (response) {
		   $( '#display_directory' ).html(response);
		  }
		  });
	};
	
function loaddata()
	{
	 var name=document.getElementById( "viewAll" );
		
	 if(name)
	 {
	  $.ajax({
	  type: 'post',
	  url: 'http://localhost:8080/ExpenseReimbursementSystem/ManagerSearchByEmployeeServlet',
	  data: {
		  empID : $("#empID").val()
	  },
	  success: function (response) {
	   $( '#display_info' ).html(response);
	  }
	  });
	 }
	 else
	 {
	  $( '#display_info' ).html("There are no requests for you to view.");
	 }
	}
	
	
	
	/* $(document).ready(function(){
		$("#btn").click(function(){
		var vempID = $("#empID").val();
		if(vempID=='')
		{
		alert("Please fill out the form");
		}
		else{
		$.post("http://localhost:8080/ExpenseReimbursementSystem/ManagerSearchByEmployee", //Required URL of the page on server
		{ // Data Sending With Request To Server
		empID:vempID
		},
		function(response,status){ // Required Callback Function
		alert("*----Received Data----*\n\nResponse : " + response+"\n\nStatus : " + status);//"response" receives - whatever written in echo of above PHP script.
		$("#form")[0].reset();
		});
		}
		});
		}); */
</script>

<!-- http://talkerscode.com/webtricks/load%20data%20from%20database%20without%20page%20refresh%20using%20ajax%20and%20jquery.php -->
</html>