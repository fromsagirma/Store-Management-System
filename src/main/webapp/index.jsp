<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store Dashboard</title>
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/style.css?v=1">
</head>

<body>

<header>
    <div>
        <img src="assets/images/logo3.png" alt="Logo">
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
    <div class="stats">
    <div class="card">
        <h3>Total Products</h3>
        <p>${totalProducts}</p>
    </div>
    <div class="card">
        <h3>Total Stock</h3>
        <p>${totalStock}</p>
    </div>
    <div class="card">
    <h3>Products Sold</h3>
    <p>${totalSold}</p>
    <a href="soldSummary" class="btn-view">View Sold Products</a>

      </div>

      


</div>

    <!-- Add Product Form -->
    <h2>Add New Product</h2>
    <form action="addProduct" method="post">
        <input type="text" name="name" placeholder="Product Name" required>
        <input type="number" step="0.01" name="price" placeholder="Price" required>
        <input type="number" name="quantity" placeholder="Quantity" required>
        <button type="submit">Add Product</button>
    </form>

    <!-- Product Table -->
    
    <c:if test="${not empty products}">
        <h2>Product Inventory</h2>
        <input type="text" id="search" class="search-input"
       placeholder="Search products..."
       onkeyup="filterTable()">


       

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
                    <td>
                        <form action="sellProduct" method="post" style="display:inline-block;">
                            <input type="hidden" name="id" value="${p.id}">
                            <input type="number" name="quantity" placeholder="Qty" min="1" max="${p.quantity}" 
                                required style="width:60px; padding:4px; border-radius:4px; border:1px solid #ccc;">
                            <button type="submit" class="btn-sell">Sell</button>
                        </form>
                        
                    </td>


                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty products}">
        <p>No products available.</p>
    </c:if>

</div>

<script>
function filterTable() {
    let input = document.getElementById("search").value.toLowerCase();
    let rows = document.querySelectorAll("table tr");

    rows.forEach((row, index) => {
        if (index === 0) return;
        row.style.display =
            row.innerText.toLowerCase().includes(input) ? "" : "none";
    });
}
</script>

</body>
</html>
