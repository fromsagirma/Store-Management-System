package com.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.store.model.Customer;

public class CustomerDAO {
    public void addCustomer(Customer c) throws Exception {
    Connection con = DBConnection.getConnection();
    PreparedStatement ps =
        con.prepareStatement("INSERT INTO customers(name,email,phone) VALUES (?,?,?)");
    ps.setString(1, c.getName());
    ps.setString(2, c.getEmail());
    ps.setString(3, c.getPhone());
    ps.executeUpdate();
    ps.close();
    con.close();
}


}
