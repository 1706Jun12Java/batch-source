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
<title>Manager Homepage - ERS</title>
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
<h1><center>Manager Homepage</center></h1>
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
      
<!-- View All Requests 
(Update Requests) :: Change Request Status (Approve/Deny Requests) 
Search Requests by Employee 
View All Employees 
View Receipt Images (--> 
  <!--  
  References for Database/ AJAX/ Servlets
  https://stackoverflow.com/questions/14446733/retrieve-db-data-with-java-servlet-and-html-form
  http://talkerscode.com/webtricks/load%20data%20from%20database%20without%20page%20refresh%20using%20ajax%20and%20jquery.php
   -->
</div>
</body>
</html>