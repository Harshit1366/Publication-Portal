<%@page import="com.conf_proceedings.conf_proceedings"%>
<%@page import="com.admin.adminCProObjs"%>
<%@page import="java.sql.*"%>
<%@page import="com.user.userObjs"%>
<%@page import="com.user.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<style>
li{
 font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
    font-size: 16px;
    font-weight : bold;

}

th{
    font-family: Lucida Console;
    font-size: 15px;
   

}

td{
font-family : "Comic Sans MS", cursive, sans-serif;
 font-size: 14px;

}

th{
background : #2695DF;
color : white;
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
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 90%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 15px;
	top: 15px;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}
/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
}
</style>
<title>Conference Proceedings</title>
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
              String name = null,comment=null;
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
      
        <div class="collapse navbar-collapse" id="myNavbar">  
        <ul class="nav navbar-nav">  
       <li><a href="journal.jsp">JOURNAL</a></li>  
          <li><a href="books.jsp">BOOKS</a></li>  
          <li><a href="book_chapter.jsp">BOOK CHAPTER</a></li>  
          <li><a href="conf_proceedings.jsp">CONFERENCE PROCEEDINGS</a></li>  
          <li><a href="conf_presentations.jsp">CONFERENCE PRESENTATIONS</a></li>  
          <li><a href="patent.jsp">PATENTS</a></li>  
          <li><a href="tech_report.jsp">TECH REPORT</a></li>
        </ul>  
          
      </div>  
    </div>  
  </div>  
</nav>   
 <br><br><br>
 <br><br>
                    
                        
                       	<table class="table table-hover table-bordered">
                        
                            <thead>
                            <th>Sl No.</th>
                            <th>PCN No.</th>
                            <th>Name of Authors as in Conference Proceedings</th>
                            <th>Department</th>
                            <th>Title of Paper</th>
                            <th>Proceedings of</th>
                            <th>Scope</th>
                            <th>Venue Details for Conference </th>
                            <th>Year</th>
                            <th>Month of Publication</th>
                            <th>Month of assigning pcn</th>
                            <th>Dates</th>
                            <th>Publishers</th>
                            <th>Page No.</th>
                            <th>Hyperlink</th>
                            <th>Mention if indexed in WOS/Scopus/Google Scholar/Thomson Reuter/Elsevier</th>
                            <th>Link for Indexing</th>
                            <th>Download Conference Proceedings</th>
                            <th>Download Plagiarism Report</th>
                            <th>Edit Details</th>
                            <th>Comments</th>
                            
                         
                            </thead>
                            <tbody>
                              <%
                             
                            	int x=0;
                            		  for(conf_proceedings c : adminCProObjs.getC_ProById(name)){
                            		  x++;%>
                                <tr class='active'>
                                     <td>
                                          <%=x%>
                                                    
                                      </td>
                                      
                                      <td>
                                          <%if(c.getPcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(c.getPcn());
                                          }%>
                                          
                                      </td>
                                      
                                      <td>
                                          <%=c.getName()%>
                                      </td>
                                      <td>
                                          <%=c.getDept()%>
                                      </td>
                                      <td>
                                          <%=c.getTitle()%>
                                      </td>
                                      <td>
                                          <%=c.getProceedings()%>
                                      </td> 
                                      <td>
                                          <%=c.getScope()%>
                                      </td>   
                                      <td>
                                          <%=c.getVenue()%>
                                      </td>
                                      <td>
                                          <%=c.getYear()%>
                                      </td>
                                      <td>
                                          <%=c.getMonth_pub()%>
                                      </td>
                                      <td>
                                          <%if(c.getMonth_pcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(c.getMonth_pcn());
                                          }%>
                                      </td>
                                      <td>
                                          <%=c.getDates()%>
                                      </td> 
                                      <td>
                                          <%=c.getPublishers()%>
                                      </td>   
                                      <td>
                                          <%=c.getPages()%>
                                      </td>
                                      <td>
                                      <%if(c.getHyperlink()==null || c.getHyperlink().equals("NA") || c.getHyperlink().equals("na")){
				                        out.print("No Link");
				                        }else{ %>
				                        <a href='<%=c.getHyperlink()%>'>Click here</a>
				                         <%} %>
                                      </td>
                                      <td>
                                          <%=c.getP_index()%>
                                      </td>
                                      <td>
                                      <%if(c.getLink_index()==null || c.getLink_index().equals("NA") || c.getLink_index().equals("na")){
				                       out.print("No Link");
				                       }else{ %>
				                       <a href='<%=c.getLink_index()%>'>Click here</a>
				                       <%} %>
                                      </td>
                                    <td>
                                          <a href='../DownloadServlet?id=<%=c.getId()%>&type=conf_proceedings'><span class="glyphicon glyphicon-download-alt"></span>Download</a>  
                                      </td>
                                      
                                      <td> 
                                          <a href='../Downloads?id=<%=c.getId()%>&type=conf_proceedings'><span class="glyphicon glyphicon-download-alt"></span> Download</a>  
                                      </td>
                                    
                                    
                                    <td>
                                       
                                       <%
                                    
                                       try{
                                    	   if(c.getStatus()!=null){
                                    		   if(c.getPcn() == null ){
                                    			   if(c.getRevision() < 2 && c.getStatus().equals("rejected")){%>
                                            	   <a href='../Conf. Proceedings/Edit.jsp?id=<%=c.getId()%>'>Edit</a>  
                                            	   <%out.print("\n(Publication rejected)"); 
                                               }
                                        		   else{
                                            		   out.print("Can't be edited");
                                            	   }
                                    		   }
                                    		   else{
                                    			   out.print("Approved publication");
                                    		   }
                                    		   
                                        	
                                    	   }
                                    	  
                                       else{
                                    	   out.print("Can't be edited");
                                       }
                                           
                                       
                                      
                                       }catch(NullPointerException e){
                                    	   e.printStackTrace();
                                       }
                                    
                                    	  %>

                                      </td> 
                                      

                                
                               
                                  <td><%
                                  
                                 if(c.getStatus() != null){
                                	 
                                     if(c.getStatus().equals("rejected")){
                                       	  
						if (c.getComment() != null) {
										int id = c.getId();
										
					%> <a
					onClick="document.getElementById('<%=id%>').style.display='block'">Comment</a>
					<%
						} else {
										out.print("No comments");
									}} else{
     	  out.print("No comments");
       }
                                 }
                                 else{
                                	  out.print("No comments");
                                  }
                                 
                                  int id = c.getId();
              					
               if (id <= 0) {

 		} else {
 			
 			comment=userObjs.getCPOComment(id);
 		}
               %>
              					<div id="<%=id%>" class="modal">

              						<form class="modal-content animate">

              							<div class="container">
              								<span
              									onclick="document.getElementById('<%=id%>').style.display='none'"
              									class="close" title="Close Modal">&times;</span> <label>
              										<p>
										<font color = blue size = 3><u><b>Reason for rejection of publication by Admin </b></u></font><br>
											<br><i><%=comment%></i>
										</p>
              								</label>
              							</div>
              						</form>
              					</div> 
                                      
                                      
                                     </td>
    
                                     </tr>
                                     
                                      <%}%>
                                                                                                     
                                
                                 
                                 
                                  

                            </tbody>

                        </table>



</body>
</html>