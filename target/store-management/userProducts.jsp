<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Products</title>
<link rel="stylesheet" href="assets/css/style.css">
<style>
.container { max-width: 900px; margin: 30px auto; padding: 20px; background: #fff; border-radius: 8px; }
table { width: 100%; border-collapse: collapse; }
th, td { padding: 12px; border-bottom: 1px solid #ddd; }
th { background: #e5e7eb; }
h2 { color: #1e293b; margin-bottom: 20px; }
</style>
</head>
<body>

<header>
    <div>
        <img src="assets/images/logo.png" alt="Logo">
        <strong>Store Catalog</strong>
    </div>
    <div>
        <a href="index.jsp">Home</a>
    </div>
</header>

<div class="container">
    <h2>Available Products</h2>

    <c:if test="${not empty products}">
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity Available</th>
            </tr>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.name}</td>
                    <td>$${p.price}</td>
                    <td>${p.quantity}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty products}">
        <p>No products are currently available.</p>
    </c:if>
</div>

</body>
</html>
