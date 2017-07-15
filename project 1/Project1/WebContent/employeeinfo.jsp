<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Settings</title>
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
        <li><a id = "view" style="cursor: pointer;">View Account Information</a></li>
        <li><a href = "EmployeeUpdate.jsp">Update Account Information</a></li>
        <li><a href="logout">Logout</a></li>
      </ul><br>
    </div>
    <div class="col-sm-9">
      <h4><small>Employee Information</small></h4>
      <hr>
      <h2 id = "h"><span class="glyphicon glyphicon-cog"></span> Account Settings</h2>
      <p id = "page">Here you can view your personal information or update your information.</p>
      <br><br>
      <h4 id = "back"></h4>
      <br><br>
    </div>
  </div>
</div>

<footer class="container-fluid">
<p>Reimbursement Inc.</p>
</footer>
</body>
<script src = "scripts/EmployeeScript.js"></script>
</html>