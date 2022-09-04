/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.UserDAO;
import Model.film;
import Model.country;
import Model.type;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author hp
 */
@WebServlet(name = "homeSev", urlPatterns = {"/homeSev"})
public class homeSev extends HttpServlet {

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
            out.println("<title>Servlet homeSev</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet homeSev at " + request.getContextPath() + "</h1>");
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
        UserDAO udao = new UserDAO();
        List<film> f1 = udao.getfilm();
        List<film> f4 = udao.getfilmASC();
                List<film> f5 = udao.getfilmDsc();

        List<film> f2 = udao.getfilmHDview();
        List<film> f3 = udao.getfilmHHview();
        List<film> f = udao.getfilmview();
        List<type> listT = udao.getAllType();
        List<country> listC = udao.getAllCountry();
        film fmax = udao.getfilmmax();
        film fmin = udao.getfilmmin();
        int sum = udao.allviews();
        int avg = udao.avgviews();
        int count = udao.countfilm();

        request.setAttribute("f1", f1);
        request.setAttribute("f", f);
        request.setAttribute("f2", f2);
        request.setAttribute("f3", f3);
        request.setAttribute("f4", f4);
                request.setAttribute("f5", f5);

        request.setAttribute("fmax", fmax);
        request.setAttribute("fmin", fmin);
        request.setAttribute("sum", sum);
        request.setAttribute("avg", avg);
        request.setAttribute("count", count);
        request.setAttribute("listT", listT);
        request.setAttribute("listC", listC);

        request.getRequestDispatcher("home.jsp").forward(request, response);
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
        processRequest(request, response);
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
