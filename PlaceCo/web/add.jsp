<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Event Scheduler</title>
  <link rel="stylesheet" href="css/style1.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>

<body style="background-color: #cc6600">
    
    
  <div class="container" >
      <section class="register">
    <center>
      <form method="post" action="enter.do">
      <div class="reg_section personal_info">
      <h3>Event</h3>
      <input type="text" name="event" placeholder="Enter the Event Name"/>
      <input type="text" name="Date" placeholder="Enter the Date"/>
      <input type="text" name="Conby" placeholder="Conducted BY"/>
      </div>
        
      <br>
      <p class="submit"><br><input type="submit" name="commit" value="Enter to db"><br></p>
      </form>
    </center>
          
      </section>
  </div>

  
</body>
</html>