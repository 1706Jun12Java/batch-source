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

<h4 style="color:red;"><center>Your submission was successful!</center></h4>
<h1><center>Employee Homepage</center></h1>
<h3 style="color:#5dade2;margin:40px;font-family:'Lato',sans-serif;">Profile</h3>
<div style="color:white;margin:60px;font-family:'Lato',sans-serif;">
	 
	 <%
 		String un = (String) request.getSession(false).getAttribute("username");
		out.println("Username: " + un);
      %>
     </br>
      <%
    	String pw = (String) request.getSession(false).getAttribute("password");
		out.println("Password: " + pw);
      %>
      </br>
      <%
    	String fn = (String) request.getSession(false).getAttribute("firstname");
		out.println("First Name: " + fn);
      %>
      </br>
      <%
    	String ln = (String) request.getSession(false).getAttribute("lastname");
		out.println("Last Name: " + ln);
      %>
      </br>
      <%
    	String em = (String) request.getSession(false).getAttribute("email");
		out.println("Email: " + em);
      %>

</div>
	
	 <center><button type="button" class="btn btn-info btn-lg" onclick="location.href = 'updateProfile.html'">Update Profile</button></center>
     

</body>
</html>