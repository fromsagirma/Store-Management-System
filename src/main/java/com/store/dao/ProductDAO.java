package com.store.dao;

<<<<<<< HEAD
public class ProductDAO {

=======
import com.store.model.Product;
import java.sql.*;
import java.util.*;


public class ProductDAO {

    public List<Product> getAllProducts() throws Exception {
        List<Product> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM products");

        while (rs.next()) {
            list.add(new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("quantity")
            ));
        }
        return list;
    }

    public void addProduct(Product p) throws Exception {
    Connection con = DBConnection.getConnection();
    String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, p.getName());
    ps.setDouble(2, p.getPrice());
    ps.setInt(3, p.getQuantity());
    ps.executeUpdate();
    ps.close();
    con.close();
}

// Delete product by ID
public void deleteProduct(int id) throws Exception {
    Connection con = DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE id=?");
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
    con.close();
}

// Update product by ID
public void updateProduct(Product p) throws Exception {
    Connection con = DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement(
        "UPDATE products SET name=?, price=?, quantity=? WHERE id=?"
    );
    ps.setString(1, p.getName());
    ps.setDouble(2, p.getPrice());
    ps.setInt(3, p.getQuantity());
    ps.setInt(4, p.getId());
    ps.executeUpdate();
    ps.close();
    con.close();
}

// Dashboard statistics
public Map<String, Object> getStats() throws Exception {
    Map<String, Object> stats = new HashMap<>();
    Connection con = DBConnection.getConnection();
    Statement st = con.createStatement();

    ResultSet rs1 = st.executeQuery("SELECT COUNT(*) AS total FROM products");
    if(rs1.next()) stats.put("totalProducts", rs1.getInt("total"));
    rs1.close();

    ResultSet rs2 = st.executeQuery("SELECT SUM(quantity) AS totalQty FROM products");
    if(rs2.next()) stats.put("totalQuantity", rs2.getInt("totalQty"));
    rs2.close();

    ResultSet rs3 = st.executeQuery("SELECT SUM(price*quantity) AS totalValue FROM products");
    if(rs3.next()) stats.put("totalValue", rs3.getDouble("totalValue"));
    rs3.close();

    st.close();
    con.close();
    return stats;
}


public int getTotalProducts() throws Exception {
    Connection con = DBConnection.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM products");
    rs.next();
    int total = rs.getInt(1);
    rs.close();
    st.close();
    con.close();
    return total;
}

public int getTotalStock() throws Exception {
    Connection con = DBConnection.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT SUM(quantity) FROM products");
    rs.next();
    int total = rs.getInt(1);
    rs.close();
    st.close();
    con.close();
    return total;
}


// Total products sold
public int getTotalSold() throws Exception {
    Connection con = DBConnection.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT SUM(sold) FROM products");
    rs.next();
    int total = rs.getInt(1);
    rs.close();
    st.close();
    con.close();
    return total;
}


// Sell specified quantity
public void sellProduct(int id, int quantityToSell) throws Exception {
    Connection con = DBConnection.getConnection();
    String sql = "UPDATE products SET quantity = quantity - ?, sold = sold + ? WHERE id = ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, quantityToSell);
    ps.setInt(2, quantityToSell);
    ps.setInt(3, id);
    ps.executeUpdate();
    ps.close();
    con.close();
}



// Get list of products with sold > 0
public List<Product> getSoldProducts() throws Exception {
    List<Product> list = new ArrayList<>();
    Connection con = DBConnection.getConnection();
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM products WHERE sold > 0");
    while (rs.next()) {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setQuantity(rs.getInt("quantity"));
        p.setSold(rs.getInt("sold"));
        list.add(p);
    }
    rs.close();
    st.close();
    con.close();
    return list;
}


>>>>>>> 864d63c132408056cc60481b5e87ba363165a607
}
