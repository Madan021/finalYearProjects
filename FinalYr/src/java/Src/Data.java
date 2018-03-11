/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Madan
 */
@WebServlet(name = "Data", urlPatterns = {"/Data.do"})
public class Data extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String tname = request.getParameter("tname");
            int time = Integer.parseInt(request.getParameter("time"));
            
            String p1 = request.getParameter("file");
            XWPFDocument doc =  new XWPFDocument(new FileInputStream("C:\\Users\\Madan\\Documents\\NetBeansProjects\\word\\"+p1)); 
   //Write the Document in file system
       
//     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//     con = DriverManager.getConnection("jdbc:odbc:ooad");
       
       XWPFWordExtractor we = new XWPFWordExtractor(doc);
 Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
   String ar = we.getText();
   Statement s = con.createStatement();
   s.execute("truncate table question;");
 PreparedStatement s1 = con.prepareStatement("insert into question values(?,?,?,?,?,?)");
   PreparedStatement s2 = con.prepareStatement("insert into tableq values(?,?)");
   s2.setString(1,"Java");
   s2.setInt(2, time);
   s2.executeUpdate();
  String quest = "\\d.*?(?=\n|$)";
  String option = "[A-D][.].*?(?=\\n|$|[A-D])";
  String ans = "Answer:..*?(?=\\n|$|[A-D])";
  String sa[];
  Pattern p = Pattern.compile(quest);
  Pattern anss = Pattern.compile(option);
  Pattern asd = Pattern.compile(ans);
  Matcher m1 = anss.matcher(ar);
  Matcher m = p.matcher(ar);
  Matcher asdg = asd.matcher(ar);
  int i;
  while( m.find())
  {
      
      System.out.println(m.group());
   s1.setString(1,m.group());
   i=2;
while(i<6){
    m1.find();

    System.out.println(m1.group());
   s1.setString(i, m1.group().substring(2));
   i++;    
  }
 if(asdg.find()){
    
 s1.setString(i,asdg.group().substring(7));
 }
else
     s1.setString(i, " ");
 s1.executeUpdate();
  }     
  request.getRequestDispatcher("main.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
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
