<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.notify.notification"%>
<%@page import="com.notify.notifObjs"%>
    <%@page import="com.user.ConnectionFactory"%>  
    <%@page import="java.sql.*"%>  
    <%@page import="com.admin.adminJObjs"%>
    <%@page import="com.admin.adminBObjs"%>
    <%@page import="com.admin.adminBCObjs"%>
    <%@page import="com.admin.adminCProObjs"%>
    <%@page import="com.admin.adminCPreObjs"%>
    <%@page import="com.admin.adminPObjs"%>
    <%@page import="com.admin.adminTRObjs"%>
    <%@page import="com.journal.Journal"%> 
      <%@page import="com.books.Books"%> 
      <%@page import="com.book_chap.Book_chapter"%>
      <%@page import="com.conf_presentations.conf_presentations"%>
      <%@page import="com.conf_proceedings.conf_proceedings"%>
      <%@page import="com.patents.Patents"%>
      <%@page import="com.tech_reports.tech_reports"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
  <style>
  li{
 font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
    font-size: 16px;
    font-weight : bold;

}

 body{
  background-color:lightblue;
  }
  
  /* Full-width input fields */
input[type=text]{
   /* width: 100%;*/
   /* padding: 12px 20px;*/
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius : 6.5px;
    box-sizing: border-box;
}

/* Set a style for all buttons */
input[type=submit] {
    background-color:#2695DF;
    color: white;
    padding: 6px 12px;
    margin: 8px 0;
    border: none;
    border-radius : 8px;
    cursor: pointer;
    
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
/*body{
background-image : url("../images/ncu.jpg");
background-repeat: no-repeat;
background-size : 1366px 720px;
}*/


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
  
  </style> 
<title>Publications</title>
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
              String name = null;//,comment=null;
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
 <br><br><br> <br><br><br>
 
                      <%String search=request.getParameter("search");
                    int x=0;
                        %>
                        <form method="post" action="#">
                        <p>&nbsp&nbspSearch : 
                        <%if(search == null){
                        	%><input type="text" name="search" size= '31' placeholder="Type author's name">
                       <%  }
                       else{
                       %><input type="text" name="search" value=<%=search %>><%} %>
                        
                        
                        <input type="SUBMIT" value="SEARCH"></p></form>
                        
                        <br>
                        
                           <table class="table table-hover table-bordered">
                            <%
                            if(search!=null){
                            
                            for(Journal j : adminJObjs.getSearch3(search)){
                      		  x++; %>
                            <thead>
                            <th>Sl No.</th>
                            <th>Type</th>
                            <th>PCN No.</th>
                            <th>Name of Authors as in Journal</th>
                            <th>Department</th>
                            <th>Title</th>
                            <th>Journal</th>
                            <th>Scope</th>
                             <th>Year</th>
                            <th>Month of Publication</th>
                            <th>Month of assigning pcn</th>
                            <th>Volume</th>
                            <th>Issue</th>
                            <th>Page No.</th>
                            <th>DOI No.</th>
                            <th>Impact Factor</th>
                            <th>Specify which Impact Factor</th>
                            <th>Link for Impact Factor</th>
                            <th>Paid/Unpaid</th>
                             <th>Payment done or not</th>
                            <th>Publication reported in Web of Science</th>
                            <th>Publication reported in Scopus</th>
                            <th>Publication reported in Google Scholar</th>
                            <th>Publication reported in Indian Citation Index</th>
                         
                            </thead>
                            <tbody>
                            
                            
                                  <tr>
                                   <td>
                                          <%=x%>
                                      </td>
                                      
                                       <td>
                                          JOURNAL
                                      </td>
                                      
                                       <td>
                                             <%if(j.getPcn()==null){
                                        	  %>Not Assigned<%
                            	              }else{
                                        	  out.print(j.getPcn());
                                        	  }%>
                                      </td>
                                      <td>
                                          <%=j.getName()%>
                                      </td>
                                      <td>
                                          <%=j.getDept()%>
                                      </td>
                                      <td>
                                          <%=j.getTitle()%>
                                      </td>
                                      <td>
                                          <%=j.getJourn()%>
                                      </td> 
                                      <td>
                                          <%=j.getScope()%>
                                      </td>   
                                      <td>
                                          <%=j.getYear()%>
                                      </td>
                                      <td>
                                          <%=j.getMonth_pub()%>
                                      </td>
                                      <td>
                                          <%if(j.getMonth_pcn()==null){
                                        	  out.print("Not Assigned");
                                          } else{
                                        	  out.print(j.getMonth_pcn());
                                          }%>
                                      </td>
                                      <td>
                                          <%=j.getVol()%>
                                      </td> 
                                      <td>
                                          <%=j.getIssue()%>
                                      </td>   
                                      <td>
                                          <%=j.getPages()%>
                                      </td>
                                        <td>
                                          <%if(j.getDoi()==null || j.getDoi().equals("NA") || j.getDoi().equals("na")){
				out.print("No Link");
				}else{ %>
				<a href='<%=j.getDoi()%>'>Click here</a>
				<%} %>
                                      </td>
                                      <td>
                                          <%=j.getIfs()%>
                                      </td>
                                      <td>
                                          <%=j.getSwif()%>
                                      </td>
                                      <td>
                                         <%if(j.getLfif()==null || j.getLfif().equals("NA") || j.getLfif().equals("na")){
				out.print("No Link");
				}else{ %>
				<a href='<%=j.getLfif()%>'>Click here</a>
				<%} %>
                                      </td> 
                                      <td>
                                          <%=j.getPay()%>
                                      </td>   
                                      <td>
                                          <%=j.getPdon()%>
                                      </td>
                                      <td>
                                          <%=j.getPw()%>
                                      </td>
                                      <td>
                                          <%=j.getPs()%>
                                      </td>
                                      <td>
                                          <%=j.getPg()%>
                                      </td> 
                                      <td>
                                          <%=j.getPi()%>
                                      </td>   
                                    
                                    
                                    
                                
                                   </tr> 
                          
                            </tbody>
                            
                            <% }
                            for(Books b : adminBObjs.getBooksSearch2(search)){
                      		  x++;%>
                      		  <thead>
                            <th>Sl No.</th>
                            <th>Type</th>
                            <th>PCN No.</th>
                            <th>Name of Authors as in Book</th>
                            <th>Department</th>
                            <th>Book Title</th>
                            <th>Publisher</th>
                            <th>Scope</th>
                             <th>Year</th>
                            <th>Month of Publication</th>
                            <th>Month of assigning pcn</th>
                            <th>Page No.</th>
                            <th>ISBN No.</th>
                            <th>Hyperlink</th>
                            <th>Mention if indexed in WOS/Scopus/Google Scholar/Thomson Reuter/Elsevier</th>
                            <th>Link for Indexing</th>
                            

                            
                            </thead>
                              <tr>
                                 <td>
                                     <%=x%>
                                               
                                 </td>
                                 
                                 <td>
                                    BOOKS
                                              
                                </td>
                                 
                                 <td>
                                     <%if(b.getPcn()==null){
                                   	  out.print("Not Assigned");
                                     } else{
                                   	  out.print(b.getPcn());
                                     }%>
                                     
                                 </td>
                                 
                                 <td>
                                     <%=b.getName()%>
                                 </td>
                                 <td>
                                     <%=b.getDept()%>
                                 </td>
                                 <td>
                                     <%=b.getTitle()%>
                                 </td>
                                 <td>
                                     <%=b.getPublisher()%>
                                 </td> 
                                 <td>
                                     <%=b.getScope()%>
                                 </td>   
                                 <td>
                                     <%=b.getYear()%>
                                 </td>
                                 <td>
                                     <%=b.getMonth_pub()%>
                                 </td>
                                 <td>
                                     <%if(b.getMonth_pcn()==null){
                                   	  out.print("Not Assigned");
                                     } else{
                                   	  out.print(b.getMonth_pcn());
                                     }%>
                                 </td>
                                 <td>
                                    <%=b.getPages()%>
                                 </td>
                                 <td>
                                     <%=b.getIsbn_no()%>
                                 </td>
                                  <td>
                                          <%if(b.getHyperlink()==null || b.getHyperlink().equals("NA") || b.getHyperlink().equals("na")){
				                        out.print("No Link");
				                        }else{ %>
				                        <a href='<%=b.getHyperlink()%>'>Click here</a>
				                         <%} %>
                                      </td>
                                      <td>
                                          <%=b.getP_index()%>
                                      </td> 
                                      <td>
                                          <%if(b.getLink_index()==null || b.getLink_index().equals("NA") || b.getLink_index().equals("na")){
				                       out.print("No Link");
				                       }else{ %>
				                       <a href='<%=b.getLink_index()%>'>Click here</a>
				                       <%} %>
                                      </td>   
                             

                                 
                                
                                   
                             </tr> 
                        <%}
                            for(Book_chapter b : adminBCObjs.getBook_chapSearch2(search)){
                      		  x++;%>
                      		   <thead>
                            <th>Sl No.</th>
                            <th>Type</th>
                            <th>PCN No.</th>
                            <th>Name of Authors as in Book Chapter</th>
                            <th>Department</th>
                            <th>Chapter Number</th>
                            <th>Chapter Title</th>
                            <th>Book Title</th>
                            <th>Publisher</th>
                            <th>Scope</th>
                             <th>Year</th>
                            <th>Month of Publication</th>
                            <th>Month of assigning pcn</th>
                            <th>Page No.</th>
                            <th>Book ISBN No.</th>
                            <th>Hyperlink</th>
                            <th>Mention if indexed in WOS/Scopus/Google Scholar/Thomson Reuter/Elsevier</th>
                            <th>Link for Indexing</th>
                           
                             <tr>
                                <td>
                                    <%=x%>
                                              
                                </td>
                                
                                <td>
                                    BOOK CHAPTER
                                              
                                </td>
                                
                                <td>
                                    <%if(b.getPcn()==null){
                                  	  out.print("Not Assigned");
                                    } else{
                                  	  out.print(b.getPcn());
                                    }%>
                                    
                                </td>
                                
                                <td>
                                    <%=b.getName()%>
                                </td>
                                <td>
                                    <%=b.getDept()%>
                                </td>
                                <td>
                                    <%=b.getChap_no()%>
                                </td>
                                <td>
                                    <%=b.getChap_title()%>
                                </td>
                                <td>
                                    <%=b.getBook_title()%>
                                </td>
                                <td>
                                    <%=b.getPublisher()%>
                                </td> 
                                <td>
                                    <%=b.getScope()%>
                                </td>   
                                <td>
                                    <%=b.getYear()%>
                                </td>
                                <td>
                                    <%=b.getMonth_pub()%>
                                </td>
                                <td>
                                    <%if(b.getMonth_pcn()==null){
                                  	  out.print("Not Assigned");
                                    } else{
                                  	  out.print(b.getMonth_pcn());
                                    }%>
                                </td>
                                <td>
                                   <%=b.getPages()%>
                                </td>
                                <td>
                                    <%=b.getBook_isbn_no()%>
                                </td>
                               <td>
                                          <%if(b.getHyperlink()==null || b.getHyperlink().equals("NA") || b.getHyperlink().equals("na")){
				                        out.print("No Link");
				                        }else{ %>
				                        <a href='<%=b.getHyperlink()%>'>Click here</a>
				                         <%} %>
                                      </td>
                                      <td>
                                          <%=b.getP_index()%>
                                      </td> 
                                      <td>
                                        <%if(b.getLink_index()==null || b.getLink_index().equals("NA") || b.getLink_index().equals("na")){
				                       out.print("No Link");
				                       }else{ %>
				                       <a href='<%=b.getLink_index()%>'>Click here</a>
				                       <%} %>
                                      </td>     
                          
                              

                                
                               
                                  
                            </tr> 
                       <%}
                            for(conf_proceedings c : adminCProObjs.getC_ProSearch2(search)){
                      		  x++;%>
                      		  <thead>
                            <th>Sl No.</th>
                            <th>Type</th>
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
                       

                     
                         
                            </thead>
                         
                            <tr>
                                <td>
                                    <%=x%>
                                              
                                </td>
                                
                                <td>
                                    CONF. PROCEEDINGS
                                              
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
                            
                                
                         
                                
                          
                            </tr> 
                       <% }
                            for(conf_presentations c : adminCPreObjs.getC_PreSearch2(search)){
                      		  x++;%>
                      		  <thead>
                            <th>Sl No.</th>
                            <th>Type</th>
                            <th>PCN No.</th>
                            <th>Faculty</th>
                            <th>Department</th>
                            <th>Title of Paper</th>
                            <th>Conference Presentation</th>
                            <th>Scope</th>
                            <th>Organised by</th>
                            <th>Venue Details for Conference </th>
                            <th>Year</th>
                            <th>Month of Publication</th>
                            <th>Month of assigning pcn</th>
                            <th>Dates</th>
                            <th>Hyperlink</th>
                          
                     
                         
                            </thead>
                     
                            <tr>
                                <td>
                                    <%=x%>
                                              
                                </td>
                                
                                <td>
                                    CONF. PRESENTATION
                                              
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
                                    <%=c.getPresentation()%>
                                </td> 
                                <td>
                                    <%=c.getScope()%>
                                </td>   
                                 <td>
                                    <%=c.getOrganiser()%>
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
                                          	<%
						if (c.getHyperlink() == null || c.getHyperlink().equals("NA") || c.getHyperlink().equals("na")) {
								out.print("No Link");
							} else {
					%> <a href='<%=c.getHyperlink()%>'>Click
						here</a> <%
 	}
 %>
                                      </td>

                           
                                
                                
                                
                          
                            </tr> 
                       <% }
                            for(Patents p : adminPObjs.getPatentSearch2(search)){
                      		  x++;%>
                      		   <thead>
                            <th>Sl No.</th>
                            <th>Type</th>
                            <th>PCN No.</th>
                            <th>Faculty</th>
                            <th>Department</th>
                            <th>Title of Patent</th>
                            <th>Scope</th>
                            <th>Country</th>
                            <th>Patent Application no.</th>
                            <th>Patent Application Year</th>
                            <th>Patent Application Date</th>
                            <th>Patent Award Year</th>
                            <th>Patent Award Date</th>
                            <th>Patent No.</th>
                        
                     
                         
                            </thead>
                            <tr>
                                <td>
                                    <%=x%>
                                              
                                </td>
                                
                                <td>
                                    PATENT
                                              
                                </td>
                                
                                <td>
                                    <%if(p.getPcn()==null){
                                  	  out.print("Not Assigned");
                                    } else{
                                  	  out.print(p.getPcn());
                                    }%>
                                    
                                </td>
                                
                                <td>
                                    <%=p.getName()%>
                                </td>
                                <td>
                                    <%=p.getDept()%>
                                </td>
                                <td>
                                    <%=p.getTitle()%>
                                </td>
                                <td>
                                    <%=p.getScope()%>
                                </td> 
                                <td>
                                    <%=p.getCountry()%>
                                </td>   
                                 <td>
                                    <%=p.getApplication_no()%>
                                </td> 
                                <td>
                                    <%=p.getApplication_year()%>
                                </td>
                                <td>
                                    <%=p.getApplication_date()%>
                                </td>
                                <td>
                                    <%=p.getAward_year()%>
                                </td>
                                <td>
                                    <%=p.getAward_date()%>
                                </td> 
                                <td>
                                    <%=p.getPatent_no() %>
                                </td>
                          
                                
                          
                            </tr> 
                       <% }
                            for(tech_reports t : adminTRObjs.getTechSearch2(search)){
                      		  x++;
                      		  %>
                      		  
                      		  <thead>
                            <th>Sl No.</th>
                            <th>Type</th>
                            <th>PCN No.</th>
                            <th>Faculty</th>
                            <th>Department</th>
                            <th>Title of Technical Report</th>
                            <th>Year</th>
                            <th>Month Of Publication</th>
                            <th>Month of assigning PCN</th>
                            <th>Date</th>
                            <th>Remarks</th>
                        
                         
                            </thead>
                      		  

                            <tr>
                                <td>
                                    <%=x%>
                                              
                                </td>
                                
                                <td>
                                    TECHNICAL REPORT
                                              
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
                          
                                
                                 
                            </tr> 
                       <% }
                            
                            
                            
                            
                            
                            }%>
                            
                            </table>
                                  
</body>
</html>