<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>Jdbc Template CRUD</title>
</head>
<body>
	<h2>${message}</h2>
	<form:form action="crud" method="post" modelAttribute="forum">
		<div>ID:</div>
		<form:input path="id" value="${forum.id }"/>

		<div>Name:</div>
		<form:input path="name" value="${forum.name }"/>

		<div>Description:</div>
		<form:textarea path="description" rows="3" cols="40" value="${forum.description }"/>
		<br/>
		<br/>
		<input type="submit" value="Insert" name="insert">
		<input type="submit" value="Update" name="update">
		<input type="submit" value="Delete" name="delete">
		<input type="submit" value="Clear">
	</form:form>

	<hr>
	<table class="table table-hover" border="1" style="width: 100%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>&npsp;</th>
		</tr>
		<c:forEach var="u" items="${forums}">
			<tr>
				<td>${u.id}</td>
				<td>${u.name}</td>
				<td>${u.description}</td>
				<td><a href="?edit&id=${u.id}">Edit</a> <a
					href="?delete&id=${u.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<hr>

</body>
</html>