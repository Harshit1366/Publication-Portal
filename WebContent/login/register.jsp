<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register youself...</title>  
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
<br><br>
<div class="container"> 
<h1 class = "text-center">&nbsp&nbsp<span class="glyphicon glyphicon-user"></span> Sign Up</h1>
<form style="width:300px" method="POST" action="../register">  
<div class="form-group">  
    <label for="name">Name </label>  
    <input type="text" class="form-control" name="name" required="required" placeholder="Your name">  
    
  </div> 
 <div class="form-group">  
    <label for="desg">Designation </label>  
    <input type="text" class="form-control" name="desg" required="required" placeholder="Your designation">  
  </div> 
 <div class="form-group">  
    <label for="InputEmail">Email address </label>  
    <input type="email" class="form-control" name="InputEmail" required="required" placeholder="eg. mysupermail@mail.com">  
  </div>  
  <div class="form-group">  
    <label for="cont">Contact No. </label>  
    <input type="tel" class="form-control" name="cont" required="required" placeholder="eg. 9876543210">  
  </div> 
  <div class="form-group">  
    <label for="date">D.O.B. </label>  
    <input type="date" class="form-control" name="dob" required="required" >  
  </div> 
  <div class="form-group">  
    <label for="username">Username </label>  
    <input type="text" class="form-control" name="username" required="required" placeholder="eg. mysuperusername690">  
  </div> 
  <div class="form-group">  
    <label for="pass">Password </label>  
    <input type="password" class="form-control" name="pass" required="required" placeholder="eg. X8df!90EO">  
  </div> 
  <div class="form-group">  
    <label for="cp">Confirm Password </label>  
    <input type="password" class="form-control" name="cp" required="required" placeholder="eg. X8df!90EO">  
  </div> 
  <div class="bton"> <br> 
  <button type="submit" class="btn btn-primary btn-lg">Sign up</button>  
  <br><br>
</div>
<p class="change_link">  
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspAlready a member ?
<a href="login.jsp" class="to_register"> Go and log in </a>
</p>
</form>  
 </div>

</body>
</html>