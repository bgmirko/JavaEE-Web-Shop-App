/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.ShoppingCart;
import entity.Artikli;
import entity.ArtikliGrp;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ArtikliFacade;
import session.ArtikliGrpFacade;
import session.EmailSessionBean;
import session.OrderManager;
import validate.Validator;

/**
 *
 * @author Mirko
 */
@WebServlet(name = "ControllerServlet",
        loadOnStartup = 1,
        urlPatterns = {"/category",
            "/search",
            "/addToCart",
            "/viewCart",
            "/updateCart",
            "/checkout",
            "/confirmation",
            "/purchase",
            "/chooseLanguage",
            "/contact",
            "/privacy",
            "/aboutUs",
            "/conditions",
            "/updateCartRemoveItem"})
public class ControllerServlet extends HttpServlet {

    private String surcharge;
    @EJB
    private ArtikliGrpFacade artikliGrpFacade;
    @EJB
    private ArtikliFacade artikliFacade;
    @EJB
    private OrderManager orderManager;
    @EJB
    private EmailSessionBean emailBean;
    private List<Artikli> subListaGrpArtk;

    // boolean can be yes or no
    // Boolean can be yes, no or NULL.
    private boolean emailSuccessfullySent = false;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);

        // initialize servlet with configuration information
        surcharge = servletConfig.getServletContext().getInitParameter("deliverySurcharge");

        getServletContext().setAttribute("grupeArtikli", artikliGrpFacade.findAll());

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        ArtikliGrp selectedGrupaArtikla;

        if (userPath.equals("/category")) {

            String categoryId = request.getParameter("categoryId");
            String strana = request.getParameter("strana");
            List<Artikli> artikliInGrup;

            if (categoryId != null) {
                selectedGrupaArtikla = artikliGrpFacade.find(Integer.parseInt(categoryId));
                artikliInGrup = (List<Artikli>) selectedGrupaArtikla.getArtikliCollection();
                setSessionData(artikliInGrup, session, selectedGrupaArtikla.getNaziv());
            }

            if (strana != null) {
                artikliInGrup = (List<Artikli>) session.getAttribute("artikliInGrup");
                int str = Integer.parseInt(strana);
                int doArtikla = str * 10;
                if (doArtikla > artikliInGrup.size()) {
                    doArtikla = artikliInGrup.size();
                }
                subListaGrpArtk = artikliInGrup.subList(str * 10 - 10, doArtikla);
                session.setAttribute("listaArtikalaNaStrani", subListaGrpArtk);
                session.setAttribute("strana", str);
            }
        } else if (userPath.equals("/viewCart")) {

            String clear = request.getParameter("clear");

            if ((clear != null) && clear.equals("true")) {
                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                cart.clear();
            }

            userPath = "/cart";

            // if checkout page is requested
        } else if (userPath.equals("/checkout")) {

            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            // izracunaj total
            cart.calculateTotal(surcharge);

        } else if (userPath.equals("/chooseLanguage")) {

            String language = request.getParameter("language");

            // postavlja u request scope
            request.setAttribute("language", language);

            String userView = (String) session.getAttribute("view");

            if ((userView != null)
                    && (!userView.equals("/index"))) {     // (index.jsp izvan 'view' folder)
                // pa se prosledjuje odvojeno
                userPath = userView;
            } else {

                // ukoliko strana sa koje posetilac dolazi ne moze da se utvrdi , salje ga na index stramu
                try {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return;
            }
        } else if (userPath.equals("/contact")) {
            request.setAttribute("testMessageSent", request.getParameter("testMessageSent"));
            userPath = "/contact";

        } else if (userPath.equals("/aboutUs")) {

            userPath = "/aboutUs";

        } else if (userPath.equals("/conditions")) {

            userPath = "/conditions";

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        Validator validator = new Validator();

        if (userPath.equals("/search")) {

            String searchText = request.getParameter("searchDatabase");

            if (!searchText.isEmpty()) {
                List<Artikli> artSerchList = artikliFacade.findInputText(searchText);

                setSessionData(artSerchList, session, "searchResults");

                session.setAttribute("strana", 1);
            } else {
                session.setAttribute("selectedGrupaNaziv", "searchResults");
//                session.setAttribute("artikliInGrup", null);
//                session.setAttribute("listaArtikalaNaStrani", null);
//                session.setAttribute("ukupnoArtikala", 0);
                session.setAttribute("ukupnoStrana", 0);

            }

            userPath = "/category";

        } else if (userPath.equals("/addToCart")) {
            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }

            String artikalId = request.getParameter("artikalId");

            if (!artikalId.isEmpty()) {
                Artikli artikal = artikliFacade.find(Integer.parseInt(artikalId));
                cart.addItem(artikal);
            }

//            userPath = "/category";
            userPath = "/cart";

        } else if (userPath.equals("/updateCart")) {

            String productId = request.getParameter("productId");
            String quantity = request.getParameter("quantity");

            boolean invalidEntry;
            invalidEntry = validator.validateQuantity(productId, quantity, request);

            if (!invalidEntry) {
                Artikli artika = artikliFacade.find(Integer.parseInt(productId));
                if (artika.getNaLageru() < Integer.parseInt(quantity)) {
                    quantity = Integer.toString(artika.getNaLageru());
                }
                cart.update(artika, quantity);
            }
            userPath = "/cart";

        } else if (userPath.equals("/updateCartRemoveItem")) {

            String productId = request.getParameter("productIdRemove");
            Artikli artika = artikliFacade.find(Integer.parseInt(productId));
            cart.update(artika, "0");

            userPath = "/cart";

        } else if (userPath.equals("/purchase")) {

            if (cart != null) {

                // extract user data from request
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String city = request.getParameter("city");
                String country = request.getParameter("country");

                boolean validationErrorFlag = false;
                validationErrorFlag = validator.validateForm(name, email, phone, address, city, country, request);

                if (validationErrorFlag) {

                    request.setAttribute("validationErrorFlag", validationErrorFlag);
                    userPath = "/checkout";

                } else {

                    int orderId = orderManager.placeOrder(name, email, phone, address, city, country, cart);

                    if (orderId != 0) {

                        Locale locale = (Locale) session.getAttribute("javax.servlet.jsp.jstl.fmt.locale.session");
                        String language = "";

                        if (locale != null) {

                            language = (String) locale.getLanguage();
                        }

                        cart = null;

                        session.invalidate();

                        if (!language.isEmpty()) {
                            request.setAttribute("language", language);
                        }

                        Map orderMap = orderManager.getOrderDetails(orderId);

                        // postavlja order detalje u request scope
                        request.setAttribute("customer", orderMap.get("customer"));
                        request.setAttribute("products", orderMap.get("products"));
                        request.setAttribute("orderRecord", orderMap.get("orderRecord"));
                        request.setAttribute("orderedProducts", orderMap.get("orderedProducts"));

                        try {
                            emailBean.sendMail("bgmirko@hotmail.com", "Porudzbina", "Porucena je roba na sajtu MinilabParts");
                        } catch (Exception ex) {
                            System.out.println("mail nije poslat" + "\n" + ex);
                        }

                        userPath = "/confirmation";

                        // otherwise, send back to checkout page and display error
                    } else {
                        userPath = "/checkout";
                        request.setAttribute("orderFailureFlag", true);
                    }
                }

            }
        } // http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/javamail/javamail.html
        else if (userPath.equals("/contact")) {

//            String testMessageSent = request.getParameter("testMessageSent");
//            emailSuccessfullySent = Boolean.parseBoolean(testMessageSent);
//            
//            System.out.println(emailSuccessfullySent);

//            if (!emailSuccessfullySent) {

                String email = request.getParameter("email");
                String subject = request.getParameter("subject");
                String comment = request.getParameter("comment");
                String phone = request.getParameter("phone");
                String name = request.getParameter("name");

                boolean validationErrorFlag = false;
                validationErrorFlag = validator.validateFormContactUs(name, email, comment, request);

                if (validationErrorFlag) {

                    request.setAttribute("validationErrorFlag", validationErrorFlag);
                    userPath = "/contact";

                } else {
                    comment = "email from: " + email + '\n' + "name: " + name + '\n' + "phone: " + phone + '\n' + "\n \n" + comment;
                    try {
                        emailSuccessfullySent = emailBean.sendMail(email, subject, comment);
                    } catch (Exception ex) {
                        System.out.println("mail nije poslat ControllerServlet" + "\n" + ex);
                    }
                    request.setAttribute("testMessageSent", emailSuccessfullySent);
                    userPath = "/contact";
                }

//            } else {
//                emailSuccessfullySent = false;
//                request.setAttribute("testMessageSent", emailSuccessfullySent);
//                userPath = "/contact";
//            }

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setSessionData(List<Artikli> artikliInGrup, HttpSession session, String naziv) {

        session.setAttribute("selectedGrupaNaziv", naziv);
        session.setAttribute("artikliInGrup", artikliInGrup);

        int doArtikla = 10;
        if (doArtikla > artikliInGrup.size()) {
            doArtikla = artikliInGrup.size();
        }
        subListaGrpArtk = artikliInGrup.subList(0, doArtikla);

        session.setAttribute("listaArtikalaNaStrani", subListaGrpArtk);
        session.setAttribute("ukupnoArtikala", artikliInGrup.size());

        int x = (artikliInGrup.size() + 9) / 10;
        session.setAttribute("ukupnoStrana", x);
    }
}
