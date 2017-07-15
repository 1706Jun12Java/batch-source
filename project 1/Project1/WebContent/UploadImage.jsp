<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload image</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 695px
}

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
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
	<%
		String user = (String) session.getAttribute("username");
	%>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4><%=user%></h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="EmployeeHomePage.jsp">Home
							Page</a></li>
					<li><a href="ReimbursementRequest.jsp">Reimbursement Menu</a></li>
					<li><a href="logout">Logout</a></li>
				</ul>
				<br>
			</div>
			<div class="col-sm-9">
				<h4>
					<small>Upload</small>
				</h4>
				<hr>
				<h1>
					<small><span class="glyphicon glyphicon-pencil"></span>
						Upload Your Receipts Here</small>
				</h1>
				<br>
				<form method="post" action="upload" enctype="multipart/form-data">
					<b>Enter id of receipt:</b><br> <input type="text" name="r_id"
						required><br><br> <b>Receipt:</b> <input type="file"
						name="receipt" size="50" /><br> <input type="submit"
						value="Submit">
				</form>
				<br>
				<p id="p1"></p>
				<a href="ReimbursementRequest.jsp">go back</a> <br> <br>
			</div>
		</div>
	</div>

	<footer class="container-fluid">
	<p>Reimbursement Inc.</p>
	</footer>
</body>
</html>