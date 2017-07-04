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
		
		String id1=request.getParameter("ids");
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
			PreparedStatement  ps1 = null;
			
			if(type.equals("journal")){
				ps1=connection.prepareStatement("update journal set status =?,comment=? where id =?");
			}
			else if(type.equals("books")){
				ps1=connection.prepareStatement("update books set status =?,comment=? where id =?");
			}
			else if(type.equals("books")){
				ps1=connection.prepareStatement("update books set status =?,comment=? where id =?");
			}
			else if(type.equals("books")){
				ps1=connection.prepareStatement("update books set status =?,comment=? where id =?");
			}
			else if(type.equals("books")){
				ps1=connection.prepareStatement("update books set status =?,comment=? where id =?");
			}
			else if(type.equals("books")){
				ps1=connection.prepareStatement("update books set status =?,comment=? where id =?");
			}
			else if(type.equals("books")){
				ps1=connection.prepareStatement("update books set status =?,comment=? where id =?");
			}
			
			
			ps1.setString(1, "rejected");
			ps1.setString(2, comment);
			ps1.setInt(3, id);
			ps1.executeUpdate();
			response.sendRedirect("Journal/Journal.jsp");
		
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
