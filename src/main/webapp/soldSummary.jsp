<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.store.model.Product" %>
<html>
<head>
    <title>Products Sold Summary</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
    <div class="container">
        <h2>Products Sold Summary</h2>
        <table>
            <tr>
                <th>Product Name</th>
                <th>Quantity Sold</th>
                <th>Remaining Stock</th>
            </tr>
            <%
                List<Product> soldProducts = (List<Product>) request.getAttribute("soldProducts");
                if (soldProducts != null && !soldProducts.isEmpty()) {
                    for(Product p : soldProducts){
            %>
            <tr>
                <td><%= p.getName() %></td>
                <td><%= p.getSold() %></td>
                <td><%= p.getQuantity() %></td>
            </tr>
            <% 
                    }
                } else { 
            %>
            <tr>
                <td colspan="3" style="text-align:center;">No products sold yet.</td>
            </tr>
            <% } %>
        </table>
        <br>
        <a href="products">Back to Dashboard</a>
    </div>
</body>
</html>
