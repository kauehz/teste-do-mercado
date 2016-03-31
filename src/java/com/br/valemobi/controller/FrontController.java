/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.valemobi.controller;

import com.br.valemobi.model.Negocio;
import com.br.valemobi.model.TipoMercadoria;
import com.br.valemobi.model.dao.NegocioDAO;
import com.br.valemobi.model.dao.TipoMercadoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asu
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    private String command;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            RequestDispatcher rd;
            TipoMercadoriaDAO tmDAO = new TipoMercadoriaDAO();
            NegocioDAO negocioDAO = new NegocioDAO();
            List<TipoMercadoria> tm = tmDAO.read();
            for (TipoMercadoria tm1 : tm) {
                System.out.println(tm1.toString());
            }
            
            request.getSession().setAttribute("ListaTm", tm);

            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

            if (command.startsWith("tm")) {
                //TipoMercadoriaDAO tmDAO = new TipoMercadoriaDAO();
                //NegocioDAO negocioDAO = new NegocioDAO();

                if (command.endsWith("insert")) {

                    List<TipoMercadoria> tms = tmDAO.readDistinct();
                    request.getSession().setAttribute("ListaTm", tm);

                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }

            }

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
        processRequest(request, response);
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
