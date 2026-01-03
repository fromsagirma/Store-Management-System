< %@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
<div class="container">
<h2>Edit Product</h2>
<c:if test="${not empty product}">
<form action="editProduct" method="post">
    <input type="hidden" name="id" value="${product.id}" />
    <input type="text" name="name" value="${product.name}" required />
    <input type="number" step="0.01" name="price" value="${product.price}" required />
    <input type="number" name="quantity" value="${product.quantity}" required />
    <button type="submit">Update Product</button>
</form>
</c:if>
</div>
</body>
</html>
