<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.notify.notification"%>
<%@page import="com.notify.notifObjs"%>
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

li{
 font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
    font-size: 16px;
    font-weight : bold;

}
ul.dropdown-menu{
width: 400px;
    height: 340px;
    overflow: scroll;

}

li.a{
font-family: Verdana;
margin-left : 10px;
font-size : 13px;
font-weight : normal;
color : blue;
/*font-style: italic;*/
}

li.dropdown-header{
font-family: Arial;
}


span.label{
 border-radius : 15px;
 padding: 5px 10px;

}

form{
    font-family: Lucida Console;
    font-size: 14px;

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
input[type=submit] {
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
<title>Publication Portal</title>
</head>
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
			<li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
     <%if(notifObjs.count_notif(name) > 0){
        	%> <span class="label label-danger"><%=notifObjs.count_notif(name) %></span><%
        }else{
       } %>
           NOTIFICATIONS <span class="glyphicon glyphicon-bell"></span></a>
         
        <ul class="dropdown-menu">
        <% 
        for(notification n : notifObjs.getNotif(name)){
        	
        %>
        
     <li class="dropdown-header">  <%=n.getDiff() %> </li>
          <li class='a'><%=n.getNotification() %></li>
         
            <li class="dropdown-header">
        
      
         <a href='../Delnote?id=<%=n.getId() %>&type=user'><p align='right'> <span class="glyphicon glyphicon-trash"> </span></p></a>
       </li>
          
           <li class="divider"></li>
          <%} %>
        </ul>
      </li>
      <li><a href="../logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  
    </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>     
<br><br><br><br>
<form name="main" action="select.jsp" method="post">
<font color = red>
&nbsp&nbsp&nbsp SELECT TYPE OF PUBLICATION  <span class="glyphicon glyphicon-hand-down"></span></p>&nbsp&nbsp&nbsp 
<%String a=request.getParameter("type"); %>
<select name="type">
<%if(a == null){
	%>
<option>---------- SELECT ANY ONE ----------</option>
<option value="JOURNAL">JOURNAL</option>
<option value="BOOKS">BOOKS</option>
<option value="BOOK CHAPTER">BOOK CHAPTER</option>
<option value="CONFERENCE PROCEEDINGS">CONFERENCE PROCEEDINGS</option>
<option value="CONFERENCE PRESENTATIONS">CONFERENCE PRESENTATIONS</option>
<option value="PATENTS">PATENTS</option>
<option value="TECH REPORTS">TECH REPORTS</option>
<%}else{
	%>
<option value="<%=a%>"><%=a %></option>
<option>---------- SELECT ANY ONE ----------</option>
<option value="JOURNAL">JOURNAL</option>
<option value="BOOKS">BOOKS</option>
<option value="BOOK CHAPTER">BOOK CHAPTER</option>
<option value="CONFERENCE PROCEEDINGS">CONFERENCE PROCEEDINGS</option>
<option value="CONFERENCE PRESENTATIONS">CONFERENCE PRESENTATIONS</option>
<option value="PATENTS">PATENTS</option>
<option value="TECH REPORTS">TECH REPORTS</option>
<%} %>
</select>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
<input type="submit" value="SUBMIT">
</font>
	<br><br><br> &nbsp&nbsp&nbsp
<font color = 'blue'>
	 <span class="glyphicon glyphicon-info-sign"></span> IMPORTANT INSTRUCTIONS <span class="glyphicon glyphicon-hand-down"></span>
<br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
1. All fields are mandatory.<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
2. The fields for which you have no details to provide, fill it with 'NA'.<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
3. Names of NCU Authors in the sequence as mentioned in Journal should be in bold to distinguish from outside faculty/ Scholars. <br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
   Put * for corresponding author.
</font>

</form>

<%

if(a==null){
}
else if(a.equals("JOURNAL")){
	%>

<form method="post" enctype="multipart/form-data" action="../uploadJournal" > 
	<br><br><br>&nbsp&nbsp&nbsp
    Name of Authors in the sequence as mentioned in Journal : <input type="text" name="name" maxlength='100' required>
	<br><br><br> &nbsp&nbsp&nbsp
	Department :
<select name="dept" required>
<option value="CSE">CSE</option>
<option value="MED">ME</option>
<option value="ECE">ECE</option>
<option value="CEE">CE</option>
<option value="APS">APS</option>
<option value="SOM">SOM</option>
<option value="SOL">SOL</option>
<option value="CLL">CLL</option>
</select>
<br><br><br> &nbsp&nbsp&nbsp
    Title of Paper :  <input type="text" name="title" maxlength='200' required>
    <br><br><br>&nbsp&nbsp&nbsp
    Journal : <input type="text" name="journal" maxlength='200' required>
    <br><br><br>&nbsp&nbsp&nbsp
     Scope : 
<select name="scope" required>
<option value="International">International</option>
<option value="National">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
 Year : 
<select name="year" required>
<%for(int i=1997;i<=2050;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
 <br><br><br>&nbsp&nbsp&nbsp   
     Month of Publication : 
<select name="month_pub" required>
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
<!--     Month of assigning PCN (if PCN assigned already) :  -->
<br><br><br>&nbsp&nbsp&nbsp
     Volume : <input type="text" name="vol" maxlength='2' required>
  <br><br><br>&nbsp&nbsp&nbsp   
     Number/Issue : <input type="text" name="issue" maxlength='2' required>
     <br><br><br>&nbsp&nbsp&nbsp    
      Page No. : <input type="text" name="pages" maxlength='10' required>
      <br><br><br>&nbsp&nbsp&nbsp
     DOI No. : <input type="text" name="doi" maxlength='500' required>
     <br><br><br>&nbsp&nbsp&nbsp
     Impact Factor (SCI, GIF, SJR, etc) : <input type="text" name="if" maxlength='200' required>
     <br><br><br>&nbsp&nbsp&nbsp
     Specify which Impact Factor : <input type="text" name="swif" maxlength='200' required>
     <br><br><br>&nbsp&nbsp&nbsp
     Link for Impact factor : <input type="text" name="lfif" maxlength='500' required>
     <br><br><br>&nbsp&nbsp&nbsp
     Paid/Unpaid : <select name="pay" required>
<option value="Paid">PAID</option>
<option value="Unpaid">UNPAID</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Payment done or not :  <select name="pdon" required>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Publication reported in Web of Science : <select name="pw" required>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Publication reported in Scopus : <select name="ps" required>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Publication reported in Google Scholar : <select name="pg" required>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Publication reported in Indian Citation Index : <select name="pi" required>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Upload Journal : <input type="file" name="jour" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagorism Report : <input type="file" name="plag" required>
<br><br><br><br><center><input type="submit" value="SUBMIT JOURNAL"></center>
</form>
<!-- C:\Program Files\Apache Software Foundation\Tomcat 8.0\webapps -->>

   	<%
}



else if(a.equals("BOOKS"))
{
	%>
	<form name="Books" method="post" enctype="multipart/form-data" action="../uploadBooks" > 
	<br><br><br> &nbsp&nbsp&nbsp
	Name of Authors in the sequence as mentioned in Book : <input type="text" name="name" maxlength = '100' autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
	Department :
<select name="dept" required>
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
    Book Title :  <input type="text" name="title" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Publisher : <input type="text" name="publisher" maxlength = '100' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Scope : 
<select name="scope">
<option value="International">International</option>
<option value="National">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year" required>
<%for(int i=1997;i<=2050;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Month of Publication : 
<select name="month_pub">
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
Page Number : <input type="text" name="Page Number" maxlength = '10' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
ISBN Number : <input type="text" name="ISBN Number" maxlength = '30' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp   
Hyperlink : <input type="text" name="hyperlink" maxlength = '500' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp     
Mention if indexed in WOS/Scopus/Google Scholar/Thomson Reuter/Elsevier :
<select name="index" required>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Link For Indexing :  <input type="text" name="link" maxlength = '500' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Book : <input type="file" name="Books" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagiarism Report : <input type="file" name="plag" required>
<br><br><br><br><center><input type="submit" value="SUBMIT BOOK"></center>
</form>
<%
}




else if(a.equals("BOOK CHAPTER"))
{
%>
<form name="Book Chapter" method="post" enctype="multipart/form-data" action="../uploadBookChapter"> 
	<br><br><br>&nbsp&nbsp&nbsp
	Name of Authors in the sequence as mentioned in Book Chapter : 
	<input type="text" name="name" maxlength = '100' autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
  
	Department :
<select name="dept" required>
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
    Chapter Number :  <input type="text" name="chapter number" maxlength = '10' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Chapter Title : <input type="text" name="chapter title" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Book Title :  <input type="text" name="title" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Publisher : <input type="text" name="publisher" maxlength = '100' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Scope : 
<select name="scope" required>
<option value="International">International</option>
<option value="National">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year : 
<select name="year" required>
<%for(int i=1997;i<=2050;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Month of Publication : 
<select name="month_pub" required>
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
 
     Page Number : <input type="text" name="Page Number" maxlength = '10' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
     Book ISBN Number : <input type="text" name="ISBN Number" maxlength = '30' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Hyperlink : <input type="text" name="hyperlink" maxlength = '500' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp    
Indexed in Scopus/WOS/Google Scholar/Elsevier/Thomson Reuter
    <select name="index" required>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
    <br><br><br>&nbsp&nbsp&nbsp
Link For Indexing :  <input type="text" name="link" maxlength = '500' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Book Chapter : <input type="file" name="Books" required/>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagiarism Report : <input type="file" name="plag" required/>
<br><br><br><br><center>
<input type="submit" value="SUBMIT BOOK CHAPTER"></center>
</form>
<%}




else if(a.equals("CONFERENCE PROCEEDINGS"))
{
%>

<form name="Conference proceedings" method="post" enctype="multipart/form-data" action="../uploadConfPro" > 
	<br><br><br>&nbsp&nbsp&nbsp
	Name of Authors in the sequence as mentioned in Conference Proceedings : 
	<input type="text" name="name" maxlength = '100' autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
   
	Department :
<select name="dept" required>
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
    Title of Paper:  <input type="text" name="paper title" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Proceedings Of : <input type="text" name="proceeding of" size="70" maxlength = '150' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Scope : 
<select name="scope" required>
<option value="International">International</option>
<option value="National">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Venue Details for Conference : <input type="text" name="Venue" maxlength = '200' autocomplete="off" required>
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
    
    Dates : <input type="text" name="dates" maxlength = '50' placeholder='Eg. DD/MM/YYYY, 01/01/2000, DD/MM/YYYY' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp

    Publishers : <input type="text" name="publisher" maxlength = '100' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    
     Page Number : <input type="text" name="Page Number" maxlength = '10' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp

Hyperlink : <input type="text" name="hyperlink" maxlength = '500' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp  

Mention if indexed in WOS/Scopus/Google Scholar/Thomson Reuter/Elsevier : 
   <select name="index" required>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp  

Link for Indexing : <input type="text" name="link_index" maxlength = '500' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp  
     
    Upload Conf. Proceedings : <input type="file" name="pro" required>
<br><br><br>&nbsp&nbsp&nbsp

Upload Plagiarism Report : <input type="file" name="plag" required>
<br><br><br><br><center>

<input type="submit" value="SUBMIT CONFERENCE PROCEEDINGS"></center>
</form>

<%}


else if(a.equals("CONFERENCE PRESENTATIONS")){
	%>
<form name="Conference presentaion" method="post" enctype="multipart/form-data" action="../uploadConfPre" > 
	<br><br><br>&nbsp&nbsp&nbsp
	Faculty Name : <input type="text" name="name" maxlength = '100' autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
    
	Department :
<select name="dept" required>
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
    Title of Paper:  <input type="text" name="paper title" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Conference Presentaion : <input type="text" name="conference presentaion" maxlength = '150' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Scope : 
<select name="scope">
<option value="int">International</option>
<option value="nat">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp

Organised By: <input type="text" name="organiser" maxlength = '100' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Venue Details : <input type="text" name="Venue" maxlength = '200' autocomplete="off" required>
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
Dates : <input type="text" name="dates" autocomplete="off" maxlength = '50' placeholder='Eg. DD/MM/YYYY, 01/01/2000, DD/MM/YYYY' required>
<br><br><br>&nbsp&nbsp&nbsp
Hyperlink :  <input type="text" name="link" autocomplete="off" maxlength = '500' required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Conference Presentation : <input type="file" name="Books" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagiarism Report : <input type="file" name="plag" required>
<br><br><br><br><center><input type="submit" value="SUBMIT CONFERENCE PRESENTATION"></center>
</form>

<%} 
else if(a.equals("PATENTS")){
	%>
	
<form name="Patents" method="post" enctype="multipart/form-data" action="../uploadPatent" > 
	<br><br><br>&nbsp&nbsp&nbsp
	Faculty Name : <input type="text" name="name" maxlength = '100' autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
Department :
<select name="dept" required>
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
    Title of Patent :  <input type="text" name="paper title" maxlength = '200' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
 Scope : 
<select name="scope">
<option value="int">International</option>
<option value="nat">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Country : <input type="text" name="country" maxlength = '20' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Patent Application no. : <input type="text" name="app_no" maxlength = '20' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Patent Application Year : 
<select name="app_year">
<%for(int i=1997;i<=2050;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Patent Application Date : <input type="date" name="app_date" autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Patent Award Year :
<select name="award_year">
<%for(int i=1997;i<=2050;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Patent Award Date : <input type="date" name="app_date" autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Patent No. : <input type="text" name="patent_no" maxlength = '20' autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Patent : <input type="file" name="patent" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagiarism Report : <input type="file" name="plag" required>
<br><br><br><br>
<center><input type="submit" value="SUBMIT PATENT"></center>
</form>	
	
	
<%}
else if(a.equals("TECH REPORTS")){
	%>

<form name="Technical report" method="post" enctype="multipart/form-data" action="../uploadTech_Report" > 
	<br><br><br>&nbsp&nbsp&nbsp
	Faculty Name : <input type="text" name="name" maxlength = '100' autocomplete="off" required>
	<br><br><br>&nbsp&nbsp&nbsp
    
	Department :
<select name="dept" required>
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
    Title of Technical Report:  <input type="text" name="tech report" maxlength = '200' autocomplete="off" required>
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
    
    
     Date of Submission : <input type="date" name="conference date" autocomplete="off" required>
<br><br><br>&nbsp&nbsp&nbsp
    Remarks :  <input type="text" name="remarks" maxlength = '500' required autocomplete="off" >
<br><br><br>&nbsp&nbsp&nbsp
     
    Upload Technical Report : <input type="file" name="tech_report" required>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagiarism Report : <input type="file" name="plag" required>
<br><br><br><br><center>
<input type="submit" value="SUBMIT TECHNICAL REPORT"></center>
</form>

<%}%>
<br><br>
</body>
</html>