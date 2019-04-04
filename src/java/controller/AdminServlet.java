/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Stranke;
import entity.FakstavkePro;
import entity.FakturePro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import session.StrankeFacade;
import session.FakstavkeProFacade;
import session.FaktureProFacade;
import session.OrderManager;

/**
 *
 * @author tgiunipero
 */
@WebServlet(name = "AdminServlet",
            urlPatterns = {"/admin/",
                           "/admin/viewOrders",
                           "/admin/viewCustomers",
                           "/admin/customerRecord",
                           "/admin/orderRecord",
                           "/admin/logout"})
@ServletSecurity(        
        @HttpConstraint(
                transportGuarantee = TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"prodavnicaDeloviAdmini"}))
public class AdminServlet extends HttpServlet {

    @EJB
    private OrderManager orderManager;
    @EJB
    private StrankeFacade strankeFacade;
    @EJB
    private FaktureProFacade faktureProFacade;

    private String userPath;
    private Stranke stranka;
    private FakturePro faktura;
    private List listaFaktura = new ArrayList();
    private List customerList = new ArrayList();


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        userPath = request.getServletPath();

        // if viewCustomers is requested
        if (userPath.equals("/admin/viewCustomers")) {
            customerList = strankeFacade.findAll();
            request.setAttribute("customerList", customerList);
        }

        // if viewOrders is requested
        if (userPath.equals("/admin/viewOrders")) {
            listaFaktura = faktureProFacade.findAll();
            request.setAttribute("orderList", listaFaktura);
        }

        // if customerRecord is requested
        if (userPath.equals("/admin/customerRecord")) {

            // get customer id from request
            String customerId = request.getQueryString();

            // get customer details
            stranka = strankeFacade.find(Integer.parseInt(customerId));
            request.setAttribute("customerRecord", stranka);

            // get customer order details
            faktura = faktureProFacade.findByStranka(stranka);
            request.setAttribute("order", faktura);
        }

        // if orderRecord is requested
        if (userPath.equals("/admin/orderRecord")) {

            // get customer id from request
            String orderId = request.getQueryString();

            // get order details
            Map orderMap = orderManager.getOrderDetails(Integer.parseInt(orderId));

            // place order details in request scope
            request.setAttribute("customer", orderMap.get("customer"));
            request.setAttribute("products", orderMap.get("products"));
            request.setAttribute("orderRecord", orderMap.get("orderRecord"));
            request.setAttribute("orderedProducts", orderMap.get("orderedProducts"));
        }

        // if logout is requested
        if (userPath.equals("/admin/logout")) {
            session = request.getSession();
            session.invalidate();   // terminate session
            response.sendRedirect("/FotoDeloviProdavnica/admin/");
            return;
        }

        // use RequestDispatcher to forward request internally
        userPath = "/admin/index.jsp";
        try {
            request.getRequestDispatcher(userPath).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}