<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminPage</title>
    <!-- Core CSS - Include with every page -->
    <link href="assets/plugins/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/plugins/pace/pace-theme-big-counter.css" rel="stylesheet" />
    <link href="assets/css/style.css" rel="stylesheet" />
    <link href="assets/css/main-style.css" rel="stylesheet" />
    <!-- Page-Level CSS -->
    <link href="assets/plugins/morris/morris-0.4.3.min.css" rel="stylesheet" />
   </head>
<body>
    <!--  wrapper -->
    <div id="wrapper">
        <!-- navbar top -->
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="navbar">
            <!-- navbar-header -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">
                    <img src="assets/img/logo.png" alt=""/>
                </a>
            </div>
            <!-- end navbar-header -->
            <!-- navbar-top-links -->
            <ul class="nav navbar-top-links navbar-right">
                <!-- main dropdown --><!-- end main dropdown -->
            </ul>
            <!-- end navbar-top-links -->

        </nav>
        <!-- end navbar top -->

        <!-- navbar side -->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <!-- sidebar-collapse -->
            <div class="sidebar-collapse">
                <!-- side-menu -->
                <ul class="nav" id="side-menu">
                    <li>
                        <!-- user image section-->
                        <div class="user-section">
                                                       <span class="das">Administrator</span>
<div class="user-info"><div><strong></strong></div>
                                
                      </div>
                        <!--end user image section-->
                    </li>
                    
                    <li class="selected">
                        <a href="main.jsp"><i class="fa fa-dashboard fa-fw"></i>Dashboard</a>
                    </li>
                    <li class="selected">
                        <a href="tools.jsp"><i class="fa fa-bitcoin fa-fw"></i>Test Creator Tools</a>
                    </li>  
                    <li class="selected">
                        <a href="marks.jsp"><i class="fa fa-chevron-left fa-fw"></i>Marks </a>
                    </li>    
                </ul>
                <!-- end side-menu -->
            </div>
            <!-- end sidebar-collapse -->
        </nav>
        <!-- end navbar side -->
        <!--  page-wrapper -->
      <div id="page-wrapper">

            <div class="row">
                <!-- Page Header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Admin Panel</h1>
                </div>
                <!--End Page Header -->
            </div>

            <div class="row">
              <div class="col-lg-8"   >



                                       <!--End area chart example -->
                    <!--Simple table example -->
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i>Marks
                            <div class="pull-right">
                                <div class="btn-group">
                                    
                                </div>
                            </div>
                        </div>

                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive" width=100%>
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                     <th width="50%">Name</th>
                                                    <th width="25%">Class</th>         
                                                    <th width="25%">Marks</th>         
                                                </tr>
                                            </thead>
                                            <tbody>
                                               <%
                                                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                                                Statement re = conn.createStatement();
                                                ResultSet rs =  re.executeQuery("Select * from StudentMarks");
                                                int i=1;
                                                 while(rs.next())
                                             {
                                                     String q = rs.getString(1);
                                                         String a = rs.getString(2);
                                                         String b = rs.getString(3);
                                                   out.println("<tr>");
                                                    out.println("<td>"+q+"</td>");
                                                     out.println("<td>");
                                                     out.println("<p style=\"font-size:15px\">"+a+"</p></td>");
                                                    out.println("<td>"+b+"</td>");
                                                       // <td>10/21/2013</td>
                                                      //  <td>2:49 PM</td>
                                                     //  <td>$8345.23</td>
                                                    
                                                  out.println("</tr>");
                                                  i++;
                                                  
                                             }
                                                %>

                                            </tbody>
                                        </table>
                                    </div>

                                </div>

                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!--End simple table example -->

              </div>
            </div>

            <div class="row"></div>


         


        </div>
        <!-- end page-wrapper -->

    </div>
    <!-- end wrapper -->

    <!-- Core Scripts - Include with every page -->
    <script src="assets/plugins/jquery-1.10.2.js"></script>
    <script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
    <script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="assets/plugins/pace/pace.js"></script>
    <script src="assets/scripts/siminta.js"></script>
    <!-- Page-Level Plugin Scripts-->
    <script src="assets/plugins/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/plugins/morris/morris.js"></script>
    <script src="assets/scripts/dashboard-demo.js"></script>

</body>

</html>
