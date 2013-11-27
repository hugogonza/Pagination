/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import ejb.ProductManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HugoCésar
 */
@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

    @EJB
    private ProductManager productManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("displayProducts".equals(action)) {
            String sfrom = request.getParameter("from");
            Integer from = Integer.valueOf(sfrom);
            String sto = request.getParameter("to");
            Integer count = Integer.valueOf(sto);

            List<Product> pp = productManager.selectProducts(from, count);

            request.setAttribute("products", pp);
            request.setAttribute("from", from+count);
            request.setAttribute("count",count);

        }

        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

}
