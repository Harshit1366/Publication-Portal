<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<title>Reject</title>
</head>
<style>
form{
margin-left : 20%;
margin-right : 0%;
width : 80%;
}
label{
text-align:center;
margin-left : 60%;
}
.bton{
text-align:center;
margin-left : 90%;
}
</style>
<body>
<br><br><br>
<%
String id1=request.getParameter("id");
int id=Integer.valueOf(id1);
String type=request.getParameter("type");
%>
<div class="container"> 
<h1 class = "text-center"> MAKE A COMMENT</h1>
<form style="width:300px" method="POST" action="../reject">  
<br><br>
<br>
 <div class="form-group">  
    <label for="comment">Enter the query or reason for the rejection of publication </label>  
      </div> 
   <textarea rows="8" cols="100" name="comment" placeholder="Type the reason here"> 
   </textarea> 
  <br>
   <div class="bton"> <br> 
   <input type="hidden" name="ids" value="<%=id %>">
   <input type="hidden" name="type" value="<%=type %>">
<center>  <button type="submit" class="btn btn-primary btn-lg">Submit response</button>  </center>
</div>
<br><br>
</form>
</div>
</body>
</html>