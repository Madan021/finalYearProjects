/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Madan
 */
@WebServlet(name = "validate", urlPatterns = {"/validate.do"})
public class validate extends HttpServlet {

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
       
        
         try
        {
            
            boolean pw = false;
        String un = request.getParameter("username");
        String pwd = request.getParameter("password");
        
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
        Statement re =conn.createStatement();
            ResultSet rs =  re.executeQuery("Select * from Customer1");
        while(rs.next())
        {
            String id = rs.getString("name");
            String Password = rs.getString("passwrd");
            if(un.equals(id))
            {
                
                if(pwd.equals(Password))
                {
                    pw=true;
                    
                }
            }
            
        }
        if(pw==true)
        {
            request.getRequestDispatcher("trans.jsp").forward(request, response);
            
        }
        else
        {
             request.getRequestDispatcher("default.jsp").forward(request, response);
        }
        
        
        
        
     }
        catch(Exception e)
        {
            System.out.println(e);
            
        
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
