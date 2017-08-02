<%@page import="com.tech_reports.tech_reports"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.admin.adminTRObjs"%>
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

tech_reports t = adminTRObjs.getTechById(id); 
if(null==t){
	   response.sendRedirect("../user/publications.jsp");
	   return;
}

%>
<h3>Edit Publication</h3>
<br> &nbsp&nbsp&nbsp

<form method="POST" enctype="multipart/form-data" action="../EditTech_Report"  onsubmit="return confirm('Are you sure you want to update the journal ?');"> 
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
Faculty Name : <input type="text" name="name" value="<%=t.getName() %>" maxlength = '100' autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
    
	Department :
<select name="dept" required>
<option value="<%=t.getDept()%>"><%=t.getDept()%></option>
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
    Title of Technical Report:  <input type="text" name="tech report" value="<%=t.getTitle() %>" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    
    Year : 
<select name="year" required>
<option value="<%=t.getYear()%>"><%=t.getYear()%></option>
<%for(int i=1997;i<=2050;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Month of Publication : 
<select name="month_pub" required>
<option value="<%=t.getMonth_pub()%>"><%=t.getMonth_pub()%></option>
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
    
    
     Date of Submission : <input type="date" name="conference date" value="<%=t.getDate() %>" autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Remarks :  <input type="text" name="remarks" value="<%=t.getRemarks() %>" maxlength = '500' required autocomplete="off" >
<br><br><br>&nbsp&nbsp&nbsp
     
    Upload Technical Report : <input type="file" name="tech_report">Already Uploaded : <%=t.getTech_report() %>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagiarism Report : <input type="file" name="plag">Already Uploaded : <%=t.getPlag_report() %>
<br><br><br><br><center>
<%request.getSession(false).setAttribute("id", id); %>
<button type="submit" >Update Conference Proceedings</button><br><br>
</form>
            

</body>
</html>