package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.ConnectionFactory;
import com.user.userObjs;

/**
 * Servlet implementation class reject
 */
@WebServlet("/reject")
public class reject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//String name=request.getParameter("authors_name");
		
		//String id1=request.getParameter("ids");
	    //int id=Integer.valueOf(id1);
		
	     String id1 = request.getSession(false).getAttribute("id").toString(); 
         int id=Integer.valueOf(id1); 
		
		String comment=request.getParameter("comment");
		
		String type=request.getParameter("type");
		
		//String id1 = request.getSession(false).getAttribute("id").toString();
		//int id=Integer.valueOf(id1);
		
		Connection connection=null;
		
		try{
			//Class.forName("com.mysql.jdbc.Driver");                                       
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
			/*PreparedStatement ps=connection.prepareStatement("select revision from journal where authors_name=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			int rev=rs.getInt(1);
			if(rev<2){
				PreparedStatement ps1=connection.prepareStatement("update journal set revision =? where authors_name =?");
				ps1.setInt(1, rev+1);
				ps1.setString(2, name);
				ps1.executeUpdate();
			}
			*/
			connection=ConnectionFactory.getConnection();
			PreparedStatement  ps1 = null, ps2=null;
			
			if(type.equals("journal")){
				ps1=connection.prepareStatement("update journal set status =?,comment=? where id =?");
				String name=userObjs.getJUser(id);
				ps2 = connection.prepareStatement("insert into notify(notification,user_id) values(?,?)");
	            ps2.setString(1, "Journal Publication uploaded by you is rejected by admin for the reason : "+comment);
	            ps2.setString(2, name);
			}
			else if(type.equals("books")){
				ps1=connection.prepareStatement("update books set status =?,comment=? where id =?");
				String name=userObjs.getBUser(id);
				ps2 = connection.prepareStatement("insert into notify(notification,user_id) values(?,?)");
	            ps2.setString(1, "Book Publication uploaded by you is rejected by admin for the reason : "+comment);
	            ps2.setString(2, name);
			}
			else if(type.equals("book_chapter")){
				ps1=connection.prepareStatement("update book_chap set status =?,comment=? where id =?");
				String name=userObjs.getBCUser(id);
				ps2 = connection.prepareStatement("insert into notify(notification,user_id) values(?,?)");
	            ps2.setString(1, "Book Chapter Publication uploaded by you is rejected by admin for the reason : "+comment);
	            ps2.setString(2, name);
			}
			else if(type.equals("conf_proceedings")){
				ps1=connection.prepareStatement("update conf_proceedings set status =?,comment=? where id =?");
				String name=userObjs.getCPOUser(id);
				ps2 = connection.prepareStatement("insert into notify(notification,user_id) values(?,?)");
	            ps2.setString(1, "Conference Proceedings uploaded by you is rejected by admin for the reason : "+comment);
	            ps2.setString(2, name);
			}
			else if(type.equals("conf_presentations")){
				ps1=connection.prepareStatement("update conf_presentations set status =?,comment=? where id =?");
				String name=userObjs.getCPEUser(id);
				ps2 = connection.prepareStatement("insert into notify(notification,user_id) values(?,?)");
	            ps2.setString(1, "Conference Presentation uploaded by you is rejected by admin for the reason : "+comment);
	            ps2.setString(2, name);
			}
			else if(type.equals("patents")){
				ps1=connection.prepareStatement("update patents set status =?,comment=? where id =?");
				String name=userObjs.getPUser(id);
				ps2 = connection.prepareStatement("insert into notify(notification,user_id) values(?,?)");
	            ps2.setString(1, "Patent Publication uploaded by you is rejected by admin for the reason : "+comment);
	            ps2.setString(2, name);
			}
			else if(type.equals("tech_report")){
				ps1=connection.prepareStatement("update tech_report set status =?,comment=? where id =?");
				String name=userObjs.getTRUser(id);
				ps2 = connection.prepareStatement("insert into notify(notification,user_id) values(?,?)");
	            ps2.setString(1, "Technical Report Publication uploaded by you is rejected by admin for the reason : "+comment);
	            ps2.setString(2, name);
			}
			
			
			ps1.setString(1, "rejected");
			ps1.setString(2, comment);
			ps1.setInt(3, id);
			
			if(ps1.executeUpdate()>0){
				ps2.executeUpdate();
			}
			
			
			if(type.equals("journal")){
				response.sendRedirect("Journal/Journal.jsp");

			}
			else if(type.equals("books")){
				response.sendRedirect("Books/Books.jsp");
			}
			else if(type.equals("book_chapter")){
				response.sendRedirect("Book Chapter/Book_Chapter.jsp");
			}
			else if(type.equals("conf_proceedings")){
				response.sendRedirect("Conf. Proceedings/Conf_Proceedings.jsp");
			}
			else if(type.equals("conf_presentations")){
				response.sendRedirect("Conf. Presentations/Conf_Presentations.jsp");
			}
			else if(type.equals("patents")){
				response.sendRedirect("Patents/Patents.jsp");
			}
			else if(type.equals("tech_report")){
				response.sendRedirect("Tech reports/Tech_Report.jsp");
			}
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
