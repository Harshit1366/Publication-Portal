<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<title>Publication Portal</title>
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
      <li><a href="../logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  
    </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>     
<br><br><br><br>
<form name="main" action="select.jsp" method="post">
&nbsp&nbsp&nbsp SELECT TYPE OF PUBLICATION  :- &nbsp&nbsp&nbsp 
<%String a=request.getParameter("type"); %>
<select name="type">
<option value="<%=a%>"><%=a %></option>
<option value="none">---------- SELECT ANY ONE ----------</option>
<option value="Journal">JOURNAL</option>
<option value="Books">BOOKS</option>
<option value="Book Chapter">BOOK CHAPTER</option>
<option value="Conference Proceedings">CONFERENCE PROCEEDINGS</option>
<option value="Conference Presentations">CONFERENCE PRESENTATIONS</option>
<option value="Patents">PATENTS</option>
<option value="Tech Reports">TECH REPORTS</option>
</select>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
<input type="submit" value="SUBMIT">
</form>
<%

if(a==null){
	
}
else if(a.equals("none")){
	%><br><br><%out.println("Please select a type!");
}
else if(a.equals("Journal")){
	%>


	<!-- enctype="multipart/form-data" -->
<form method="post" enctype="multipart/form-data" action="../uploadJournal" > 
	<br><br><br>&nbsp&nbsp&nbsp
	<!-- <input type='hidden' name='type' value='<%//=request.getParameter("type")%>'>-->
	<!-- 
	PCN NUMBER (If any) : <input type="text" name="pcn" size="30">
	<br><br><br>&nbsp&nbsp&nbsp -->
	Authors Name : <input type="text" name="name" size="70">
	<br><br><br>&nbsp&nbsp&nbsp
	Department :
<select name="dept">
<option value="CSE">CSE</option>
<option value="ME">ME</option>
<option value="ECE">ECE</option>
<option value="CE">CE</option>
</select>
<br><br><br> &nbsp&nbsp&nbsp
    Title of Paper :  <input type="text" name="title" size="70">
<br><br><br>&nbsp&nbsp&nbsp
    Journal : <input type="text" name="journal" size="70">
<br><br><br>&nbsp&nbsp&nbsp
    Scope : 
<select name="scope">
<option value="International">International</option>
<option value="National">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year">
<%for(int i=1997;i<=2050;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Month of Publication : 
<select name="month_pub">
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
<!--     Month of assigning PCN (if PCN assigned already) : 
<select name="month_pcn">
<option value="Not Assigned">NOT ASSIGNED</option>
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
<br><br><br>&nbsp&nbsp&nbsp -->
     Volume* : <input type="text" name="vol">
<br><br><br>&nbsp&nbsp&nbsp
     Number/Issue* : <input type="text" name="issue">
<br><br><br>&nbsp&nbsp&nbsp
     Page No* : <input type="text" name="pages">
<br><br><br>&nbsp&nbsp&nbsp
     Impact Factor* : <input type="text" name="if">
<br><br><br>&nbsp&nbsp&nbsp
     Specify which Impact Factor* : <input type="text" name="swif">
<br><br><br>&nbsp&nbsp&nbsp
     Link for Impact factor* : <input type="text" name="lfif">
<br><br><br>&nbsp&nbsp&nbsp
     Paid/Unpaid* : <select name="pay">
<option value="Paid">PAID</option>
<option value="Unpaid">UNPAID</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Payment done or not* :  <select name="pdon">
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Publication reported in Web of Science* : <select name="pw">
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Publication reported in Scopus* : <select name="ps">
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Publication reported in Google Scholar* : <select name="pg">
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Publication reported in Indian Citation Index* : <select name="pi">
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Upload Journal* : <input type="file" name="jour"/>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagorism Report* : <input type="file" name="plag"/> 
<br><br><br><br><center><input type="submit" value="SUBMIT JOURNAL"></center>
</form>
<!-- C:\Program Files\Apache Software Foundation\Tomcat 8.0\webapps -->>

   	<%
}
else if(a.equals("Books"))
{
	%>
	<form name="Books" method="post" enctype="multipart/form-data" action="../uploadBooks" > 
	<br><br><br> &nbsp&nbsp&nbsp
	Authors Name : <input type="text" name="name" size="70" required autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
	Department :
<select name="dept">
<option value="cse">CSE</option>
<option value="me">ME</option>
<option value="ece">ECE</option>
<option value="ce">CE</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Book Title :  <input type="text" name="title" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Publisher : <input type="text" name="publisher" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Scope : 
<select name="scope">
<option value="int">International</option>
<option value="nat">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year">
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
Page Number : <input type="text" name="Page Number" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
ISBN Number : <input type="text" name="ISBN Number" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp   
Hyperlink : <input type="text" name="hyperlink" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp     
Mention if indexed in WOS/Scopus/Google Scholar/Thomson Reuter/Elsevier :
<input type="text" name="Mention if any" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Link For Indexing :  <input type="text" name="link" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Book : <input type="file" name="Books"/ required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagiarism Report : <input type="file" name="plag"/ required>
<br><br><br><br><center><input type="submit" value="SUBMIT BOOK"></center>
</form>
<%
}
else if(a.equals("Book Chapter"))
{
%>
<form name="Book Chapter" method="post" enctype="multipart/form-data" action="UploadServlet"> 
	<br>&nbsp&nbsp&nbsp
	Authors Name : <input type="text" name="name" size="70" required autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
  
	Department :
<select name="dept">
<option value="cse">CSE</option>
<option value="me">ME</option>
<option value="ece">ECE</option>
<option value="ce">CE</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
   Chapter Number :  <input type="number" name="chapter number" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Chapter Title : <input type="text" name="chapter title" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Book Title :  <input type="text" name="title" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Publisher : <input type="text" name="publisher" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Scope : 
<select name="scope">
<option value="int">International</option>
<option value="nat">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year">
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
 
     Page Number : <input type="text" name="Page Number" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
     ISBN Number : <input type="text" name="ISBN Number" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Link For Indexing :  <input type="text" name="link" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
     
Indexed in Scopus/WOS/Google SCholar/Elsevier/Thomson Reuter
    <input type="text" name="Mention if any" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Book : <input type="file" name="Books"/>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plag Report : <input type="file" name="plag"/>
<br><br><br><br><center><input type="submit" value="SUBMIT BOOK CHAPTER"></center>
</form>
<%}
else if(a.equals("Conference Proceedings"))
{
%>

<form name="Conference proceedings" method="post" enctype="multipart/form-data" action="UploadServlet" > 
	<br>&nbsp&nbsp&nbsp
	Authors Name : <input type="text" name="name" size="70" required autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
   
	Department :
<select name="dept">
<option value="cse">CSE</option>
<option value="me">ME</option>
<option value="ece">ECE</option>
<option value="ce">CE</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Title of Paper:  <input type="text" name="paper title" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Proceedings Of : <input type="text" name="proceeding of" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Venue Details : <input type="text" name="Venue" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Publishers: <input type="text" name="publisher" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Date of Conference: <input type="date" name="" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Scope : 
<select name="scope">
<option value="int">International</option>
<option value="nat">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year">
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
    
    
     Page Number : <input type="number" name="Page Number" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
     
    Upload Book : <input type="file" name="Books"/ required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plag Report : <input type="file" name="plag"/ required>
<br><br><br><br><center><input type="submit" value="SUBMIT CONFERENCE PROCEEDINGS"></center>
</form>

<%}
else if(a.equals("Conference Presentations")){
	%>
<form name="Conference presentaion" method="post" enctype="multipart/form-data" action="UploadServlet" > 
	<br>&nbsp&nbsp&nbsp
	Faculty Name : <input type="text" name="name" size="70" required autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
    
	Department :
<select name="dept">
<option value="cse">CSE</option>
<option value="me">ME</option>
<option value="ece">ECE</option>
<option value="ce">CE</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Title of Paper:  <input type="text" name="paper title" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Conference Presentaion : <input type="text" name="conference presentaion" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Venue Details : <input type="text" name="Venue" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Organised By: <input type="text" name="organiser" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    
    Scope : 
<select name="scope">
<option value="int">International</option>
<option value="nat">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year">
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
Page Number : <input type="text" name="Page Number" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
     Link For Indexing :  <input type="text" name="link" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
     
    Upload Book : <input type="file" name="Books"/ required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plag Report : <input type="file" name="plag"/ required>
<br><br><br><br><center><input type="submit" value="SUBMIT CONFERENCE PRESENTATION"></center>
</form>

<%} 
else if(a.equals("Patents")){
	%>
	
<form name="Patents" method="post" enctype="multipart/form-data" action="UploadServlet" > 
	<br>&nbsp&nbsp&nbsp
	Faculty Name : <input type="text" name="name" size="70" required autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
    
	Department :
<select name="dept">
<option value="cse">CSE</option>
<option value="me">ME</option>
<option value="ece">ECE</option>
<option value="ce">CE</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Title of Paper:  <input type="text" name="paper title" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Conference Presentaion : <input type="text" name="conference presentaion" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Venue Details : <input type="text" name="Venue" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Organised By: <input type="text" name="organiser" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    
    Scope : 
<select name="scope">
<option value="int">International</option>
<option value="nat">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year">
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
    
   
     Date of Conference : <input type="date" name="conference date" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
     
    Upload Book : <input type="file" name="Books"/ required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plag Report : <input type="file" name="plag"/ required>
<br><br><br><br><center><input type="submit" value="SUBMIT PATENT"></center>
</form>	
	
	
<%}
else if(a.equals("Tech Reports")){
	%>

<form name="Technical report " method="post" enctype="multipart/form-data" action="UploadServlet" > 
	<br>&nbsp&nbsp&nbsp
	Faculty Name : <input type="text" name="name" size="70" required autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
    
	Department :
<select name="dept">
<option value="cse">CSE</option>
<option value="me">ME</option>
<option value="ece">ECE</option>
<option value="ce">CE</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Title of Technical Report:  <input type="text" name="tech report" size="70" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    
    Scope : 
<select name="scope">
<option value="int">International</option>
<option value="nat">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year">
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
    
    
     Date of Submittion: <input type="date" name="conference date" required autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Remarks:  <input type="text" name="remarks" size="70" required autocomplete="off" >
<br><br><br>&nbsp&nbsp&nbsp
     
    Upload Book : <input type="file" name="Books"/ required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plag Report : <input type="file" name="plag"/ required>
<br><br><br><br><center><input type="submit" value="SUBMIT TECHNICAL REPORT"></center>
</form>

<%}%>
</body>
</html>