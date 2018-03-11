<%-- 
    Document   : disp2
    Created on : Mar 7, 2015, 12:31:34 PM
    Author     : Madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" buffer="1000kb" autoFlush="true"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .text{
                margin-left: -219px;
                margin-top: -130px;
            }
        </style>
    </head>
    <body style="background: #3f88b8">
    <center>
        <iframe src="disp1.jsp" height="500" width="600" style="background: #3f88b8;  border: none"></iframe>
        <form action="check.do" method="post">
            <div class="text">
            <input type="text" name="test" placeholder="Enter the code">
            <input type="submit" value="Check"></div>
            
            </form>
    </center>
    </body>
</html>
