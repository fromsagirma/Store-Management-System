<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store Dashboard</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<header>
    <div>
        <img src="assets/images/logo.png" alt="Logo">
        <strong>Store Management</strong>
    </div>
    <div>
        Welcome, ${sessionScope.user} |
        <a href="logout">Logout</a>
    </div>
</header>

<div class="container">

    <div class="hero">
        <h1>Manage Your Products Easily</h1>
    </div>

    <!-- Dashboard Statistics -->
    <c:set var="stats" value="${productsDAO.getStats()}" />
    <div class="dashboard-cards">
    <div class="card total-products">
        <h3>Total Products</h3>
        <p>${stats.totalProducts}</p>
    </div>
    <div class="card total-stock">
        <h3>Total Stock</h3>
        <p>${stats.totalQuantity}</p>
    </div>
    <div class="card total-value">
        <h3>Total Inventory Value</h3>
        <p>${stats.totalValue}</p>
    </div>
</div>


    <!-- Add Product Form -->
    <h2>Add New Product</h2>
    <form action="addProduct" method="post">
        <input type="text" name="name" placeholder="Product Name" required>
        <input type="number" step="0.01" name="price" placeholder="Price" required>
        <input type="number" name="quantity" placeholder="Quantity" required>
        <button type="submit">Add Product</button>
        <button type="submit">Sell</button>
    </form>

    <!-- Product Table -->
    <h2>Product Inventory</h2>
    <c:if test="${not empty products}">
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                    <td>${p.quantity}</td>
                    <td>
                        <a href="editProduct?id=${p.id}">Edit</a> |
                        <a href="deleteProduct?id=${p.id}" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty products}">
        <p>No products available.</p>
    </c:if>

</div>

</body>
</html>
