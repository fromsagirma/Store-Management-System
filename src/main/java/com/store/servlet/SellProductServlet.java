package com.store.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.store.dao.ProductDAO;

public class SellProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            int qty = Integer.parseInt(req.getParameter("quantity"));

            ProductDAO dao = new ProductDAO();
            dao.sellProduct(id, qty);

            resp.sendRedirect("products"); // back to dashboard
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
