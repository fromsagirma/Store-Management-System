package com.store.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.store.dao.ProductDAO;
import com.store.model.Product;

public class AddProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        try {
            Product p = new Product(0, name, price, quantity); // ID auto-generated
            ProductDAO dao = new ProductDAO();
            dao.addProduct(p);
            resp.sendRedirect("products"); // Redirect to product list
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
