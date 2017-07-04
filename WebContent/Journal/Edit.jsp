<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.journal.Journal"%>
    <%@page import="com.admin.adminObjs"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
 <br><br><br>
<%
String id1=request.getParameter("id"); 

int id=Integer.valueOf(id1);



Journal j = adminObjs.getUserById(id); 
if(null==j){
	   response.sendRedirect("../user/publications.jsp");
	   return;
}

%>
<h3>Edit Publication <%//out.print("id : "+id); %></h3>
<form method="POST" enctype="multipart/form-data" action="../Edit"  onsubmit="return confirm('Are you sure you want to update the journal ?');"> 
	<br>&nbsp&nbsp&nbsp
<!-- PCN NUMBER (If any) : <input type="text" name="pcn" size="30" value=<%//=j.getPcn() %> >
	<br><br><br>&nbsp&nbsp&nbsp -->
    <%//out.print(j.getName()+"\n"); %>
    <%//=j.getName() %>
	Authors Name* : <input type="text" name="auth_name"  size="70" value="<%=j.getName() %>">
	<br><br><br>&nbsp&nbsp&nbsp
	Department* :
<select name="dept">
<option value="<%=j.getDept() %>" selected><%=j.getDept() %></option>
<option value="CSE">CSE</option>
<option value="ME">ME</option>
<option value="ECE">ECE</option>
<option value="CE">CE</option>
</select>
<br><br><br> &nbsp&nbsp&nbsp
    Title of Paper* :  <input type="text" name="title" value="<%=j.getTitle() %>" size="70">
<br><br><br>&nbsp&nbsp&nbsp
    Journal* : <input type="text" name="journal" value="<%=j.getJourn() %>" size="70">
<br><br><br>&nbsp&nbsp&nbsp
    Scope* : 
<select name="scope">
<option value="<%=j.getScope() %>" selected><%=j.getScope() %></option>
<option value="International">International</option>
<option value="National">National</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Year* : 
<select name="year">
<option value="<%=j.getYear() %>" selected><%=j.getYear() %></option>
<%for(int i=1997;i<2038;i++){%>
<option value="<%=i%>"><%=i %></option>
<%} %>
<!-- 
<option value="2017">2017</option>
<option value="2016">2016</option>
<option value="2015">2015</option>
<option value="2014">2014</option>
<option value="2013">2013</option>
<option value="2012">2012</option>
<option value="2011">2011</option>
<option value="2010">2010</option> -->
</select>
<br><br><br>&nbsp&nbsp&nbsp
    Month of Publication* : 
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
<!--   Month of assigning PCN (if PCN assigned already) : 
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
     Volume* : <input type="text" name="vol" value="<%=j.getVol() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Number/Issue* : <input type="text" name="issue" value="<%=j.getIssue() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Page No* : <input type="text" name="pages" value="<%=j.getPages() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Impact Factor* : <input type="text" name="if" value="<%=j.getIfs() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Specify which Impact Factor* : <input type="text" name="swif" value="<%=j.getSwif() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Link for Impact factor* : <input type="text" name="lfif" value="<%=j.getLfif() %>">
<br><br><br>&nbsp&nbsp&nbsp
     Paid/Unpaid* : <select name="pay" value="<%=j.getPay() %>">
     <option value="<%=j.getPay() %>" selected><%=j.getPay() %></option>
<option value="Paid">PAID</option>
<option value="Unpaid">UNPAID</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Payment done or not* :  <select name="pdon" value="<%=j.getPdon() %>">
     <option value="<%=j.getPdon() %>" selected><%=j.getPdon() %></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Publication reported in Web of Science* : <select name="pw" value="<%=j.getPw() %>">
     <option value="<%=j.getPw() %>" selected><%=j.getPw() %></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
     Publication reported in Scopus* : <select name="ps" value="<%=j.getPs() %>">
     <option value="<%=j.getPs() %>" selected><%=j.getPs() %></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Publication reported in Google Scholar* : <select name="pg" value="<%=j.getPg() %>">
<option value="<%=j.getPg() %>" selected><%=j.getPg() %></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Publication reported in Indian Citation Index* : <select name="pi" value="<%=j.getPi() %>" >
<option value="<%=j.getPi() %>" selected><%=j.getPi() %></option>
<option value="Yes">YES</option>
<option value="No">NO</option>
</select>
<br><br><br>&nbsp&nbsp&nbsp
Upload Journal* : <input type="file" name="jour"/><%=j.getJournal_file() %>
<br><br><br>&nbsp&nbsp&nbsp
Upload Plagorism Report* : <input type="file" name="plag"/><%=j.getPlag_report() %>
<br><br><br><br><center>
<%request.getSession(false).setAttribute("id", id); %>
<%//out.println(names);%>
<button type="submit" >Update Journal</button><br><br>
<!-- 
<a href="../Edit?authors_name=<%//=names%>" onClick="return confirm('Are you sure you want to update the journal ?');">UPDATE JOURNAL</a></center><br><br>
 -->
</form>
            

</body>
</html>