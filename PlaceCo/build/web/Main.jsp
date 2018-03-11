<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>Placement Coordinator</title>
        <link href="css/style_2.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<!-- Header -->
<div id="header">
	<div class="shell">
		<!-- Logo + Top Nav -->
		<div id="top">
			<h1><a href="index.html">CSE-DEPARTMENT</a></h1>
			<div id="top-navigation">
				Welcome <a href="#"><strong>Administrator</strong></a>
				<span>|</span>
				<a href="login.html">Log out</a>
			</div>
		</div>
		<!-- End Logo + Top Nav -->
		
		<!-- Main Nav -->
		<div id="navigation">
			<ul>
			    <li><a class="active"><span>Dashboard</span></a></li>
			</ul>
		</div>
		<!-- End Main Nav -->
	</div>
</div>
<!-- End Header -->

<!-- Container -->
<div id="container">
	<div class="shell">
		
		<!-- Small Nav -->
		<div class="small-nav">
			<a href="#">Dashboard</a>
			<span>&gt;</span>
			
		</div>
		<!-- End Small Nav -->
		
		<!-- Message OK -->		
				<!-- End Message OK -->		
		<br />
		<!-- Main -->
		<div id="main">
			<div class="cl">&nbsp;</div>
			
			<!-- Content -->
			<div id="content">
				
				<!-- Box -->
				<div class="box">
					<!-- Box Head -->
					<div class="box-head">
						<h2 class="left">Upcoming Events</h2>
						
					</div>
					<!-- End Box Head -->	

					<!-- Table -->
                                    <div class="table">
                                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                 <tr>
                                                            <th width="13"><input type="checkbox" class="checkbox" /></th>
                                                            <th>Title</th>
                                                            <th>Date</th>
                                                            <th>Conducted By</th>
                                                 </tr>
                                                <%
                                                    
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
        
                                                %>
                                                    
                                            </table>


                                           

                                    </div>
                                    <!-- Table -->

                            </div>
                            <!-- End Box -->
                            <li><a href="First.jsp"><span>First Year</span></a></li>
			    <li><a href="Second.jsp"><span>Second Year</span></a></li>
			    <li><a href="third.jsp"><span>Third Year</span></a></li>
			    <li><a href="Fourth.jsp"><span>Final Year</span></a></li>
                            

                    </div>
                    <!-- End Content -->
			
			<!-- Sidebar -->
			<div id="sidebar">
				
				<!-- Box -->
				<div class="box">
					
					<!-- Box Head -->
					<div class="box-head">
						<h2>Management</h2>
					</div>
					<!-- End Box Head-->
					
					<div class="box-content">
						<a href="add.jsp" class="add-button"><span>Add new Event</span></a>
						<div class="cl">&nbsp;</div>
						
										
						<!-- Sort -->
										
					</div>
				</div>
				<!-- End Box -->
			</div>
			<!-- End Sidebar -->
			
			<div class="cl">&nbsp;</div>			
		</div>
		<!-- Main -->
	</div>
</div>
<!-- End Container -->

	
</body>
</html>