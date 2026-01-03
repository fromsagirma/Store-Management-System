package com.store.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import com.store.dao.ProductDAO;
import com.store.model.Product;

public class SoldSummaryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            ProductDAO dao = new ProductDAO();
            List<Product> soldProducts = dao.getSoldProducts();
            req.setAttribute("soldProducts", soldProducts);
            req.getRequestDispatcher("soldSummary.jsp").forward(req, resp);
        } catch(Exception e) {
            throw new ServletException(e);
        }
    }
}
