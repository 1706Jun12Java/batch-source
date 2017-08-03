<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="consume">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script src="book.js" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert</title>
</head>
<body>

	<div ng-controller="getBooks">
		<table> 
			<tr ng-repeat="book in books">
				<td>{{book.name}}</td>
				<td>{{book.author.firstname}}</td>
				<td>{{book.author.lastname}}</td>
				<td>{{book.year}}</td>
			</tr>
		</table>
	</div>
</body>
</html>