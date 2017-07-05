<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/profile.css"/>
<title>Main Activities</title>
</head>
<body>
<div class="container">
<div class="pull-right"><a href="logout">Logout</a></div>
<c:if test="${error!=null}">
<div><h2 style="text-align:center;color:red;">${error}</h2></div><br>
</c:if>

<h2>Accounts</h2>
<form action="" method="post">
	<input type="submit" name="submit" value="create"/>
</form>
<br>
<c:forEach items="${accounts}" var="ac">
<p>
${ac.toString()}
</p>
<form action="" method="post">
	<input type="text" name="amount" value="0.0"/>
	<input class="btn btn-success" type="submit" name="submit" value="deposite"/>
	<input class="btn btn-primary" type="submit" name="submit" value="withdraw"/>
	<input class="btn btn-danger" type="submit" name="submit" value="delete"/>
	<input type="hidden" value=${ac.acID} name="acID" />
</form>
<br>
</c:forEach>
<hr>
<h2>Transactions</h2>
<c:forEach items="${TransLists}" var="tranList">
<hr>
<table>
<caption>account id ${tranList.get(0).acID}</caption>
<thead><tr><td>ID</td><td>Time</td><td>Action</td><td>Before</td><td>After</td></tr></thead>

		<c:forEach items="${tranList}" var="t">
		<tr>
		<td>${t.tranID}</td>
		<td>${t.tranDate}</td>
		<td>${t.actionType}</td>
		<td>${t.beforeBal}</td>
		<td>${t.afterBal}</td>
		</tr>
		</c:forEach>
</table>
<hr>
</c:forEach>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>	
</body>
</html>