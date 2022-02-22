<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Share</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="d-flex p-3">
		<div class="flex-fill">
			<h1>Change Your Entry</h1>
		</div>
		<div class="">
			<a href="/books">back to the shelves</a>
		</div>
	</div>
	
	<div class="container-fluid">
		<div class="row">
			<div class="offset-1 col-8">
				<form:form action="/books/${book.id}" modelAttribute="book" class="form" method="post">
					<input type="hidden" name="_method" value="put"/>
					<form:input type="hidden" path="postedBy" value="${user.id}" class="form-control"/>

					<div class="row my-2">
						<form:label for="title" path="title" class="col-2 col-form-label">Title:</form:label>
						<div class="col-10">
							<form:input type="text" path="title" class="form-control"/>
						 	<form:errors path="title" class="error"/>
						</div>
					</div>
					
					<div class="row my-2">
						<form:label for="authorName" path="authorName" class="col-2 col-form-label">Author:</form:label>
						<div class="col-10">
							<form:input type="text" path="authorName" class="form-control"/>
							<form:errors path="authorName" class="error"/>
						</div>
					</div>
					
					<div class="row my-2">
						<form:label for="review" path="review" class="col-2 col-form-label">Review:</form:label>
						<div class="col-10">
							<form:textarea path="review" class="form-control"/>
							<form:errors path="review" class="error"/>
						</div>
					</div>
					
					<div class="row my-2">
						<div class="col-12 d-flex justify-content-end">
							<input type="submit" value="Submit" class="btn btn-primary"/>
						</div>
					</div>
					
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>