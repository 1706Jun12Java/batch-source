<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Reimbursement Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    .row.content {
    height: 695px;
    background-color: #e9e9e9;
    }
    .h4{
    color: white;
    }
    input {
    width: 50%;
    }
    hr {
    border-top-color: #898989;
    border-right-color: currentcolor;
	border-bottom-color: currentcolor;
	border-left-color: currentcolor;
	width: 110%;
    }
    .sidenav {
      background-color:  #34495e;
      height: 100%;
      width: 17%;
    }
    .active {
    color: #dcf4be;
    }  
    .input-group-btn > .btn {
    position: relative;
}
    
    .input-group .form-control {
    position: relative;
    z-index: 2;
    float: left;
    width: 100%;
    margin-bottom: 0;
    height: 30px;
}
    
    footer {
      background-color: #212121;
      color: white;
      padding: 15px;
    }
        @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>
<%String user = (String) session.getAttribute("musername");%>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4 class = "h4"><%=user %></h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="ManagerHomePage.jsp">Home Page</a></li>
        <li><a href="ApproveOrDeny.jsp">Approve/Deny Requests</a></li>
        <li><a id = "view" style="cursor: pointer;">View all pending requests</a></li>
        <li><a id = "view2" style="cursor: pointer;">View all resolved requests</a></li>
        <li><a href="ViewImage.jsp">View Receipts</a></li>
        <li><a href="Search.jsp">Search</a></li>
        <li><a href="logout">Logout</a></li>
      </ul>
    </div>
    <div class="col-sm-9">
      <h3><small>Reimbursements</small></h3>
      <hr>
      <h2 id = "h">Manage Reimbursements</h2>
      <p id = "page">Here you can view reimbursement requests made by employees. Any pending reimbursements must be approved or denied 
      and a expense report must be written up for review. If you wish to search reimbursements from a specific user please use
      the search feature.</p>
      <br>
      <div class="container">
      <table id="table" class="table table-condensed">
		<tr>
		</tr>
	</table>
	</div>
      <br><br>
      <h4 id = "back"></h4>
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Reimbursement Inc.</p>
</footer>
</body>
<script src = "scripts/ManagerReimbursementScript.js"></script>
</html>