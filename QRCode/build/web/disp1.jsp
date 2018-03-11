<%-- 
    Document   : home
    Created on : Jan 26, 2015, 12:19:28 AM
    Author     : MADAN
 --%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="javax.crypto.spec.SecretKeySpec"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.IOException"%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="net.glxn.qrgen.QRCode,java.util.Base64,javax.crypto.Cipher,javax.crypto.KeyGenerator,javax.crypto.SecretKey,net.glxn.qrgen.image.ImageType,java.util.Random" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="30; url=http://localhost:8080/QRCode/test.jsp">
        
        <title>CODE</title>
        <style>
             img{
                
                margin-left: 30px;
            }
        </style>
             
    </head>
    <body style="height: 500px ; width: 500px">
        
    
        <div>  <%
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
Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");

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
 %>
 
<%outStream.write(out1.toByteArray());%>

<%
out.println("</div>");

outStream.flush();
outStream.close();

       %>
       
        </div>
        
        
        
        
        
        
    </body>
</html>
