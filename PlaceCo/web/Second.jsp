<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>SECOND YEAR</title>
  <link rel="stylesheet" href="css/style_2.css">
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
 <script>
      function myFun()
      {
                var str = "two.jsp?cgpa="+ document.forms["ns"]["cgpa"].value;
      window.open(str,null,"height=200,width=400,status=yes,toolbar=no,menubar=no,location=no");
      
      return true;
    }
      
  </script>
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>

<body>
    
    
  <center><h1 style="font-family: sans-serif; font-size: 20px">Second Year</h1></center>
         <center> <table class="hovertable">
                                                 <tr>
                                                            <th>Register Number</th>
                                                            <th>Name</th>
                                                            <th>CGPA</th>
                                                            <th>Mail ID</th>
                                                 </tr>
    <%
         Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
    Statement re =conn.createStatement();
    ResultSet rs =  re.executeQuery("Select REGISTERNUMBER,NAME,CGPA,MAILID from StudentCSE where YR = 2  ORDER BY REGISTERNUMBER");
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
    out.println("Data Sorted By CGPA");
    out.println("<table class=\"hovertable\">");
    out.println("<tr><th>Register Number</th><th>Name</th><th>CGPA</th><th>Mail ID</th></tr>");
    ResultSet rd =  re.executeQuery("Select REGISTERNUMBER,NAME,CGPA,MAILID from StudentCSE where Yr = 2 ORDER BY CGPA DESC");
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
    %>
    <form onsubmit="return myFun()" name="ns">
       GET STUDENTS ABOVE <input type="text" name="cgpa" /><br/>
       <input type="submit" value="GET">
    </form>
      </center>
     
  
</body>
</html>