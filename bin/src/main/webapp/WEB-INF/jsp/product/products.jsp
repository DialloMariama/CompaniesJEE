<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Product</title>
	</head>
	<body>
		<jsp:include page="../../../welcome.jsp"></jsp:include>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<td>ID</td>
						<td>NAME</td>
						<td>REFERENCE</td>
						<td>STOCK</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td>${product.id}</td>
							<td>${product.firstName}</td>
							<td>${product.lastName}</td>
							<td>${product.email}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container">
			<form action="product" method="post">
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Name</label>
			    <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Reference</label>
			    <input type="text" name="reference" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Stock</label>
			    <input type="number" min=0 name="stock" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			  </div>
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</body>
</html>