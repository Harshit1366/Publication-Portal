<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.admin.adminObjs"%>
    <%@page import="com.journal.Journal"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<title>Admin Dashboard</title>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<nav class="navbar navbar-inverse navbar-fixed-top">  
  <div class="container-fluid">  
    <div class="navbar-header">  
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">  
          <span class="icon-bar"></span>  
          <span class="icon-bar"></span>  
          <span class="icon-bar"></span>                          
      </button>  
      <a class="navbar-brand" href="admin_dashboard.jsp">Admin</a>  
    </div>  
    <div>  
      <div class="collapse navbar-collapse" id="myNavbar">  
        <ul class="nav navbar-nav">  
          <li><a href="../Journal/Journal.jsp">JOURNAL</a></li>  
          <li><a href="../Books/Books.jsp">BOOKS</a></li>  
          <li><a href="#">BOOK CHAPTER</a></li>  
          <li><a href="#">CONF. PROCEEDINGS</a></li>  
          <li><a href="#">CONF. PRESENTATIONS</a></li>  
          <li><a href="#">PATENTS</a></li>  
          <li><a href="#">TECH REPORT</a></li>  
        </ul>  
			<ul class="nav navbar-nav navbar-right">  
      <li><a href="../admin_logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  
    </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>     
 <br><br>
                        <h3 class="text">&nbsp&nbspWelcome Admin</h3>
                        <form method="post" action="#">
                        <p class="text-right">Search : 
                        <input type="text" name="search">
                        <input type="SUBMIT" value="SEARCH"></p></form>
                        
                        <br>

</body>
</html>