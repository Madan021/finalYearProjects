package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Arrays;
import java.security.MessageDigest;
import javax.crypto.spec.SecretKeySpec;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import net.glxn.qrgen.QRCode;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import net.glxn.qrgen.image.ImageType;
import java.util.Random;

public final class disp1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"refresh\" content=\"30; url=http://localhost:8080/QRCode/test.jsp\">\n");
      out.write("        \n");
      out.write("        <title>CODE</title>\n");
      out.write("        <style>\n");
      out.write("             img{\n");
      out.write("                \n");
      out.write("                margin-left: 30px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("             \n");
      out.write("    </head>\n");
      out.write("    <body style=\"height: 500px ; width: 500px\">\n");
      out.write("        \n");
      out.write("    \n");
      out.write("        <div>  ");

            Random r = new Random();
int Low = 999;
int High = 9999;
int R = r.nextInt(High-Low) + Low;
Cipher cipher;
KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
              //  String key = "Madan";
                byte[] key = ("madan").getBytes("UTF-8");
MessageDigest sha = MessageDigest.getInstance("SHA-1");
key = sha.digest(key);
key = Arrays.copyOf(key, 16); // use only first 128 bit
                 //   byte[] decodedKey = Base64.getDecoder().decode(key);
		SecretKey secretKey = new SecretKeySpec(key, 0, key.length, "AES");
                
                
		cipher = Cipher.getInstance("AES");
   String sa=Integer.toString(R);

           byte[] plainTextByte = sa.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		
   ByteArrayOutputStream out1 = QRCode.from(encryptedText).to(ImageType.PNG).withSize(350, 350).stream();
 
response.setContentType("image/png");
response.setContentLength(out1.size());
HttpSession ses = request.getSession(true);
ses.setAttribute("id", sa);

OutputStream outStream = response.getOutputStream();
out.println("<div class='pic' >");
 
      out.write("\n");
      out.write(" \n");
outStream.write(out1.toByteArray());
      out.write('\n');
      out.write('\n');

out.println("</div>");

outStream.flush();
outStream.close();

       
      out.write("\n");
      out.write("       \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
