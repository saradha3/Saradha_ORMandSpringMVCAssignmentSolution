<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Update customer details</h1>

				<form action="${pageContext.request.contextPath }/handle-customer" method="post">
				
				<input type="hidden" value="${customer.id}" name="id" />
				
					<div class="form-group">
						<label for="firstName" class="form-label">First Name</label>
						 <input type="text" class="form-control"
							id="firstName" name="firstName" value="${customer.firstName }" aria-describedby="emailHelp">
					</div>
					<div class="form-group">
						<label for="lastName" class="form-label">Last Name</label>
						 <input type="text" class="form-control"
							id="lastName" name="lastName" value="${customer.lastName }" aria-describedby="emailHelp">
					</div>
					<div class="form-group">
						<label for="email" class="form-label">Email</label>
						 <input type="email" class="form-control"
							id="email" name="email" value="${customer.email }" aria-describedby="emailHelp">
					</div>
				
					<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back to list</a>
					<button type="submit" class="btn btn-primary">Update</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>