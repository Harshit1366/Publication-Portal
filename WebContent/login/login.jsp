<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in page...</title>  
  <meta charset="utf-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
</head>
<style>
form{
margin-left : 37.5%;
margin-right : 37.5%;
width : 25%;
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
<h1 class = "text-center"><span class="glyphicon glyphicon-log-in"></span> LOGIN</h1>
<form style="width:300px" method="POST" action="../login">  
<br><br>
<br>
 <div class="form-group">  
    <label for="user">Username </label>  
    <input type="text" class="form-control" name="user" placeholder="Enter your username">  
  </div>  
  <br>
  <div class="form-group">  
    <label for="Password">Password </label>  
    <input type="password" class="form-control" name="pas" placeholder="Enter your password">  
  </div>  

  <div class="bton"> <br> 
  <button type="submit" class="btn btn-primary btn-lg">Sign in</button>  
</div>
<br><br><center>
<a href="Forgot_Password.jsp" class="forgot">Forgotten your username or password?</a>
<br><br>
<p class="change_link">
					Not signed up yet ?
					<a href="register.jsp" class="to_register">Create an Account</a>
				</p></center>

</form>  
 </div>
</body>
</html>