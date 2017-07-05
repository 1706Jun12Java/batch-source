<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.navbar {
	margin-bottom: 0;
	border-radius: 0;
	background-color: #1F57B0;
}

.row.content {
	height: 644px;
}

.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
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
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="MainPage.html">Home</a></li>
				<li><a href="profile.html">Profile</a></li>
				<li><a href="deposit.html">Deposit</a></li>
				<li><a href="checkbalance.html">Check Balance</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="LogoutServlet"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</div>
</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>
					<a href="createaccount.html">Create new account</a>
				</p>
				<p>
					<a href="#">Delete existing account</a>
				</p>
				<p>
					<a href="#"></a>
				</p>
			</div>
			<div class="col-sm-8 text-left">
				<h1></h1>

				<hr>

				<h3>Transaction completed</h3>
				<br>
				<%
					String amount = request.getParameter("amount");
				%>
				<h4>
					You deposited $<%=amount%></h4>
				<br> <a href="deposit.html">go back</a>
			</div>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>Insert AD here to make more money</p>
				</div>
				<div class="well">
					<p>Insert AD here to make more money</p>
				</div>
			</div>
		</div>
	</div>
		<footer class="container-fluid text-center">
		<p>Chase,JPMorgan,JPMorgan Chase, the JPMorgan Chase logo and the Octagon Symbol are trademarks of JPMorgan Chase Bank, N.A.  JPMorgan Chase Bank, N.A. is a wholly-owned subsidiary of JPMorgan Chase and Co.</p>
	</footer>
</body>
</html>