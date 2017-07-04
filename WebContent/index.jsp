<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
  <script>  
$(document).ready(function(){  
    $('[data-toggle="popover"]').popover();     
});  
</script>
<title>Publication Portal</title>
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
      <a class="navbar-brand" href="#">TechZone</a>  
    </div>  
    <div>  
      <div class="collapse navbar-collapse" id="myNavbar">  
        <ul class="nav navbar-nav">  
          <li><a href="">HOME</a></li>  
          <li><a href="">ABOUT US</a></li>  
          <li><a href="">NEWS</a></li>  
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="">CONTACT<span class="caret"></span></a>  
            <ul class="dropdown-menu">  
              <li><a href="">9958825034</a></li>  
              <li><a href="">0129-4151175</a></li>
            </ul>  
			</li>  
        </ul>  
			<ul class="nav navbar-nav navbar-right">  
      <li><a href="login/register.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>  
      <li><a href="login/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>  
    </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>   
<br><br><br><br><br>   
 <div class="container">  
<a href="#" title="Dismissible popover" data-toggle="popover" data-trigger="focus">Hover me</a>  
</div>  

</body>
</html>