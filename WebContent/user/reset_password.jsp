<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
        <title>Change Password</title>
</head>
<style>
h1{
text-align : center;
}
body{
background-image : url("../images/ncu.jpg");
background-repeat: no-repeat;
background-size : 1600px 900px;
}
form{
margin-left : 39%;
width : 25%;
}
input{
text-align:center;
}
.bton{
text-align:center;
}
</style>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<%String sess=request.getParameter("token"); 
if(sess==null){

	response.sendRedirect("../login.jsp");
    return;
}

%>
<br><br>
<h1 class="text">Reset Password </h1>
           <br><br><br>    
           <form style="width:300px" method="POST" action="../reset_password">  
 <div class="form-group">  
    <label for="desg">New Password </label>  
    <br><input type="password" class="form-control" name="np" placeholder="Enter your new password" required="required">  <br>
  </div> 
 <div class="form-group">  
    <label for="InputEmail">Confirm New Password </label>  
    <br><input type="password" class="form-control" name="cnp" placeholder="Confirm your new password" required="required"> <br> 
  </div>  
  <input type='hidden' name='role' value='user'>
   <input type='hidden' name='id' value='<%=sess%>'>
  <div class="bton"> <br> 
  <button type="submit" class="btn btn-primary btn-lg">Change Password</button>  
  <br><br>
</div>
</form>  
</body>
</html>