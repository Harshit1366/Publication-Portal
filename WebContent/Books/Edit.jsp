<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.books.Books"%>
    <%@page import="com.admin.adminBObjs"%>
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



Books b = adminBObjs.getUserById(id); 
if(null==b){
	   response.sendRedirect("../user/publications.jsp");
	   return;
}

%>


<h3>Edit Publication</h3>
<br> &nbsp&nbsp&nbsp

<form name="Books" method="post" enctype="multipart/form-data" action="../EditBooks" onsubmit="return confirm('Are you sure you want to update the book details ?');"> 
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
	<br><br><br> &nbsp&nbsp&nbsp
	Name of Authors in the sequence as mentioned in Book : <input type="text" name="name" size="70" maxlength = '100' value="<%=b.getName() %>" autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
	Department :
<select name="dept">
<option value="<%=b.getDept()%>"><%=b.getDept()%></option>
<option value="cse">CSE</option>
<option value="me">ME</option>
<option value="ece">ECE</option>
<option value="ce">CE</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Book Title :  <input type="text" name="title" value="<%=b.getTitle() %>" size="70" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Publisher : <input type="text" name="publisher" value="<%=b.getPublisher() %>" size="70" maxlength = '100' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Scope : 
<select name="scope">
<option value="<%=b.getScope()%>"><%=b.getScope()%></option>
<option value="int">International</option>
<option value="nat">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year">
<option value="<%=b.getYear()%>"><%=b.getYear()%></option>
<option value="2017">2017</option>
<option value="2016">2016</option>
<option value="2015">2015</option>
<option value="2014">2014</option>
<option value="2013">2013</option>
<option value="2012">2012</option>
<option value="2011">2011</option>
<option value="2010">2010</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Month of Publication : 
<select name="month_pub">
<option value="<%=b.getMonth_pub()%>"><%=b.getMonth_pub()%></option>
<option value="jan">JANUARY</option>
<option value="feb">FEBRUARY</option>
<option value="mar">MARCH</option>
<option value="apr">APRIL</option>
<option value="may">MAY</option>
<option value="jun">JUNE</option>
<option value="jul">JULY</option>
<option value="aug">AUGUST</option>
<option value="sep">SEPTEMBER</option>
<option value="oct">OCTOBER</option>
<option value="nov">NOVEMBER</option>
<option value="dec">DECEMBER</option>
</select> 
    <br><br><br>&nbsp&nbsp&nbsp
Page Number : <input type="text" name="Page Number" value="<%=b.getPages() %>" maxlength = '10' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
ISBN Number : <input type="text" name="ISBN Number" value="<%=b.getIsbn_no() %>" maxlength = '30' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp   
Hyperlink : <input type="text" name="hyperlink" value="<%=b.getHyperlink() %>" maxlength = '500' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp     
Mention if indexed in WOS/Scopus/Google Scholar/Thomson Reuter/Elsevier :
<select name="index" required>
<option value="<%=b.getP_index()%>"><%=b.getP_index()%></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Link For Indexing :  <input type="text" name="link" value="<%=b.getLink_index() %>" maxlength = '500' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Book : <input type="file" name="Books">Already Uploaded : <%=b.getBook_file() %>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagiarism Report : <input type="file" name="plag"/>Already Uploaded : <%=b.getPlag_report() %>
<%request.getSession(false).setAttribute("id", id); %>
<center>
<button type="submit" >Update Book</button></center><br><br>
</form>
            

</body>
</html>