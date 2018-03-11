<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>FOURTH YEAR</title>
  <link rel="stylesheet" href="css/style_2.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
  <style type="text/css">
table.hovertable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.hovertable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr {
	background-color:#d4e3e5;
}
table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>
</head>

<body>
    
<center><h1 style="font-family: sans-serif; font-size: 20px">THIRD YEAR</h1></center>
          <center>  <table class="hovertable">
                                                 <tr>
                                                          
                                                            <th>Register Number</th>
                                                            <th>Name</th>
                                                            <th>CGPA</th>
                                                            <th>Mail ID</th>
                                                 </tr>
    <%
         Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
    
    String s = request.getParameter("cgpa");
    PreparedStatement ps = conn.prepareStatement("Select REGISTERNUMBER,NAME,CGPA,MAILID from StudentCSE where YR = 3 AND CGPA > ?");
    ps.setDouble(1,Double.parseDouble(s));
    ResultSet rs =  ps.executeQuery();
    
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
    %>
              </table>
          </center>
</body>
</html>    
