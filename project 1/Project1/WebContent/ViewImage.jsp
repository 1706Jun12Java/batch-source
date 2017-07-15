<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Reimbursements</title>
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
    hr {
    border-top-color: #898989;
    border-right-color: currentcolor;
	border-bottom-color: currentcolor;
	border-left-color: currentcolor;
	width: 110%;
    }
    small {
    color: black;
    }
    .sidenav {
      background-color:  #34495e;
      height: 100%;
      width: 17%;
    }
    .active {
    color: #dcf4be;
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
        <li><a href="logout">Logout</a></li>
      </ul><br>
    </div>
    <div class="col-sm-9">
      <h4><small>Search Reimbursements</small></h4>
      <hr>
      <h1 id = "h"><small><span class=""></span> Search Reimbursements from specific users</small></h1>
      <br>
      <form action = "ViewImage" method = "get">
      <button type="submit" >Receipt</button>
      </form>
      <br>
      <p "></p>
      <a href = "ManagerReimbursementPage.jsp">go back</a>
      <br><br>
    </div>
  </div>
</div>

<footer class="container-fluid">
<p>Reimbursement Inc.</p>
</footer>
</body>
</html>