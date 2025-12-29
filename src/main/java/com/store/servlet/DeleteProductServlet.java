package com.store.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.store.dao.ProductDAO;

public class DeleteProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        try {
            ProductDAO dao = new ProductDAO();
            dao.deleteProduct(id);
            resp.sendRedirect("products");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
