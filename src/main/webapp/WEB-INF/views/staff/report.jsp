<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>Bai_4 SQL</title>
</head>
<body>
<h2>${error}</h2>
	<table class="table table-hover" border="1">
		<tr>
			<th>Mã NV</th>
			<th>Tổng thành tích</th>
			<th>Tổng kỷ luật</th>
			<th>Tổng kết</th>
		</tr>
		<c:forEach var="u" items="${arrays}">
			<tr>
				<td>${u[0]}</td>
				<td>${u[1]}</td>
				<td>${u[2]}</td>
				<td>${u[1]-u[2]}</td>
			</tr>
		</c:forEach>
	</table>
	<hr><form action="index" method="post">
		<button>Home</button>
	</form>
</body>
</html>