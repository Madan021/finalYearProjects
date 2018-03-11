package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class Fourth_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\"> <!--<![endif]-->\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("  <title>FOURTH YEAR</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/style_2.css\">\n");
      out.write("  <script>\n");
      out.write("      function myFun()\n");
      out.write("      {\n");
      out.write("          alert(\"asdasd\");\n");
      out.write("      var str = \"Four.jsp?cgpa=\"+ document.forms[\"ns\"][\"cgpa\"].value;\n");
      out.write("      window.open(str,null,\"height=200,width=400,status=yes,toolbar=no,menubar=no,location=no\");\n");
      out.write("      \n");
      out.write("      return true;\n");
      out.write("    }\n");
      out.write("      \n");
      out.write("  </script>\n");
      out.write("  <!--[if lt IE 9]><script src=\"//html5shim.googlecode.com/svn/trunk/html5.js\"></script><![endif]-->\n");
      out.write("  <style type=\"text/css\">\n");
      out.write("table.hovertable {\n");
      out.write("\tfont-family: verdana,arial,sans-serif;\n");
      out.write("\tfont-size:11px;\n");
      out.write("\tcolor:#333333;\n");
      out.write("\tborder-width: 1px;\n");
      out.write("\tborder-color: #999999;\n");
      out.write("\tborder-collapse: collapse;\n");
      out.write("}\n");
      out.write("table.hovertable th {\n");
      out.write("\tbackground-color:#c3dde0;\n");
      out.write("\tborder-width: 1px;\n");
      out.write("\tpadding: 8px;\n");
      out.write("\tborder-style: solid;\n");
      out.write("\tborder-color: #a9c6c9;\n");
      out.write("}\n");
      out.write("table.hovertable tr {\n");
      out.write("\tbackground-color:#d4e3e5;\n");
      out.write("}\n");
      out.write("table.hovertable td {\n");
      out.write("\tborder-width: 1px;\n");
      out.write("\tpadding: 8px;\n");
      out.write("\tborder-style: solid;\n");
      out.write("\tborder-color: #a9c6c9;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("<center><h1 style=\"font-family: sans-serif; font-size: 20px\">Fourth Year</h1></center>\n");
      out.write("          <center>  <table class=\"hovertable\">\n");
      out.write("                                                 <tr>\n");
      out.write("                                                          \n");
      out.write("                                                            <th>Register Number</th>\n");
      out.write("                                                            <th>Name</th>\n");
      out.write("                                                            <th>CGPA</th>\n");
      out.write("                                                            <th>Mail ID</th>\n");
      out.write("                                                 </tr>\n");
      out.write("    ");

         Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
    Statement re =conn.createStatement();
    ResultSet rs =  re.executeQuery("Select REGISTERNUMBER,NAME,CGPA,MAILID from StudentCSE where YR = 4 ORDER BY REGISTERNUMBER");
    while(rs.next())
    {
        String Reg = rs.getString(1);
          String Name = rs.getString(2);
          String CGPA = rs.getString(3);
          String mail = rs.getString(4);
          
          out.println("<tr><td><h3>"+Reg+"</h3></td>");
          out.println("<td><h3>"+Name+"</h3></td>");
          out.println("<td><h3>"+CGPA+"</h3></td>");
          out.println("<td><h3>"+mail+"</h3></td>");
          out.println("</tr>");
          
    }
    out.println("</table>");
    out.println("<br/>");
    out.println("<br/>");out.println("<br/>");out.println("<br/>");
    out.println("<table class=\"hovertable\">");
    out.println("Data Sorted By CGPA");
    out.println("<tr><th>Register Number</th><th>Name</th><th>CGPA</th><th>Mail ID</th></tr>");
    ResultSet rd =  re.executeQuery("Select REGISTERNUMBER,NAME,CGPA,MAILID from StudentCSE where Yr = 4 ORDER BY CGPA DESC");
    while(rd.next())
    {
        String Reg = rd.getString(1);
          String Name = rd.getString(2);
          String CGPA = rd.getString(3);
          String mail = rd.getString(4);
          
          out.println("<tr><td><h3>"+Reg+"</h3></td>");
          out.println("<td><h3>"+Name+"</h3></td>");
          out.println("<td><h3>"+CGPA+"</h3></td>");
          out.println("<td><h3>"+mail+"</h3></td>");
          out.println("</tr>");
          
    }
        out.println("</table>");

    
      out.write("\n");
      out.write("    \n");
      out.write("    <form onsubmit=\"return myFun()\" name=\"ns\">\n");
      out.write("       GET STUDENTS ABOVE <input type=\"text\" name=\"cgpa\" /><br/>\n");
      out.write("       <input type=\"submit\" value=\"GET\">\n");
      out.write("    </form>\n");
      out.write("  </center>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
