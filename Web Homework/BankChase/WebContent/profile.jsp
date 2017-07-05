<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
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
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="MainPage.html">Home</a></li>
					<li><a href="withdrawal.html">Withdrawal</a></li>
					<li><a href="deposit.html">Deposit</a></li>
					<li><a href="checkbalance.html">Check Balance</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="LogoutServlet"><span class="glyphicon glyphicon-log-in"></span>
							Logout</a></li>
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
			<% 
				String user = (String) session.getAttribute("username");
			%>
				<h1>Welcome to your Chase Profile <%=user %></h1>

				<hr>
				<h3>Mission Statement</h3>
				<p>It is our goal to take as much money as we can from you to further benefit us
				and make sure we stay as rich as possible</p>
				<h4>Transactions</h4>
				<p> If you agree with our mission statement then please look over your options on the navigation bar 
				located at the top of the page and choose to deposit your money with us</p>
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