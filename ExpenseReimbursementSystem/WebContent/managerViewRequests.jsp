<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Manager View Requests - ERS</title>
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
    </style>    
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
     

</head>
<body>
</br>
<h1><center>Manager View Requests</center></h1>
<div style="color:white;margin:60px;font-family:'Lato',sans-serif;">
<table class="table table-hover">
    <thead>
      <tr>
        <th>RT_Status ID</th>
        <th>RT_Status</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>PENDING</td>
      </tr>
      <tr>
        <td>2</td>
        <td>RESOLVED</td>
      </tr>
      <tr>
        <td>3</td>
        <td>REJECTED</td>
      </tr>
    </tbody>
  </table>
</div>


<!-- <center><button type="submit" class="btn btn-primary" id="viewAll" onclick="loaddata();">View All Requests</button></center> -->
<div id="display_info" >
</div>  

</body>
<script type="text/javascript">

window.onload = function() {
	  $.ajax({
		  type: 'post',
		  url: 'http://localhost:8080/ExpenseReimbursementSystem/ManagerViewRequests',
		  data: {
		  },
		  success: function (response) {
		   $( '#display_info' ).html(response);
		  }
		  });
	};

/* function loaddata()
{
 var name=document.getElementById( "viewAll" );
	
 if(name)
 {
  $.ajax({
  type: 'post',
  url: 'http://localhost:8080/ExpenseReimbursementSystem/ManagerViewRequests',
  data: {
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
} */
</script>
<!-- http://talkerscode.com/webtricks/load%20data%20from%20database%20without%20page%20refresh%20using%20ajax%20and%20jquery.php -->
</html>