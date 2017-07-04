package com.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class edit_profile
 */
@WebServlet("/edit_profile")
public class edit_profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Connection connection=null;
		
		String user = null;
        HttpSession sess=request.getSession(false);  
        if(sess!=null){  
        user=(String)sess.getAttribute("name");  
        }
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");                                       
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
			connection=ConnectionFactory.getConnection();
			String name = request.getParameter("name");
			String desg = request.getParameter("desg");
			String email = request.getParameter("InputEmail");
			String contact = request.getParameter("cont");
			long cont=Long.parseLong(contact);
			String dob = request.getParameter("dob");
			
		
		PreparedStatement p1 = connection.prepareStatement("update login set Name=?,Designation=?,Email_Id=?,Contact_No=?,"
				+ "DOB=? where Username=?");
		p1.setString(1, name);
		p1.setString(2, desg); 
        p1.setString(3, email); 
		p1.setLong(4, cont);
		p1.setString(5, dob); 
		p1.setString(6, user);
		
     System.out.println(p1.executeUpdate());
		response.sendRedirect("user/user_profile.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(NullPointerException ne){
		ne.getStackTrace();
	}
	}
		
	

}
