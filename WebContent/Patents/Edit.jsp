<%@page import="com.patents.Patents"%>
<%@page import="com.conf_presentations.conf_presentations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.admin.adminPObjs"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style>
body {
    background-color: lightblue;
}


p{

margin-left:3%;
}

li{
 font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
    font-size: 16px;
    font-weight : bold;

}

form{
    font-family: Lucida Console;
    font-size: 14px;

}


h3{
    font-family: Verdana;
    font-size: 35px;
    margin-left : 3%;
    color:red;

}

input{
text-align:center;
}
.bton{
text-align:center;
}

/* Full-width input fields */
input[type=text]{
   /* width: 100%;*/
    padding: 6px 20px;
    width : 25%;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius : 6.5px;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button[type=submit] {
    background-color: #3386FF;
    color: white;
    padding: 6px 12px;
    margin: 8px 0;
    border: none;
    border-radius : 8px;
    cursor: pointer;
    
}

input[type=file] {
    background-color: orange;
    color: white;
    padding: 6px 12px;
    margin: 8px 0;
    border: none;
    border-radius : 8px;
    cursor: pointer;
    
}

select{
border-radius : 6.5px;
padding: 6px 20px;
}

</style>
  <style>

form{
    font-family: Lucida Console;
    font-size: 14px;

}

</style>
<title>Edit Publication Details</title>
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
   <a class="navbar-brand" href="../user/user_dashboard.jsp"><%
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
          <li><a href="../user/user_profile.jsp">PROFILE</a></li>  
          <li><a href="../user/publications.jsp">PUBLICATIONS</a></li>  
          <li><a href="../user/select.jsp">UPLOAD PUBLICATION DETAILS</a></li>  
        </ul>  
			<ul class="nav navbar-nav navbar-right">  
      <li><a href="../logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  
    </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>   
 <br><br><br>
<%
String id1=request.getParameter("id"); 

int id=Integer.valueOf(id1);



Patents p = adminPObjs.getPatentById(id); 
if(null==p){
	   response.sendRedirect("../user/publications.jsp");
	   return;
}

%>
<h3>Edit Publication</h3>
<form method="POST" enctype="multipart/form-data" action="../EditPatent"  onsubmit="return confirm('Are you sure you want to update the journal ?');"> 
<br> &nbsp&nbsp&nbsp
	<p>
<font color = 'blue'>
	 <span class="glyphicon glyphicon-info-sign"></span> IMPORTANT INSTRUCTIONS <span class="glyphicon glyphicon-hand-down"></span>
<br><br>&nbsp&nbsp&nbsp&nbsp
1. All fields are mandatory.<br>&nbsp&nbsp&nbsp&nbsp
2. The fields for which you have no details to provide, fill it with 'NA'.<br>&nbsp&nbsp&nbsp&nbsp
3. Do not upload any file or plagiarism report until and unless asked by admin.<br>&nbsp&nbsp&nbsp&nbsp
4. Names of NCU Authors in the sequence as mentioned in Journal should be in bold to distinguish from outside faculty/ Scholars. 
   <br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  Put * for corresponding author.
</font></p>
	<br><br><br>&nbsp&nbsp&nbsp
Faculty Name : <input type="text" name="name" value="<%=p.getName() %>" maxlength = '100' autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
Department :
<select name="dept" required>
<option value="<%=p.getDept()%>"><%=p.getDept()%></option>
<option value="CSE">CSE</option>
<option value="MED">ME</option>
<option value="ECE">ECE</option>
<option value="CEE">CE</option>
<option value="APS">APS</option>
<option value="SOM">SOM</option>
<option value="SOL">SOL</option>
<option value="CLL">CLL</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Title of Patent :  <input type="text" name="paper title" value="<%=p.getTitle() %>" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
 Scope : 
<select name="scope">
<option value="<%=p.getScope()%>"><%=p.getScope()%></option>
<option value="International">International</option>
<option value="National">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Country : <input type="text" name="country" value="<%=p.getCountry() %>" maxlength = '20' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Patent Application no. : <input type="text" name="app_no" value="<%=p.getApplication_no() %>" maxlength = '20' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Patent Application Year : 
<select name="app_year">
<option value="<%=p.getApplication_year()%>"><%=p.getApplication_year()%></option>
<%for(int i=1997;i<=2050;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Patent Application Date : <input type="date" name="app_date" value="<%=p.getApplication_date() %>" autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Patent Award Year :
<select name="award_year">
<option value="<%=p.getAward_year()%>"><%=p.getAward_year()%></option>
<%for(int i=1997;i<=2050;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Patent Award Date : <input type="date" name="app_date" value="<%=p.getAward_date() %>" autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Patent No. : <input type="text" name="patent_no" value="<%=p.getPatent_no() %>" maxlength = '20' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Patent : <input type="file" name="patent">Already Uploaded : <%=p.getPatent_file() %>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagiarism Report : <input type="file" name="plag">Already Uploaded : <%=p.getPlag_report() %>
<br><br><br><br><center>
<%request.getSession(false).setAttribute("id", id); %>
<button type="submit" >Update Patent</button><br><br>
</form>
</body>
</html>