<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">Welcome to Customer Relationship Management App</h1>
				<table class="table mt-5">
					<thead>
						<tr>
							
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${customers }" var="cus">
						<tr>
							
							<td>${cus.firstName }</td>
							<td>${cus.lastName }</td>
							<td>${cus.email }</td>
							<td>
								<a href="update/${cus.id }">Update</a> |
								<a href="delete/${cus.id }">Delete</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
				<div class="container text-center">
					<a href="add-customer" class="btn btn-outline-success">Add Customer</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>