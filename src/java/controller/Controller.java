/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 
 * INFO2514
 * @author fssco
 */
public class Controller extends HttpServlet {

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
        doPost(request, response);
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
        String url = "/display.jsp";

        String action = request.getParameter("action");
        if (action == null) {
            action = "first";
        }
        
         HttpSession session = request.getSession();

        LinkedHashMap <Integer, Person> linkMap =
               (LinkedHashMap <Integer, Person>) session.getAttribute ("linkMap");

        if(linkMap == null) {
            linkMap = new LinkedHashMap<Integer, Person>();
        
        
        linkMap.put(731, new Person("Pris", "", "Stratton", 731,
                LocalDate.of(2016, Month.FEBRUARY, 14), LocalDate.of(2016, Month.FEBRUARY, 14)));
        linkMap.put(734, new Person("Roy", "B", "Batty", 734,
                LocalDate.of(2016, Month.JANUARY, 8), LocalDate.of(2016, Month.JANUARY, 9)));
        }
        
  session.setAttribute("linkMap", linkMap);
        
        request.setAttribute("linkMap", linkMap);
       
        switch(action) {
            case "first":
                  
                break;
        
        
        case "delete": 
       String keyString = request.getParameter("key");
        int key = Integer.parseInt(keyString);
        linkMap.remove(key);
        break;
        
        case "reset":    
               linkMap = new LinkedHashMap<Integer, Person>();
        
        linkMap.put(731, new Person("Pris", "", "Stratton", 731,
                LocalDate.of(2016, Month.FEBRUARY, 14), LocalDate.of(2016, Month.FEBRUARY, 14)));
        linkMap.put(734, new Person("Roy", "B", "Batty", 734,
                LocalDate.of(2016, Month.JANUARY, 8), LocalDate.of(2016, Month.JANUARY, 9)));
        session.setAttribute("linkMap", linkMap);
        break;
        }
    
        
    
    
   request.setAttribute("linkMap", linkMap);
        getServletContext().getRequestDispatcher(url).forward(request, response);
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
