<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Admin</title>
	</head>
	<body>
		<jsp:include page="../../../welcome.jsp"></jsp:include>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>EMAIL</th>
						<th>STATE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.email}</td>
							 <c:choose>
					            <c:when test="${user.state == false}">
					                <td>Deactivated</td>
					            </c:when>
					            <c:otherwise>
					                <td>Activated</td>
					            </c:otherwise>
					        </c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container my-3">
			<h3 class="text-center">Add User</h3>
			<form action="admin" method="post">
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Email</label>
			    <input type="text" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Password</label>
			    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">State</label>
			    <select name="state" class="form-select">
			    	<option value="1">Activated</option>
			    	<option value="0">Deactivated</option>
			    </select>
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</body>
</html>