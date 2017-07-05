<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/profile.css"/>
<title>Super</title>
</head>
<body>
<div class="container">
<div class="pull-right"><a href="logout">Logout</a></div><hr>
<c:if test="${error!=null}">
<div><h2 style="text-align:center;color:red;">${error}</h2></div><br>
</c:if>
<div class="adminForm">
	<form action="" method="post">
		User ID: <input type="text" name="userID" value=""/><br>
		Username: <input type="text" name="username" value=""/><br>
		Password: <input type="text" name="password" value=""/><br>
		Type: <input type="text" name="type" value="0"/><br>
		<input class="btn btn-success" type="submit" name="submit" value="create"/>
		<input class="btn btn-primary" type="submit" name="submit" value="update"/>
		<input class="btn btn-danger" type="submit" name="submit" value="delete"/>
	</form>
	<br>
</div>
<h2>Users</h2>
<Table>
<caption>Users Table</caption>
<thead><tr><th>ID</th><th>Username</th><th>Password</th><th>Type</th></tr></thead>
<c:forEach items="${userList}" var="user">
<tr>
<td>${user.userID}</td>
<td>${user.username}</td>
<td>${user.password}</td>
<td>${user.userType}</td>
</tr>
</c:forEach>
</Table>



</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>	
</body>
</html>