<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<html>
	<head>
		<meta charset="UTF-8">
		<title>Produits</title>
	</head>
	
	<body>
	<jsp:include page="../../../welcome.jsp"></jsp:include>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>NAME</th>
						<th>REFERENCE</th>
						<th>STOCK</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productList}" var="product">
						<tr>
							<td>${product.name}</td>
							<td>${product.reference}</td>
							<td>${product.stock}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container my-3">
			<h3 class="text-center">Add Product</h3>
			<form action="product" method="post">
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Name</label>
			    <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Reference</label>
			    <input type="text" name="reference" class="form-control" id="exampleInputPassword1">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Stock quantity</label>
			    <input type="number" name="stock" class="form-control" id="exampleInputPassword1">
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</body>
</html>