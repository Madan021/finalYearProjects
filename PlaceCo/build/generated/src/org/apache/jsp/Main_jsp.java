package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class Main_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t<title>Placement Coordinator</title>\n");
      out.write("        <link href=\"css/style_2.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<!-- Header -->\n");
      out.write("<div id=\"header\">\n");
      out.write("\t<div class=\"shell\">\n");
      out.write("\t\t<!-- Logo + Top Nav -->\n");
      out.write("\t\t<div id=\"top\">\n");
      out.write("\t\t\t<h1><a href=\"index.html\">CSE-DEPARTMENT</a></h1>\n");
      out.write("\t\t\t<div id=\"top-navigation\">\n");
      out.write("\t\t\t\tWelcome <a href=\"#\"><strong>Administrator</strong></a>\n");
      out.write("\t\t\t\t<span>|</span>\n");
      out.write("\t\t\t\t<a href=\"login.html\">Log out</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- End Logo + Top Nav -->\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Main Nav -->\n");
      out.write("\t\t<div id=\"navigation\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t    <li><a class=\"active\"><span>Dashboard</span></a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- End Main Nav -->\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<!-- End Header -->\n");
      out.write("\n");
      out.write("<!-- Container -->\n");
      out.write("<div id=\"container\">\n");
      out.write("\t<div class=\"shell\">\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Small Nav -->\n");
      out.write("\t\t<div class=\"small-nav\">\n");
      out.write("\t\t\t<a href=\"#\">Dashboard</a>\n");
      out.write("\t\t\t<span>&gt;</span>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- End Small Nav -->\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Message OK -->\t\t\n");
      out.write("\t\t\t\t<!-- End Message OK -->\t\t\n");
      out.write("\t\t<br />\n");
      out.write("\t\t<!-- Main -->\n");
      out.write("\t\t<div id=\"main\">\n");
      out.write("\t\t\t<div class=\"cl\">&nbsp;</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<!-- Content -->\n");
      out.write("\t\t\t<div id=\"content\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- Box -->\n");
      out.write("\t\t\t\t<div class=\"box\">\n");
      out.write("\t\t\t\t\t<!-- Box Head -->\n");
      out.write("\t\t\t\t\t<div class=\"box-head\">\n");
      out.write("\t\t\t\t\t\t<h2 class=\"left\">Upcoming Events</h2>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<!-- End Box Head -->\t\n");
      out.write("\n");
      out.write("\t\t\t\t\t<!-- Table -->\n");
      out.write("                                    <div class=\"table\">\n");
      out.write("                                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("                                                 <tr>\n");
      out.write("                                                            <th width=\"13\"><input type=\"checkbox\" class=\"checkbox\" /></th>\n");
      out.write("                                                            <th>Title</th>\n");
      out.write("                                                            <th>Date</th>\n");
      out.write("                                                            <th>Conducted By</th>\n");
      out.write("                                                 </tr>\n");
      out.write("                                                ");

                                                    
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
    Statement re =conn.createStatement();
    ResultSet rs =  re.executeQuery("Select * from Events");
    while(rs.next())
    {
        String name = rs.getString(1);
          String date = rs.getString(2);
          String conby = rs.getString(3);
          out.println("<tr><td><input type=\"checkbox\" class=\"checkbox\" /></td>");
          out.println("<td><h3>"+name+"</h3></td>");
           out.println("<td><h3>"+date+"</h3></td>");
            out.println("<td><h3>"+conby+"</h3></td>");
            out.println("</tr>");
          
    }
        
                                                
      out.write("\n");
      out.write("                                                    \n");
      out.write("                                            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                           \n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Table -->\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <!-- End Box -->\n");
      out.write("                            <li><a onclick='window.open(\"First.jsp\",null,\"height=500,width=700,status=yes,toolbar=no,menubar=no,location=no\");'><span>First Year</span></a></li>\n");
      out.write("\t\t\t    <li><a href=\"Second.jsp\"><span>Second Year</span></a></li>\n");
      out.write("\t\t\t    <li><a href=\"third.jsp\"><span>Third Year</span></a></li>\n");
      out.write("\t\t\t    <li><a href=\"Fourth.jsp\"><span>Final Year</span></a></li>\n");
      out.write("                            \n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- End Content -->\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<!-- Sidebar -->\n");
      out.write("\t\t\t<div id=\"sidebar\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!-- Box -->\n");
      out.write("\t\t\t\t<div class=\"box\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<!-- Box Head -->\n");
      out.write("\t\t\t\t\t<div class=\"box-head\">\n");
      out.write("\t\t\t\t\t\t<h2>Management</h2>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<!-- End Box Head-->\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"box-content\">\n");
      out.write("\t\t\t\t\t\t<a href=\"add.jsp\" class=\"add-button\"><span>Add new Event</span></a>\n");
      out.write("\t\t\t\t\t\t<div class=\"cl\">&nbsp;</div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<!-- Sort -->\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<!-- End Box -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!-- End Sidebar -->\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div class=\"cl\">&nbsp;</div>\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- Main -->\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<!-- End Container -->\n");
      out.write("\n");
      out.write("\t\n");
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
