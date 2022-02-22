<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Book Share</title>
</head>
<body>

	<div class="d-flex p-3">
		<div class="flex-fill">
			<h1>Welcome, ${user.firstName}</h1>
			<h5>Books from everyone's shelves</h5>
		</div>
		<div class="text-end">
			<a href="/logout">logout</a>
			<br />
			<a href="/books/new">+ Add a book to my shelf!</a>
		</div>
	</div>

	<div class="d-flex p-3">
		<table class="table">
			<thead>
				<tr>
					<td>ID</td>
					<td>TITLE</td>
					<td>AUTHOR NAME</td>
					<td>POSTED BY</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.id}" /></td>
						<td><a href="/books/${book.id}"><c:out
									value="${book.title}" /></a></td>
						<td><c:out value="${book.authorName}" /></td>
						<td><c:out value="${book.postedBy.firstName}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>