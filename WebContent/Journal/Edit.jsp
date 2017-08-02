<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.journal.Journal"%>
    <%@page import="com.admin.adminJObjs"%>
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



Journal j = adminJObjs.getUserById(id); 
if(null==j){
	   response.sendRedirect("../user/publications.jsp");
	   return;
}

%>
<h3>Edit Publication <%//out.print("id : "+id); %></h3>
<br> &nbsp&nbsp&nbsp

<!-- You need not upload the file or plagiarism report again if the one uploaded last time have no changes.  -->
<form method="POST" enctype="multipart/form-data" action="../EditJournal"  onsubmit="return confirm('Are you sure you want to update the journal ?');"> 
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
	

	Name of Authors in the sequence as mentioned in Journal : <input type="text" name="auth_name" maxlength='100' value="<%=j.getName() %>">
	<br><br><br>&nbsp&nbsp&nbsp
	Department :
<select name="dept">
<option value="<%=j.getDept() %>" selected><%=j.getDept() %></option>
<option value="CSE">CSE</option>
<option value="ME">ME</option>
<option value="ECE">ECE</option>
<option value="CE">CE</option>
</select>
<br><br><br> &nbsp&nbsp&nbsp
    Title of Paper :  <input type="text" name="title" value="<%=j.getTitle() %>" maxlength='200' size="70">
<br><br><br>&nbsp&nbsp&nbsp
    Journal : <input type="text" name="journal" value="<%=j.getJourn() %>" maxlength='200' size="70">
<br><br><br>&nbsp&nbsp&nbsp
    Scope : 
<select name="scope">
<option value="<%=j.getScope() %>" selected><%=j.getScope() %></option>
<option value="International">International</option>
<option value="National">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year">
<option value="<%=j.getYear() %>" selected><%=j.getYear() %></option>
<%for(int i=1997;i<2038;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Month of Publication : 
<select name="month_pub" value="<%=j.getMonth_pub() %>">
<option value="<%=j.getMonth_pub() %>" selected><%=j.getMonth_pub() %></option>
<option value="January">JANUARY</option>
<option value="February">FEBRUARY</option>
<option value="March">MARCH</option>
<option value="April">APRIL</option>
<option value="May">MAY</option>
<option value="June">JUNE</option>
<option value="July">JULY</option>
<option value="August">AUGUST</option>
<option value="September">SEPTEMBER</option>
<option value="October">OCTOBER</option>
<option value="November">NOVEMBER</option>
<option value="December">DECEMBER</option>
</select> 
<br><br><br>&nbsp&nbsp&nbsp
     Volume : <input type="text" name="vol" maxlength='2' value="<%=j.getVol() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Number/Issue : <input type="text" name="issue" maxlength='2' value="<%=j.getIssue() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Page No : <input type="text" name="pages" maxlength='10' value="<%=j.getPages() %>">
<br><br><br>&nbsp&nbsp&nbsp
 DOI No. : <input type="text" name="doi" maxlength='500' value="<%=j.getDoi()%>">
<br><br><br>&nbsp&nbsp&nbsp
     Impact Factor : <input type="text" name="if" maxlength='200' value="<%=j.getIfs() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Specify which Impact Factor : <input type="text" maxlength='200' name="swif" value="<%=j.getSwif() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Link for Impact factor : <input type="text" maxlength='500' name="lfif" value="<%=j.getLfif() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Paid/Unpaid : <select name="pay" value="<%=j.getPay() %>">
     <option value="<%=j.getPay() %>" selected><%=j.getPay() %></option>
<option value="Paid">PAID</option>
<option value="Unpaid">UNPAID</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Payment done or not :  <select name="pdon" value="<%=j.getPdon() %>">
     <option value="<%=j.getPdon() %>" selected><%=j.getPdon() %></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Publication reported in Web of Science : <select name="pw" value="<%=j.getPw() %>">
     <option value="<%=j.getPw() %>" selected><%=j.getPw() %></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Publication reported in Scopus : <select name="ps" value="<%=j.getPs() %>">
     <option value="<%=j.getPs() %>" selected><%=j.getPs() %></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Publication reported in Google Scholar : <select name="pg" value="<%=j.getPg() %>">
<option value="<%=j.getPg() %>" selected><%=j.getPg() %></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Publication reported in Indian Citation Index : <select name="pi" value="<%=j.getPi() %>" >
<option value="<%=j.getPi() %>" selected><%=j.getPi() %></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Upload Journal : <input type="file" name="jour"/>Already Uploaded : <%=j.getJournal_file() %>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagorism Report : <input type="file" name="plag"/>Already Uploaded : <%=j.getPlag_report() %>
<br><br><br><br><center>
<%request.getSession(false).setAttribute("id", id); %>
<button type="submit" >Update Journal</button><br><br>

</form>
            

</body>
</html>