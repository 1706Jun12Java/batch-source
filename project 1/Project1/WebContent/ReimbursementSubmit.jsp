<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit Reimbursement</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    .row.content {height: 695px}
    
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
      width: 20%;
    }
    
    footer {
      background-color: #555;
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
<%String user = (String) session.getAttribute("username");%>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4><%=user %></h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="EmployeeHomePage.jsp">Home Page</a></li>
        <li><a href="ReimbursementRequest.jsp">Reimbursements</a></li>
        <li><a href="logout">Logout</a></li>
      </ul><br>
    </div>
    <div class="col-sm-9">
      <h4><small>Employee Reimbursements</small></h4>
      <hr>
      <h1><small>Submit Reimbursement</small></h1>
      <br>
      <form action = "reimburserequest" method = "post">
      <h4>Select reimbursement type</h4>
      <select name = "type">
      	<option value="1">Business</option>
 	 	<option value="2">Medical</option>
  		<option value="3">Travel</option>
  		<option value="4">Education</option>
      </select>
      <h4>Amount:</h4>
      <input type = "text" name = "amount" required>
      <h4>Description:</h4>
      <input type = "text" name = "description" required>
      <br><br>
      <button type="submit">Submit</button>
      </form>
      <br>
      <p id = "p1"></p>
      <a href = "ReimbursementRequest.jsp">go back</a>
      <br><br>
    </div>
    </div>
  </div>
</div>

<footer class="container-fluid">
<p>Reimbursement Inc.</p>
</footer>
</body>
</html>