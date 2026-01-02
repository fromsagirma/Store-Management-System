package com.store.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.store.dao.ProductDAO;
import com.store.model.Product;

public class EditProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        try {
            ProductDAO dao = new ProductDAO();
            Product p = dao.getAllProducts().stream()
                           .filter(prod -> prod.getId() == id)
                           .findFirst().orElse(null);

            req.setAttribute("product", p);
            req.getRequestDispatcher("/editProduct.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        try {
            ProductDAO dao = new ProductDAO();
            dao.updateProduct(new Product(id, name, price, quantity));
            resp.sendRedirect("products");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
