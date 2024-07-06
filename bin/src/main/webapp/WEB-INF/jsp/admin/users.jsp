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
						<th>ETAT</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.email}</td>
							<c:if test="${user.state == true}">
								<td>Activé</td>
							</c:if>
							<c:if test="${user.state == false}">
								<td>Desactivé</td>
							</c:if>
							
						</tr>
					</c:forEach>
				</tbody>
			
			</table>
		</div>
	</body>
</html>