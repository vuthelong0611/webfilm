/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.UserDAO;
import Model.user;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author hp
 */
public class loginSev extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginSev</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginSev at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String r = request.getParameter("check");
        Cookie cu = new Cookie("user", user);
        Cookie cp = new Cookie("pass", pass);
        Cookie cr = new Cookie("crem", r);
        if (r != null) {
            cu.setMaxAge(60 * 60 * 24);
            cp.setMaxAge(60 * 60 * 24);
            cr.setMaxAge(60 * 60 * 24);

        } else {
            cu.setMaxAge(0);
            cp.setMaxAge(0);
            cr.setMaxAge(0);
        }
        response.addCookie(cr);
        response.addCookie(cu);
        response.addCookie(cp);
        HttpSession session = request.getSession();

        UserDAO uDao = new UserDAO();
        try {
            user u = uDao.getUser(user, pass);
            if(u !=null){if (user.equals(u.getName()) && pass.equals(u.getPass())) {
                session.setAttribute("user", u);
                request.getRequestDispatcher("homeSev").forward(request, response);
            } else {
                response.setContentType("text/html;charset=UTF-8");

                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Resister</title>");

                out.println("</head>");
                out.println("<body>");
                out.println("not account");
                out.println("<br>");
                out.println("<a href=" + "Login.jsp" + ">" + "login" + "</a>");
                out.println("</body>");
                out.println("</html>");
            }}else{
                 response.setContentType("text/html;charset=UTF-8");

                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Resister</title>");

                out.println("</head>");
                out.println("<body>");
                out.println("not account");
                out.println("<br>");
                out.println("<a href=" + "Login.jsp" + ">" + "login" + "</a>");
                out.println("</body>");
                out.println("</html>");
            }
            
        } catch (ServletException | IOException e) {
            response.setContentType("text/html;charset=UTF-8");

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Resister</title>");

            out.println("</head>");
            out.println("<body>");
            out.println("not account");
            out.println("<br>");
            out.println("<a href=" + "Login.jsp" + ">" + "login" + "</a>");
            out.println("</body>");
            out.println("</html>");
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

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
