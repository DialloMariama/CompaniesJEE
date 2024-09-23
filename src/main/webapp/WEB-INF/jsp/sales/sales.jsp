<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sales</title>
</head>
<body>
    <jsp:include page="../../../welcome.jsp"></jsp:include>
    <div class="container">
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Produit</th>
                    <th>Quantité</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${salesList}" var="sale">
                    <tr>
                        <td>${sale.id}</td>
                        <td>${sale.product.name}</td>
                        <td>${sale.quantity}</td>
                        <td>${sale.dateP}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="container">
        <form action="sales" method="post">
            <div class="mb-3">
                <label for="inputProduct" class="form-label">Produit</label>
                <select name="productRef" class="form-control" id="inputProduct" required>
                    <c:forEach items="${productList}" var="product">
                        <option value="${product.ref}">${product.ref} - ${product.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="inputQuantity" class="form-label">Quantité</label>
                <input type="number" name="quantity" class="form-control" id="inputQuantity" required>
            </div>
            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form>
    </div>
</body>
</html>
