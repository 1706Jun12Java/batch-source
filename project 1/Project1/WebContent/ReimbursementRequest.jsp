<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursements</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 695px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
      width: 20%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        width: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>
<%String user = (String) session.getAttribute("username");%>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4><%=user %></h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="EmployeeHomePage.jsp">Home Page</a></li>
        <li><a href = "ReimbursementSubmit.jsp">Submit Reimbursements</a></li>
        <li><a id = "view" style="cursor: pointer;">View Pending Reimbursements</a></li>
        <li><a id = "view2" style="cursor: pointer;">View Resolved Reimbursements</a></li>
        <li><a href = "UploadImage.jsp">Upload Receipt</a></li>
        
        <li><a href="logout">Logout</a></li>
      </ul><br>
    </div>
    <div class="col-sm-9">
      <h4><small>Employee Reimbursements</small></h4>
      <hr>
      <h2 id = "h"><span class="glyphicon glyphicon-yen"></span> Reimbursement</h2>
      <p id = "page">Here you can submit your reimbursements as well as view your pending or approved reimbursements</p>
      <div class="container">
      <table id="table" class="table table-condensed">
		<tr>
		</tr>
	</table>
	</div>
      <br>
      <h4 id = "back"></h4>
      <br><br>
    </div>
  </div>
</div>

<footer class="container-fluid">
<p>Reimbursement Inc.</p>
</footer>
</body>
<script src = "scripts/EmployeeReimbursementScript.js"></script>
</html>