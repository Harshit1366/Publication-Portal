package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.abc.objs.LoginObjs;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		PrintWriter out = response.getWriter();
		try {

			//Class.forName("com.mysql.jdbc.Driver");
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/publication", "root", "root");
			connection=ConnectionFactory.getConnection();
			String user = request.getParameter("user");
			String pass = request.getParameter("pas");
			//String mode = request.getParameter("mode");
			//System.out.println(user + pass + mode);
			ResultSet rs = null;
			String role = null;

			PreparedStatement ps1 = connection.prepareStatement("Select Username, Password, Role from login where"
					+ " Username=? and Password=?");
			ps1.setString(1, user);
			ps1.setString(2, pass);
			// ps1.setString(3,mode);
			rs = ps1.executeQuery();

			if (rs.next()) {
				//System.out.println("Sucess!");
				role = rs.getString("role");
				
				if (role.equals("user")) {
					response.sendRedirect("user/user_dashboard.jsp");
				}

				// out.println("<script type=\"text/javascript\">");
				// out.println("alert('LOGIN SUCCESSFUL!');");
				// out.println("location='my.jsp';");
				// out.println("</script>");
				// //request.getRequestDispatcher("my.jsp").include(request,
				// response);
				
				out.print("Welcome, "+user);
				HttpSession sess = request.getSession(false);
				String session_identifier = UUID.randomUUID().toString().replaceAll("-", "");
				//System.out.println("Sesssion identifier : "+session_identifier);
				userObjs.setUUID(user, session_identifier);
				sess.setAttribute("name", user);
				sess.setAttribute("s_id", session_identifier);
				sess.setAttribute("role", role);
				out.close();
			}
//			else if(role.equals("Role_Admin") && 
//					user.equals("admin") && pass.equals("admin")){
//			
//					response.sendRedirect("admin/admin_dashboard.jsp");
//				
//			}
			else {
				System.out.println("Fail!");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('LOGIN FAILED!');");
				out.println("location='login/login.jsp';");
				out.println("</script>");
				out.close();

				//request.getRequestDispatcher("login/login.jsp").include(request,response);

			}

			// response.sendRedirect("login.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException ne) {
			ne.getStackTrace();
		}
	
	}

}
