<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@page import="com.user.userObjs"%>
    <%@page import="com.user.User"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<title>Edit your profile</title>
</head>
<style>
h1{
margin-left : 3%;
}
form{
margin-left : 8%;
width : 40%;
}
input{
text-align:center;
}
.bton{
text-align:center;
}
</style>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-inverse navbar-fixed-top">  
  <div class="container-fluid">  
    <div class="navbar-header">  
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">  
          <span class="icon-bar"></span>  
          <span class="icon-bar"></span>  
          <span class="icon-bar"></span>                          
      </button>  
      <a class="navbar-brand" href="user_dashboard.jsp"><%
              String name = null;
              HttpSession sess=request.getSession(false);  
              if(sess!=null){  
              name=(String)sess.getAttribute("name");  
              out.print(name);
              }
               %></a>  
    </div>  
    <div>  
      <div class="collapse navbar-collapse" id="myNavbar">  
        <ul class="nav navbar-nav">  
          <li><a href="user_profile.jsp">PROFILE</a></li>  
          <li><a href="publications.jsp">PUBLICATIONS</a></li>  
          <li><a href="select.jsp">UPLOAD PUBLICATION DETAILS</a></li>  
        </ul>  
			<ul class="nav navbar-nav navbar-right">  
			 <li><a href="Edit_Profile.jsp"> Edit Profile</a></li>
      <li><a href="Change_Password.jsp"> Change Password</a></li>  
      <li><a href="../logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  
    </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>     
 
     

<br><br><br><br>
<h1 class="text">Edit Profile </h1>
           <% 
           
           //String name = null;
           //HttpSession sess=request.getSession(false);  
           if(sess!=null){  
           name=(String)sess.getAttribute("name");  
           
           }
           
           
           User u = userObjs.getUserById(name); 
           if(null==u){
        	   response.sendRedirect("user/user_dashboard.jsp");
        	   return;
           }
           
           %>
           
  <br><br>       
           <form style="width:300px" method="POST" action="../edit_profile">  
<div class="form-group">  
    <label for="name">Name </label>  
    <br><input type="text" class="form-control" name="name" required="required" value=<%=u.getName() %>>  
    <br>
  </div> 
 <div class="form-group">  
    <label for="desg">Designation </label>  
    <br><input type="text" class="form-control" name="desg" required="required" value=<%=u.getDesg() %>>  <br>
  </div> 
 <div class="form-group">  
    <label for="InputEmail">Email address </label>  
    <br><input type="email" class="form-control" name="InputEmail" required="required" value=<%=u.getEmail() %>> <br> 
  </div>  
  <div class="form-group">  
    <label for="cont">Contact No. </label>  
    <br><input type="tel" class="form-control" name="cont" required="required" value=<%=u.getContact() %>>  <br>
  </div> 
  <div class="form-group">  
    <label for="date">D.O.B. </label>  
    <br><input type="date" class="form-control" name="dob" value=<%=u.getDob() %>>  <br>
  </div> 
  <div class="bton"> <br> 
  <button type="submit" class="btn btn-primary btn-lg">Edit profile</button>  
  <br><br>
</div>
</form>  
           
        

</body>
</html>