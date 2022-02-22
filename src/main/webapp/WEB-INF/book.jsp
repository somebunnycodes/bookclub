<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="d-flex p-3">
		<div class="flex-fill">
			<h1><c:out value="${book.title}"/></h1>
		</div>
		<div class="">
			<a href="/books">back to the shelves</a>
		</div>
	</div>
		
	<div class="container-fluid">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-8">
				<h3><span style="color: crimson;"><c:out value="${book.postedBy.firstName}"/></span> read 
				<span style="color: indigo;"><c:out value="${book.title}"/></span> by 
				<span style="color: forestgreen;"><c:out value="${book.authorName}"/></span></h3>
		
				<h4>Here are <c:out value="${book.postedBy.firstName}"/>'s thoughts:</h4>
				
				<hr />
						
				<p><c:out value="${book.review}"/></p>
				
				<hr />
				<div class="w-100 d-flex justify-content-end">
					<a href="/books/${book.id}/edit" class="btn btn-warning">edit</a>
				</div>
			</div>
			<div class="col-3"></div>
		</div>
	</div>

</body>
</html>