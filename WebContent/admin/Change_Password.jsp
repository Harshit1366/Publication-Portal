<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.admin.adminJObjs"%>
    <%@page import="com.admin.adminBObjs"%>
    <%@page import="com.admin.adminBCObjs"%>
    <%@page import="com.admin.adminCProObjs"%>
    <%@page import="com.admin.adminCPreObjs"%>
    <%@page import="com.admin.adminPObjs"%>
    <%@page import="com.admin.adminTRObjs"%>
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
li{
font-family: Lucida Console;
}
body{
background-image : url("../images/ncu.jpg");
background-repeat: no-repeat;
background-size : 1600px 1100px;
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
<%  if(request.getSession().getAttribute("s_id")==null){
            response.sendRedirect("../login.jsp");
            return;
        }%>
<nav class="navbar navbar-inverse navbar-fixed-top">  
  <div class="container-fluid">  
    <div class="navbar-header">  
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">  
          <span class="icon-bar"></span>  
          <span class="icon-bar"></span>  
          <span class="icon-bar"></span>                          
      </button>  
      <a class="navbar-brand" href="../admin/admin_dashboard.jsp">Admin</a>  
    </div>  
    <div>  
      <div class="collapse navbar-collapse" id="myNavbar">  
        <ul class="nav navbar-nav">  
         
         <li>   
     <%   if(adminJObjs.AllNewJ()+adminJObjs.AllRev1J()+adminJObjs.AllRev2J() <= 0){ %>
        <a href="../Journal/Journal.jsp">JOURNAL</a>
        <%}else{%>
         <a href="../Journal/Journal.jsp">JOURNAL <span class="badge"><%=(adminJObjs.AllNewJ()+adminJObjs.AllRev1J()+adminJObjs.AllRev2J()) %></span></a>  
        <%} %>
        </li>
        
<li>   
 <%   if(adminBObjs.AllNewB()+adminBObjs.AllRev1B()+adminBObjs.AllRev2B() <= 0){ %>
        <a href="../Books/Books.jsp">BOOKS</a>
        <%}else{%>
 <a href="../Books/Books.jsp">BOOKS <span class="badge"><%=(adminBObjs.AllNewB()+adminBObjs.AllRev1B()+adminBObjs.AllRev2B()) %></span></a>
   <%} %></li>

<li>   
 <%   if((adminBCObjs.AllNewBC()+adminBCObjs.AllRev1BC()+adminBCObjs.AllRev2BC()) <= 0){ %>
        <a href="../Book Chapter/Book_Chapter.jsp">BOOK CHAPTER</a>
        <%}else{%>
<a href="../Book Chapter/Book_Chapter.jsp">BOOK CHAPTER <span class="badge"><%=(adminBCObjs.AllNewBC()+adminBCObjs.AllRev1BC()+adminBCObjs.AllRev2BC()) %></span></a><%} %></li>

<li>   
 <%   if(adminCProObjs.AllNewCPro()+adminCProObjs.AllRev1CPro()+adminCProObjs.AllRev2CPro() <= 0){ %>
        <a href="../Conf. Proceedings/Conf_Proceedings.jsp">CONFERENCE PROCEEDINGS</a>
        <%}else{%>
<a href="../Conf. Proceedings/Conf_Proceedings.jsp">CONFERENCE PROCEEDINGS <span class="badge"><%=(adminCProObjs.AllNewCPro()+adminCProObjs.AllRev1CPro()+adminCProObjs.AllRev2CPro()) %></span></a><%} %></li>

<li>   
 <%   if(adminCPreObjs.AllNewCPre()+adminCPreObjs.AllRev1CPre()+adminCPreObjs.AllRev2CPre() <= 0){ %>
        <a href="../Conf. Presentations/Conf_Presentations.jsp">CONFERENCE PRESENTATIONS</a>
        <%}else{%>
<a href="../Conf. Presentations/Conf_Presentations.jsp">CONFERENCE PRESENTATIONS <span class="badge"><%=(adminCPreObjs.AllNewCPre()+adminCPreObjs.AllRev1CPre()+adminCPreObjs.AllRev2CPre()) %></span></a><%} %></li>

<li>   
 <%   if(adminPObjs.AllNewP()+adminPObjs.AllRev1P()+adminPObjs.AllRev2P() <= 0){ %>
        <a href="../Patents/Patents.jsp">PATENTS</a>
        <%}else{%>
<a href="../Patents/Patents.jsp">PATENTS <span class="badge"><%=(adminPObjs.AllNewP()+adminPObjs.AllRev1P()+adminPObjs.AllRev2P()) %></span></a><%} %></li>

<li>   
 <%   if(adminTRObjs.AllNewTR()+adminTRObjs.AllRev1TR()+adminTRObjs.AllRev2TR() <= 0){ %>
        <a href="../Tech reports/Tech_Report.jsp">TECH REPORT</a>
        <%}else{%>
<a href="../Tech reports/Tech_Report.jsp">TECH REPORT <span class="badge"><%=(adminTRObjs.AllNewTR()+adminTRObjs.AllRev1TR()+adminTRObjs.AllRev2TR()) %></span></a><%} %></li>
        
        </ul>  
			<ul class="nav navbar-nav navbar-right"> 
			<li><a href="Change_Password.jsp"> Change Password</a></li>   
      <li><a href="../logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  
    </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>     

 
     

<br><br><br><br><br>
<h1 class="text">Change Password </h1>
           <br>  
           <form style="width:300px" method="POST" action="../change_password">  
<div class="form-group">  
    <label for="name">Old Password </label>  
    <br><input type="password" class="form-control" name="op" placeholder="Enter your old password" required="required">  
    <br>
  </div> 
 <div class="form-group">  
    <label for="desg">New Password </label>  
    <br><input type="password" class="form-control" name="np" placeholder="Enter your new password" required="required">  <br>
  </div> 
 <div class="form-group">  
    <label for="InputEmail">Confirm New Password </label>  
    <br><input type="password" class="form-control" name="cnp" placeholder="Confirm your new password" required="required"> <br> 
  </div>  
   <input type='hidden' name='role' value='admin'>
  <div class="bton"> <br> 
  <button type="submit" class="btn btn-primary btn-lg">Change Password</button>  
  <br><br>
</div>
</form>  
        
</body>
</html>