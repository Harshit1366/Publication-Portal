<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
<title>Forgot Password</title>
</head>
<style>
form{
margin-left : 37.5%;
margin-right : 37.5%;
width : 25%;
}
body{
background-image : url("../images/ncu.jpg");
background-repeat: no-repeat;
background-size : 1366px 1000px;
}
input{
text-align:center;
}
.bton{
text-align:center;
}
</style>
    
     <body>
     <br><br><br>
<div class="container"> 
<h1 class = "text-center"> Forgot Password</h1>
<form style="width:300px" method="POST" action="../forgot_password">  
<br><br>
                      <div class="form-group">  
    <label for="user">Username </label>  
    <input type="text" class="form-control" name="username" placeholder="Enter your username">  
  </div>  
  <br>
  <div class="bton"> <br> 
  <button type="submit" class="btn btn-primary btn-lg">GO</button>  
</div><br><br><center>
                        <div class="forgot"><a href="../login.jsp">Go to login page</a></div>
                  </center>  </form>
                  </div>
                  
            </div>
    </body>
    
</html>