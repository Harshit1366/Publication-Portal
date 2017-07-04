package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Connection connection=null;
		
		try {
			 PrintWriter out = response.getWriter();
			//Class.forName("com.mysql.jdbc.Driver");                                       
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
			 connection=ConnectionFactory.getConnection();
			String name = request.getParameter("name");
			String desg = request.getParameter("desg");
			String email = request.getParameter("InputEmail");
			String contact = request.getParameter("cont");
			long cont=Long.parseLong(contact);
			String dob = request.getParameter("dob");
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			String confirm = request.getParameter("cp");
			
		
			
	/*	if(name.equals("")){
			 out.println("<script type=\"text/javascript\">");
          out.println("alert('Please fill your name !');");
          //out.println("location='first.jsp';");
          out.println("</script>");
          out.close();
          return;
		}
		else if(desg.equals("")){
			 out.println("<script type=\"text/javascript\">");
         out.println("alert('Please fill your gender !');");
         //out.println("location='first.jsp';");
         out.println("</script>");
         out.close();
         return;
		}
		else if(email.equals("")){
			 out.println("<script type=\"text/javascript\">");
         out.println("alert('Please fill your Email-Address !');");
         //out.println("location='first.jsp';");
         out.println("</script>");
         out.close();
         return;
		}
		else if(contact.equals("")){
			 out.println("<script type=\"text/javascript\">");
         out.println("alert('Please type your contact number !');");
         //out.println("location='first.jsp';");
         out.println("</script>");
         out.close();
         return;
		}                       */
		
		PreparedStatement p1 = connection.prepareStatement("insert into login(Name,Designation,Email_Id,Contact_No,"
				+ "DOB,Username,Password,Role) values (?,?,?,?,?,?,?,?)");
		p1.setString(1, name);
		p1.setString(2, desg); 
        p1.setString(3, email); 
		p1.setLong(4, cont);
		p1.setString(5, dob); 
		p1.setString(6, username);
		p1.setString(7, password);
		p1.setString(8, "user");
      System.out.println(p1.executeUpdate());
		response.sendRedirect("login/register.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(NullPointerException ne){
		ne.getStackTrace();
	}
	}

	}


