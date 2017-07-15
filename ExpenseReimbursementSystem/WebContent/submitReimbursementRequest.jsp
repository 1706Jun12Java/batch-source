<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
      <a class="navbar-brand" href="employeeHomepage.jsp">Expense Reimbursement System</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right"> 
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reimbursements<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="submitReimbursementRequest.jsp">Submit Reimbursement Request</a>
            </li>
            <li><a href="uploadImage.jsp">Upload Receipt Image</a>
            </li>
            <li><a href="viewRequests.jsp">View Pending/Resolved Requests</a>
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
<title>Employee Homepage - ERS</title>
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
<h1><center>Submit Reimbursement Request</center></h1>
<div style="color:white;margin:60px;font-family:'Lato',sans-serif;">
</br>

  <form method="post" action="reimbReqServlet">
  
      <div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">Reimbursement Type</label>
      <div class="col-sm-10">
      	<p>Options:
      	<p>		Enter "1" for Transportation.</p>
      	<p>		Enter "2" for Relocation.</p>
      	<p>		Enter "3" for Meal. </p>
      	<p>		Enter "4" for Equipment. </p>
      	</p>
      	
        <input type="text" name="rtType" class="form-control" id="RTType" placeholder="Enter a number option...">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">Reimbursement Amount</label>
      <div class="col-sm-10">
        <input type="text" name="rAmount" class="form-control" id="inputRAmount" placeholder="Enter the reimbursement amount ($)...">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">Brief Description</label>
      <div class="col-sm-10">
        <input type="text" name="rDescription" class="form-control" id="inputRDescription" placeholder="Enter a brief description...">
      </div>
    </div>
    
    <!--  Needs to send the user ID, the author ID,  -->
    
    <!--  RT status will be "pending" RT_ID = 1 -->
    
    <div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">Receipt Overview</label>
      <div class="col-sm-10">
        <input type="text" name="rReceipt" class="form-control" id="inputRReceipt" placeholder="Enter Receipt Item: Price">
      </div>
    </div>
   
    <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
        <button type="submit" class="btn btn-primary" id="submitRequest">Submit Request</button>
      </div>
    </div>
    
    
  </form>
</div>
<!-- Utilize AJAX and JS to GET information about the requests from the database -->
</body>

</div>
</body>
<script>
</script>
</html>