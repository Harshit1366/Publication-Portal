<%@page import="com.conf_presentations.conf_presentations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.journal.Journal"%>
    <%@page import="com.admin.adminCPreObjs"%>
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



conf_presentations c = adminCPreObjs.getC_PreById(id); 
if(null==c){
	   response.sendRedirect("../user/publications.jsp");
	   return;
}

%>
<h3>Edit Publication</h3>
<br> &nbsp&nbsp&nbsp

<form method="POST" enctype="multipart/form-data" action="../EditConfPre"  onsubmit="return confirm('Are you sure you want to update the journal ?');"> 
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
	<br>&nbsp&nbsp&nbsp
Faculty Name : <input type="text" name="name" value="<%=c.getName() %>" maxlength = '100' autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
    
	Department :
<select name="dept" required>
<option value="<%=c.getDept()%>"><%=c.getDept()%></option>
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
    Title of Paper:  <input type="text" name="paper title" value="<%=c.getTitle() %>" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Conference Presentaion : <input type="text" name="conference presentaion" value="<%=c.getPresentation() %>" maxlength = '150' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Scope : 
<select name="scope">
<option value="<%=c.getScope()%>"><%=c.getScope()%></option>
<option value="International">International</option>
<option value="National">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp

Organised By: <input type="text" name="organiser" value="<%=c.getOrganiser() %>" maxlength = '100' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Venue Details : <input type="text" name="Venue" value="<%=c.getVenue() %>" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp

        Year : 
<select name="year">
<option value="<%=c.getYear()%>"><%=c.getYear()%></option>
<%for(int i=1997;i<=2050;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Month of Publication : 
<select name="month_pub">
<option value="<%=c.getMonth_pub()%>"><%=c.getMonth_pub()%></option>
<option value="JANUARY">JANUARY</option>
<option value="FEBRUARY">FEBRUARY</option>
<option value="MARCH">MARCH</option>
<option value="APRIL">APRIL</option>
<option value="MAY">MAY</option>
<option value="JUNE">JUNE</option>
<option value="JULY">JULY</option>
<option value="AUGUST">AUGUST</option>
<option value="SEPTEMBER">SEPTEMBER</option>
<option value="OCTOBER">OCTOBER</option>
<option value="NOVEMBER">NOVEMBER</option>
<option value="DECEMBER">DECEMBER</option>
</select> 
    <br><br><br>&nbsp&nbsp&nbsp
Dates : <input type="text" name="dates" value="<%=c.getDates() %>" maxlength = '50' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Hyperlink :  <input type="text" name="link" value="<%=c.getHyperlink() %>" maxlength = '500' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Conference Presentation : <input type="file" name="Books">Already Uploaded : <%=c.getPre_file() %>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagiarism Report : <input type="file" name="plag">Already Uploaded : <%=c.getPlag_report() %>
<br><br><br><br><center>
<%request.getSession(false).setAttribute("id", id); %>
<button type="submit" >Update Conference Proceedings</button><br><br>
</form>
            

</body>
</html>