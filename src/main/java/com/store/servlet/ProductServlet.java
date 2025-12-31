package com.store.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import com.store.dao.ProductDAO;
import com.store.model.Product;

public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ProductDAO dao = new ProductDAO();

        try {
            // Get all products
            List<Product> products = dao.getAllProducts();
            req.setAttribute("products", products);
        } catch (Exception e) {
            e.printStackTrace(); // log the error
            req.setAttribute("products", null);
        }

        try {
            // Get total products
            int totalProducts = dao.getTotalProducts();
            req.setAttribute("totalProducts", totalProducts);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("totalProducts", 0);
        }

        try {
            // Get total stock
            int totalStock = dao.getTotalStock();
            req.setAttribute("totalStock", totalStock);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("totalStock", 0);
        }

        try {
            int totalSold = dao.getTotalSold();
            req.setAttribute("totalSold", totalSold);
        } catch(Exception e) {
            e.printStackTrace();
            req.setAttribute("totalSold", 0);
        }


        // Forward to JSP AFTER setting all attributes
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
