<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.admin.adminJObjs"%>
    <%@page import="com.admin.adminBObjs"%>
    <%@page import="com.admin.adminBCObjs"%>
    <%@page import="com.admin.adminCProObjs"%>
    <%@page import="com.admin.adminCPreObjs"%>
    <%@page import="com.admin.adminPObjs"%>
    <%@page import="com.admin.adminTRObjs"%>
    <%@page import="com.tech_reports.tech_reports"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

p{
color : blue;
font-family: Verdana;
}

li{
font-family: Lucida Console;
font-weight:bold;
font-size:16px;
}

ul.dropdown-menu{
width: 400px;
    height: 340px;
    overflow: scroll;

}


li.a{
font-family: Verdana;
margin-left : 10px;
/*font-style: italic;*/
}

li.dropdown-header{
font-family: Arial;
}


span.label{
 border-radius : 15px;
 padding: 5px 10px;

}

select{
padding: 8px 16px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius : 8px;
    box-sizing: border-box;
}

/* Set a style for all buttons */
input[type=submit] {
    background-color: #2695DF;
    color: white;
    padding: 6px 12px;
    margin: 8px 0;
    border: none;
    border-radius : 8px;
    cursor: pointer;
    
}

  /* Full-width input fields */
input[type=text]{
   /* width: 100%;*/
    padding: 10px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius : 8px;
    box-sizing: border-box;
}


td{
font-family : "Comic Sans MS", cursive, sans-serif;
 font-size: 14px;

}


th{
font-family: Lucida Console;
font-size: 15px;
background : #2695DF;
color : white;
}



button:hover {
    opacity: 0.8;
}

.abc{
width : 90%;
padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius : 6.5px;
    box-sizing: border-box;

}

/* Extra styles for the cancel button */
.submitbtn {
    width: auto;
    padding: 10px 18px;
    color : white;
    background-color: #0080ff;
}


.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 20px;
    top: 15px;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}


/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
    <script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

</script>
<title>Journal : Revision-1</title>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<%  if(request.getSession().getAttribute("s_id")==null){
            response.sendRedirect("../login.jsp");
            return;
        }%>

<%int x=0; %>
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
			
          
      </div>  
       <div class="collapse navbar-collapse" id="myNavbar">  
        <ul class="nav navbar-nav">  
      
          <li>
          <%   if(adminTRObjs.AllNewTR() <= 0){ %>
        <a href="New.jsp">NEW</a>
        <%}else{%>
        <a href="New.jsp">NEW <span class="badge"><%=adminTRObjs.AllNewTR() %></span></a>
        <%} %>
          </li>  
           <li>
          <%   if(adminTRObjs.AllRev1TR() <= 0){ %>
        <a href="Revision1.jsp">REVISION 1</a>
        <%}else{%>
        <a href="Revision1.jsp">REVISION 1 <span class="badge"><%=adminTRObjs.AllRev1TR() %></span></a>
        <%} %>
          </li>  
           <li>
          <%   if(adminTRObjs.AllRev2TR() <= 0){ %>
        <a href="Revision2.jsp">REVISION 2</a>
        <%}else{%>
        <a href="Revision2.jsp">REVISION 2 <span class="badge"><%=adminTRObjs.AllRev2TR() %></span></a>
        <%} %>
          </li>      
        </ul>  
        <ul class="nav navbar-nav navbar-right">  
      <li><a href="../logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  
    </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>     
                     <br><br><br><br><br><br><br>   
                     <%String search=request.getParameter("search"); %>
                   
                      <form method="post" action="#">
                        <p>&nbsp&nbspSearch : 
                        <%if(search == null){
                        	%><input type="text" name="search" size= '31' placeholder="Type author's name or PCN no.">
                       <%  }
                       else{
                       %><input type="text" name="search" size= '31' placeholder="Type author's name or PCN no." value=<%=search %>><%} %>
                        
                        
                        <input type="SUBMIT" value="SEARCH"></p></form>
                        
                        <br>
                        <table class="table table-hover table-bordered">
                        
                            <thead>
                            <th>Sl No.</th>
                            <th>PCN No.</th>
                            <th>Faculty</th>
                            <th>Department</th>
                            <th>Title of Technical Report</th>
                            <th>Year</th>
                            <th>Month Of Publication</th>
                            <th>Month of assigning PCN</th>
                            <th>Date</th>
                            <th>Remarks</th>
                            <th>Download Tech Report</th>
                            <th>Download Plagiarism Report</th>
                            <th>Approve Publication</th>
                            <th>Reject Application</th>                     
                         
                            </thead>
                            <tbody>
                              <%
                              
                            //search=request.getParameter("search");
                            	
                              if(search==null){
                            	  for(tech_reports t : adminTRObjs.getRev1Tech()){
                            		  x++;
                            		  %>
                            		  
  
                                  <tr>
                                      <td>
                                          <%=x%>
                                                    
                                      </td>
                                      
                                      <td>
                                          <%if(t.getPcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(t.getPcn());
                                          }%>
                                          
                                      </td>
                                      
                                      <td>
                                          <%=t.getName()%>
                                      </td>
                                      <td>
                                          <%=t.getDept()%>
                                      </td>
                                      <td>
                                          <%=t.getTitle()%>
                                      </td>
                                      <td>
                                          <%=t.getYear()%>
                                      </td> 
                                      <td>
                                          <%=t.getMonth_pub()%>
                                      </td>
                                      <td>
                                          <%if(t.getMonth_pcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(t.getMonth_pcn());
                                          }%>
                                      </td>
                                      <td>
                                          <%=t.getDate()%>
                                      </td> 
                                      <td>
                                          <%=t.getRemarks()%>
                                      </td> 
                                   <td>
                                          <a href='../DownloadServlet?id=<%=t.getId()%>&type=tech_report'><span class="glyphicon glyphicon-download-alt"></span>Download</a>  
                                      </td>
                                      
                                      <td> 
                                          <a href='../Downloads?id=<%=t.getId()%>&type=tech_report'><span class="glyphicon glyphicon-download-alt"></span>Download</a>  
                                      </td>
                                    
                                      
                                       <td>
                                       <%
                                       if(t.getStatus()!=null){
                                    	   if(t.getStatus().equals("rejected")){
                                           	   out.print("Rejected Application");
                                              }
                                               else if(t.getStatus().equals("accepted")){
                                             	  out.print("Already generated");
                                               } 
                                       }
                                       
                                       else{%>
                                    	   <a href='../pcn?year=<%=t.getYear()%>&dept=<%=t.getDept()%>&id=<%=t.getId() %>&type=tech_report' onClick="return confirm('Are you sure you want to generate pcn for this publication?');" >Generate PCN</a>
                                      <%} 
                                       %>
                                     
                                      </td> 
                                      
                                         <td>  
                                      <%
                                      if(t.getStatus()!=null){
                                    	  if(t.getStatus().equals("rejected")){
                                         	   out.print("Rejected Application");
                                            }
                                   	  else if(t.getStatus().equals("accepted")){
                                       	  out.print("Already approved");
                                         }
                                      }
                                    	 
                                    	  else{
                                        request.getSession(false).setAttribute("id", t.getId()); %>
                                        <a onClick="document.getElementById('id01').style.display='block'">Reject</a> 
                                         <% }
                                      
                                      
                                       %> 
                                      </td> 
                                  </tr> 
                                  <%}
                              }
                              
                              else{
                            	  for(tech_reports t : adminTRObjs.getRev1TechSearch(search)){
                            		  x++;
                            		  %>
                            		  
  
                                  <tr>
                                      <td>
                                          <%=x%>
                                                    
                                      </td>
                                      
                                      <td>
                                          <%if(t.getPcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(t.getPcn());
                                          }%>
                                          
                                      </td>
                                      
                                      <td>
                                          <%=t.getName()%>
                                      </td>
                                      <td>
                                          <%=t.getDept()%>
                                      </td>
                                      <td>
                                          <%=t.getTitle()%>
                                      </td>
                                      <td>
                                          <%=t.getYear()%>
                                      </td> 
                                      <td>
                                          <%=t.getMonth_pub()%>
                                      </td>
                                      <td>
                                          <%if(t.getMonth_pcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(t.getMonth_pcn());
                                          }%>
                                      </td>
                                      <td>
                                          <%=t.getDate()%>
                                      </td> 
                                      <td>
                                          <%=t.getRemarks()%>
                                      </td> 
                                    <td>
                                          <a href='../DownloadServlet?id=<%=t.getId()%>&type=tech_report'><span class="glyphicon glyphicon-download-alt"></span>Download</a>  
                                      </td>
                                      
                                      <td> 
                                          <a href='../Downloads?id=<%=t.getId()%>&type=tech_report'><span class="glyphicon glyphicon-download-alt"></span>Download</a>  
                                      </td>
                                    
                                      
                                       <td>
                                       <%
                                       if(t.getStatus()!=null){
                                    	   if(t.getStatus().equals("rejected")){
                                           	   out.print("Rejected Application");
                                              }
                                               else if(t.getStatus().equals("accepted")){
                                             	  out.print("Already generated");
                                               } 
                                       }
                                       
                                       else{%>
                                    	   <a href='../pcn?year=<%=t.getYear()%>&dept=<%=t.getDept()%>&id=<%=t.getId() %>&type=tech_report' onClick="return confirm('Are you sure you want to generate pcn for this publication?');" >Generate PCN</a>
                                      <%} 
                                       %>
                                     
                                      </td> 
                                      
                                       
                                      <td>  
                                      <%
                                      if(t.getStatus()!=null){
                                    	  if(t.getStatus().equals("rejected")){
                                         	   out.print("Rejected Application");
                                            }
                                   	  else if(t.getStatus().equals("accepted")){
                                       	  out.print("Already approved");
                                         }
                                      }
                                    	 
                                    	  else{
                                     request.getSession(false).setAttribute("id", t.getId()); %>
                                        <a onClick="document.getElementById('id01').style.display='block'">Reject</a> 
                                         <% }
                                      
                                      
                                       %> 
                                      </td> 
                                  </tr> 
                             <% } }
                              %>
                              
                              

                            </tbody>

                        </table>

                        
  <div id="id01" class="modal"> 
  <form class="modal-content animate" method='post' action="../reject">
 <div class="container">
 <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <label><b>Enter the query or reason for the rejection of publication </b></label>
      <input type="text" class="abc" placeholder="Type the reason here" name="comment" required>
      <input type='hidden' name='type' value='tech_report'>
   
    <center>  <button type="submit" onclick="document.getElementById('id01').style.display='none'" class="submitbtn">Submit response</button></center>
    
    </div>
  </form>
</div>

</body>
</html>